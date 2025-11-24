# Inventory Management System

A simple yet powerful inventory management system built with Spring Boot, Hibernate, Thymeleaf, and MSSQL database.

## Features

- ✅ **Create** new products with name, description, quantity, and price
- 📋 **Read** and view all products in a beautiful table interface
- ✏️ **Update** existing product information
- 🗑️ **Delete** products from inventory
- 💾 **MSSQL Database** integration for persistent storage
- 🎨 **Modern UI** with responsive design and smooth animations
- ⚡ **Real-time validation** and user feedback

## Technology Stack

- **Backend**: Spring Boot 3.1.5
- **ORM**: Hibernate (JPA)
- **Frontend**: Thymeleaf
- **Database**: Microsoft SQL Server (MSSQL)
- **Build Tool**: Maven
- **Java Version**: 17

## Prerequisites

Before running this application, ensure you have:

- Java 17 or higher installed
- Maven 3.6+ installed
- Microsoft SQL Server Express (or any MSSQL edition)
- SQL Server configured with Windows Authentication or SQL Authentication

## Database Setup

1. **Create the database** (if it doesn't exist):
   ```sql
   CREATE DATABASE InventoryDB;
   ```

2. **Configure connection** in `src/main/resources/application.properties`:
   - The application is configured to use Windows Integrated Security
   - Update the connection string if using SQL Authentication

3. **Automatic table creation**:
   - Hibernate is configured with `ddl-auto=update`
   - The `products` table will be created automatically on first run

## Installation & Running

1. **Clone or navigate to the project directory**:
   ```bash
   cd inventory-management
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**:
   - Open your browser and navigate to: `http://localhost:8080`

## Project Structure

```
inventory-management/
├── src/
│   ├── main/
│   │   ├── java/com/inventory/
│   │   │   ├── InventoryManagementApplication.java  # Main application class
│   │   │   ├── model/
│   │   │   │   └── Product.java                     # Product entity
│   │   │   ├── repository/
│   │   │   │   └── ProductRepository.java           # Data access layer
│   │   │   ├── service/
│   │   │   │   ├── ProductService.java              # Service interface
│   │   │   │   └── ProductServiceImpl.java          # Service implementation
│   │   │   └── controller/
│   │   │       └── ProductController.java           # MVC controller
│   │   └── resources/
│   │       ├── application.properties               # Configuration
│   │       ├── templates/                           # Thymeleaf templates
│   │       │   ├── product-list.html               # Product listing page
│   │       │   └── product-form.html               # Create/Edit form
│   │       └── static/
│   │           └── css/
│   │               └── style.css                    # Styling
└── pom.xml                                          # Maven configuration
```

## Usage

### Adding a New Product
1. Click the "➕ Add New Product" button
2. Fill in the product details (name, description, quantity, price)
3. Click "Create Product"

### Viewing Products
- All products are displayed in a table on the main page
- Low stock items (quantity < 10) are highlighted in yellow

### Editing a Product
1. Click the "✏️ Edit" button next to the product
2. Modify the product details
3. Click "Update Product"

### Deleting a Product
1. Click the "🗑️ Delete" button next to the product
2. Confirm the deletion in the popup dialog

## Configuration

### Database Configuration
Edit `src/main/resources/application.properties` to customize:
- Database URL and name
- Authentication method (Windows or SQL)
- Hibernate settings
- Server port

### Hibernate Settings
- `spring.jpa.hibernate.ddl-auto=update` - Automatically updates schema
- `spring.jpa.show-sql=true` - Shows SQL queries in console (for debugging)

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Redirects to product list |
| GET | `/products` | Display all products |
| GET | `/products/new` | Show create form |
| POST | `/products` | Create new product |
| GET | `/products/edit/{id}` | Show edit form |
| POST | `/products/update/{id}` | Update product |
| GET | `/products/delete/{id}` | Delete product |

## Troubleshooting

### Database Connection Issues
- Ensure SQL Server is running
- Verify Windows Authentication is enabled
- Check firewall settings
- Confirm database name matches configuration

### Build Issues
- Ensure Java 17 is installed: `java -version`
- Ensure Maven is installed: `mvn -version`
- Clear Maven cache: `mvn clean`

## Future Enhancements

- 🔍 Search and filter functionality
- 📊 Dashboard with analytics
- 📁 Category management
- 📸 Product images
- 📤 Export to Excel/PDF
- 🔐 User authentication and authorization
- 📱 Mobile app integration

## License

This project is open source and available for educational purposes.

## Author

Built with ❤️ using Spring Boot and Thymeleaf
