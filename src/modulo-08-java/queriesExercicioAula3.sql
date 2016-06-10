Create sequence seq_pessoa start with 1 increment by 1 nomaxvalue
Create table Pessoa(IdPessoa int, NomePessoa varchar(255) not null, PRIMARY KEY(IdPessoa))
Insert into Pessoa(IdPessoa, NomePessoa) VALUES (seq_pessoa.nextVal, 'Teste1')
Insert into Pessoa(IdPessoa, NomePessoa) VALUES (seq_pessoa.nextVal, 'Teste2')
Insert into Pessoa(IdPessoa, NomePessoa) VALUES (seq_pessoa.nextVal, 'Teste3')
Insert into Pessoa(IdPessoa, NomePessoa) VALUES (seq_pessoa.nextVal, 'Teste4')
Update Pessoa set NomePessoa = 'Teste update' where IdPessoa = 1
Delete from Pessoa where IdPessoa = 4