import forca
import jogo_adivinhacao

print("*********************************")
print("****    Escolha um jogo      ****")
print("*********************************")

jogo = int(input("(1) Forca (2) Adivinhação : "))

if jogo == 1:
    print("Iniciando forca")
    forca.jogar()
elif jogo == 2:
    print("Iniciando adivinhação")
    jogo_adivinhacao.jogar()