# GitHub Repository Listing API

This Spring Boot application serves as an API to list GitHub repositories for a given user. Retrieves repository information from the GitHub API using a provided username and provides it in JSON format.

## Features

- Retrieves GitHub repositories for a specified user.
- Returns repository name, owner, and branches information.

## Technologies Used

- Java
- Spring Boot
- RestTemplate
- Mockito

## Prerequisites

- Java JDK 21 
- Maven 
- IDE

## Setup

1. Build the project using Maven.
2. Run the application.
3. The application will start running at http://localhost:8080.

## API Endpoints

- `GET /repositories/{username}`: Retrieve GitHub repositories and branches for the specified username.

## Response Format

The API responds with JSON containing the following information for each repository:
- Repository Name
- Owner Login
- Branches (name and last commit SHA)

In case of a non-existing GitHub user, the API returns a 404 response with a JSON error message.

## Testing

- Unit tests are included using JUnit and Mockito for testing controller logic.