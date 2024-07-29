
CREATE DATABASE IF NOT EXISTS Assignment7_db;

-- Use the new database
USE Assignment7_db;

-- Create users table
CREATE TABLE IF NOT EXISTS ass28 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
INSERT INTO ass28 (name, email) VALUES ('yuvraj', 'yuvraj@example.com');
INSERT INTO ass28 (name, email) VALUES ('vishal', 'vishal@example.com');
INSERT INTO ass28 (name, email) VALUES ('jayesh', 'jayesh@example.com');
select * from ass28;