CREATE TABLE IF NOT EXISTS medicine_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    classification VARCHAR(255),
    dosage TEXT,
    ingredients VARCHAR(255),
    product_name VARCHAR(255)
);
