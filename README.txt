While running the functional test suite there are several system properties
that may be set to control which tests are run:

- skipCli may be set to skip all of the CLI tests
- skipScripts may be set to skip all of the functional test scripts
- skipNewApp will skip all of the new app functional tests
- skipApps may be set to skip all of the functional test apps
- appToTest may be set to specify a specific functional test app to run

As an example, to skip the scripts tests, skip the new app tests and run only the webflow
functional test app:

ant -DskipNewApp=true -DskipScripts=true -DappToTest=webflow

Running the test suite relies on access to a copy of the Grails.  When
running the build you need to set the grails.home system property
and assign it a value that points to a valid Grails installation.

ant -Dgrails.home=/home/user/tools/grails


