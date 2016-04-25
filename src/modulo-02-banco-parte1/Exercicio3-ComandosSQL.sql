-- 1) Selecione o nome do empregado e nome do departamento em que cada um est� inserido.
Select E.NomeEmpregado, D.NomeDepartamento From Empregado E 
INNER JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento;

--2) Exibir o nome do associado e sua cidade, exibir tamb�m associados sem cidade relacionada
Select A.Nome, C.Nome From Associado A LEFT JOIN Cidade C ON A.IDCidade = C.IDCidade;

--3) Listar os Estados e total de cidades, exibir apenas as cidades que n�o possuem associados relacionados
Select C.UF, COUNT(C.IDCidade) Total_Cidades From Cidade C 
LEFT JOIN Associado A ON C.IDCidade = A.IDCidade where A.IDCidade is null Group By C.UF;

--4)Fa�a uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade � da 
-- regi�o SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), sen�o imprimir nulo.
Select A.Nome, C.Nome, �DaRegiaoSul =
	Case 
		when C.UF in('RS', 'SC', 'PR') then '***'
		else null
	End
From Associado A INNER JOIN Cidade C ON A.IDCidade = C.IDCidade;

--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
Select E.NomeEmpregado NomeEmpregado, G.NomeEmpregado NomeGerente, D.NomeDepartamento From Empregado E 
INNER JOIN Empregado G ON E.IDGerente = G.IDEmpregado
INNER JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento;

--6)Fa�a uma c�pia da tabela Empregado e altere o sal�rio de todos os empregados (Empregado) que o departamento fique na 
-- localidade de SAO PAULO, fa�a um reajuste de 14,5%

Select * Into EmpregadoAux From Empregado;
Begin transaction
Update EmpregadoAux Set Salario = (Salario+(Salario*14.5/100)) where Salario in
(Select Salario From EmpregadoAux E Inner Join Departamento D ON E.IDDepartamento = D.IDDepartamento where D.Localizacao = 'Sao Paulo');
rollback
commit

--7)Liste a diferen�a que representar� o reajuste aplicado no item anterior no somat�rio dos sal�rios de todos os empregados.
Select Sum(EA.Salario - E.Salario) Reajuste From Empregado E INNER JOIN EmpregadoAux EA ON E.IDEmpregado = EA.IDEmpregado;

--8)Liste o departamento com o empregado de maior sal�rio.
Select top 1 D.IDDepartamento, D.NomeDepartamento From Departamento D INNER JOIN Empregado E ON E.IDDepartamento = D.IDDepartamento 
Order By E.Salario desc;

--9)Fa�a uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os empregados (nome) e a cidade (localidade) 
-- de seu departamento, isto deve ser exibido em uma consulta.
Select A.Nome 'Nome do Empregado/Associado', C.Nome 'Cidade' From Associado A INNER JOIN Cidade C ON A.IDCidade = C.IDCidade
UNION ALL
Select E.NomeEmpregado, D.Localizacao From Empregado E Inner Join Departamento D ON E.IDDepartamento = D.IDDepartamento;

--10)Lista as cidades que tenham associado relacionados. Exibr: Nome e UF apenas
Select C.Nome, C.UF From Cidade C INNER JOIN Associado A ON C.IDCidade = A.IDCidade;