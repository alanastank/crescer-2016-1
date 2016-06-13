package br.com.crescer.exerciciosaula4.POJOS;

import br.com.crescer.exerciciosaula4.POJOS.Cidade;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T11:50:57")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Cidade> cidade;
    public static volatile SingularAttribute<Cliente, String> situacao;
    public static volatile SingularAttribute<Cliente, String> endereco;
    public static volatile SingularAttribute<Cliente, String> bairro;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, Long> id;
    public static volatile SingularAttribute<Cliente, String> razaoSocial;
    public static volatile SingularAttribute<Cliente, Integer> cep;

}