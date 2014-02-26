#!/bin/bash
NEW_VERSION=$1
if [ -z "$NEW_VERSION" ]; then
   echo "usage: $0 [new_version]"
   echo "example: $0 2.4.0"
   exit 1
fi

perl -i -p -e "s/(app\.grails\.version\=).*/\${1}${NEW_VERSION}/" `git ls-files '*/application.properties'`
