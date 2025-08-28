<?php
/* name: Jay Chao
file name: getBook.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles retrieving all books from the database. */

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
  http_response_code(500);   // Internal Server Error
  echo json_encode(['error' => 'Database connection failed']);
  exit;
}

// Query to select all books, ordered by book_id descending
$result = $conn->query("SELECT * FROM books ORDER BY book_id DESC");

// Initialize an array to store books
$books = [];
while ($row = $result->fetch_assoc()) {
  $books[] = $row;   // Add each book to the array
}

// Return the books as a JSON response
echo json_encode($books);

// Close the database connection
$conn->close();
?>
