#!/bin/bash

##CE SCRIPT A POUR BUT DE FACILITER LE TRAITEMENT DES DONNEES PAR L'APPLICATION ANDROID ET L'ANALYSE DE LEUR CONTENU##

##Relation avec la cible - Déclaration de l'entrée

#	TARGET="http://isis.unice.fr/~ga103969/ext/saejava/" #URL de la page web

OUTPUT="index.php" #Nom du fichier temporaire

##Téléchargement de la cible avec curl

#	curl $TARGET --output $OUTPUT 2>/dev/null

##Mise en forme temporaire pour détecter le début (S) et la fin (E) du document
cat $OUTPUT \
| tr " " "\n" > .tmp #Remplacement des espaces par des retours à la ligne
export S=$(cat .tmp | grep -nE "\(" | cut -d ':' -f 1) #Start
export E=$(cat .tmp | grep -nE "}')" | cut -d ':' -f 1) #End

##Extraction
cat .tmp \
| sed -n "${S},${E}p" \
| tr "\n" " " > .tmp2

##Déduction du nom du document, extraction du pattern permettant de distinguer données et métadonnées
export TITLE=$(grep -o '[0-9]*' .tmp2 | xargs | awk '{ print $1}') #Nom du document (numéro de génération)
export REGEX_1="GenerationFichier" #Pattern CSV
export REGEX_2='values' #Pattern JSON

##Mise en forme des données sélectionnées dans un seul bloc de fichier
cat .tmp2 \
| sed s/"\"$REGEX_1"/"\n\"$REGEX_1"/g \
| grep -v $TITLE \
| sed s/"\[{"/"\n{"/g \
| sed '/values/ s/':'/','/g' \
| awk -F "]" '{ print $1 }' \
| sed s/' '/''/g \
| awk -F ",\"$REGEX_2\"," '{ print $1 }' \
| sed 's/"Pasd\\u2019alerte."/"Pas d'\''alerte."/g' > $TITLE.sae

##Initialisation du filtrage
mkdir .dump 2> /dev/null #Création du dossier recueillant les dumps .csv et .json
cd $_ #Déplacement dans ce dernier pour la suite des opérations

##Déclaration des fichiers
export INPUT=$TITLE.sae #Fichier d'aggrégation
export CSV=1 #Fichier de stockage des métadonnées au format CSV
export JSON=1 #Fichier de stockage des valeurs au format JSON

##Boucle while de hierarchisation et de séparation des données
while read -r line
do if [[ $line == *Gen* ]]
then echo $line > ${INPUT:0:-4}-${CSV}.csv &\
& CSV=$(($CSV+1))
else echo $line > ${INPUT:0:-4}-${JSON}.json &\
& JSON=$(($JSON+1))
fi
done < ../$INPUT

cd ..
rm ./.tmp* #	$OUTPUT
