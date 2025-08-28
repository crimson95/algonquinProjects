<?php
/* name: Jay Chao
file name: deleteBook.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles deleting a book from the database. */

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
  http_response_code(500);  // Internal Server Error
  echo json_encode(['error' => 'Database connection failed']);
  exit;
}

// Get the JSON data from the request body and decode it
$data = json_decode(file_get_contents('php://input'), true);
// Get the book ID to delete, ensure it is an integer
$book_id = intval($data['book_id']); 

// SQL statement to delete the book with the given book_id
$sql = "DELETE FROM books WHERE book_id = $book_id";
if ($conn->query($sql)) {
  echo json_encode(['success' => true]);
} else {
  http_response_code(500);  // Internal Server Error
  echo json_encode(['error' => 'Delete failed']);
}

// Close the database connection
$conn->close();
?>
