public class ElfoVerde extends Elfo {
 
    public ElfoVerde(String nome) {
        super(nome);
    }
            
    public void atirarFlecha(Dwarf dwarf) {
        experiencia += 2; 
        numFlechas--;
        dwarf.levarDano();
    }
    
    public void adicionarItem(Item item){
        if(item.getDescricao().equals("Espada de aço valiriano") || item.getDescricao().equals("Arco e Flecha de Vidro")){     
            inventario.adicionarItem(item);
        }
    }
}
