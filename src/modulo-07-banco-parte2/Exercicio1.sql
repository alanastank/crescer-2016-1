-- 1) Liste os clientes e suas respectivas cidades. 
Select C.IDCliente "Id Cliente", C.Nome "Cliente", CI.Nome "Cidade", CI.UF from Cliente C join Cidade CI on C.IDCidade = CI.IDCidade;

-- 2) Liste o total de pedidos realizados no m�s de maio de 2016.
Select Count(IDPedido) "N�mero de pedidos" from Pedido where 
EXTRACT(month FROM TO_DATE(DataPedido, 'dd/mm/yyyy')) = 05 and EXTRACT(year FROM TO_DATE(DataPedido, 'dd/mm/yyyy')) = 16;

-- 3) Liste todos os clientes que tenham o LTDA no nome ou razao social. 
Select * from Cliente where lower(Nome) like '%ltda%' or lower(RazaoSocial) like '%ltda%';

-- 4) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es: 
-- Nome: Galocha Maragato; Pre�o de custo: 35.67; Pre�o de venda: 77.95; Situa��o: A 

Create sequence produto_sequence start with 8001 increment by 1 nomaxvalue; 
Insert into Produto (IdProduto, Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao) 
Values (produto_sequence.nextVal, 'Galocha Maragato', '01/06/16', 35.67, 77.95, 'A');

-- 5) Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois n�o h� relacionamento 
-- direto entre Produto e Pedido (ser� preciso relacionar PedidoItem). Obs.: o produto criado anteriormente dever� ser listado (apenas este)

Select * from Produto PR FULL OUTER JOIN PedidoItem PI on PR.IdProduto = PI.IdProduto where PI.IdProduto is null;

-- 6) Liste todos os pedidos de um determinado cliente, considere que sempre que for executar esta consulta ser� informado o IDCliente como 
-- par�metro. Dever�o ser listados: Data do Pedido, Produto, Quantide, Valor Unit�rio, e valor total. 

Select PE.DataPedido, PR.Nome, PI.Quantidade, PR.PrecoVenda "Valor unit�iro", (PR.PrecoVenda*PI.Quantidade) "Valor total" 
from Cliente C 
join Pedido PE on C.IdCliente = PE.IdCliente
join PedidoItem PI on PE.IdPedido = PI.IdPedido
join Produto PR on PI.IdProduto = PR.IdProduto;

-- 7) Fa�a uma consulta que receba um par�metro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram 
-- vendidos no �ltimo ano (desde janeiro/2016). 

-- 8) Utilizando de fun��es de agrupamento (aggregation function), fa�a uma consulta que liste agrupando por ano e m�s a quantidade de pedidos 
-- comprados, a quantidade de produtos distintos comprados, o valor total dos pedidos, o menor valor de um pedido, o maior valor de um pedido e
-- valor m�dio de um pedido. 

