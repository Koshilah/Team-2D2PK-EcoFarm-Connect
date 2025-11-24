insert into farmer values (100,'Peter','John','peter@gmail.com','0716426637','No.111/A,Galle Rd','Colombo 03','Degree','HND');

select * from farmer;

CREATE TABLE crop (
    cropId INT AUTO_INCREMENT PRIMARY KEY,
    cropName VARCHAR(100) NOT NULL,
    variety VARCHAR(100),
    plantingDate VARCHAR(40),
    expectedHarvestDate VARCHAR(40),
    growthStage VARCHAR(50),
    yieldPrediction DOUBLE
);

create table signup(
	email varchar(30) primary key,
    password varchar(50),
    name varchar(20)
);

CREATE TABLE inventory (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50), -- e.g., Seed, Fertilizer, Tool, Equipment
    quantity INT DEFAULT 0,
    unit VARCHAR(20), -- e.g., kg, liters, units
    farm_id VARCHAR(50), -- foreign key if you have a farm table
    is_organic BOOLEAN DEFAULT FALSE,
    certification VARCHAR(100)
);

drop table inventory;
CREATE TABLE produce (
    produce_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    available_quantity INT,
    harvest_date DATE,
    price_per_unit DOUBLE
);

INSERT INTO produce VALUES
('P001', 'Carrots', 'vegetable', 100, '2025-11-10', 1.50),
('P002', 'Spinach', 'leafy', 80, '2025-11-12', 2.00),
('P003', 'Banana', 'fruit', 120, '2025-11-09', 1.20);

CREATE TABLE orders (
    order_id VARCHAR(20) PRIMARY KEY,
    customer_id VARCHAR(20),
    produce_id VARCHAR(20),
    quantity INT,
    preferred_delivery_date DATE,
    delivery_status VARCHAR(20)
);

INSERT INTO orders VALUES
('O001', 'C001', 'P001', 10, '2025-11-15', 'Pending'),
('O002', 'C002', 'P002', 5, '2025-11-16', 'Pending');

ALTER TABLE farmer
ADD COLUMN preferredChannel VARCHAR(20) DEFAULT 'Email',
ADD COLUMN notificationStatus VARCHAR(20) DEFAULT 'Active';

ALTER TABLE farmer
CHANGE farmerPhone phoneNumber VARCHAR(20);

CREATE TABLE notifications (
    notificationID VARCHAR(5) PRIMARY KEY,
    farmerID VARCHAR(10),
    message VARCHAR(250),
    sentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
drop table notifications;

CREATE TABLE notifications (
    notificationID INT AUTO_INCREMENT PRIMARY KEY,
    farmerID VARCHAR(10),
    message VARCHAR(250),
    sentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE quality_checkpoints (
  checkpointID INT PRIMARY KEY AUTO_INCREMENT,
  produceID varchar(20),
  checkpointName VARCHAR(100),
  status VARCHAR(50),
  dateChecked DATE,
  FOREIGN KEY (produceID) REFERENCES produce(produce_id)
);

CREATE TABLE inspector_alerts (
  alertID INT PRIMARY KEY AUTO_INCREMENT,
  produceID varchar(20),
  inspectorID VARCHAR(50),
  message TEXT,
  FOREIGN KEY (produceID) REFERENCES produce(produce_id)
);





