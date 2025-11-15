# spring-boot-rest-api-project-02
Employee Spring boot REST API using H2

What you can learn from this project ?

1. REST Controller & Routing

@RestController: Marks the class as a REST controller where each method returns JSON/HTTP responses instead of views.

@RequestMapping("/api/employees"): Defines the base URL for all endpoints in this controller.

HTTP method mappings:

@GetMapping – Read data (GET /api/employees, GET /api/employees/{id})

@PostMapping – Create data (POST /api/employees)

@PutMapping – Update data (PUT /api/employees/{id})

@DeleteMapping – Delete data (DELETE /api/employees/{id})

👉 You should understand: basic RESTful principles, how URLs map to controller methods, and when to use GET/POST/PUT/DELETE.

2. Dependency Injection & Service Layer

The controller depends on EmployeeService, injected via constructor:

@Autowired
public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
}


The controller does not talk directly to the database. It delegates all business logic and persistence to the service layer (EmployeeService), which in turn uses DAO / repository classes.

👉 You should understand:

What dependency injection (DI) is and why we use it.

Separation of concerns: Controller (HTTP) vs Service (business logic) vs DAO/Repository (data access).

3. Request Validation & DTO (Request Object)

@Valid @RequestBody EmployeeRequest employeeRequest:

@RequestBody: Binds JSON from the HTTP request body to a Java object.

@Valid: Triggers validation based on annotations in EmployeeRequest.

EmployeeRequest is a request DTO (Data Transfer Object) that represents input data from the client and is separate from the persistence entity Employee.

👉 You should understand:

Why we use DTOs instead of exposing JPA entities directly.

Bean Validation (Jakarta Validation) annotations (@NotNull, @Size, etc.) and how @Valid works.

4. Path Variables & Basic Validation

@PathVariable @Min(value = 1) long employeeId:

@PathVariable: Binds {employeeId} from the URL to the method parameter.

@Min(1): Validates that the ID must be >= 1.

👉 You should understand:

How to extract variables from URL paths.

Simple validation on path parameters.

5. HTTP Status Codes & @ResponseStatus

Each endpoint explicitly sets the expected HTTP status:

@ResponseStatus(HttpStatus.OK) – 200 OK for successful GET/PUT.

@ResponseStatus(HttpStatus.CREATED) – 201 Created when a new employee is created.

@ResponseStatus(HttpStatus.NO_CONTENT) – 204 No Content when an employee is deleted.

👉 You should understand:

Common HTTP status codes for REST APIs.

How to return the correct status depending on the operation.

6. Basic CRUD Operations

The controller exposes a complete CRUD API:

Read all: findAll() → GET /api/employees

Read one: getEmployeeById() → GET /api/employees/{employeeId}

Create: addEmployee() → POST /api/employees

Update: updateEmployee() → PUT /api/employees/{employeeId}

Delete: deleteEmployee() → DELETE /api/employees/{employeeId}

Each method delegates to EmployeeService, which hides the details of JPA/DAO implementation.

👉 You should understand:

The standard CRUD pattern in REST APIs.

How controller methods map to service methods.

7. OpenAPI / Swagger Documentation

@Tag(name = "Employee Rest API Endpoints", description = "Operations related to employees") – Groups endpoints under a tag in Swagger UI.

@Operation(summary = "...", description = "...") – Adds documentation for each endpoint.

👉 You should understand:

What OpenAPI/Swagger is and how it helps document and test REST APIs.

How to annotate controllers to generate API docs automatically.

8. Exception Handling (Implied)

Although not shown directly in this class, methods like employeeService.findById(employeeId) are typically expected to:

Throw a custom exception (e.g., EmployeeNotFoundException) when an employee is not found.

Be handled by a global exception handler (@ControllerAdvice) to return meaningful error responses (e.g., 404 Not Found).

👉 You should understand:

The concept of centralized exception handling in Spring Boot.

How to return error responses with proper HTTP status and error body.