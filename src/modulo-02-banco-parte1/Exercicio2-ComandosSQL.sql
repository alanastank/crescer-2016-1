--1) Retornar o primeiro nome do associado
	Select SUBSTRING(Nome, 1, CHARINDEX(' ', Nome, 1) - 1) Nome From Associado;

--2) Nome dos associados e a idade de cada um
	Select Nome, DATEDIFF (YEAR, DataNascimento, getDate()) Idade From Associado;
 
--3) Empregados admitidos entre 01/05/1980 e 20/01/1982. Total de meses de trabalho até a data de 31/12/2000.
	Select *, DATEDIFF (MONTH, DataAdmissao, convert(datetime, '31/12/2000', 103)) As TotalDeMesesAte2000 From Empregado
	where DataAdmissao between convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103);

--4) Cargo com mais empregados 
	Select top 1 Cargo, COUNT(IDEmpregado) NumeroEmpregados From Empregado group by Cargo order by COUNT(IDEmpregado) desc;