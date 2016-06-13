package br.com.crescer.exerciciosaula4.APP;

import br.com.crescer.exerciciosaula4.DAO.CidadeDAO;
import br.com.crescer.exerciciosaula4.DAO.ClienteDAO;
import br.com.crescer.exerciciosaula4.DAO.ICrud;
import br.com.crescer.exerciciosaula4.DAO.MaterialDAO;
import br.com.crescer.exerciciosaula4.DAO.PedidoDAO;
import br.com.crescer.exerciciosaula4.DAO.PedidoItemDAO;
import br.com.crescer.exerciciosaula4.DAO.ProdutoDAO;
import br.com.crescer.exerciciosaula4.DAO.ProdutoMaterialDAO;
import br.com.crescer.exerciciosaula4.DAO.SimpleEntityManager;
import br.com.crescer.exerciciosaula4.POJOS.Cidade;
import br.com.crescer.exerciciosaula4.POJOS.Cliente;
import br.com.crescer.exerciciosaula4.POJOS.Material;
import br.com.crescer.exerciciosaula4.POJOS.Pedido;
import br.com.crescer.exerciciosaula4.POJOS.PedidoItem;
import br.com.crescer.exerciciosaula4.POJOS.Produto;
import br.com.crescer.exerciciosaula4.POJOS.ProdutoMaterial;
import java.util.Date;

public class Menu {

    public static void main(String[] args) {
        SimpleEntityManager sem = SimpleEntityManager.getInstance();
        ICrud<Long, Cliente> clienteDAO = new ClienteDAO(sem.getEntityManager());
        ICrud<Long, Cidade> cidadeDAO = new CidadeDAO(sem.getEntityManager());
        ICrud<Long, Material> materialDAO = new MaterialDAO(sem.getEntityManager());
        ICrud<Long, Pedido> pedidoDAO = new PedidoDAO(sem.getEntityManager());
        ICrud<Long, PedidoItem> pedidoItemDAO = new PedidoItemDAO(sem.getEntityManager());
        ICrud<Long, Produto> produtoDAO = new ProdutoDAO(sem.getEntityManager());
        ICrud<Long, ProdutoMaterial> produtoMaterialDAO = new ProdutoMaterialDAO(sem.getEntityManager());

        Cidade cid1 = new Cidade("Sapucaia do Sul", "RS");
        Cidade cid2 = new Cidade("Porto Alegre", "RS");

        sem.beginTransaction();
        cidadeDAO.insert(cid1);
        cidadeDAO.insert(cid2);
        sem.commit();

        Cliente cli1 = new Cliente("João Pedro da Silva", "JP LTDA", "Av. Sertório", "Centro", cid2, 91040 - 972, "A");
        Cliente cli2 = new Cliente("Caroline Isabel Barbosa", "Inforgel", "Rua Nova Petrópolis", "Capão da Cruz", cid1, 93226465, "A");

        sem.beginTransaction();
        clienteDAO.insert(cli1);
        clienteDAO.insert(cli2);
        sem.commit();

        Material mat1 = new Material("Controle de estoque", 1.81576, 1.96);
        Material mat2 = new Material("Sistema de rastreabilidade", 2.1531, 1.79);

        sem.beginTransaction();
        materialDAO.insert(mat1);
        materialDAO.insert(mat2);
        sem.commit();

        Produto prod1 = new Produto("Suspensor Escrt", new Date(16, 2, 18), 88.27, 12.11, "B");
        sem.beginTransaction();
        produtoDAO.insert(prod1);
        sem.commit();

        sem.close();
    }

}
