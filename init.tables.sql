CREATE TABLE `store1`.`products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `cost` INT NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb4
        COLLATE = utf8mb4_ru_0900_as_cs;
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Apple', 40);
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Orange', '55');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Pasta', '45');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Milk', '60');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Meat', '90');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Potaro', '20');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Beet', '15');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Onion', '16');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Cucumber', '20');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Chocolate', '65');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Marmalade', '50');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Biscuits', '45');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Cake', '65');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Jam', '55');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Tea', '60');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Coffee', '85');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Bread', '25');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Fish', '95');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Shrimp', '90');
INSERT INTO `store1`.`products` (`title`, `cost`) VALUES ('Squid', '55');

CREATE TABLE `store1`.`buyer` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_ru_0900_as_cs;

INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('1', 'Mick');
INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('2', 'Bob');
INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('3', 'Alex');
INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('4', 'Ivan');
INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('6', 'Masha');
INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('7', 'Rita');
INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('8', 'Kirill');
INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('9', 'Max');
INSERT INTO `store1`.`buyer` (`id`, `name`) VALUES ('10', 'Marina');

CREATE TABLE `store1`.`buyers_products` (
    `buyers_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    PRIMARY KEY (`buyers_id`, `product_id`),
    INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
    CONSTRAINT `buyers_id`
        FOREIGN KEY (`buyers_id`)
        REFERENCES `store1`.`buyer` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT `product_id`
        FOREIGN KEY (`product_id`)
            REFERENCES `store1`.`products` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION);
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('1', '1');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('1', '3');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('1', '4');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('2', '5');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('3', '6');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('2', '12');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('2', '19');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('2', '4');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('3', '8');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('4', '10');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('4', '12');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('6', '8');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('6', '18');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('6', '17');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('7', '4');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('7', '8');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('7', '9');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('7', '20');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('8', '1');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('8', '2');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('8', '5');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('8', '14');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('9', '9');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('9', '11');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('9', '13');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('10', '3');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('10', '4');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('10', '8');
INSERT INTO `store1`.`buyers_products` (`buyers_id`, `product_id`) VALUES ('10', '18');
