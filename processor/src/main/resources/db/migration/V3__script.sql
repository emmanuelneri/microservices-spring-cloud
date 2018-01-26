CREATE TABLE sales_order (
  id BIGSERIAL PRIMARY KEY,
  customer_id VARCHAR(14) NOT NULL,
  identifier VARCHAR(20) NOT NULL,
  date_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  total NUMERIC(19, 2) NOT NULL,
  CONSTRAINT sales_order_uk UNIQUE (identifier),
  CONSTRAINT sales_order_customer_id_fk FOREIGN KEY (customer_id) REFERENCES customer(cnpj)
);

CREATE INDEX sales_order_order_customer_id_idx ON sales_order(customer_id);

