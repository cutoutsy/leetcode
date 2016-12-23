#!/bin/bash

# This solution Memory Limit Exceeded.

WRD=$(head -n 1 file.txt | wc -w)
for((i=1;i<=$WRD;i++))
do
	awk '{print $'$i'}' file.txt | tr '\n' ' ' | sed 's/[ \t]$/\n/g'
done
