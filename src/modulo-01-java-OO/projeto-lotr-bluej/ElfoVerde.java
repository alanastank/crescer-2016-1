public class ElfoVerde extends Elfo {
 
    public ElfoVerde(String nome) {
        super(nome);
    }
            
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        experiencia++;
    }
    
    public void adicionarItem(Item item){
        if(item.getDescricao().equals("Espada de aço valiriano") || item.getDescricao().equals("Arco e Flecha de Vidro")){     
            inventario.adicionarItem(item);
        }
    }
}
