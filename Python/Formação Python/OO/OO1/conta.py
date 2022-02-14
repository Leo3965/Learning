class Conta:

    # construtor o self é o endereço na memória do objeto
    def __init__(self, numero, titular, saldo, limite):
        print('contruindo objeto ... {}'.format(self))
        self.__numero = numero
        self.__titular = titular
        self.__saldo = saldo
        self.__limite = limite
        self.__codigo_banco = "001"

    def extrair(self):
        print('Saldo {} do titular {}'.format(self.__saldo, self.__titular))

    def depositar(self, valor):
        self.__saldo += valor

    def __pode_sacar(self, valor_a_sacar):
        valor_disponivel = self.__saldo + self.__limite
        return (valor_a_sacar <= valor_disponivel)

    def sacar(self, valor):
        if (self.__pode_sacar(valor)):
            self.__saldo -= valor
        else:
            print("O valor {} ultrapassou o limite".format(valor))

    def transferir(self, valor, conta):
        self.sacar(valor)
        conta.depositar(valor)
        print(
            'Foi transferido {} reais da conta do {} para a conta do {}'.format(valor, self.__titular, conta.__titular))

    def get_saldo(self):
        return self.__saldo

    def get_titular(self):
        return self.__limite

    def set_titular(self, titular):
        self.__titular = titular

    @property
    def limite(self):
        return self.__limite

    @limite.setter
    def limite(self, limite):
        self.__limite = limite

    @staticmethod
    def codigo_banco():
        return "001"

    @staticmethod
    def codigo_bancos():
        return {'BB': '001', 'Caixa': 104, 'Bradesco': 237}