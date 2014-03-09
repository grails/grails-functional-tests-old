#!/bin/bash
PLUGIN_NAME=$1
NEW_VERSION=$2
if [ -z "$PLUGIN_NAME" -o -z "$NEW_VERSION" ]; then
   echo "usage: $0 [plugin_name] [new_version]"
   echo "example: $0 hibernate 3.6.10.1"
   exit 1
fi
perl -i -p -e "s/([\'\"]:${PLUGIN_NAME}:)[^'\"]+([\'\"])/\${1}${NEW_VERSION}\${2}/" `git ls-files '*/grails-app/conf/BuildConfig.groovy'` build.xml
