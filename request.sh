#!/bin/bash

OUTPUT="get.html"

curl http://isis.unice.fr/~ga103969/ext/saejava/ --output $OUTPUT 2>/dev/null
cat $OUTPUT | tr " " "\n" > .tmp

export S=$(cat .tmp | grep -nE "\(" | cut -d ':' -f 1)
export E=$(cat .tmp | grep -nE "}')" | cut -d ':' -f 1)

cat .tmp \
| sed -n "${S},${E}p" \
| tr "\n" " " > .tmp2

export TITLE=$(grep -o '[0-9]*' .tmp2 | xargs | awk '{ print $1}')

cat .tmp2 \
| sed s/"\"GenerationFichier"/"\n\"GenerationFichier"/g \
| grep -v $TITLE \
| sed s/"\[{"/"\n{"/g \
| sed '/values/ s/':'/','/g' \
| awk -F "]" '{ print $1 }' \
| sed s/' '/''/g \
| awk -F ",\"values\"," '{ print $1 }' \
| sed 's/"Pasd\\u2019alerte."/"Pas d'\''alerte."/g' > $TITLE.sae

mkdir .dump
cd $_

INPUT=88.sae ; CSV=1 ; JSON=1

while read -r line
do if [[ $line == *Gen* ]]
then echo $line > ${INPUT:0:-4}-${CSV}.csv &\
& CSV=$(($CSV+1))
else echo $line > ${INPUT:0:-4}-${JSON}.json &\
& JSON=$(($JSON+1))
fi
done < ../$INPUT
cd ..

rm ./.t* $OUTPUT
