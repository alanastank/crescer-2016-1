package br.com.cwi.aulas.aula3;

public class Pessoa {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String nome;
    private long id;
    
    public Pessoa(){}
    
    public Pessoa(long id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public Pessoa(String nome){
        this.nome = nome;
    }
}
