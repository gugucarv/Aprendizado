import os
from getpass import _raw_input
from os import system


def gkfv(val: object, dicionario: object) -> object:
    """
    Função busca val em dicionário e retorna a primeira chave correspondente encontrada, ou None

    """
    lista = [chave for chave, valor in dicio.items() if valor == val]
    if lista:
        return lista[0]
    return None

dic
def Menu(opcoes_menu, descricao_opcoes):
    lista_valida = []
    index = 0
    opcoes_menu.update({'Sair': 'S'})
    print(f'Escolha {descricao_opcoes}')
    for index, opcao in enumerate(opcoes_menu, 1):
        lista_valida.extend([opcoes_menu[opcao]])
        print(f'{index}) {opcao}')
    validacao_input = False
    opcao_selecionada = None

    while not validacao_input:
        try:
            inputRaw = input(f'Selecione uma opção: ')
            inputNo = int(inputRaw) - 1
            if int(inputRaw) == len(lista_valida):
                return 'S'
            elif -1 < inputNo < len(lista_valida):
                opcao_selecionada = lista_valida[inputNo]
                print(f'Opção selecionada: {gkfv(opcao_selecionada,opcoes_menu)} ')
                validacao_input = True
            else:
                print(f'Por favor, selecione uma {descricao_opcoes} válida')
                os.system('cls')
                Menu(opcoes_menu, descricao_opcoes)
        except ValueError:
            print('\n' + '!\n' * 3)
            input(f'!!!!  Permitido apenas números  !!!!\n(Aperte enter para continuar)')
            os.system('cls')
            Menu(opcoes_menu, descricao_opcoes)

    return opcao_selecionada


def Conversao(opcao_conversao):
    try:
        if opcao_conversao == 'C':
            celsius = float(input("Insira a temperatura em ºC (Celsius): "))
            fahrenheit = (celsius * 9 / 5) + 32
            print(f'{celsius:.1f} ºC (Celsius) é: {fahrenheit:.1f} ºF (Fahrenheit)')
        elif opcao_conversao == 'F':
            fahrenheit = float(input('Insira a temperatura em ºF (Fahrenheit): '))
            celsius = (fahrenheit - 32) * 5 / 9
            print(f'{fahrenheit:.1f} ºF (Fahrenheit) é: {celsius:.1f} ºC (Celsius)')
        else:
            _raw_input('Opção invalida tente novamente')
    except ValueError:
        print('\n' + '!\n' * 3)
        print('!!!!  Apenas números são permitidos  !!!!')
        _raw_input('Aperte \'ENTER\' para continuar')
        os.system('cls')
        Conversao(opcao_conversao)


menu = {'ºC (converte ºC -> ºF)': 'C', 'ºF (converte ºF -> ºC)': 'F'}
opcao = Menu(menu, 'Escala de Entrada')
if opcao == 'S':
    print('VOCÊ SAIU! ATÉ A PROXIMA!!')
    exit()
Conversao(opcao)
