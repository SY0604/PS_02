Inventory Management System
An Inventory Management System built with Spring Boot, JPA, and MySQL to handle the management of products, categories, and inventory stocks. The application provides CRUD operations for managing categories, products, and stock levels within the inventory.

Features
Category Management: Create, read, and delete product categories.
Product Management: Add, view, and remove products, including assigning categories and managing inventory.
Inventory Management: Update stock levels by adding or deducting quantities for each product.
REST API: Exposes various endpoints to interact with the system, such as fetching product lists, managing categories, and adjusting inventory stocks.
Technologies Used
Spring Boot: A Java-based framework for building RESTful APIs.
Spring Data JPA: Provides integration with relational databases and simplifies CRUD operations.
Hibernate: ORM for mapping Java objects to database tables.
MySQL: A relational database for storing categories, products, and inventory data.
Swagger/OpenAPI: API documentation and testing tool.
HikariCP: Connection pooling for efficient database management.
Prerequisites
Before running the application, ensure that you have the following software installed:

Java 17+
MySQL
Maven (for building the project)
Setup
1. Clone the repository
bash
Copy code
git clone https://github.com/yourusername/inventory-management.git
cd inventory-management
2. Configure MySQL Database
Make sure you have a MySQL database running on your machine. Create a new database (e.g., inventory_db) and note down the credentials.

3. Configure the application properties
Edit the src/main/resources/application.properties file and provide your database connection details:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
4. Build the project
Run the following command to build the project using Maven:

bash
Copy code
mvn clean install
5. Run the application
Start the Spring Boot application by running:

bash
Copy code
mvn spring-boot:run
The application will start on http://localhost:8080.

6. API Endpoints
The following endpoints are available for interacting with the system:

GET /api/categories: Retrieve all categories.

GET /api/categories/{id}: Retrieve a category by ID.

POST /api/categories: Create a new category.

DELETE /api/categories/{id}: Delete a category by ID.

GET /api/products: Retrieve all products.

GET /api/products/{id}: Retrieve a product by ID.

POST /api/products: Create a new product.

DELETE /api/products/{id}: Delete a product by ID.

PUT /api/inventory/{inventoryId}/add: Add stock to a product.

PUT /api/inventory/{inventoryId}/deduct: Deduct stock from a product.

7. Testing the API with Swagger
You can test and interact with the API using Swagger UI, which is available at:

bash
Copy code
http://localhost:8080/swagger-ui/index.html
8. Database Schema
The application expects the following entities in the MySQL database:

Category: Contains product categories (name).
Product: Stores product information (name, category, and associated inventory).
Inventory: Contains stock levels for each product.
Contribution
If you would like to contribute to the project, feel free to fork the repository, make changes, and submit a pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.

This README provides a high-level overview of the project, setup instructions, API endpoints, and testing with Swagger UI. You can expand or modify the sections based on additional requirements or features you add to the project.
