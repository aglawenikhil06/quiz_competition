# Quiz_competition

Core Java + JDBC + MySQL | CRUD Based Console Application
-----------------------------------------------------------

This project is a console-based Quiz Competition System developed using Core Java and MySQL. It allows an Admin to manage quiz questions and view user performance, while Users can register, take quizzes, and store their scores in a database.
The application demonstrates real-time CRUD operations (Create, Read, Update, Delete) using JDBC connectivity.

----------------------------------------------------------------------------------------------------------

👨‍💼 Admin Module
---------------

This class handles all operations that can be performed by the Admin of the quiz system. It focuses on managing quiz content and monitoring user performance.

🔹 Functionalities
---------------------

✔ Add Questions (CREATE)
-------------------------
Admin can insert new quiz questions into the question table using PreparedStatement.

✔ View User Results (READ)
--------------------------
Displays all user names and their scores from the userRecords table.

✔ Manage Quiz Data (CRUD Ready Structure)
------------------------------------------
The system is structured to allow updating or deleting questions if extended in the future.

🔹 Concepts Used
------------------
   - JDBC Connection
   - SQL INSERT & SELECT
   - PreparedStatement
   - ResultSet Handling

----------------------------------------------------------------------------------------------------------------------------------------------

👨‍💼 User Module
---------------

This class manages all quiz participant (user) operations. It handles user registration, quiz execution, answer evaluation, and score storage.

Key Responsibilities:

👤 User Registration
----------------------
Takes the user’s name as input.
Stores the name in the userRecords table using JDBC.

📝 Start Quiz
---------------
      Retrieves 5 random questions from the database using:

           - ORDER BY RAND() LIMIT 5
        
      Displays questions and options in the console.
      Accepts user answers and checks them against the correct answer.
      Calculates total score.


💾 Store Final Score
---------------------
Updates the user’s score in the database after quiz completion.

Concepts Used:
---------------
      - JDBC (Database Connectivity)
      - PreparedStatement
      - ResultSet
      - Random question selection via SQL
      - Conditional logic for answer checking
      - Score calculation and update

----------------------------------------------------------------------------------------------------------------------------------------------

Database Design (MySQL)
-----------------------
📌 Table: question
-------------------

Stores quiz questions and answers.

| Column Name       | Data Type    | Description            |
| ----------------- | ------------ | ---------------------- |
| `id`              | INT          | Unique question ID     |
| `questions`       | VARCHAR(100) | Quiz question text     |
| `alternateOption` | VARCHAR(100) | List of answer options |
| `correctOption`   | VARCHAR(45)  | Correct answer         |

📌 Table: userRecords
---------------------

Stores user details and quiz scores.

| Column Name | Data Type       | Description                  |
| ----------- | --------------- | ---------------------------- |
| `name`      | VARCHAR(100)    | Name of the quiz participant |
| `score`     | INT (default 0) | Final quiz score of the user |

--------------------------------------------------------------------------------------------------------------------------------------------

Project Outcome
---------------

This project helped in gaining hands-on experience with:

      ✅ Connecting Java applications to MySQL using JDBC
      ✅ Performing real-time CRUD operations
      ✅ Writing secure SQL queries using PreparedStatement
      ✅ Handling ResultSet data from databases
      ✅ Designing and using relational database tables
      ✅ Building a complete menu-driven console application
      ✅ Implementing quiz logic with score calculation
