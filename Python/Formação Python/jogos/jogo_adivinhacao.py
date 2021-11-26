import random

def jogar():
    print("*********************************")
    print("Bem vindo ao jogo de adivinhação")
    print("*********************************")

    numero_secreto = random.randrange(1, 101)
    contador = 0
    turno = 1
    pontos = 1000
    tag = True

    while tag:

        print("Qual será o nível de dificuldade?")
        nivel = int(input("(1) Fácil (2) Médio (3) Difícil : "))

        if nivel > 3 or nivel < 1:
            print("Valor inválido")
        elif nivel == 1:
            total_de_tentativas = 10
            tag = False
        elif nivel == 2:
            total_de_tentativas = 5
            tag = False
        elif nivel == 3:
            total_de_tentativas = 3
            tag = False


    for contador in range(0, total_de_tentativas):

        print("Tentativa {} total de tentativas: {}".format(turno, total_de_tentativas))
        chute = int(input("Digite um número: "))
        print("Você digitou", chute)

        acertou = numero_secreto == chute
        maior = numero_secreto < chute

        if chute < 1 or chute > 100:
            print("Você deve digitar um número entre 1 e 100!")
            continue

        if (acertou):
            print("Você acertou e fez {} pontos".format(pontos))
            break
        elif (maior):
            print("Você errou! O seu chute foi maior que o número secreto.")
        else:
            print("Você errou! O seu chute foi menor que o número secreto.")
            pontos_perdidos = pontos - chute
            pontos -= abs(pontos_perdidos)
        turno += 1


    print("Fim do jogo")


if __name__ == "__main__":
    jogar()