-- Exercicio 1

declare

vNomeCliente CLIENTE.NOME%Type;
vNomeCidade CIDADE.NOME%Type;
vDataPrimeiroPedido PEDIDO.DATAPEDIDO%Type;
vDataUltimoPedido PEDIDO.DATAPEDIDO%Type;
vValorTotalPedidos PEDIDO.VALORPEDIDO%Type;
vQuantidadePedidos PEDIDOITEM.QUANTIDADE%Type;
vMediaValorPedidos PEDIDO.VALORPEDIDO%Type;

begin

Select C.Nome, CID.Nome, min(PE.DataPedido), max(PE.DataPedido), sum(PE.ValorPedido), count(PE.IdPedido), avg(PE.ValorPedido)
into vNomeCliente, vNomeCidade, vDataPrimeiroPedido, vDataUltimoPedido, vValorTotalPedidos, vQuantidadePedidos, vMediaValorPedidos 
from Cliente C
inner join Cidade CID on C.IdCidade = CID.IdCidade
inner join Pedido PE on C.IdCliente = PE.IdCliente
where C.IdCliente = &p_IdProduto group by C.Nome, CID.Nome;

DBMS_OUTPUT.PUT_LINE('Nome do cliente: ' || vNomeCliente);
DBMS_OUTPUT.PUT_LINE('Nome da cidade: ' || vNomeCidade);
DBMS_OUTPUT.PUT_LINE('Data do primeiro pedido: ' || vDataPrimeiroPedido);
DBMS_OUTPUT.PUT_LINE('Data do último pedido: ' || vDataUltimoPedido);
DBMS_OUTPUT.PUT_LINE('Valor total dos pedidos: ' || vValorTotalPedidos);
DBMS_OUTPUT.PUT_LINE('Quantidade de pedidos: ' || vQuantidadePedidos);
DBMS_OUTPUT.PUT_LINE('Média dos valores dos pedidos: ' || vMediaValorPedidos);

end;

-- Exercicio 2
Create sequence cidade_sequence start with 4668 increment by 1 nomaxvalue; 

declare

vNomeCidade CIDADE.NOME%Type;
vUFCidade CIDADE.UF%Type;
vCidadeExiste int;

begin

Select Count(IdCidade), Nome, UF into vCidadeExiste, vNomeCidade, vUFCidade from Cidade 
where Nome = '&p_NomeCidade' and UF = '&p_UFCidade' group by Nome, UF;

if(vCidadeExiste = 0) then
insert into Cidade(IdCidade, Nome, UF) values (cidade_sequence.nextVal, vNomeCidade, vUFCidade);
else
DBMS_OUTPUT.PUT_LINE('Existe: ' || vCidadeExiste);
DBMS_OUTPUT.PUT_LINE('Cidade: ' || vNomeCidade);
DBMS_OUTPUT.PUT_LINE('UF: ' || vUFCidade);
end if;
end;