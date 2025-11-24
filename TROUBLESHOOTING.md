# Troubleshooting SQL Server Connection

## Issue
The application cannot connect to SQL Server Express. The SQL Browser service is stopped and cannot be started without admin privileges.

## Solutions

### Option 1: Use SQL Server Configuration Manager (Recommended)

1. **Enable TCP/IP Protocol**:
   - Open "SQL Server Configuration Manager"
   - Navigate to: SQL Server Network Configuration → Protocols for SQLEXPRESS
   - Right-click "TCP/IP" → Enable
   - Double-click "TCP/IP" → IP Addresses tab
   - Scroll to "IPALL" section
   - Note the "TCP Dynamic Ports" value (or set "TCP Port" to 1433)
   - Restart SQL Server service

2. **Start SQL Browser Service** (requires admin):
   ```powershell
   Start-Service -Name "SQLBrowser"
   Set-Service -Name "SQLBrowser" -StartupType Automatic
   ```

### Option 2: Use SQL Authentication

If Windows Authentication is causing issues, create a SQL Server login:

1. **Create SQL Login** (in SSMS):
   ```sql
   USE master;
   CREATE LOGIN inventoryuser WITH PASSWORD = 'YourPassword123!';
   GO
   
   USE InventoryDB;
   CREATE USER inventoryuser FOR LOGIN inventoryuser;
   ALTER ROLE db_owner ADD MEMBER inventoryuser;
   GO
   ```

2. **Update application.properties**:
   ```properties
   spring.datasource.url=jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=InventoryDB;encrypt=true;trustServerCertificate=true
   spring.datasource.username=inventoryuser
   spring.datasource.password=YourPassword123!
   # Remove integratedSecurity=true from URL
   ```

### Option 3: Find Dynamic Port

SQL Server Express uses dynamic ports by default. Check the port in SQL Server Configuration Manager or error log.

### Option 4: Use LocalDB (Alternative)

If SQL Server Express is too complex, consider using LocalDB:
```properties
spring.datasource.url=jdbc:sqlserver://(localdb)\\MSSQLLocalDB;databaseName=InventoryDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true
```

## Quick Test

Test connection with sqlcmd:
```bash
# Test with Windows Auth
sqlcmd -S localhost\SQLEXPRESS -E -Q "SELECT @@VERSION"

# Test with SQL Auth
sqlcmd -S localhost\SQLEXPRESS -U inventoryuser -P YourPassword123! -Q "SELECT @@VERSION"
```

## Current Status

- ✅ SQL Server (SQLEXPRESS) is running
- ❌ SQL Browser service is stopped (needs admin to start)
- ✅ InventoryDB database exists
- ❌ Application cannot connect (connection timeout)

## Recommended Next Steps

1. Open SQL Server Configuration Manager as Administrator
2. Enable TCP/IP protocol
3. Note the port number (or set to 1433)
4. Restart SQL Server service
5. Update connection string with correct port
6. Run the application again
