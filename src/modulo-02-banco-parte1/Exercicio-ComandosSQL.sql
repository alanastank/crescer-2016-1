--1) Retornar nome dos empregados exibindo em ordem de admissão
 	
Select NomeEmpregado Nome From Empregado order by DataAdmissao ASC;

--2) Retornar o nome dos empregados e o salário anual, onde o cargo seja Atendente ou que o salário anual seja inferior a R$18.500
	
Select NomeEmpregado Nome, (salario*12) as SalarioAnual From Empregado where Cargo like 'Atendente' or (salario*12) < 18.500;

--3) Retornar o ID da cidade de Uberlândia
	
Select IDCidade From Cidade where Nome like 'Uberlândia';

--4) Retornar todas as cidades (ID e nome) do estado do Rio Grande do Sul
	
Select IDCidade, Nome From Cidade where UF like 'RS'; 