#!/bin/bash

url=http://localhost:8080/api/receiver

value=100

START_TIME=$SECONDS
for i in {1..10}
do
  cnpj="59683461000159"
  dateNow=$(date +"%FT%T")
  total=$(($value * $i))

  json="{\"identifier\":\"${i}\", \"customer\":{\"cnpj\":\"${cnpj}\"}, \"dateTime\":\"${dateNow}\",\"total\":$total}"

  curl -d "${json}" -H "Content-Type: application/json" -X POST ${url}/orders/TEST &

done

ELAPSED_TIME=$(($SECONDS - $START_TIME))
echo "$(($ELAPSED_TIME/60)) min $(($ELAPSED_TIME%60)) sec"