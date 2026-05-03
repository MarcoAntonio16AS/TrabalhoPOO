-- Tabelas a serem criadas: Clientes, Reservas, Recursos, Eventos;

----------------------------------------------------------------------------------------------
-- Tabela de Clientes:
----------------------------------------------------------------------------------------------

CREATE TABLE clientes(
	id_cliente		serial			primary key,
	nome_cliente	varchar(100)	not null,
	doc_cliente		varchar(14)		unique not null,
	tel_cliente		varchar(14)		not null
);

----------------------------------------------------------------------------------------------
-- Tabela de Recursos:
----------------------------------------------------------------------------------------------

CREATE TABLE recursos(
	id_recurso		serial			primary key,
	nome_recurso	varchar(50)		not null,
	tipo_recurso	varchar(50)		not null,
	cap_recurso		integer			not null,
	preco_recurso	numeric(6,2)	not null,
	disponivel		boolean			not null default true
);

-- Criação dos recursos em si, afinal, são limitados!
-- Não precisa colocar o "disponivel" na linha, pois todos estão setados como true.


-- COMANDO PARA GERAR OS RECURSOS: 
------------------------------------------------------------------
INSERT INTO recursos
(nome_recurso, tipo_recurso, cap_recurso, preco_recurso)

SELECT 
		'Quarto ' || generate_series, 
		'Quarto Comum', 
	 	 2, 
	 	 300.00

FROM generate_series(2,20);
------------------------------------------------------------------
------------------------------------------------------------------
INSERT INTO recursos
(nome_recurso, tipo_recurso, cap_recurso, preco_recurso)

SELECT 
		'Suite ' || generate_series, 
		'Suite Deluxe', 
	 	 5, 
	 	 650.00

FROM generate_series(1,7);
------------------------------------------------------------------
------------------------------------------------------------------
INSERT INTO recursos
(nome_recurso, tipo_recurso, cap_recurso, preco_recurso)

SELECT 
		'Sala ' || generate_series, 
		'Sala de Reuniões', 
	 	 20, 
	 	 65.00

FROM generate_series(1,10);
------------------------------------------------------------------
------------------------------------------------------------------
INSERT INTO recursos
(nome_recurso, tipo_recurso, cap_recurso, preco_recurso)

SELECT 
		'Salão ' || generate_series, 
		'Salão de Eventos', 
	 	 150, 
	 	 300.00

FROM generate_series(1,3);
------------------------------------------------------------------

----------------------------------------------------------------------------------------------
-- Tabela de Reservas:
----------------------------------------------------------------------------------------------

CREATE TABLE reservas(
	id_reserva		serial			primary key,
	id_cliente		integer			not null,
	id_recurso		integer			not null,
	
	inicio_reserva	timestamp		not null,
	fim_reserva		timestamp		not null,
	
	total_reserva	numeric(12,2)	not null,

	----------------------------------------------

	FOREIGN KEY (id_cliente)
	REFERENCES clientes(id_cliente),

	FOREIGN KEY (id_recurso)
	REFERENCES recursos(id_recurso)
);

----------------------------------------------------------------------------------------------
-- Tabela de EventosReserva:
----------------------------------------------------------------------------------------------

CREATE TABLE eventos_reserva(
	id_evento		SERIAL 			PRIMARY KEY,
	id_reserva		INTEGER 		NOT NULL,

	tipo_evento		VARCHAR(50) 	NOT NULL,
	data_evento		TIMESTAMP 		NOT NULL,
	descricao		VARCHAR(255),

	-----------------------------------------------

	FOREIGN KEY (id_reserva)
	REFERENCES reservas(id_reserva)
);

----------------------------------------------------------------------------------------------
-- Testes de Verificação:
----------------------------------------------------------------------------------------------

SELECT * FROM clientes; 		-- Funcionando | Cloud funcionando
SELECT * FROM recursos; 		-- Funcionando | Cloud funcionando
SELECT * FROM reservas; 		-- Funcionando | Cloud funcionando
SELECT * FROM eventos_reserva; 	-- Funcionando | Cloud funcionando

----------------------------------------------------------------------------------------------