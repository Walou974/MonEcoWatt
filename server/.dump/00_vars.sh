#!/bin/bash

cd .dump/

L=0
P=1
R='None'

for i in *.csv
do L=$P && P=$(basename $i | awk -F "-" '{ print $1 }')
##echo $P
if [[ $P -gt $N  ]]
then N=$P
fi

done
##echo $L $P $N

for c in {1..4}
do
	Ldate=$(cat ${N}"-"${c}".csv" | head -1 | sed s/"\""/""/g | awk -F "," '{ print $7 }' | cut -d "T" -f 1)
	echo $Ldate > ./$(($c-1))_LastVars/Ldate

	Lmess=$(cat ${N}"-"${c}".csv" | head -1 | sed s/"\""/""/g | awk -F "," '{ print $NF }')
	echo $Lmess > ./$(($c-1))_LastVars/Lmess

	echo -e "\n"

	for i in {1..24}
	do
	cat ${N}"-"${c}".json" | tail -1 | sed s/"},{"/"\n"/g | sed -n ${i}p | awk -F ":" '{ print $NF }' | sed s/"}"/""/g > ./$(($c-1))_LastVars/${i}h
	done
done
cd ..
