#!/bin/bash

url=http://localhost:8090

value=100

for i in {1..100}
do
  cnpj="59683461000159"
  dateNow=$(date +"%FT%T")
  total=$(($value * $i))

  json="{\"identifier\":\"${i}\", \"customer\":{\"cnpj\":\"${cnpj}\"}, \"dateTime\":\"${dateNow}\",\"total\":$total}"

  curl -d "${json}" -H "Content-Type: application/json" -X POST ${url}/orders/TEST

done