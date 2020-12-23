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