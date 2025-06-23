delimiter $$

create procedure findProductsByPrice(
    minPrice decimal(10,2),
    maxPrice decimal(10, 2)
)

BEGIN
    SELECT id, name, description, price, category_id
    FROM products
    WHERE price BETWEEN minPrice AND maxPrice
    ORDER BY name;
END $$

delimiter ;