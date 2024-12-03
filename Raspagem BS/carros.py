import requests
from concurrent.futures import ThreadPoolExecutor
import pandas as pd
from datetime import date
import json
import random
import time

user_agents = [
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Safari/605.1.15",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299",
    "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1"
]

# Configuração de proxy sem autenticação (diretamente pelo IP)
proxy_config = {
    "http": "http://p.webshare.io:9999"
}

# Retirada do projeto Público para nao haver Problemas
url_car = '####'

session = requests.Session()

# Função para processar os dados 
def process_car_data(car):

    return {
        'brand': car['Specification']['Make']['Value'],
        'model': car['Specification']['Model']['Value'],
        'version': car['Specification']['Version']['Value'],
        "type": car['ListingType'],
        'price': car['Prices']['Price'],
        'color': car['Specification']['Color']['Primary'],
        'transmission': car['Specification']['Transmission'],
        'doors': car['Specification']['NumberPorts'],
        'mileage': (car['Specification']['Odometer']),
        'city': car['Seller']['City'],
        'state': car['Seller']['State'],
        'fabYear': int(car['Specification']['YearFabrication']),
        'modelYear': int(car['Specification']['YearModel']),
        'date': date.today().strftime("%Y-%m-%d")
    }

def fetch_car_data(page):
    while True:
        headers = {
            'User-Agent': random.choice(user_agents),
            'Accept': 'application/json, text/plain, */*',
            'Accept-Language': 'pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7'

        }
        params = {
            'url': '#####', # Retirada do projeto Público para nao haver Problemas
            'actualPage': page,
            'displayPerPage': 24,
            'order': 1,
            'showMenu': True,
            'showCount': True,
            'showBreadCrumb': True,
            'testAB': False,
            'returnUrl': False
        }
        response = requests.get(url_car, headers=headers, params=params, )#proxies=proxy_config)
        car = response.json()
        code = response.status_code
        print(f"Fetching cars page {page}: {code}")
        if code == 200: break
        time.sleep(15)
    return [process_car_data(item) for item in car.get('SearchResults', [])]

def scrape_car_data(max_pages):
    with ThreadPoolExecutor(max_workers=5) as executor:
        results = executor.map(fetch_car_data, range(1, max_pages + 1))
    flat_results = [item for sublist in results for item in sublist]
    pd.DataFrame(flat_results)
    return flat_results
    
    

#print("ok")    
# Coleta de dados de carros
#df_cars = scrape_car_data(15) 
#df_cars.to_csv('output_cars_detailed.csv', index=False)
#print("Dados detalhados de motos salvos em 'output_cars_detailed.csv'.")