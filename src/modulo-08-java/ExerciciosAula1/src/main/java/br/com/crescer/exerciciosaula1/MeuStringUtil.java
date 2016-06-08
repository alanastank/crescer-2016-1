package br.com.crescer.exerciciosaula1;

import java.util.Scanner;

public class MeuStringUtil {

    public static boolean validarString(String palavra) {
        if (palavra == null) return true;
        return palavra.trim().length() == 0;
    }

    public static int contarVogais(String palavra) {
        if (palavra == null) return 0;
        int contadorVogais = 0;
        String[] letrasDaPalavra = palavra.toLowerCase().split("");
        for (String letra : letrasDaPalavra) {
            if (letra.equalsIgnoreCase("a") || letra.equalsIgnoreCase("e") || letra.equalsIgnoreCase("i") || letra.equalsIgnoreCase("o") || letra.equalsIgnoreCase("u")){
                contadorVogais++;
            }
        }
        return contadorVogais;
    }

    public static String inverterString(String palavra) {
        if (palavra == null) return "";
        return new StringBuilder(palavra.toLowerCase()).reverse().toString();
    }

    public static boolean verificarSeEhPalindromo(String palavra) {
        if (palavra == null || palavra == "") return false;
         // TODO: arrumar para frase
        String palavraInversa = inverterString(palavra);
        return palavraInversa.toLowerCase().equalsIgnoreCase(palavra);
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
                
                if (opcao == 1) System.out.println(validarString(palavra) ? "A palavra é vazia" : "A palavra não é vazia");
                if (opcao == 2) System.out.println("A palavra possui " + contarVogais(palavra) + " vogais.");
                if (opcao == 3) System.out.println("A palavra invertida é: " + inverterString(palavra));
                if (opcao == 4) System.out.println(verificarSeEhPalindromo(palavra) ? "A palavra é um palíndromo." : "A palavra não é um palíndromo.");
                
                System.out.println("\nDeseja fazer outra operação? 1 - Sim 2- Não");
                continuar = teclado.nextInt();
            } 
            
            while (continuar != 2);
            System.out.println("\nOperação finalizada.");
            teclado.close();
        }
    }
