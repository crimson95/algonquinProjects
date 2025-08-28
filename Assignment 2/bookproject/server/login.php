<?php
/* name: Jay Chao
file name: login.php
create date: 2025-08-04
Section: CST 8285 section 312
description: This script handles user login. */

session_start();
header('Content-Type: application/json');
$data = json_decode(file_get_contents("php://input"), true);

$username = $data['username'];
$password = $data['password'];

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
$password = $data['password'] ?? '';

// Validate required fields
if (!$username || !$password) {
  http_response_code(400);
  if (!$username) {
    echo json_encode(['success' => false, 'message' => 'Username is required.']);
  } else if (!$password) {
    echo json_encode(['success' => false, 'message' => 'Password is required.']);
  }
  exit;
}

// Prepare and execute the SQL statement to check user credentials
$stmt = $conn->prepare("SELECT * FROM Users WHERE username = ?");
$stmt->bind_param("s", $username);
$stmt->execute();
$result = $stmt->get_result();

if ($result && $result->num_rows > 0) {
  $user = $result->fetch_assoc();
  if (password_verify($password, $user['password'])) {
    echo json_encode(["success" => true]);
  } else {
    echo json_encode(["success" => false, "message" => "Incorrect password."]);
  }
} else {
  echo json_encode(["success" => false, "message" => "User not found."]);
}

$stmt->close();
$conn->close();
?>