Create table Usuario (
Id int IDENTITY NOT NULL,
Nome VARCHAR(255) NOT NULL,
Email VARCHAR(255) UNIQUE NOT NULL,
Senha VARCHAR(255) NOT NULL,
PRIMARY KEY (Id)
)

Create table Permissao (
Id int IDENTITY NOT NULL,
Permissao VARCHAR(255) NOT NULL,
PRIMARY KEY (Id),
CONSTRAINT CHECK_Permissao CHECK (Permissao = 'COMUM' OR Permissao = 'ADMIN')
)

Create table UsuarioPermissao (
Id int IDENTITY NOT NULL,
Usuario_Id int NOT NULL,
Permissao_Id int NOT NULL,
PRIMARY KEY(Id),
CONSTRAINT FK_Usuario FOREIGN KEY (Usuario_Id) REFERENCES Usuario(Id),
CONSTRAINT FK_Permissao FOREIGN KEY (Permissao_Id) REFERENCES Permissao(Id)
)

Create table Produto (
Id int IDENTITY NOT NULL,
DescricaoProduto varchar(255) NOT NULL,
Valor decimal (10,2) NOT NULL,
PRIMARY KEY(Id)
)

Create table TipoPagamento (
Id int IDENTITY NOT NULL,
DescricaoPagamento varchar(255) NOT NULL,
PRIMARY KEY(Id),
CONSTRAINT CHECK_TipoPagamento CHECK 
(DescricaoPagamento = 'AMEX' OR DescricaoPagamento = 'DINERS' OR DescricaoPagamento = 'VISA' OR DescricaoPagamento = 'MASTERCARD' )
)

Create table Pedido (
Id int IDENTITY NOT NULL,
DataEntregaDesejada date NOT NULL,
Cidade varchar(255) NOT NULL,
Estado varchar(255) NOT NULL,
TipoPagamento_Id int NOT NULL,
Produto_Id int NOT NULL,
Usuario_Id int NOT NULL,
PRIMARY KEY(Id),
CONSTRAINT FK_TipoPagamento FOREIGN KEY (TipoPagamento_Id) REFERENCES TipoPagamento(Id),
CONSTRAINT FK_Produto FOREIGN KEY (Produto_Id) REFERENCES Produto(Id),
CONSTRAINT FK_Usuario_Pedido FOREIGN KEY (Usuario_Id) REFERENCES Usuario(Id)
)