import random
import matplotlib.pyplot as plt

def main():
    cont = 0
    print("comenzar")
    cont += 1
    contador = [0] * 100000
    intentos = 0
    contador2 = 0

    while intentos < 200000:
        loteria = random.randint(0, 99999)
        contador[loteria] += 1
        intentos += 1

    for i in range(100000):
        if contador[i] >= 10:
            print(f"El número {i:05d} ha salido como mínimo 10 veces")
            contador2 += 1

    print(f"En total salieron {contador2} premiados 10 veces o más")

    # Generar un gráfico de barras
    numeros = list(range(100000))
    veces_salido = [contador[i] for i in range(100000)]
    plt.bar(numeros, veces_salido)
    plt.xlabel('Número de lotería')
    plt.ylabel('Veces que ha salido')
    plt.title('Resultados de la lotería')
    plt.show()

if __name__ == "__main__":
    main()