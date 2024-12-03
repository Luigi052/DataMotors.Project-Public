from requests import post
from carros import scrape_car_data
import json
import pandas as pd
import ssl

ssl._create_default_https_context = ssl._create_unverified_context

print("Iniciando raspagem de dados...")

lista = scrape_car_data(100)

print(json.dumps(lista))

token = 'eyJraWQiOiI4NDAyMzEzNS1jOWNmLTQzOWMtYTZkNS1hMGY3YWY2OGRlMzAiLCJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImJldG8iLCJleHAiOjE3MTY5MTU2MzgsInJvbGUiOiJBRE1JTiJ9.g_kO6bH5vHyzWha5jKagP1N60bzbA9Wgvx2ezPc11do'

if len(lista) != 0: 
    df = pd.DataFrame(lista)
    #df.to_csv("carros.csv", index=False)
    for item in lista:
        response = post(
            url="http://localhost:8080/car",
            json=item,
            headers={
                "Content-Type":"application/json",
                "Authorization": f"Bearer {token}"
            }
        )
        print(response)
        print(lista)
else:
    print("Lista vazia. ")