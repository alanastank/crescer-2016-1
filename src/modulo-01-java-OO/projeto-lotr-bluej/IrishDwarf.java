import java.util.ArrayList;

public class IrishDwarf extends Dwarf {
         
    public IrishDwarf(String nome) {
        super(nome);
    }
    
    // Sobrecarga de construtor
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) { 
        super(nome, dataNascimento);
    }
    
    // Quando eles tentarem a sorte e tiverem sucesso, ganharão 1000 * Soma de valores até a quantidade atual.
    public void tentarSorte(){
        int novaQuantidade = 0;
        int soma = 0;
        if(getNumeroSorte() == -3333.0){
            for(int i=0; i < inventario.getListaItens().size(); i++){
                for(int j=1; j <= inventario.getListaItens().get(i).getQuantidade(); j++){
                    soma += j;
                }
                novaQuantidade = (soma * 1000) + inventario.getListaItens().get(i).getQuantidade();
                inventario.getListaItens().get(i).setQuantidade(novaQuantidade);
            }
        }
    }
        
}