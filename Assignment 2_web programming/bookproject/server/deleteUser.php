<?php
/* name: Jay Chao
file name: deleteUser.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles deleting a user from the database. */

// deleteUser.php
header('Content-Type: application/json');

// Database connection
$host = 'localhost';
$user = 'root';
$pass = '';
$dbname = 'bookproject';

// Create connection
$conn = new mysqli($host, $user, $pass, $dbname);

// Check connection
if ($conn->connect_error) {
  http_response_code(500);
  echo json_encode(['error' => 'Database connection failed']);
  exit;
}

// Get user ID from request
$data = json_decode(file_get_contents('php://input'), true);
// Validate input
$user_id = intval($data['user_id']);

// Delete user
$sql = "DELETE FROM users WHERE user_id = $user_id";
if ($conn->query($sql)) {
  echo json_encode(['success' => true]);
} else {
  http_response_code(500);
  echo json_encode(['error' => 'Delete failed']);
}

// Close connection
$conn->close();
?>