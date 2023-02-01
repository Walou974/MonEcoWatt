#!/bin/bash

export tips_0="Pensez à réduire autant que possible la température du chauffage"
export tips_1="Décalez les heures d'utilisation de vos appareils domestiques"
export tips_2="Ajustez l'utilisation des appareils de cuisson au strict nécessaire"
export tips_3="Pensez à éteindre les lumières inutiles"
export tips_4="Pensez à établir une programmation spécifique de votre chauffage"
export tips_5="Pensez à réduire l'éclairage intérieur des bâtiments"
export tips_6="Evitez de recharger vos véhicules électriques pendant les périodes de tension"
export tips_7="Dès que possible, coupez les affichages et éclairages non essentiels"
export tips_8="Faites fonctionner votre chauffe-eau pendant les heures creuses"
export tips_9="Baissez la température de votre chauffage à 19°C"

export today="\$tips_${RANDOM:1:1}"
eval "echo ${today}" > ./.dump/tipss/tips
