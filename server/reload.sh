#!/bin/bash
echo `date` > .last_req
kill -9 $(ps aux |grep auto_daemon.sh | head -1 |awk '{ print $2 }') 2>/dev/null
./autoclean.sh
nohup ./.auto_daemon.sh &
