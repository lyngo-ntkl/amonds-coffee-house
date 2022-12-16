USE master
GO
/*
DROP DATABASE IF EXISTS AmondsCoffeeHouse
DROP TABLE IF EXISTS tblOrderDetails
DROP TABLE IF EXISTS tblOrders
DROP TABLE IF EXISTS tblProductImages
DROP TABLE IF EXISTS tblProducts
DROP TABLE IF EXISTS tblCategories
DROP TABLE IF EXISTS tblContacts
DROP TABLE IF EXISTS tblAccounts
*/
--GO
CREATE DATABASE AmondsCoffeeHouse
GO
USE AmondsCoffeeHouse
GO


/****** Object:  Table [dbo].[tblAccounts] ******/
CREATE TABLE tblAccounts(
	accountId VARCHAR(36) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(32) NOT NULL,
	username VARCHAR(50)  NOT NULL,
	roleId VARCHAR(2) NOT NULL CHECK(roleId='AD' OR roleId='US'), --AD: administrator, US: user
	status BIT, -- 1: active; 0: inactive
	phone VARCHAR(15) NOT NULL,
	CONSTRAINT UNQ_tblAccounts UNIQUE (email),
	CONSTRAINT PK_tblAccounts PRIMARY KEY CLUSTERED (accountId ASC) 
	WITH (IGNORE_DUP_KEY = OFF, PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO
INSERT tblAccounts (accountId, email, password, username, roleId, phone) VALUES ('Admin1', 'admin@gmail.com', '1', 'Administrator', 'AD', '012345678')
GO


/****** Object:  Table [dbo].[tblContacts] ******/
CREATE TABLE tblContacts(
	contactId VARCHAR(36) NOT NULL,
	accountId VARCHAR(36) NOT NULL,
	phone VARCHAR(15),
	city VARCHAR(20),
	district VARCHAR(20),
	ward VARCHAR(20),
	CONSTRAINT FK_tblContacts FOREIGN KEY (accountId) REFERENCES tblAccounts,
	CONSTRAINT PK_tblContacts PRIMARY KEY CLUSTERED (contactId ASC) 
	WITH (IGNORE_DUP_KEY = OFF, PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO


/****** Object:  Table [dbo].[tblCategories] ******/
CREATE TABLE tblCategories(
	categoryId INT IDENTITY(1,1) NOT NULL,
	categoryName VARCHAR(50) NOT NULL,
	CONSTRAINT PK_tblCategory PRIMARY KEY CLUSTERED (categoryId ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO
SET IDENTITY_INSERT tblCategories ON
INSERT tblCategories(categoryId,categoryName) VALUES (1,'Tea')
INSERT tblCategories(categoryId,categoryName) VALUES (2,'Coffee')
INSERT tblCategories(categoryId,categoryName) VALUES (3,'Milk tea')
INSERT tblCategories(categoryId,categoryName) VALUES (4,'Dessert')
SET IDENTITY_INSERT tblCategories OFF


/****** Object:  Table [dbo].[tblProducts] ******/
CREATE TABLE tblProducts(
	productId INT IDENTITY(1,1) NOT NULL,
	productName VARCHAR(50) NOT NULL,
	price MONEY NOT NULL,
	quantity INT NOT NULL,
	categoryId INT,
	description TEXT,
	CONSTRAINT FK_tblProducts FOREIGN KEY (categoryId) REFERENCES tblCategories,
	CONSTRAINT PK_tblProducts PRIMARY KEY CLUSTERED(productId ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO

Americano	20000.0000	100	2
Earl Grey	25000.0000	100	1
Espresso	20000.0000	100	2
Latte	20000.0000	100	2
Red Velvet	30000.0000	100	4
Black Forest	30000.0000	100	4
select p1_0.productId,p1_0.categoryId,p1_0.description,p1_0.price,p1_0.productName,p1_0.quantity from tblProducts p1_0 where p1_0.productName like '%e%'

/****** Object:  Table [dbo].[tblProductImages] ******/
CREATE TABLE tblProductImages(
	productId INT NOT NULL,
	imgPath VARCHAR(70) NOT NULL,
	CONSTRAINT FK_tblProductImages FOREIGN KEY (productId) REFERENCES tblProducts,
	CONSTRAINT PK_tblProductImages PRIMARY KEY CLUSTERED(imgPath ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO


/****** Object:  Table [dbo].[tblOrders] ******/
CREATE TABLE tblOrders(
	orderId VARCHAR(32) NOT NULL,
	contactId VARCHAR(36) NOT NULL,
	status VARCHAR(2) CHECK(status = 'PR' or status = 'CO' or status = 'CA'), -- PR: processing, CO: completed, CA: cancel
	orderDate DATETIME,
	shipDate DATETIME,
	deliveryCharge MONEY,
	total MONEY,
	CONSTRAINT FK_tblOrders FOREIGN KEY (contactId) REFERENCES tblContacts,
	CONSTRAINT PK_tblOrders PRIMARY KEY CLUSTERED (orderId ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO


/****** Object:  Table [dbo].[tblOrderDetails] ******/
CREATE TABLE tblOrderDetails(
	detailId VARCHAR(32) NOT NULL,
	orderId VARCHAR(32) NOT NULL,
	productId INT NOT NULL,
	price MONEY,
	quantity INT,
	discount MONEY,
	total MONEY,
	CONSTRAINT FK_tblOrderDetail_Order FOREIGN KEY (orderId) REFERENCES tblOrders,
	CONSTRAINT FK_tblOrderDetail_Product FOREIGN KEY (productId) REFERENCES tblProducts,
	CONSTRAINT PK_tblOrderDetail PRIMARY KEY CLUSTERED (detailID ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO