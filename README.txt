While running the functional test suite there are several system properties
that may be set to control which tests are run:

- skipScripts may be set to skip all of the functional test scripts
- skipGrailsBuild may be set to skip building Grails (Grails must already be built)
- skipNewApp will skip all of the new app functional tests
- skipApps may be set to skip all of the functional test apps
- appToTest may be set to specify a specific functional test app to run

As an example, to skip the scripts tests, skip the new app tests and run only the webflow
functional test app:

ant -DskipNewApp=true -DskipScripts=true -DappToTest=webflow

Running the test suite relies on access to a copy of the Grails
source code.  By default the build will download a copy of the source
code from Github.  The archive downloaded will be snaphshot of the latest
version of the project, not the entire project history.  Because of that,
the download is smaller than a full clone of the repository but is still
fairly large (approximately 40mb).  To avoid the download you may take
advantage of a local copy of the source tree by setting the grails.home
system property and assigning it a value that points to a copy of the
grails project:

ant -Dgrails.home=/home/user/projects/grails-core


