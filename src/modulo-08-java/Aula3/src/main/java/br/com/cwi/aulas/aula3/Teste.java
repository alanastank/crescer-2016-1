/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aulas.aula3;

/**
 *
 * @author alana.souza
 */
public class Teste {

    public static void main(String[] args) {
        PessoaDao pessoaDao = new PessoaDao();

        Pessoa pessoaInsert = new Pessoa("Teste insert");
        pessoaDao.insert(pessoaInsert);

        Pessoa pessoaUpdate = new Pessoa(8, "Teste update");
        pessoaUpdate.setNome("Teste update atualizado");
        pessoaDao.update(pessoaUpdate);

        Pessoa pessoaDelete = new Pessoa(9, "Teste delete");
        pessoaDao.delete(pessoaDelete);
    }
}
