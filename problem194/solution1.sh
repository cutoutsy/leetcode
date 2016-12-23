#!/bin/bash
awk '
{
    for (i = 1; i <= NF; i++) {
        if(NR == 1) {
	    print $i
            s[i] = $i;
        } else {
	    print $i
            s[i] = s[i] " " $i;
        }
    }
}
END {
    for (i = 1; s[i] != ""; i++) {
        print s[i];
    }
}' file.txt
