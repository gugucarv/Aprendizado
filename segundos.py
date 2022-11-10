entrada_segundos = int(input('Por favor, entre com o número de segundos que deseja converter: '))

segundos = entrada_segundos % 60
total_minutos = entrada_segundos // 60
minutos = total_minutos % 60
total_horas = total_minutos // 60
horas = total_minutos % 24
dias = total_horas // 24

print(f'{dias} dias, {horas} horas, {minutos} minutos e {segundos} segundos.')

