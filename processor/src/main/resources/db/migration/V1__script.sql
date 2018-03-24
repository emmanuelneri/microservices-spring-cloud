CREATE TABLE sales_order (
  id BIGSERIAL PRIMARY KEY,
  customer_id VARCHAR(14) NOT NULL,
  identifier VARCHAR(20) NOT NULL,
  date_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  total NUMERIC(19, 2) NOT NULL,
  CONSTRAINT sales_order_uk UNIQUE (identifier)
);