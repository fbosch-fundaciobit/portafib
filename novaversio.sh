#!/bin/bash


env mvn versions:set -DnewVersion=$@  -Psqlgen -Papplet -Pclientcert -Pws-portafib -Pws-indra  -Pws-indra-callback-test  -Pdesenvolupament -Pproduccio


echo -e "\n"
echo -e "\n"
echo --------------------------- IMPORTANT ------------------------------
echo "|  El projectes del directori ws no s\'actualitzen automaticament. |"
echo "|  Per favor actualitzar la versio manualment.                     |"
echo --------------------------------------------------------------------
echo -e "\n"
echo -e "\n"
