#!/bin/bash

git remote remove origin
git remote add origin https://gitlab.com/jeff.zapotoczny/forrester-sast-wave.git
git branch -M master
git push -u origin master
