
# ShopEasy - Mini E-Commerce Full-Stack Web Application

ShopEasy is a full-stack e-commerce web application built using React, Spring Boot, and MySQL. It allows users to view available products, manage product information through REST APIs, and add products to a shopping cart.

## Features

- Display all available products
- View individual product details
- Add new products
- Update existing products
- Delete products
- Add products to shopping cart
- Calculate total cart price
- Input validation
- Custom exception handling
- DTO-based data transfer using MapStruct
- MySQL database integration

## Technologies Used

### Frontend
- React.js
- JavaScript
- HTML5
- CSS3
- Vite

### Backend
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- REST APIs
- MapStruct

### Database
- MySQL

### Tools
- IntelliJ IDEA
- Postman
- Git
- GitHub
- npm

## Project Structure

```text
mini-ecommerce/
│
├── src/
│   └── main/
│       ├── java/com/example/miniecommerce/
│       │   ├── controller/
│       │   ├── service/
│       │   ├── repository/
│       │   ├── model/
│       │   ├── dto/
│       │   ├── mapper/
│       │   ├── exception/
│       │   └── MiniEcommerceApplication.java
│       │
│       └── resources/
│           ├── application.properties
│           └── application-example.properties
│
├── frontend/
│   ├── src/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   └── main.jsx
│   ├── package.json
│   └── index.html
│
├── build.gradle
├── .gitignore
└── README.md
```

## Database Configuration

1. Install MySQL on your system.
2. Open MySQL Workbench or MySQL Command Line.
3. Create the database using:

```sql
CREATE DATABASE ecommerce_db;
```

4. Navigate to `src/main/resources`.
5. Copy `application-example.properties`.
6. Rename the copied file to `application.properties`.
7. Open `application.properties` and enter your own MySQL username and password.

The application uses Spring Data JPA and Hibernate to communicate with the MySQL database.

**Important:** Do not upload your actual database credentials to GitHub.

## How to Run the Project

### 1. Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Open the Project

- Open the project in IntelliJ IDEA.
- Wait for Gradle dependencies to load.
- Make sure MySQL is running.
- Configure your database connection in `application.properties`.

### 3. Start the Backend

Run the main Spring Boot application:

`MiniEcommerceApplication.java`

The backend will start at:

```text
http://localhost:8080
```

### 4. Start the Frontend

Open a terminal inside the frontend directory:

```bash
cd frontend
npm install
npm run dev
```

The frontend will start at:

```text
http://localhost:5173
```

Open the frontend URL in your browser to use ShopEasy.

## REST API Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/products` | Add a new product |
| GET | `/api/products` | Retrieve all products |
| GET | `/api/products/{id}` | Retrieve a product by ID |
| PUT | `/api/products/{id}` | Update an existing product |
| DELETE | `/api/products/{id}` | Delete a product |
| GET | `/api/products/dto/{id}` | Retrieve product details using DTO |

## Sample Product JSON

Use the following JSON when adding a new product:

```json
{
  "name": "Wireless Mouse",
  "description": "Bluetooth wireless mouse",
  "price": 599.0,
  "quantity": 20
}
```

## Learning Outcomes

Through this project, I gained practical experience in:

- Building RESTful APIs using Spring Boot.
- Implementing CRUD operations using Spring Data JPA.
- Connecting Java applications with MySQL.
- Creating responsive user interfaces using React.
- Integrating frontend and backend applications.
- Implementing DTOs and object mapping using MapStruct.
- Applying input validation and exception handling.
- Testing REST APIs using Postman.
- Managing project dependencies using Gradle and npm.

## Future Enhancements

- User registration and login
- Shopping cart persistence
- Order management
- Payment gateway integration
- Product search and filtering
- Product images
- Online deployment

---

**Developed as a Full-Stack Mini E-Commerce Project using React, Spring Boot, and MySQL.**
