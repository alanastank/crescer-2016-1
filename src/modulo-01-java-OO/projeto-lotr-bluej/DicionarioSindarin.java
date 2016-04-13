import java.util.*;

public class DicionarioSindarin {
   public static void main(String[] args){
       HashMap<String, String> dicionarioSindarin = new HashMap<>();
       // inserir valores na lista
       dicionarioSindarin.put("terra", "amar");
       dicionarioSindarin.put("fogo", "naur");
       dicionarioSindarin.put("vento", "gwaew");
       dicionarioSindarin.put("água", "nen");
       dicionarioSindarin.put("coração", "gû");
       // obter o valor a partir de uma chave
       String terraEmSindarin = dicionarioSindarin.get("terra");
       // sobrepor o valor de uma chave
       dicionarioSindarin.put("água", "nîm");
       // remover valor a partir de chave
       dicionarioSindarin.remove("água");
       // está vazio?
       boolean estaVazio = dicionarioSindarin.isEmpty();
       // tamanho
       int tamanhoDePares = dicionarioSindarin.size();
       // contém chave?
       boolean contemAgua = dicionarioSindarin.containsKey("água");
       // contém valor?
       boolean contemValor = dicionarioSindarin.containsValue("naur");
       // quantas chaves contem o valor "naur"
       for(String chave: dicionarioSindarin.keySet()){
           System.out.println(chave);
       }
       
       int qtdNaur = 0;
       for(String valor: dicionarioSindarin.keySet()){
           if(valor.equals("naur")){
               qtdNaur++;
           }
        }
       System.out.println("Quantos tem naur: " + qtdNaur); 
           
       for (Map.Entry<String, String> chaveValor : dicionarioSindarin.entrySet()){
           if(chaveValor.getValue().equals("naur")){
              qtdNaur++;
              System.out.println("A chave " + chaveValor.getKey() + " significa naur");
          }
       }
       System.out.println("Quantos tem naur: " + qtdNaur);
       dicionarioSindarin.put("FB", "facebook");
       dicionarioSindarin.put("Ea", "badoo");
       
       for(Map.Entry<String, String> chaveValor : dicionarioSindarin.entrySet()){
           System.out.println("K: " + chaveValor.getKey() + "-V: " + chaveValor.getValue());
       }
   }
}

