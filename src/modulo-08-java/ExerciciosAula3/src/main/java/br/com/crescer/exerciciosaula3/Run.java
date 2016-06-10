package br.com.crescer.exerciciosaula3;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        MeuSQLUtils sqlUtils = new MeuSQLUtils();
        Scanner teclado = new Scanner(System.in);
        System.out.println("O que você deseja fazer? \n1 - Ler um arquivo sql e executar queries \n2 - Executar uma query \n3 - Importar um arquivo CSV");
        int opcao = teclado.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite o endereço do arquivo sql:");
                teclado.nextLine();
                String arquivo = teclado.nextLine();
                sqlUtils.lerArquivoSQLEExecutar(arquivo);
                break;
            case 2:
                System.out.println("Digite uma query pra ser executada:");
                teclado.nextLine();
                String query = teclado.nextLine();
                sqlUtils.executarQueryEMostrarColunasELinhasSeForSelect(query);
                break;
            case 3:
                System.out.println("Digite o endereco do arquivo csv:");
                teclado.nextLine();
                String arquivoCSV = teclado.nextLine();
                sqlUtils.importarCSV(arquivoCSV);
                break;
        }
    }
}
