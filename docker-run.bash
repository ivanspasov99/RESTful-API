#!/bin/sh


# version=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

version=$(grep -E -o "<version>[0-9.]*</version>" < pom.xml |
grep -E -o "[0-9].[0.9].[0-9]" |
head -n 1)

sudo docker build --build-arg version="$version" -t rest .