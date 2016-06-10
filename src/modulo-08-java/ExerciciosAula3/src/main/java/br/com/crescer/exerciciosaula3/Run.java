package br.com.crescer.exerciciosaula3;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        MeuSQLUtils sqlUtils = new MeuSQLUtils();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o endereço do arquivo sql");
        String arquivo = teclado.nextLine();
        sqlUtils.lerArquivoSQLEExecutar(arquivo);
    }

}
