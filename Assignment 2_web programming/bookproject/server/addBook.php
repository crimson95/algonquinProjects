<?php
/* name: Jay Chao
file name: addBook.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles adding a new book to the database. */

// Set the response content type to JSON
header('Content-Type: application/json');

// Database connection parameters
$host = 'localhost';
$user = 'root';
$pass = '';
$dbname = 'bookproject';

// Create a new MySQLi connection
$conn = new mysqli($host, $user, $pass, $dbname);

// Check if the connection failed
if ($conn->connect_error) {
  http_response_code(500);
  echo json_encode(['error' => 'Database connection failed']);
  exit;
}

// Get the JSON data from the request body and decode it
$data = json_decode(file_get_contents('php://input'), true);

// Extract book details from the decoded data
$title = $data['title'] ?? '';
$author = $data['author'] ?? '';
$genre = $data['genre'] ?? '';
$user_id = 1; // Assuming a static user ID for simplicity, replace with actual user ID logic as needed

// Validate required fields
if (!$title || !$author || !$genre) {
  http_response_code(400); // Bad Request
  // Return specific error messages for missing fields
  if (!$title) {
    echo json_encode(['error' => 'Title is required.']);
  } else if (!$author) {
    echo json_encode(['error' => 'Author is required.']);
  } else if (!$genre) {
    echo json_encode(['error' => 'Genre is required.']);
  }
  exit;
}

// Prepare an SQL statement to insert the book into the database
$stmt = $conn->prepare("INSERT INTO books (title, author, genre, user_id) VALUES (?, ?, ?, ?)");
// Bind the parameters to the SQL statement
$stmt->bind_param("sssi", $title, $author, $genre, $user_id);

// Execute the statement and check
if ($stmt->execute()) {
  echo json_encode(['success' => true]);
} else {
  http_response_code(500);  // Internal Server Error
  echo json_encode(['error' => 'Insert failed']);
}

// Close the statement and the database connection
$stmt->close();
$conn->close();
?>
