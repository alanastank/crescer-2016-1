--1) Retornar o primeiro nome do associado
	Select SUBSTRING(Nome, 1, CHARINDEX(' ', Nome, 1) - 1) Nome From Associado;

--2) Nome dos associados e a idade de cada um
	Select Nome, DATEDIFF (YEAR, DataNascimento, getDate()) Idade From Associado;
 
--3) Empregados admitidos entre 01/05/1980 e 20/01/1982. Total de meses de trabalho até a data de 31/12/2000.
	Select *, DATEDIFF (MONTH, DataAdmissao, convert(datetime, '31/12/2000', 103)) As TotalDeMesesAte2000 From Empregado
	where DataAdmissao between convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103);

--4) Cargo com mais empregados 
	Select top 1 Cargo, COUNT(IDEmpregado) NumeroEmpregados From Empregado group by Cargo order by COUNT(IDEmpregado) desc;
	
--6) Retornar a data e o dia da semana em que os associados completaram ou completarão 50 anos
	Select Nome,
	   Dateadd(Year,50,DataNascimento) 'Data dos 50 anos',
	   Datename(weekday,Dateadd(Year,50,DataNascimento)) 'Dia da semana' 
	From Associado;

--7) Retornar quantidade de cidades por estado
	Select UF, COUNT(IDCidade) NumeroCidades From Cidade Group By UF;

--8) Retornar cidades que possuem o mesmo nome e estado (cidades duplicadas)
	Select Nome From Cidade Group By Nome Having COUNT(Nome) > 1;

--9) Retornar o próximo ID para criação de um novo registro na tabela Associado (maior + 1)
	Select (MAX(IDAssociado)+1) ProximoID From Associado;

--10) Limpar a tabela CidadeAux e insira somente as cidades com nomes e UF's distintos, considere somente o menor id das cidades duplicadas
	Select MIN(IDCidade) IDCidade, Nome, UF Into CidadeAux From Cidade Group By Nome, UF;

--11) Altere todas as cidades duplicadas acrescentando no inicio do nome um asterisco (*)
	Update Cidade Set Nome = Concat('* ', Nome) where Nome in(Select Nome From Cidade Group By Nome Having Count(Nome)>1);

--12) Retornar o nome dos associados e a descrição da coluna sexo, informando masculino ou feminino
	Select Nome, Sexo = 
	Case	
		when Sexo = 'F' then 'Feminino'
		when Sexo = 'M' then 'Masculino'
		else 'sem gênero identificado'
	End
	From Associado;

--13) Retornar nome do empregado, salário e percentual a ser descontado do imposto de renda, considerando que: 
-- Até R$1.164 = 0%, De R$1.164 a R$2.326 = 15% e Acima de R$2.326 = 27,5%
	Select NomeEmpregado, Salario, PercentualASerDescontado =
	Case
		when Salario <= 1164 then '0%'
		when Salario between 1164 and 2326 then '15%'
		when Salario >= 2326 then '27,5%'
	End
	From Empregado Order By Salario;

--14) Eliminar as cidades duplicadas, mantendo um registro pra cada (menor IDCidade)
	Delete From Cidade Where IDCidade in(Select MAX(IDCidade) From Cidade Group By Nome Having Count(Nome)>1 );

--15) Adicione uma regra que impeça que exista mais de uma cidade com o mesmo nome em um estado
	Alter Table Cidade add Unique (Nome);
