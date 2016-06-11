package br.com.crescer.exerciciosaula4.APP;

import br.com.crescer.exerciciosaula4.DAO.GenericDAO;
import br.com.crescer.exerciciosaula4.POJOS.Cidade;
import br.com.crescer.exerciciosaula4.POJOS.Cliente;
import br.com.crescer.exerciciosaula4.POJOS.Material;
import br.com.crescer.exerciciosaula4.POJOS.Pedido;
import br.com.crescer.exerciciosaula4.POJOS.Produto;

public class Menu {

    public static void main(String[] args) {
        GenericDAO genericDao = new GenericDAO();
        Cidade cidade = new Cidade();
        Cliente cliente = new Cliente();
        Material material = new Material();
        Pedido pedido = new Pedido();
        Produto produto = new Produto();
    }

}
