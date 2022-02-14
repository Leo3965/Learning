class Data:

    def __init__(self, dia, mes, ano):
        # dois underscore para mostrar atributo privado
        self.__dia = dia
        self.__mes = mes
        self.__ano = ano

    def formatada(self):
        print('{}/{}/{}'.format(self.__dia, self.__mes, self.__ano))