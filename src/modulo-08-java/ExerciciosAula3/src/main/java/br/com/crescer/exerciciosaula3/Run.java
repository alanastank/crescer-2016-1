package br.com.crescer.exerciciosaula3;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        MeuSQLUtils sqlUtils = new MeuSQLUtils();
        Scanner teclado = new Scanner(System.in);
        System.out.println("O que você deseja fazer? \n1 - Ler um arquivo sql e executar queries \n2 - Executar uma query");
        int opcao = teclado.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite o endereço do arquivo sql:");
                String arquivo = teclado.next();
                sqlUtils.lerArquivoSQLEExecutar(arquivo);
                break;
            case 2:
                System.out.println("Digite uma query pra ser executada:");
                String query = teclado.next();
                sqlUtils.executarQueryEMostrarColunasELinhasSeForSelect(query);
                break;
        }
    }
}
