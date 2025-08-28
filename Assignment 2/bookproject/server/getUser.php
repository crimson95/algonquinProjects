<?php
/* name: Jay Chao
file name: getUser.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles retrieving all users from the database. */

// Set the response content type to JSON
header('Content-Type: application/json');

// Database connection parameters
$host = 'localhost';
$user = 'root';
$pass = '';
$dbname = 'bookproject';

// Create a new MySQL connection
$conn = new mysqli($host, $user, $pass, $dbname);

// Check for connection errors
if ($conn->connect_error) {
  http_response_code(500);  // Internal Server Error
  echo json_encode([]);  // Return an empty array on error
  exit;
}

// Query to get all users (username and email), ordered by user_id descending
$result = $conn->query("SELECT user_id, username, email FROM users ORDER BY user_id DESC");
$users = [];

// Fetch each user and add to the users array
if ($result) {
  while ($row = $result->fetch_assoc()) {
    $users[] = $row;
  }
}

// Output the users array as JSON
echo json_encode($users);

// Close the database connection
$conn->close();
?>