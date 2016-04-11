import java.util.ArrayList;
import java.util.*;

public class HobbitContador {
    
    public int calcularMmc(int valor1, int valor2){  
        int mmc = 1;
            if(valor1 == valor2){  
                mmc = valor1;  
            }else{  
                for (int i=2;((valor1 > 1) || (valor2 > 1)); i++) {  
                    while(((valor1 % i) == 0) || ((valor2 % i) == 0)){  
                        if((valor1 % i) == 0){  
                           valor1 /= i;      
                        }  
                        if((valor2 % i) == 0){  
                            valor2 /= i;  
                        }  
                        mmc *= i;  
                    }  
                }  
            }  
        return mmc;  
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
