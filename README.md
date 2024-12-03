# DataMotors Project

## Description

This project was developed for the "Interdisciplinary Project" and consists of three main components: a Spring Boot API for CRUD operations and security, a Docker system for containerizing the API and the database, and a Python application for data scraping. The process was closely supervised by Professor [Humberto Sandman](https://www.linkedin.com/in/hsandmann/), who guided us.

### Project Components

1. **Spring Boot API**: Responsible for performing CRUD operations and implementing security filters using Spring Security and JWT token. This API provides secure endpoints for data manipulation, including creation, reading, updating, and deletion of records in the PostgreSQL database.

2. **Docker**: Used to containerize the application, facilitating the creation, testing, and deployment of the API and the PostgreSQL database in an isolated and consistent manner. With Docker, all the necessary components of the application, including the API, the database, and their respective dependencies, are packaged into containers. This ensures that the development environment is replicable on any machine that has Docker installed, eliminating environment configuration issues.

   - **Docker Compose**: Used to define and manage multi-container Docker applications. It facilitates the orchestration of the containers needed to run the API and the database, defining how the services interact and allowing them to be started with a single command.

3. **Data Scraping**: Python script that simulates a large data exchange with the API. This script scrapes data from various web sources and sends this data to the API, allowing the application to use real data in its database. The script is essential for testing and for populating the database with relevant information for the application.

## Project Structure

### Docker (`Datamotors.docker.api`)
Contains the files to configure and run the database and the API in Docker containers.
- `.env`: Environment configuration file.
- `docker-compose.yaml`: Docker Compose configuration file.

### API (`datamotors.api`)
Spring Boot API responsible for performing CRUD operations on the database, as well as implementing security filters using Spring Security and JWT token.
- `Dockerfile`: Configuration file for creating the API's Docker image.
- `pom.xml`: Maven configuration file.
- `src`: Directory containing the API's source code.

### Data Scraping (`Raspagem BS`)
Python application that performs data scraping and sends it to the API, allowing the use of this data in the system.
- `carros.py`: Python script related to car data.
- `main.py`: Main script for scraping and sending data.

## System Requirements

To set up and run this project, you will need the following software installed on your system:

- **Java 11** or higher: To compile and run the Spring Boot API.
- **Maven 3.6.3** or higher: To manage the project's dependencies and automate the build process.
- **Docker** and **Docker Compose**: For containerizing the application and managing the services.
- **Python 3.8** or higher: To run the data scraping scripts.
- **pip**: Python's package manager, necessary for installing the required Python libraries.

## Installation of Requirements

### Maven

1. **Install Maven using npm**:
   ```bash
   npm install -g maven
   ```
2. **Verify Maven installation**:
   ```bash
   mvn -version
   ```
   - The output should show the installed version of Maven.

### Docker
**Download and install Docker**:
We recommend installing Docker via Homebrew on macOS or via the Command Prompt on Windows to ensure an easy and consistent setup.

1. **Install Docker on macOS via Homebrew**:
   ```bash
   brew install --cask docker
   ```
   - After installation, start Docker from the Launchpad.

**Install Docker on Windows via Chocolatey**:
   ```bash
   choco install docker-desktop -y
   ```

3. **Verify Docker installation**:
   ```bash
   docker --version
   ```
   - The output should show the installed version of Docker.
4. **Verify Docker Compose installation**:
   ```bash
   docker-compose --version
   ```
   - The output should show the installed version of Docker Compose.

### Python

1. **Verify Python installation**:
   ```bash
   python --version
   ```
   - The output should show if Python is installed and which version is installed.

2. **Verify pip installation**:
   ```bash
   pip --version
   ```
   - The output should show the installed version of pip.

### Installation of Python Libraries

Install the necessary libraries:
```bash
pip install requests pandas concurrent.futures datetime json random time
```

Update all Python libraries:
```bash
pip install --upgrade requests pandas concurrent.futures datetime json random time
```

## Step-by-Step to Compile and Run

### Environment Preparation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Luigi052/DataMotors.Project.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd DataMotors.Project
   ```

### Compile the API

1. **Navigate to the API directory**:
   ```bash
   cd datamotors.api
   ```

2. **Compile the API using Maven**:
   ```bash
   mvn package
   ```

### Executing with Docker

1. **Navigate to the Docker directory**:
   ```bash
   cd Datamotors.docker.api
   ```

2. **Start the Docker containers**:
   ```bash
   docker-compose up --build
   ```

### Running the Data Scraping

1. **Configure the token in the `main.py` file**:
   ```python
   token = 'Your generated Token'
   ```

2. **Run the scraping script**:
   ```bash
   python main.py
   ```

## Authentication and Account Creation

### Create Account

To create an account, make a `POST` request to `/auth/register` with the following body:
```json
{
  "login": "beto",
  "password": "1234",
  "role": "ADMIN"
}
```
Example of cURL command:
```bash
curl -X POST "http://localhost:8080/auth/register" -H "Content-Type: application/json" -d '{"login":"beto","password":"1234","role":"ADMIN"}'
```

### Obtain Token

To obtain the token, make a `POST` request to `/auth/login` with the following body:
```json
{
  "username": "beto",
  "password": "1234"
}
```
The response will include a JWT token that must be used in subsequent requests.

Example of cURL command:
```bash
curl -X POST "http://localhost:8080/auth/login" -H "Content-Type: application/json" -d '{"username":"beto","password":"1234"}'
```

## Examples of Requests with Token

### Add Car

To add a car, make a `POST` request to `/api/cars` with the following body and the JWT token in the header:
```json
{
    "brand": "PORSCHE",
    "model": "911",
    "version": "3.0 24V H6 GASOLINA CARRERA PDK",
    "type": "U",
    "price": 998000.0,
    "color": "Silver",
    "transmission": "Automatic",
    "doors": "2",
    "mileage": 1549.0,
    "city": "São Paulo",
    "state": "São Paulo (SP)",
    "fabYear": 2023,
    "modelYear": 2024,
    "date": "2024-05-28"
}
```
Header:
```
Authorization: Bearer <token>
```

Example of cURL command:
```bash
curl -X POST "http://localhost:8080/api/cars" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{"brand":"Toyota","model":"Corolla","year":2020,"price":20000}'
```

### View Cars

To view the cars, make a `GET` request to `/api/cars` with the JWT token in the header:
Header:
```
Authorization: Bearer <token>
```

Example of cURL command:
```bash
curl -X GET "http://localhost:8080/api/cars" -H "Authorization: Bearer <token>"
```

## Contributors

- [**Luigi Tomassone**](https://github.com/Luigi052)
- **Antonio Cesar**
- **Bruno Pereira**
- **Bruno Massaro**
- **Vinicius Tinoco**

## License

This project is licensed under the [MIT License](LICENSE).

---

**Note:** The application includes a dashboard for data visualization, but it will not be shown publicly due to template license restrictions.
