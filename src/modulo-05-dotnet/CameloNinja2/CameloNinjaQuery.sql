insert into Usuario (Nome, Email, Senha) values ('teste', 'teste@teste.com', '698dc19d489c4e4db73e28a713eab07b'); /*teste*/
insert into Usuario (Nome, Email, Senha) values ('João da Silva', 'joaodasilva@cameloninja.com', '6916ce8a9595c1fb05b35e3649e22171'); /*joaodasilva*/
select * from usuario;

insert into Permissao(Permissao) values ('COMUM'), ('ADMIN');
select * from Permissao;

insert into UsuarioPermissao(Usuario_Id, Permissao_Id) values (1, 1);
insert into UsuarioPermissao(Usuario_Id, Permissao_Id) values (2, 2);
select * from UsuarioPermissao;