#!/bin/bash

git remote remove origin
git remote add origin https://gitlab.com/jeff.zapotoczny/my-java-app.git
git branch -M master
git push -u origin master
