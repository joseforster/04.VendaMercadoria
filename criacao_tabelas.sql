create schema if not exists prog_aplicacoes;

create table if not exists prog_aplicacoes.fornecedor(
	id serial primary key,
	nome varchar(150) not null,
	email varchar(45) not null,
	telefone varchar(45) not null,
	cnpj varchar(45) not null,
	ativo char default 'S' check(ativo in ('S', 'N'))
);

create table if not exists prog_aplicacoes.compra(
	id serial primary key,
	data varchar(45) not null,
	fornecedor_id int not null,
	ativo char default 'S' check(ativo in ('S', 'N')),
	foreign key (fornecedor_id) references prog_aplicacoes.fornecedor(id)
);

create table if not exists prog_aplicacoes.produto(
	id serial primary key,
	descricao varchar(150),
	valor_unitario decimal(10,2),
	qtde_estoque varchar(45),
	ativo char default 'S' check(ativo in ('S', 'N'))
);

create table if not exists prog_aplicacoes.item_compra(
	id serial primary key,
	compra_id int not null,
	produto_id int not null,
	qtde decimal(10,2) not null,
	valor decimal(10,2) not null,
	foreign key (compra_id) references prog_aplicacoes.compra(id),
	foreign key (produto_id) references prog_aplicacoes.produto(id)
	
);

create table if not exists prog_aplicacoes.endereco(
	id serial primary key,
	descricao varchar(45),
	cep varchar(10),
	ativo char default 'S' check(ativo in ('S', 'N'))
);

create table if not exists prog_aplicacoes.cliente(
	id serial primary key,
	nome varchar(150) not null,
	email varchar(45) not null,
	cpf varchar(45) not null,
	telefone varchar(45) not null,
	ativo char default 'S' check(ativo in ('S', 'N'))
);

create table if not exists prog_aplicacoes.cliente_endereco(
	id serial primary key,
	cliente_id int not null,
	endereco_id int not null,
	foreign key(cliente_id) references prog_aplicacoes.cliente(id),
	foreign key(endereco_id) references prog_aplicacoes.endereco(id)
);

create table if not exists prog_aplicacoes.pedido(
	id serial primary key,
	data date not null,
	endereco_entrega varchar(45) not null,
	observacao varchar(500),
	cliente_id int not null,
	ativo char default 'S' check(ativo in ('S', 'N')),
	foreign key (cliente_id) references prog_aplicacoes.cliente(id)
);

create table if not exists prog_aplicacoes.item_pedido(
	id serial primary key,
	produto_id int not null,
	pedido_id int not null,
	qtde integer not null,
	valor_item decimal(10,2) not null,
	foreign key (produto_id) references prog_aplicacoes.produto(id),
	foreign key (pedido_id) references prog_aplicacoes.pedido(id)
);
