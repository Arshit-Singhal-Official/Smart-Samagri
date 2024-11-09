-- Users Table
CREATE TABLE IF NOT EXISTS Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Ingredients Table
CREATE TABLE IF NOT EXISTS Ingredients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    category VARCHAR(50) NOT NULL,
    user_id INTEGER REFERENCES Users(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Recipes Table
CREATE TABLE IF NOT EXISTS Recipes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    user_id INTEGER REFERENCES Users(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- RecipeIngredients Table (join table for Recipes and Ingredients)
CREATE TABLE IF NOT EXISTS Recipe_Ingredients (
    id SERIAL PRIMARY KEY,
    recipe_id INTEGER REFERENCES Recipes(id) ON DELETE CASCADE,
    ingredient_id INTEGER REFERENCES Ingredients(id) ON DELETE CASCADE,
    quantity VARCHAR(50) NOT NULL
);

-- Tutorials Table
CREATE TABLE IF NOT EXISTS Tutorials (
    id SERIAL PRIMARY KEY,
    recipe_id INTEGER REFERENCES Recipes(id) ON DELETE CASCADE,
    video_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
