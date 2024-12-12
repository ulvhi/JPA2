create  TABLE customers(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(64),
    surname VARCHAR(64),
    email VARCHAR(255),
    subscription_amount NUMERIC(16, 2) DEFAULT 0,
    subscription_status VARCHAR
);
alter user postgres
with password 'postgres'