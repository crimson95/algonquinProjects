<!--name: Manilyn Vicenio
file name: book.php
create date: 2025-08-04
Section: CST 8285 section 312
description: book registration page-->

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Book Catalog</title>
  <link rel="stylesheet" href="../css/style.css" />
</head>
<body>
  <header>
    <h1>Book Catalog</h1>
    <nav>
    <a href="index.php">Home</a>
    <a href="book.php">Book</a>
  </nav>
  </header>

  <!-- Main content for book management -->
  <main>
    <section class="form-section">
      <h2>Add a New Book</h2>
      <form id="bookForm">
        <label for="title">Title:</label>
        <input type="text" id="title" />

        <label for="author">Author:</label>
        <input type="text" id="author" />

        <label for="genre">Genre:</label>
        <input type="text" id="genre" />

        <button type="submit">Add Book</button>
        <p id="formError" class="error"></p>
      </form>
    </section>

    <!-- Genre filter dropdown -->
    <section class="catalog">
      <h2>Book List</h2>

      <div class="search-filter-bar">
        <label for="search" id="searchLabel">Search by Title:</label>
        <input type="text" id="search" />

        <label for="genreFilter" id="genreFilterLabel">Filter by Genre:</label>
        <select id="genreFilter">
          <option value="">All Genres</option>
          <option value="Classic">Classic</option>
          <option value="Dystopian">Dystopian</option>
          <option value="Romance">Romance</option>
          <option value="Fiction">Fiction</option>
          <option value="Fantasy">Fantasy</option>
          <option value="Adventure">Adventure</option>
          <option value="Historical">Historical</option>
          <option value="Tragedy">Tragedy</option>
        </select>
      </div>
      <ul id="bookList"></ul>
    </section>

  </main>

    <script src="../scripts/script.js" defer></script>
  </body>
</html>
