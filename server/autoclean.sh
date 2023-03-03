#!/bin/bash

cd "/home/users/etudiant/g/ga103969/www/ext/saejava/"
#suppression des copies de la base de donnée
for i in *.sae
do rm -vf $i
done
rm -vf ecowatt.db

#suppression des fichiers temporaires
rm -vf *_liss.txt nohup.out

#suppression des derniers json et csv
for i in ./.dump/*.{json,csv}
do rm -vf $i
done

#suppression des dernières données
for i in ./.dump/?_LastVars/*
do rm -vf $i
done

#suppression du dernier conseil
rm -vf ./.dump/tipss/tips
