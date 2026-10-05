
CREATE TABLE item (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('LIVRO', 'REVISTA')),
    autor VARCHAR(100),
    edicao VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('ALUNO', 'PROFESSOR')),
    limite_itens INT NOT NULL
);

CREATE TABLE emprestimo (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INT NOT NULL REFERENCES item(id),
    usuario_id INT NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE, 
    valor_multa NUMERIC(10, 2) DEFAULT 0.00
);

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('L01', 'Java para Iniciantes', 'LIVRO', 'Paul Deitel', '10ª Edição', FALSE),
('L02', 'Banco de Dados Relacional', 'LIVRO', 'Silberschatz', '6ª Edição', TRUE),
('R01', 'Tech Monthly', 'REVISTA', 'Editora Tech', 'Ed. 45', TRUE),
('L03', 'Engenharia de Software', 'LIVRO', 'Pressman', '8ª Edição', TRUE);

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Carlos Silva', 'ALUNO', 3),
('Dra. Ana Souza', 'PROFESSOR', 5);


INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES (3, 2, '2026-09-01', '2026-09-08', '2026-09-10', 2.00);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES (1, 1, '2026-10-01', '2026-10-15', NULL, 0.00);
