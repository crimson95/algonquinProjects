/* name: Jay Chao
file name: register.js
create date: 2025-08-04
Section: CST 8285 section 312
description: user registration script */

// This script handles user registration and displays a list of registered users.
document.addEventListener("DOMContentLoaded", () => {
  // Get the registration form and error message elements
  const form = document.getElementById("registerForm");
  const error = document.getElementById("registerError");
  let allUsers = [];
  // Get the login form and error message elements
  const loginForm = document.getElementById("loginForm");
  const loginError = document.getElementById("loginError");
  const searchInput = document.getElementById("search");
  loadUsers();

  // Load users from the server and render them in the list
  function loadUsers() {
    fetch('../server/getUser.php')
      .then(res => res.json())
      .then(data => {
        allUsers = data;
        renderUserList(allUsers);
      })
      .catch(() => {
        document.getElementById("userList").innerHTML = "<li>Error loading users.</li>";
      });
  }

  // Load users from the server
  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const username = document.getElementById("loginUsername").value.trim();
    const password = document.getElementById("loginPassword").value.trim();
    loginError.textContent = "";

    fetch("../server/login.php", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, password })
    })
      .then(res => res.json())
      .then(data => {
        if (data.success) {
          alert("Login successful!");
          // Redirect to the book page
          window.location.href = "book.php";
        } else {
          loginError.textContent = data.message || "Login failed.";
        }
      })
      .catch(() => {
        loginError.textContent = "Server error.";
      });
  });

  // Render the list of users
  function renderUserList(users) {
    const userList = document.getElementById("userList");
    userList.innerHTML = "";
    if (!users.length) {
      userList.innerHTML = "<li>No users registered.</li>";
      return;
    }
    // Create list items for each user
    users.forEach(user => {
      const li = document.createElement("li");
      li.textContent = `${user.username} (${user.email})`;

          // Add delete button
      const delBtn = document.createElement("button");
      delBtn.textContent = "Delete";
      delBtn.onclick = () => deleteUser(user.user_id);
      li.appendChild(delBtn);

      userList.appendChild(li);
    });
  }

  // Add deleteUser function
  function deleteUser(user_id) {
    fetch("../server/deleteUser.php", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ user_id })
    })
    .then(res => res.json())
    .then(data => {
      if (data.success) {
        loadUsers();
      } else {
        alert("Delete failed");
      }
    })
    .catch(() => alert("Server error"));
  }

  // Filter users based on search input
  if (searchInput) {
    searchInput.addEventListener("input", () => {
      const keyword = searchInput.value.trim().toLowerCase();
      const filtered = allUsers.filter(user =>
        user.username.toLowerCase().includes(keyword)
      );
      renderUserList(filtered);
    });
  }

  // Handle form submission for user registration
  form.addEventListener("submit", (e) => {
    e.preventDefault();

    // Get input values
    const usernameInput = document.getElementById("username");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");

    // Get trimmed values
    const username = usernameInput.value.trim();
    const email = emailInput.value.trim();
    const password = passwordInput.value.trim();

    // Clear error styles
    usernameInput.classList.remove("error");
    emailInput.classList.remove("error");
    passwordInput.classList.remove("error");
    error.textContent = "";

    // Validate inputs
    fetch("../server/addUser.php", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, email, password })
    })
      .then(res => res.json())
      .then(data => {
        if (data.success) {
          alert("User registered!");
          form.reset();
          loadUsers();
        } else {
          error.textContent = data.message || "Registration failed.";
          if (data.message && data.message.includes("Username")) {
            usernameInput.classList.add("error");
          } else if (data.message && data.message.includes("Email")) {
            emailInput.classList.add("error");
          } else if (data.message && data.message.includes("Password")) {
            passwordInput.classList.add("error");
          }
        }
      })
      .catch(() => {
        error.textContent = "Server error.";
      });
  });
});
