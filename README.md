# Smart Samagri - Your Personal Kitchen Companion

Smart Samagri is an innovative app designed to help users make the most out of their ingredients and minimize food waste. By simply entering the items available in their pantry, users can receive personalized recipe recommendations, detailed cooking instructions, and even tutorial videos to guide them through the cooking process. The app empowers users to discover new dishes and optimize meal preparation based on what they already have at home.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Security Configuration](#security-configuration)
- [Contributing](#contributing)
- [Project Status](#project-status)
- [Acknowledgements](#acknowledgements)

## Features

- **Ingredient-Based Recommendations**: Users input the ingredients they have, and Smart Samagri suggests a variety of dishes they can prepare.
- **Comprehensive Recipes**: Each dish comes with a detailed recipe, outlining step-by-step cooking instructions and tips for perfecting the meal.
- **Video Tutorials**: To make the cooking process easier, users can access tutorial videos that provide visual guidance for each recipe.
- **Personalized Experience**: The app tailors its suggestions based on user preferences, dietary restrictions, and available ingredients, ensuring a customized experience.

## Problem Solved

Many people struggle with deciding what to cook, especially when they have limited ingredients or are unfamiliar with certain recipes. Smart Samagri eliminates this challenge by providing easy-to-follow recommendations based on what users already have in their kitchen, reducing food waste and making meal planning more efficient.

## Target Audience

- Home cooks looking for quick meal ideas.
- Individuals who want to reduce food waste and maximize pantry use.
- Anyone interested in learning new recipes and improving their cooking skills.

## Prerequisites

- Java 23
- PostgreSQL
- Gradle

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Arshit-Singhal-Official/Smart-Samagri.git
    cd Smart-Samagri
    ```

2. Configure the PostgreSQL database in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=none
    spring.datasource.initialization-mode=always
    ```

3. Ensure the `schema.sql` file is in `src/main/resources` to initialize the database schema.

## Running the Application

1. Build the project:
    ```sh
    ./gradlew build
    ```

2. Run the application:
    ```sh
    ./gradlew bootRun
    ```

3. Access the application at `http://localhost:8080`.

## API Endpoints

### User Endpoints

- **Create User**
    ```sh
    POST /users
    ```

- **Retrieve All Users**
    ```sh
    GET /users
    ```

### Recipe Endpoints

- **Create Recipe**
    ```sh
    POST /api/recipes
    ```

- **Retrieve All Recipes**
    ```sh
    GET /api/recipes
    ```

### Ingredient Endpoints

- **Create Ingredient**
    ```sh
    POST /api/ingredients
    ```

- **Retrieve All Ingredients**
    ```sh
    GET /api/ingredients
    ```

### Tutorial Endpoints

- **Create Tutorial**
    ```sh
    POST /api/tutorials
    ```

- **Retrieve All Tutorials**
    ```sh
    GET /api/tutorials
    ```

## Database Schema

The database schema is defined in `src/main/resources/schema.sql` and includes the following tables:

- Users
- Ingredients
- Recipes
- Recipe_Ingredients
- Tutorials

## Security Configuration

The application uses Spring Security for authentication and authorization. The security configuration is defined in `src/main/java/com/smartsamagri/config/SecurityConfig.java`.

- Default login page: `/login`
- Default logout success URL: `/`
- Public endpoints: `/login`, `/health`

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## Project Status

The project is currently under development in the `develop` branch. Any recommendations or contributions can be made there. The project is being served for Review 1.

## Acknowledgements

Thank you for reading!