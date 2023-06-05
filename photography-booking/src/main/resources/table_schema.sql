-- Table for 'customer'
CREATE TABLE customer (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);

-- Table for 'photographer'
CREATE TABLE photographer (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);

-- Table for 'booking'
CREATE TABLE booking (
  id INT PRIMARY KEY AUTO_INCREMENT,
  bookingDate DATE NOT NULL,
  customerId INT NOT NULL,
  photographerId INT NOT NULL,
  FOREIGN KEY (customerId) REFERENCES customer(id),
  FOREIGN KEY (photographerId) REFERENCES photographer(id)
);
