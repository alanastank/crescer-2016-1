import java.util.ArrayList;
import java.util.*;

public class HobbitContador {
    
    public int calcularMmc(int valor1, int valor2){   
        int i=1;    
        while(true){
            if(valor2 == 0 || valor1 == 0){
                return 0;
            }
            if( ((valor1 * i) % valor2) == 0){ 
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
}