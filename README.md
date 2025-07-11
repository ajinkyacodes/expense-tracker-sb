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

- Added dependency called springdoc-openapi
- It's a Java Library that provides integration between spring-boot and swagger-ui
- Generates documentation in JSON/YAML and HTML format APIs 
- Added @OpenAPIDefinition annotation in Java Main File
- Customized Swagger API Documentation with annotations like @Tag, @Operation, and @ApiResponse for each API Controller Method
- Customized Swagger Models Documentation with annotations like @Schema for ErrorDetails, CategoryDto, and ExpenseDTo

