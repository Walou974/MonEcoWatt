#!/bin/bash

while true
do
echo `date` > .last_req
kill -9 $(ps aux |grep auto_daemon.sh | head -1 |awk '{ print $2 }') 2>/dev/null
./autoclean.sh
./.auto_daemon2.sh
sleep 86400
done
