import msvcrt as m
from os import system  # Utilizar função cls do terminal


def WaitEnter():
    m.getch()


def gkfv(val: str, dicio: dict) -> object:
    """
    gkfv - Get Key From Key - Função busca val em dicionário e retorna a
    primeira chave correspondente encontrada, ou None

    Args:
        val (str): Valor a ser buscado no objeto tipo dicionario
        dicio (dict): Objeto tipo dicionário onde o valor será procurado

    Returns:
        object: Retorna a chave referente ao primeiro valor encontrado, se não retorna None
    """
    lista = [chave for chave, valor in dicio.items() if valor == val]
    if lista:
        return lista[0]
    return None


def Menu(opcoes_menu: dict, descricao_opcoes: str):
    """
    Menu Exibe menu baseado nos argumentos de entrada e pede ao usuario que esclha uma opção do menu.

    Args:
        opcoes_menu (dict): Objeto contendo texto do menu (chave) e letra da escolha(valor). ex {'ºC (converte ºC -> ºF)': 'C'}
        descricao_opcoes (str): Texto de escolha a ser exibido no menu.

    Returns:
        str: Retorna valor baseado no valor de opcoes_menu (objeto dict) selecionado pelo usuario
    """
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
            inputRaw = input('Selecione uma opção: ')
            inputNo = int(inputRaw) - 1
            if int(inputRaw) == len(lista_valida):
                return 'S'
            elif -1 < inputNo < len(lista_valida):
                opcao_selecionada = lista_valida[inputNo]
                print(
                    f'Opção selecionada: {gkfv(opcao_selecionada,opcoes_menu)} ')
                validacao_input = True
            else:
                print(f'Por favor, selecione uma {descricao_opcoes} válida')
                system('cls')
                Menu(opcoes_menu, descricao_opcoes)
        except ValueError:
            print('\n' + '!\n' * 3)
            print('!!!!  Permitido apenas números  !!!!\n(Aperte enter para continuar)')
            WaitEnter()
            system('cls')
            Menu(opcoes_menu, descricao_opcoes)

    return opcao_selecionada


def Conversao(opcao_conversao: str):
    """
    Conversao Função para conversão de temperatura baseada na escolha do usuario na função Menu.

    Args:
        opcao_conversao (str): Valor retornado pela função menu.
    """

    try:
        if opcao_conversao == 'C':
            celsius = float(input("Insira a temperatura em ºC (Celsius): "))
            fahrenheit = (celsius * 9 / 5) + 32
            print(f'{celsius:.1f} ºC (Celsius) é: {fahrenheit:.1f} ºF (Fahrenheit)')
        elif opcao_conversao == 'F':
            fahrenheit = float(
                input('Insira a temperatura em ºF (Fahrenheit): '))
            celsius = (fahrenheit - 32) * 5 / 9
            print(f'{fahrenheit:.1f} ºF (Fahrenheit) é: {celsius:.1f} ºC (Celsius)')
        else:
            print('Opção invalida tente novamente')
            WaitEnter()
    except ValueError:
        print('\n' + '!\n' * 3)
        print('!!!!  Apenas números são permitidos  !!!!')
        WaitEnter()
        system('cls')
        Conversao(opcao_conversao)


menu = {'ºC (converte ºC -> ºF)': 'C', 'ºF (converte ºF -> ºC)': 'F'}
opcao = Menu(menu, 'Escala de Entrada')
if opcao == 'S':
    print('VOCÊ SAIU! ATÉ A PROXIMA!!')
    exit()
Conversao(opcao)
