#!/bin/bash

curl  "http://isis.unice.fr/~mgautero/ext/sae302/bd/ecowatt.db" --output ecowatt.db 2>/dev/null &&
./trans.sh &&
./request.sh &&
date &&
./dump/00_vars.sh &&
./ecogestes.sh
