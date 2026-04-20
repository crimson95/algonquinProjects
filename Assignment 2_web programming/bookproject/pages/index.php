<!--name: Jay Chao
file name: index.php
create date: 2025-08-04
Section: CST 8285 section 312
description: user registration page-->

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Register</title>
  <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
    <header>
        <h1>Book Catalog</h1>
        <nav>
        <a href="#">Home</a>
        <a href="book.php">Book</a>
    </nav>
  </header>

  <!-- Main content for user registration -->
  <main>
    <h2>User Registration</h2>
    <form id="registerForm">
      <label for="username">Username:</label>
      <input type="text" id="username" />

      <label for="email">Email:</label>
      <input type="email" id="email" />

      <label for="password">Password:</label>
      <input type="password" id="password" />

      <button type="submit">Register</button>
      <p id="registerError" class="error"></p>
    </form>

    <h2>Login</h2>
    <form id="loginForm">
      <label for="loginUsername">Username:</label>
      <input type="text" id="loginUsername" />

      <label for="loginPassword">Password:</label>
      <input type="password" id="loginPassword" />
      
      <button type="submit">Login</button>
      <p id="loginError" class="error"></p>
    </form>

    <!-- Section to display registered users -->
    <section class="user-list-section">
      <h2>Registered Users</h2>
      <input type="text" id="search" placeholder="Search by username..." />
      <ul id="userList"></ul>
    </section>
  </main>

  <script src="../scripts/register.js" defer></script>
</body>
</html>
