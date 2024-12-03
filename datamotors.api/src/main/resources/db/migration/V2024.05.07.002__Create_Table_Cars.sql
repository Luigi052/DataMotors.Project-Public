CREATE TABLE tb_cars (
                         id SERIAL PRIMARY KEY,
                         brand VARCHAR(255),
                         model VARCHAR(255),
                         version VARCHAR(255),
                         type VARCHAR(255),
                         price INT,
                         color VARCHAR(255),
                         transmission VARCHAR(255),
                         doors VARCHAR(255),
                         mileage INT,
                         city VARCHAR(255),
                         state VARCHAR(255),
                         fabyear INT,
                         modelyear INT,
                         date DATE
);
