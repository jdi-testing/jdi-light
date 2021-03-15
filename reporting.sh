#!/bin/bash

####################             ABOUT

# grubAllureResults - to send allure results
# deployAllureResults - to deploy allure reports

####################             VARS
BRANCH_ERROR_MESSAGE="THIS BUILD HAS NO RELATED PULL REQUEST, ALLURE REPORTS ARE NOT SAVED"
URL_NOT_FOUND_ERROR_MESSAGE="NONE OF THE ALLURE REPORTS WERE FOUND"
TEST_FAILED_ERROR_MESSAGE="SOME OF THE TESTS IS NOT PASSED. PLEASE CHECK ALLURE REPORT, FOR GETTING MORE DETAILS"
FILENAME_WITH_COMMENTS_FROM_GITHUB="comments"
FASTER_FILE_SHARING="true"
DESTINATION_PULL_REQUEST=$TRAVIS_PULL_REQUEST
JDK_VERSIONS="openjdk8 openjdk9 openjdk10 openjdk11 openjdk12 openjdk13"

####################             PULL REQUEST TO LEAVE COMMENTS
if [[ $TRAVIS_BRANCH == "master" && ($TRAVIS_EVENT_TYPE = "cron" || $TRAVIS_EVENT_TYPE = "api") ]];
then
  DESTINATION_PULL_REQUEST=${CRONJOB_COMMENTS_PR}
  echo "This build was triggered against cronjob-debug branch by cronjob or api"
  echo "Comments are going to be redirected to PR: ${CRONJOB_COMMENTS_PR}"
fi

####################             UTILS
function getCommentsLastPageIndex() {
    url="https://api.github.com/repos/${TRAVIS_REPO_SLUG}/issues/${DESTINATION_PULL_REQUEST}/comments"
    index="$(curl -I -H "Authorization: token ${GIT_COMMENT_USER}"\
         -X GET  "${url}" | grep Link: | awk '{print $4}' | egrep -o 'page=[0-9]{1,10}' | awk -F"=" '{print $2}')"
    reInteger='[0-9]+'
	  if ! [[ $index =~ $reInteger ]] ;
	  then
	    index=1
	  fi
    echo ${index}
}

function collectRelevantComments() {
    lastPageIndex=$(getCommentsLastPageIndex)
    matchPattern="$1"
    fileName="${FILENAME_WITH_COMMENTS_FROM_GITHUB}"
    for (( pageIndex=1; pageIndex<=lastPageIndex; pageIndex++ ))
    do
      url="https://api.github.com/repos/${TRAVIS_REPO_SLUG}/issues/${DESTINATION_PULL_REQUEST}/comments?page=${pageIndex}"
    	curl -H "Authorization: token ${GIT_COMMENT_USER}"\
    	     -X GET  "${url}"\
    	     >> ${fileName}
    done
    jq ".[].body" ${fileName} | grep "${matchPattern}"| awk '{print $3}' | sed "s/\"//g" | sort | uniq #return list
}

function sendComment() {
    body="$1"
    url="https://api.github.com/repos/${TRAVIS_REPO_SLUG}/issues/${DESTINATION_PULL_REQUEST}/comments";
    echo Body: ${body}
    echo URL: ${url}
    curl -H "Authorization: token ${GIT_COMMENT_USER}" \
         -X POST "${url}" \
         -d "{
                \"body\": \"${body}\"
             }";
}

#########################               PART 1: send allure results into web to collect it later
function grubAllureResults() {
    echo "Stage was: ${TRAVIS_BUILD_STAGE_NAME}"
    checkBranchIsOk #there is an exit inside

    if [[ "x${TRAVIS_BUILD_STAGE_NAME}" == "xtest" ]] ; then #don't remove x, it's useful
        for result in $(find -type d -regex ".*/jdi.*/target/allure-results-${TRAVIS_JDK_VERSION}")
        do
            echo RESULT: ${result}
            archiveFile="$(archive "${result}")"
            echo ARCHIVE: "${archiveFile}"
            ls -lah *.tar.gz
            uploadedTo="$(uploadFile "${archiveFile}")"
            echo UPLOAD TO KEY: "${uploadedTo}"
            sendComment "$(aboutTransfer "${uploadedTo}")"
        done
    fi
}


function printAllureSummary() {
    FAILED_OR_BROKEN_TESTS=false

    echo "Brief passed/failed/broken/skipped summary by JDK: $1"

    content=$(<"allure-report/widgets/summary.json")     #file system request
    passed="$(echo "${content}"| jq '.statistic.passed')"
    failed="$(echo "${content}"| jq '.statistic.failed')"
    skipped="$(echo "${content}"| jq '.statistic.skipped')"
    broken="$(echo "${content}"| jq '.statistic.broken')"
    echo "${JDK}:"
    echo "  Passed:  ${passed}"
    echo "  Failed:  ${failed}"
    echo "  Broken:  ${skipped}"
    echo "  Skipped: ${broken}"
    if [[ ${failed} -gt 0 || ${broken} -gt 0 ]]; then
      FAILED_OR_BROKEN_TESTS=true
    fi

    echo "End of summary"
}

######################         PART 2: Deploy allure results as allure reports to netlify
function deployAllureResults() {
    checkBranchIsOk #there is an exit inside
    downloadAllureResults
    extractAllureResults
    # Great, now we have huge amount of jsons for different JDKs distributed across directory tree
    # Our goal now is to distribute them across multiple allure reports
    for JDK in $JDK_VERSIONS;
    do
      if [[ $(find -name "*$JDK*" -type d) ]]; then
        echo "Generating and publishing allure results for ${JDK}"
        generateAllureReports "${JDK}"
        echo "LOG1"
        url="$(deployToNetlify "allure-report-${JDK}")"
        echo "LOG2"
        sendComment "$(aboutNetlify "${url}" "${JDK}")"
      else
        echo "No allure reports found for $JDK"
      fi
    done
    checkThatAllTestsPassed #there is an exit with exception inside
}

function downloadAllureResults() {
    urlExistence=false
    echo "TRAVIS_BUILD_NUMBER: ${TRAVIS_BUILD_NUMBER}"
    for urlKey in $(collectRelevantComments "${TRAVIS_BUILD_NUMBER}")
    do
        urlExistence=true
        echo "Found: ${urlKey}"
        if [[ "x${FASTER_FILE_SHARING}" == "xfalse" ]] ; then
            fileName="$(echo "${urlKey}"| awk -F/ '{print $5}')"
            curl "${urlKey}" --output "${fileName}"
        else
            fileName="${urlKey}.tar.gz"
            curl https://file.io/"${urlKey}" --output "${fileName}"
        fi
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
    for report in $(ls -d1 jdi*/target/allure-results ./*/jdi*/target/allure-results)
    do
        allureDirExistence=true
        reportDirList="${reportDirList} ${report}"
    done
    if [[ "x${allureDirExistence}" == "xfalse" ]] ; then
        echo "Failed inside generateAllureReports()"
        exitWithError
    fi
    echo "Generating allure-report based on: ${reportDirList}"
    allure generate --clean ${reportDirList}

}
