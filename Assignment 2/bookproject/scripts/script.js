/* name: Manilyn Vicenio
file name: script.php
create date: 2025-08-04
Section: CST 8285 section 312
description: book registration script */

// This script handles book management including adding, deleting, and searching books.
document.addEventListener("DOMContentLoaded", () => {
  const bookForm = document.getElementById("bookForm");
  const bookList = document.getElementById("bookList");
  const formError = document.getElementById("formError");
  const searchInput = document.getElementById("search");
  const genreFilter = document.getElementById("genreFilter");

  loadBooks();

  // Load books from the server and render them in the list
  bookForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const title = document.getElementById("title").value.trim();
    const author = document.getElementById("author").value.trim();
    const genre = document.getElementById("genre").value.trim();

    // Remove any previous error styles
    document.getElementById("title").classList.remove("error");
    document.getElementById("author").classList.remove("error");
    document.getElementById("genre").classList.remove("error");
    formError.textContent = "";

    // Clear previous error message
    fetch('../server/addBook.php', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ title, author, genre })
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
      bookForm.reset();
      loadBooks();
    } else if (data.error) {
      formError.textContent = data.error;
      // Add error class to the relevant input field
      if (data.error.includes("Title")) {
        document.getElementById("title").classList.add("error");
      } else if (data.error.includes("Author")) {
        document.getElementById("author").classList.add("error");
      } else if (data.error.includes("Genre")) {
        document.getElementById("genre").classList.add("error");
      }
    }
  })
  .catch(() => {
    formError.textContent = "Server error.";
  });
});

  // Search functionality
  searchInput.addEventListener("input", () => {
  const query = searchInput.value.trim();

  // Clear the book list before rendering new items
  fetch('../server/searchBook.php', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ query })
  })
  .then(res => res.json())
  .then(data => {
    renderBookList(data);
  })
  .catch(() => {
    bookList.innerHTML = "<li>Error searching books.</li>";
  });
});

  // Load books from the server and render them in the list
  function loadBooks(query = "") {
    fetch('../server/getBook.php')
      .then(res => res.json())
      .then(data => {
        renderBookList(data);
      })
      .catch(() => {
        bookList.innerHTML = "<li>Error loading books.</li>";
      });
  }

  // Render the list of books
  function renderBookList(data) {
  bookList.innerHTML = "";

  // If no books are found, display a message
  if (data.length === 0) {
    bookList.innerHTML = "<li>No books found.</li>";
    return;
  }
  // Clear the book list before rendering new items
  data.forEach(({ book_id, title, author, genre }) => {
    const li = document.createElement("li");
    li.innerHTML = `
      ${title} by ${author}${genre ? " - " + genre : ""}
      <button class="deleteBtn" data-id="${book_id}">Delete</button>
    `;
    bookList.appendChild(li);
  });

  // Attach delete event listeners to the newly created buttons
  document.querySelectorAll(".deleteBtn").forEach(button => {
    button.addEventListener("click", () => {
      const bookId = button.getAttribute("data-id");
      deleteBook(bookId);
    });
  });
}

  // Delete a book by its ID
  function deleteBook(bookId) {
    fetch('../server/deleteBook.php', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ book_id: bookId })
    })
    .then(res => res.json())
    .then(data => {
      if (data.success) {
        loadBooks(); // Reload the book list after deletion
      } else {
        alert("Failed to delete book.");
      }
    })
    .catch(() => {
      alert("Server error.");
    });
  }

  if (genreFilter) {
  genreFilter.addEventListener("change", () => {
    const genre = genreFilter.value;
    fetch('../server/filterBook.php', {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ genre })
    })
    .then(res => res.json())
    .then(data => {
      renderBookList(data);
    })
    .catch(() => {
      bookList.innerHTML = "<li>Error filtering books.</li>";
    });
  });
}
});
