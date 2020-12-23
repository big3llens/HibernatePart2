CREATE TABLE products (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    cost INT NOT NULL,
    PRIMARY KEY (id))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_ru_0900_as_cs;