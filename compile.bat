rem cd ../JDILightsaber
rem call mvn clean install
rem cd ../JDILight/jdi-light
cd jdi-light
call mvn clean install
cd ../jdi-light-html
call mvn clean install
rem cd ../jdi-light-examples
rem call mvn clean compile
cd ../jdi-light-html-tests
call mvn clean compile
rem cd ../jdi-performance
rem call mvn clean compile
cd ..