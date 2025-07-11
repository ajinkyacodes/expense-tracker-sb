# Expense Tracker App
A simple Expense Tracker App using Java Spring Boot.

## Category Management

Build CRUD REST APIs

- Create Category
- Get Category
- Get All Categories
- Update Category
- Delete Category

## Expense Management

Build CRUD REST APIs

- Create Expense
- Get Expense
- Get All Expenses
- Update Expense
- Delete Expense

## Exception Handling

Performed exception handling for different conditions.

- RESOURCE_NOT_FOUND
- INTERNAL_SERVER_ERROR

## REST API Documentation

Swagger UI URL: http://localhost:8080/swagger-ui/index.html

- Added dependency called springdoc-openapi
- It's a Java Library that provides integration between spring-boot and swagger-ui
- It generates documentation in JSON/YAML and HTML format APIs 
- Added @OpenAPIDefinition annotation in Java Main File
- Added annotations like @Tag, @Operation, and @ApiResponse in API Controller
- Added annotations like @Schema for ErrorDetails, CategoryDto, and ExpenseDTo

