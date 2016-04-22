-- 1) Selecione o nome do empregado e nome do departamento em que cada um está inserido.
Select E.NomeEmpregado, D.NomeDepartamento From Empregado E 
INNER JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento;

--2) Exibir o nome do associado e sua cidade, exibir também associados sem cidade relacionada
Select A.Nome, C.Nome From Associado A LEFT JOIN Cidade C ON A.IDCidade = C.IDCidade;

--3) Listar os Estados e total de cidades, exibir apenas as cidades que não possuem associados relacionados // tem que arrumar
Select C.UF, COUNT(C.IDCidade) Total_Cidades From Cidade C 
LEFT JOIN Associado A ON C.IDCidade = A.IDCidade where A.IDCidade is null Group By C.UF;

--4)Faça uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade é da 
-- região SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), senão imprimir nulo.
Select A.Nome, C.Nome, ÉDaRegiaoSul =
	Case 
		when C.UF in('RS', 'SC', 'PR') then '***'
		else null
	End
From Associado A INNER JOIN Cidade C ON A.IDCidade = C.IDCidade;

--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
Select E.NomeEmpregado NomeEmpregado, G.NomeEmpregado NomeGerente, D.NomeDepartamento From Empregado E 
INNER JOIN Empregado G ON E.IDGerente = G.IDEmpregado
INNER JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento;

--6)Faça uma cópia da tabela Empregado e altere o salário de todos os empregados (Empregado) que o departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%
--7)Liste a diferença que representará o reajuste aplicado no item anterior no somatório dos salários de todos os empregados.
--8)Liste o departamento com o empregado de maior salário.
--9)Faça uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os empregados (nome) e a cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta.
--10)Lista as cidades que tenham associado relacionados. Exibr: Nome e UF apenas