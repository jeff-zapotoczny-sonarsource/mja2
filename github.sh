#!/bin/bash

git remote remove origin
git remote add origin https://github.com/jeff-zapotoczny-sonarsource/forrester-sast-wave.git
git branch -M master
git push -u origin master
