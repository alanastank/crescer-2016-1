package br.com.crescer.exerciciosaula1;

import java.util.Scanner;

public class MeuStringUtil {

//Deve possuir um metodo que identifique um palíndromo.("ovo", "Ame a ema", "A sogra má e amargosa")
    public static void validarString(String palavra) {
        System.out.println(palavra.isEmpty() == true ? "A palavra é vazia" : "A palavra não é vazia");
    }

    public static void contarVogais(String palavra) {
        int contadorVogais = 0;
        String[] letrasDaPalavra = palavra.split("");
        for (String letra : letrasDaPalavra) {
            if (letra.equalsIgnoreCase("a")) contadorVogais++;
            if (letra.equalsIgnoreCase("e")) contadorVogais++;
            if (letra.equalsIgnoreCase("i")) contadorVogais++;
            if (letra.equalsIgnoreCase("o")) contadorVogais++;
            if (letra.equalsIgnoreCase("u")) contadorVogais++;
        }
        System.out.println("A palavra possui " + contadorVogais + " vogais.");
    }

    private static String inverterString(String palavra) {
        // TODO: arrumar para frase
        return new StringBuilder(palavra).reverse().toString().toLowerCase();
    }

    private static void verificarSeEhPalindromo(String palavra) {
         // TODO: arrumar para frase
        String palavraInversa = inverterString(palavra);
        System.out.println(palavraInversa.equalsIgnoreCase(palavra) ? "A palavra é um palíndromo." : "A palavra não é um palíndromo.");
    }

    public static void main(String[] args) {

            Scanner teclado = new Scanner(System.in);
            int continuar;
            
            do {
                System.out.println("\nSeja bem vindo ao MeuStringUtil. O que você deseja fazer? "
                        + "\n 1 - Validar se palavra é vazia \n 2 - Contar quantas vogais uma palavra possui "
                        + "\n 3 - Inverter uma palavra \n 4 - Verificar se uma palavra é palíndromo \n");
                int opcao = teclado.nextInt();
                
                System.out.println("Digite uma palavra");
                String palavra = teclado.next();
                
                if (opcao == 1) validarString(palavra);
                if (opcao == 2) contarVogais(palavra);
                if (opcao == 3) System.out.println("A palavra invertida é: " + inverterString(palavra));
                if (opcao == 4) verificarSeEhPalindromo(palavra);
                
                System.out.println("\nDeseja fazer outra operação? 1 - Sim 2- Não");
                continuar = teclado.nextInt();
            } 
            
            while (continuar != 2);
            System.out.println("\nOperação finalizada.");
            teclado.close();
        }
    }
