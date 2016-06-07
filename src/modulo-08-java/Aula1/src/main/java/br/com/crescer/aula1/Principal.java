package br.com.crescer.aula1;

public class Principal {
    
     public static void main(String[] args) {
       
         String estados = "";
         
         for (Estados estado : Estados.values()) {
           System.out.print(new StringBuilder(estados).append(estado.getNome()) + ", ");
         }
    }
    
}
