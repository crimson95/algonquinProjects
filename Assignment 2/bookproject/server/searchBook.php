<?php
/* name: Jay Chao
file name: searchBook.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles searching for books in the database. */

header('Content-Type: application/json');

$host = 'localhost';
$user = 'root';
$pass = '';
$dbname = 'bookproject';

// Create a new MySQL connection
$conn = new mysqli($host, $user, $pass, $dbname);

// Check for connection errors
if ($conn->connect_error) {
  http_response_code(500);
  echo json_encode(['error' => 'Database connection failed']);
  exit;
}

// Get the search query from the request body
$data = json_decode(file_get_contents('php://input'), true);
// Escape the query string to prevent SQL injection (not fully secure)
$query = $conn->real_escape_string($data['query']);

// SQL statement to search for books by title (vulnerability: SQL injection possible if not using prepared statements)
$sql = "SELECT * FROM books WHERE title LIKE '%$query%' ORDER BY book_id DESC";
$result = $conn->query($sql);

// Initialize an array to store the books
$books = [];
while ($row = $result->fetch_assoc()) {
  $books[] = $row;   // Add each book to the array
}

// Return the books as a JSON response
echo json_encode($books);

// Close the database connection
$conn->close();
?>
