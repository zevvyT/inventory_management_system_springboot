# Quick Start Guide - Inventory Management System

## 🚀 Quick Setup (3 Steps)

### Step 1: Create the Database
Open SQL Server Management Studio (SSMS) or run this command:
```bash
sqlcmd -S localhost\SQLEXPRESS -E -Q "CREATE DATABASE InventoryDB"
```

### Step 2: Run the Application
```bash
cd C:\Users\abdulhafiz.pcsb\.gemini\antigravity\scratch\inventory-management
mvn spring-boot:run
```

### Step 3: Access the Application
Open your browser and go to: **http://localhost:8080**

## 📋 Testing CRUD Operations

1. **Create**: Click "Add New Product" → Fill form → Submit
2. **Read**: View all products on the main page
3. **Update**: Click "Edit" → Modify → Submit
4. **Delete**: Click "Delete" → Confirm

## 📁 Project Location
```
C:\Users\abdulhafiz.pcsb\.gemini\antigravity\scratch\inventory-management\
```

## 📚 Documentation
- Full details: See [README.md](file:///C:/Users/abdulhafiz.pcsb/.gemini/antigravity/scratch/inventory-management/README.md)
- Walkthrough: See [walkthrough.md](file:///C:/Users/abdulhafiz.pcsb/.gemini/antigravity/brain/e9db8f0f-23f1-4bfa-9f6a-b3141093681e/walkthrough.md)

## ⚠️ Important Notes
- **Database**: Must be created manually (InventoryDB)
- **Java Version**: Java 8 (already installed)
- **Port**: Application runs on port 8080
- **Auto-Schema**: Hibernate creates tables automatically
