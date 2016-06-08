package br.com.cwi.aulas.chataula2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Run {

    public static BufferedReader getReader(String fila) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fila));
    }

    public static BufferedWriter getWriter(String fila) throws IOException {
        return new BufferedWriter(new FileWriter(fila, true));
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader bufferReader = null;
                try {
                    bufferReader = Run.getReader("chat.txt");
                    while (true) {
                        String readLine = bufferReader.readLine();
                        if (readLine != null && readLine != "" && !readLine.isEmpty()) {
                            System.out.println(readLine);
                        }
                        Thread.sleep(10001);
                    }
                } catch (Exception e) {
                    // ...
                } finally {
                    try {
                        if (bufferReader != null) {
                            bufferReader.close();
                        }
                    } catch (IOException ex) {
                        //... 
                    }
                }
            }
        }).start();

        while (true) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Digite seu nome:");
            String nome = teclado.nextLine();
            if ("sair".equals(nome)) {
                System.out.println("Chat encerrado!");
                break;
            }
            System.out.println("Digite a mensagem:");
            String mensagem = teclado.nextLine();
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = getWriter("chat.txt");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date data = new Date();
                String conteudo = dateFormat.format(data) + "\n" + nome + " says: " + mensagem;
                bufferedWriter.write(conteudo);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (Exception e) {
                //...
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (IOException ex) {
                    //... 
                }
            }
        }
    }
}