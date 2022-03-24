
insert into produto (id, nome, preco, data_criacao, data_ultima_atualizacao, descricao) values (1, 'Kindle', 499.0, now(), now(),'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (id, nome, preco, data_criacao, data_ultima_atualizacao, descricao) values (3, 'Câmera GoPro Hero 7', 1400.0, now(), now(),'Desempenho 2x melhor.');
insert into produto (id, nome, preco, data_criacao, data_ultima_atualizacao, descricao) values (4, 'Microfone Rode Videmic', 1000.0, now(), now(),'A melhor qualidade de som.');
insert into produto (id, nome, preco, data_criacao, data_ultima_atualizacao, descricao) values (5, 'Smartphone One Plus', 2000.0, now(), now(),'O processador mais rápido.');
insert into produto (id, nome, preco, data_criacao, data_ultima_atualizacao, descricao) values (6, 'Notebook Dell', 2000.0, now(), now(),'O melhor da categoria.');

insert into produto (id, nome, preco, data_criacao, data_ultima_atualizacao, descricao) values (10,'Máquina de Lavar', 4800.0, now(), now(),'A melhor Máquina de Lavar.');
insert into produto (id, nome, preco, data_criacao, data_ultima_atualizacao, descricao) values (12,'Air Fryer Eletrolux', 600.0, now(), now(),'A mais indicada.');

-- insert into cliente (id, nome) values (1,'Fernando Medeiros');
-- insert into cliente (id, nome) values (2,'Marcos Mariano');
-- insert into cliente (id, nome) values (18,'Fernanda Morais');
-- insert into cliente (id, nome) values (3,'João');
-- insert into cliente (id, nome) values (4,'José Mineiro');
-- insert into cliente (id, nome) values (15,'Sirlene Gonçalves');
-- insert into cliente (id, nome) values (16,'Lígia');
-- insert into cliente (id, nome) values (17,'Maria Antônia');

insert into cliente (id, nome, cpf, sexo) values (1,'Fernando Medeiros', '000', 'MASCULINO');
insert into cliente (id, nome, cpf, sexo) values (2,'Marcos Mariano', '111', 'MASCULINO');
insert into cliente (id, nome, cpf, sexo) values (18,'Fernanda Morais', '222', 'FEMININO');
insert into cliente (id, nome, cpf, sexo) values (3,'João', '333', 'MASCULINO');
insert into cliente (id, nome, cpf, sexo) values (4,'José Mineiro', '444', 'MASCULINO');
insert into cliente (id, nome, cpf, sexo) values (15,'Sirlene Gonçalves', '555', 'FEMININO');
insert into cliente (id, nome, cpf, sexo) values (16,'Lígia', '666', 'FEMININO');
insert into cliente (id, nome, cpf, sexo) values (17,'Maria Antônia', '777', 'FEMININO');

-- insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (1, 'MASCULINO', date_sub(sysdate(), interval 27 year));
insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (1, 'MASCULINO', now());
insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (2, 'MASCULINO', now());
insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (18, 'FEMININO', now());
insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (3, 'MASCULINO', now());
insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (4, 'MASCULINO', now());
insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (15, 'FEMININO', now());
insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (16, 'FEMININO', now());
insert into cliente_detalhe (Cliente_id, sexo, data_nascimento) values (17, 'FEMININO', now());

insert into pedido (id, cliente_id, data_criacao, total, status) values (1, 1, now(), 998.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (2, 1, now(), 499.0, 'AGUARDANDO');

insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 499, 2);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (2, 1, 499, 1);

--insert pagamento (pedido_id, status, tipo_pagamento) values (2, 'PROCESSANDO', 'cartao');
--insert pagamento_cartao (pedido_id, numero_cartao) values (2, '123');
insert into pagamento (pedido_id, status, numero_cartao, tipo_pagamento) values (2, 'PROCESSANDO', '123', 'cartao');

insert into categoria (id, nome) values (1, 'Eletrodomésticos');

-- insert into pedido (id, cliente_id, data_criacao, total, status) values (2, 1, now(), 499.0, 'AGUARDANDO');
-- insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (2, 1, 499, 1);

-- insert into pedido (id, cliente_id, data_pedido, total, status) values (1, 1, sysdate(), 100.0,'AGUARDANDO');
-- insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 5.0, 2);




