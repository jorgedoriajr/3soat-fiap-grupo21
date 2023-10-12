--Clientes
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Daniel Teste', 'daniel@teste.com', '59766143021');
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Luis Teste', 'luis@teste.com', '60904915000');
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Lucas Teste', 'lucas@teste.com', '42030321052');
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Ana Teste', 'ana@teste.com', '02304335020');
INSERT INTO CLIENTES (NOME, EMAIL, CPF) VALUES ('Jessica Teste', 'jessica@teste.com', '66226725044');


--Categorias
INSERT INTO CATEGORIAS(NOME, DESCRICAO) VALUES ('LANCHE', 'Conjunto de ingredientes que forma um lanche');
INSERT INTO CATEGORIAS(NOME, DESCRICAO) VALUES ('ACOMPANHAMENTO', 'Produtos que acompanham o lanche');
INSERT INTO CATEGORIAS(NOME, DESCRICAO) VALUES ('BEBIDA', 'Liquido gelado para beber');
INSERT INTO CATEGORIAS(NOME, DESCRICAO) VALUES ('SOBREMESA', 'Docinho');


--Lanches
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Tião Matador', 'Hamburguer pao brioche, com alface cebola e blend de costela', 33.29, 1, '{"teste001.jpg","teste002.jpg"}');
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Maria Bonita', 'Hamburguer pao normal, com alface cebola e blend de picanha', 37.88, 1, '{"teste004.jpg","teste005.jpg"}');

--Acompanhamentos
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Batata Frita', 'Batata frita tipo palito congelada', 15.82, 2, '{"teste006.jpg","teste007.jpg"}');
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Batata com Cheddar e Bacon', 'Batata frita rustica com cheddar e bacon', 23.57, 2, '{"teste008.jpg","teste009.jpg"}');

--Bebidas
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Refrigerante 350ml', 'Refrigerante 350ml', 5.61, 3, '{"teste010.jpg","teste011.jpg"}');
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Suco Natural 500ml', 'Suco Natural 500ml', 8.17, 3, '{"teste012.jpg","teste013.jpg"}');

--Sobremesas
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Sorvete', 'Sorvete de massa', 13.45, 4, '{"teste014.jpg","teste015.jpg"}');
INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECO, CATEGORIA_ID, IMAGENS) VALUES ('Cokie', 'Biscoito de chocolate', 3.77, 4, '{"teste016.jpg","teste017.jpg"}');


--Pedidos
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE) VALUES (0, 194.39, '2023-10-11 20:31:56.557984', 2);
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE) VALUES (1, 190.79, '2023-10-11 20:32:52.618388', 1);
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE) VALUES (2, 81.37, '2023-10-11 20:33:21.251222', 3);
INSERT INTO PEDIDOS (ESTADO, VALOR_PEDIDO, DATA_PEDIDO, ID_CLIENTE) VALUES (3, 169.17, '2023-10-11 20:52:51.781442', 4);

INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (1, 1, 1, 'tirar a salada');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (3, 2, 1, 'COLOCA TUDO');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (3, 3, 1, 'Colocar bacon');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (3, 2, 2, 'tirar a salada');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (1, 2, 2, 'COLOCA TUDO');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (7, 5, 2, 'Colocar bacon');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (1, 2, 3, 'tirar a salada');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (1, 2, 3, 'COLOCA TUDO');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (1, 5, 3, 'Colocar bacon');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (2, 4, 4, 'Colocar bacon');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (1, 2, 4, 'Colocar bacon');
INSERT INTO ITENS_PEDIDO (QUANTIDADE, ID_PRODUTO, PEDIDOID, OBSERVACAO) VALUES (15, 5, 4, 'Colocar bacon');




