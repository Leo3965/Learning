def cria_conta(numero, titular, saldo, limite):
    return  {"numero": numero, "titular": titular, "saldo": saldo, "limite": limite}

def deposita(conta, valor):
    conta["saldo"] += valor

def saca(conta, valor):
    conta["saldo"] -= valor

def extrato(conta):
    print("Saldo é {}".format(conta["saldo"]))