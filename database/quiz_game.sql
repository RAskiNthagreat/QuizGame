
-- QUIZ GAME DATABASE


DROP DATABASE IF EXISTS quiz_game;
CREATE DATABASE quiz_game;
USE quiz_game;

-- QUESTIONS TABLE

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    option_a VARCHAR(100) NOT NULL,
    option_b VARCHAR(100) NOT NULL,
    option_c VARCHAR(100) NOT NULL,
    option_d VARCHAR(100) NOT NULL,
    correct_answer CHAR(1) NOT NULL,
    difficulty ENUM('Easy', 'Medium', 'Hard') NOT NULL,
    category VARCHAR(50)
);


-- SCORES TABLE


CREATE TABLE scores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(50) NOT NULL,
    score INT NOT NULL,
    difficulty ENUM('Easy', 'Medium', 'Hard') NOT NULL,
    date_played DATETIME DEFAULT CURRENT_TIMESTAMP
);


-- INDEXES


CREATE INDEX idx_difficulty ON questions(difficulty);
CREATE INDEX idx_score ON scores(score);

INSERT INTO questions
(question, option_a, option_b, option_c, option_d, correct_answer, difficulty, category)
VALUES

('What is the capital of Nepal?',
'Pokhara','Kathmandu','Biratnagar','Butwal','B','Easy','Geography'),

('Which planet is known as the Red Planet?',
'Earth','Mars','Jupiter','Saturn','B','Easy','Science'),

('2 + 5 = ?',
'6','7','8','9','B','Easy','Mathematics'),

('Which language is used for Java programs?',
'Java','Python','HTML','CSS','A','Easy','Computing'),

('How many days are there in one week?',
'5','6','7','8','C','Easy','General'),

('Which animal is known as the King of the Jungle?',
'Tiger','Lion','Elephant','Bear','B','Easy','General'),

('Which device is used to move the cursor?',
'Keyboard','Mouse','Printer','Scanner','B','Easy','Computing'),

('What color is the sky on a clear day?',
'Green','Blue','Red','Yellow','B','Easy','General'),

('How many hours are there in one day?',
'12','18','24','30','C','Easy','General'),

('Which ocean is the largest?',
'Indian','Pacific','Atlantic','Arctic','B','Easy','Geography'),

('How many months are there in a year?',
'10','11','12','13','C','Easy','General'),

('Which is the largest mammal?',
'Elephant','Blue Whale','Giraffe','Hippo','B','Easy','Science'),

('Who developed Java?',
'James Gosling','Dennis Ritchie','Bill Gates','Guido van Rossum','A','Medium','Computing'),

('Which keyword is used to create an object in Java?',
'class','new','this','super','B','Medium','Computing'),

('What is the chemical symbol for Gold?',
'Ag','Au','Fe','Go','B','Medium','Science'),

('Which country has the largest population?',
'India','China','USA','Indonesia','A','Medium','Geography'),

('What is the square root of 144?',
'10','11','12','13','C','Medium','Mathematics'),

('Which data structure works on FIFO?',
'Stack','Queue','Tree','Graph','B','Medium','Computing'),

('Who wrote "Romeo and Juliet"?',
'Charles Dickens','William Shakespeare','Mark Twain','Jane Austen','B','Medium','Literature'),

('Which planet has the most moons?',
'Saturn','Mars','Earth','Venus','A','Medium','Science'),

('Which SQL command retrieves data?',
'INSERT','SELECT','DELETE','UPDATE','B','Medium','Database'),

('What does CPU stand for?',
'Central Process Unit','Central Processing Unit','Computer Personal Unit','Central Program Utility','B','Medium','Computing'),

('Which continent is the Sahara Desert located in?',
'Asia','Africa','Australia','Europe','B','Medium','Geography'),

('How many bits are in one byte?',
'4','8','16','32','B','Medium','Computing'),

('Which sorting algorithm has the best average-case complexity?',
'Bubble Sort','Selection Sort','Merge Sort','Insertion Sort','C','Hard','Computing'),

('What is the time complexity of binary search?',
'O(n)','O(log n)','O(n²)','O(1)','B','Hard','Computing'),

('Which normal form removes transitive dependency?',
'1NF','2NF','3NF','BCNF','C','Hard','Database'),

('Who proposed the theory of relativity?',
'Isaac Newton','Albert Einstein','Nikola Tesla','Galileo','B','Hard','Science'),

('Which layer of the OSI model handles routing?',
'Transport','Network','Application','Session','B','Hard','Networking'),

('Which SQL clause is used to filter grouped records?',
'WHERE','GROUP BY','HAVING','ORDER BY','C','Hard','Database'),

('Which planet has the shortest day?',
'Mercury','Jupiter','Mars','Earth','B','Hard','Science'),

('What is the hexadecimal value of decimal 255?',
'AA','FF','EF','FE','B','Hard','Computing'),

('Which design principle promotes loose coupling?',
'SOLID','DRY','KISS','YAGNI','A','Hard','Software Engineering'),

('Which protocol is used to securely browse websites?',
'FTP','HTTP','HTTPS','SMTP','C','Hard','Networking'),

('What does JVM stand for?',
'Java Variable Machine','Java Virtual Machine','Joint Virtual Memory','Java Verified Machine','B','Hard','Computing'),

('Which SQL keyword removes duplicate records?',
'GROUP','DISTINCT','UNIQUE','ORDER','B','Hard','Database');