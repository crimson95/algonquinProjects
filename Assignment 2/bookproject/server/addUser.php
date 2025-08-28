<?php
/* name: Jay Chao
file name: addUser.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles user registration. */

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
  echo json_encode(['success' => false, 'message' => 'DB connection failed']);
  exit;
}

// Get JSON input and extract fields
$data = json_decode(file_get_contents('php://input'), true);
$username = trim($data['username'] ?? '');
$email = trim($data['email'] ?? '');
$password = $data['password'] ?? '';

// Validate required fields
if (!$username || !$email || !$password) {
  http_response_code(400);
  if (!$username) {
    echo json_encode(['success' => false, 'message' => 'Username is required.']);
  } else if (!$email) {
    echo json_encode(['success' => false, 'message' => 'Email is required.']);
  } else if (!$password) {
    echo json_encode(['success' => false, 'message' => 'Password is required.']);
  }
  exit;
}

// Validate email format
if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
  http_response_code(400);
  echo json_encode(['success' => false, 'message' => 'Invalid email format.']);
  exit;
}

// Hash the password securely
$passwordHash = password_hash($password, PASSWORD_DEFAULT);

// Prepare and execute the insert statement
$stmt = $conn->prepare("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
$stmt->bind_param("sss", $username, $email, $passwordHash);

// Return success or error message
if ($stmt->execute()) {
  echo json_encode(['success' => true]);
} else {
  http_response_code(400);
  echo json_encode(['success' => false, 'message' => 'User already exists or invalid data']);
}

// Close statement and connection
$stmt->close();
$conn->close();
?>