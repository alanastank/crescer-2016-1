import java.util.ArrayList;
import java.util.*;

public class HobbitContador {
    
    public int calcularMmc(int valor1, int valor2){   
        int i=1;    
        while(true){
            if(valor2 == 0 || valor1 == 0){
                return 0;
            }
            if(((valor1 * i) % valor2) == 0){ 
                return valor1*i;
            }
            i++;
        }
    }
    
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares) {
        int valor1, valor2, somaProduto=0, somaMmc=0;
        for(int i=0; i<arrayDePares.size(); i++){
            valor1 = arrayDePares.get(i).get(0);
            valor2 = arrayDePares.get(i).get(1);
            somaProduto += valor1 * valor2;
            somaMmc += calcularMmc(valor1, valor2);
        }
        return somaProduto - somaMmc;
    }    
    
    /* Como o enunciado pedia apenas o maior multiplo de 3 até um determinado número, e não todos os múltiplos de 3, o ArrayList do código original era desnecessário e foi 
    substituido por um inteiro para armazenar o maior múltiplo. A variável limite, que não chegou nem a ser declarada no código original, também é desnecessária visto que o limite 
    da repetição é o próprio valor passado como parâmetro do método. Dentro do if, como não estamos usando um arrayList, trocamos a chamada do método add(i) pela atribuição do valor 
    de i na variável maiorMultiploDeTres. Como não existe mais nenhum comando dentro do if após a atribuição da variável, o continue é desnecessário e por isso foi apagado. */
    
    public int obterMaiorMultiploDeTresAte(int numero) {
        int maiorMultiploDeTres = 0;  
        for (int i = 1; i <= numero; i++) {
            if (i % 3 == 0) {
                maiorMultiploDeTres = i;
            }
        }
        return maiorMultiploDeTres;
    }
    
    /* A variável limite, que não chegou nem a ser declarada no código original, é desnecessária visto que o limite da repetição é o próprio valor passado como parâmetro 
    do método. Break deve ser retirado, caso contrário o loop irá parar toda vez que encontrar um multiplo de 3, e não adicionará o i ao arrayList. */
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
        ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));
        for (int i = 1; i <= numero; i++) {
            if (i % 3 == 0){
                multiplos.add(i);
            }
        }
        return multiplos;
    }
}