
# Company Application

## Overview
This is a **Spring Boot** application that is built with the following stack:

- **Spring Boot** for the backend
- **JPA/Hibernate** for ORM and database interaction
- **H2DB** for the database on memory
- **Lombok** to reduce boilerplate code
- **Spring Data JPA** for repository management

## Features
- Company Accession
- Companies joined last month
- Companies that made transfers last month


## Table of Contents
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Technologies](#technologies)

## Getting Started

To get started with the application, follow these steps:

### Prerequisites
Make sure you have the following installed:
- **Java 17**
- **Maven 3.x**
- **Git**

### Clone the Repository

```bash
git clone https://github.com/mgrellet/company.git
cd company
```

### Build the Application

```bash
mvn clean package
```

## Running the Application

You can run the application by executing:

```bash
mvn spring-boot:run 
```

## API Endpoints

Below are the available API endpoints:

| HTTP Method | Endpoint                        | Description                                  |
|-------------|---------------------------------|----------------------------------------------|
| `POST`      | `/company`                      | Company Accession                            |
| `GET`       | `/company/accession-last-month` | Gets companies that joined last month.       |
| `GET`       | `/company/transfer-last-month`  | Gets companies that make transfer last month |

### Sample API Request

#### Company Accession
```bash
POST /company
Content-Type: application/json

{
    "cuit":"10-123456789-10",
    "companyName": "Acme",
    "accessionDate": "2025-02-22"

}
```

#### Response:
```json
{
  "id": 1,
  "cuit": "10-123456789-10",
  "companyName": "Acme",
  "accessionDate": "2025-02-22"
}
```

## Technologies
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2DB**
- **Lombok**

