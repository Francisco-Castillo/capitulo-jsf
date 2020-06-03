CREATE TABLE peliculas(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(100),
  descripcion TEXT,
  genero VARCHAR(20),
  año VARCHAR(4)
);