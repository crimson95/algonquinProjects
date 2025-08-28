<?php
/* name: Jay Chao
file name: filterBook.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles filtering books by genre. */

// Set the content type to JSON
header("Content-Type: application/json");
$data = json_decode(file_get_contents("php://input"), true);
$genre = $data['genre'];

// Database connection parameters
$host = 'localhost';
$user = 'root';
$pass = '';
$dbname = 'bookproject';

// Create a new MySQL connection
$conn = new mysqli($host, $user, $pass, $dbname);
if ($conn->connect_error) {
  http_response_code(500);
  echo json_encode(["error" => "DB connection failed"]);
  exit;
}

// Prepare the SQL statement based on the genre filter
if ($genre === "") {
  $sql = "SELECT * FROM Books";
  $stmt = $conn->prepare($sql);
} else {
  $sql = "SELECT * FROM Books WHERE genre = ?";
  $stmt = $conn->prepare($sql);
  $stmt->bind_param("s", $genre);
}

// Execute the statement and fetch results
$stmt->execute();
$result = $stmt->get_result();
$books = [];

// Check if any books were found
while ($row = $result->fetch_assoc()) {
  $books[] = $row;
}

// Return the books as a JSON response
echo json_encode($books);
$stmt->close();
$conn->close();
?>
