#!/bin/bash

####################             ABOUT

# grubAllureResults - to send allure results
# deployAllureResults - to deploy allure reports

####################             VARS
BRANCH_ERROR_MESSAGE="IF YOU DON'T SEE THE PULL REQUEST BUILD, THEN BRANCH CANNOT BE MERGED, YOU SHOULD FIX IT FIRST"
URL_NOT_FOUND_ERROR_MESSAGE="NONE OF THE ALLURE REPORTS WERE FOUND"
FILENAME_WITH_COMMENTS_FROM_GITHUB="comments"

####################             UTILS
function getCommentsLastPageIndex(){
    url="https://api.github.com/repos/${TRAVIS_REPO_SLUG}/issues/${TRAVIS_PULL_REQUEST}/comments"
    curl -I -H "Authorization: token ${GIT_COMMENT_USER}"\
         -X GET  "${url}" | grep Link: | awk '{print $4}' | egrep -o 'page=[0-9]{1,10}' | awk -F"=" '{print $2}'
}

function collectRelevantComments(){
    lastPageIndex=$(getCommentsLastPageIndex)
    matchPattern="$1"
    fileName="${FILENAME_WITH_COMMENTS_FROM_GITHUB}"
    for (( pageIndex=1; pageIndex<=lastPageIndex; pageIndex++ ))
    do
      url="https://api.github.com/repos/${TRAVIS_REPO_SLUG}/issues/${TRAVIS_PULL_REQUEST}/comments?page=${pageIndex}"
    	curl -H "Authorization: token ${GIT_COMMENT_USER}"\
    	     -X GET  "${url}"\
    	     >> ${fileName}
    done
    jq ".[].body" ${fileName} | grep "${matchPattern}"| awk '{print $3}' | sed "s/\"//g" | sort | uniq #return list
}

function sendComment() {
    body="$1"
    url="https://api.github.com/repos/${TRAVIS_REPO_SLUG}/issues/${TRAVIS_PULL_REQUEST}/comments";
    echo Body: ${body}
    echo URL: ${url}
    curl -H "Authorization: token ${GIT_COMMENT_USER}" \
         -X POST "${url}" \
         -d "{
                \"body\": \"${body}\"
             }";
}

function archive() {
    directory="$1"
    archiveName="$(echo ${directory}| awk -F"/" '{print $1}')".tar.gz
    tar -czf "${archiveName}" "${directory}" > /dev/null
    echo "${archiveName}" #return
}

function extractArchive() {
    file="$1"
    tar -zxvf "${file}"
}

function aboutTransfer() {
    url="$1"
    echo "[${TRAVIS_BUILD_NUMBER}] - ${url}" #return
}

function aboutNetlify() {
    url="$1"
    echo "[${TRAVIS_BUILD_NUMBER}] - Allure report on Netlify: ${url}" #return
}

function checkBranchIsOk() {
    if [[ "x${TRAVIS_PULL_REQUEST}" == "xfalse" ]] ; then
        echo "${BRANCH_ERROR_MESSAGE}"
        sleep 3
        exit 0
    fi
}

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

#########################               PART 1: send allure results into web to collect it later
function grubAllureResults() {
    echo "Stage was: ${TRAVIS_BUILD_STAGE_NAME}"
    checkBranchIsOk #there is an exit inside

    if [[ "x${TRAVIS_BUILD_STAGE_NAME}" == "xtest" ]] ; then #don't remove x, it's useful
        for result in $(find jdi*/target/allure-results -maxdepth 1 -type d)
        do
            echo RESULT: ${result}
            archiveFile="$(archive ${result})"
            echo ARCHIVE: "${archiveFile}"
            ls -lah *.tar.gz
            uploadedTo="$(uploadFile "${archiveFile}")"
            echo UPLOAD TO KEY: ${uploadedTo}
            sendComment "$(aboutTransfer "${uploadedTo}")"
        done
    fi
}

function uploadFile() {
    file="$1"
    # TODO : make an if depending of boolean variable to switch between transfer or between https://www.file.io/#one

    #url=$(curl --upload-file "${file}" https://transfer.sh/${file})
    response="$(curl -F "file=@${file}" https://file.io/)"
    url="$(echo ${response} |jq -j '.link')"
    urlKey="$(echo "${url}"| awk -F/ '{print $4}')"
    echo "${urlKey}" #return
}

######################         PART 2: Deploy allure results as allure reports to netlify
function deployAllureResults() {
    checkBranchIsOk #there is an exit inside
    downloadAllureResults
    extractAllureResults
    generateAllureReports
    echo "LOG1"
    url="$(deployToNetlify "allure-report")"
    echo "LOG2"
    sendComment "$(aboutNetlify ${url})"
}

function downloadAllureResults() {
    urlExistence=false
    echo "TRAVIS_BUILD_NUMBER: ${TRAVIS_BUILD_NUMBER}"
    for urlKey in $(collectRelevantComments "${TRAVIS_BUILD_NUMBER}")
    do
        urlExistence=true
        echo "Found: ${urlKey}"
        # TODO: $4 for file.io, #5 for transfer.sh, add an IF
        #fileName="$(echo "${url}.tar.gz"| awk -F/ '{print $5}')"
        fileName="${urlKey}.tar.gz"
        tmpResult="$(curl https://file.io/${urlKey} --output ${fileName})"
    done
    if [[ "x${urlExistence}" == "xfalse" ]] ; then
        echo "Failed inside downloadAllureResults()"
        echo "Comments recieved from github:"
        cat "${FILENAME_WITH_COMMENTS_FROM_GITHUB}"
        exitWithError
    fi
}

function extractAllureResults() {
    for archiveFile in $(ls -1 *.tar.gz)
    do
        extractArchive "${archiveFile}"
    done
}

function generateAllureReports() {
    reportDirList="";
    allureDirExistence=false
    for report in $(ls -d1 jdi-light*/target/)
    do
        allureDirExistence=true
        allureDir="${report}allure-results"
        if [[ -d "$allureDir" ]] ; then
            echo "Results found for ${report}"
            reportDirList="${reportDirList} ${allureDir}"
        else
            echo "RESULTS NOT FOUND FOR ${report}"
        fi
    done
    if [[ "x${allureDirExistence}" == "xfalse" ]] ; then
        echo "Failed inside generateAllureReports()"
        exitWithError
    fi
    echo ${reportDirList}
    allure generate --clean ${reportDirList}
}

function deployToNetlify() {
    directory="$1"
    result="$(netlify deploy --dir ${directory} --json)"
    deployUrl="$(echo ${result}r |jq '.deploy_url' |sed 's/"//g')"
    echo "${deployUrl}"
}

function exitWithError() {
    echo "${URL_NOT_FOUND_ERROR_MESSAGE}"
    sleep 3
    exit 1
}
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
