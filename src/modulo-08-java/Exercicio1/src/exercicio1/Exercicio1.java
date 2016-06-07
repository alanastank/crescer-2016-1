package exercicio1;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = teclado.nextInt();
        System.out.println(numero % 2 == 0 ? "Par" : "Ímpar");
    }

}
