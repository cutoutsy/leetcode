#!/bin/bash
(sed 's/^[ \t]*//g' | sed 's/[ \t]*$//g' | tr -s ' ' | tr 'A-Z' 'a-z' | tr ' ' '\n' | sort | uniq -c | sort -r $1 |awk '{print $2" "$1}') < words.txt
