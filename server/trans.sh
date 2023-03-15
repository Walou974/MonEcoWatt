#!/bin/bash
CONT=$(cat index.template)
echo $CONT  > index_liss.txt
python3 trans.py
cat index_liss.txt | sed "s/#_TODAY/`tail -1 db_liss.txt`/g" > index.php
