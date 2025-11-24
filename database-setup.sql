-- Inventory Management System - Database Setup Script
-- This script creates the InventoryDB database if it doesn't exist
-- Run this with: sqlcmd -S localhost\SQLEXPRESS -i database-setup.sql

-- Note: If you get permission errors, you can create the database manually:
-- 1. Open SQL Server Management Studio (SSMS)
-- 2. Connect to localhost\SQLEXPRESS
-- 3. Right-click on Databases -> New Database
-- 4. Enter "InventoryDB" as the database name
-- 5. Click OK

USE master;
GO

-- Check if database exists, create if not
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'InventoryDB')
BEGIN
    CREATE DATABASE InventoryDB;
    PRINT 'Database InventoryDB created successfully.';
END
ELSE
BEGIN
    PRINT 'Database InventoryDB already exists.';
END
GO

USE InventoryDB;
GO

-- The products table will be created automatically by Hibernate
-- This script is just for database creation
PRINT 'Database setup complete. Hibernate will create the products table on application startup.';
GO
