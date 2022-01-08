CREATE DATABASE codingzone;
CREATE TABLE users(
  id SERIAL NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE stuffs(
  id SERIAL NOT NULL,
  acc_password VARCHAR(100) NOT NULL,
  id_user INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_user) REFERENCES users(id)
);
CREATE TABLE students(
  id SERIAL NOT NULL,
  classe VARCHAR(50) NOT NULL,
  promo INT NOT NULL,
  id_user INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_user) REFERENCES users(id)
);
CREATE TABLE categories(
  id SERIAL NOT NULL,
  category VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE quizzes(
  id SERIAL NOT NULL,
  quizz_name VARCHAR(100) NOT NULL,
  quizz_description VARCHAR(1000) NOT NULL,
  id_category INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_category) REFERENCES categories(id)
);
CREATE TABLE answers(
  id SERIAL NOT NULL,
  answer VARCHAR(2000) NOT NULL,
  id_category INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_category) REFERENCES categories(id)
);
CREATE TABLE questions(
  id SERIAL NOT NULL,
  question VARCHAR(2000) NOT NULL,
  time_limit INT NOT NULL,
  id_answer INT NOT NULL,
  id_category INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_answer) REFERENCES answers(id),
  FOREIGN KEY (id_category) REFERENCES categories(id)
);
CREATE TABLE quizz_questions(
  id_quizz INT NOT NULL,
  id_question INT NOT NULL,
  PRIMARY KEY (id_quizz, id_question),
  FOREIGN KEY (id_quizz) REFERENCES quizzes(id),
  FOREIGN KEY (id_question) REFERENCES questions(id)
);
CREATE TABLE open_sessions(
  id SERIAL NOT NULL,
  id_quizz INT NOT NULL,
  id_student INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_quizz) REFERENCES quizzes(id),
  FOREIGN KEY (id_student) REFERENCES students(id)
);
CREATE TABLE archives(
  id SERIAL NOT NULL,
  id_quizz INT NOT NULL,
  student VARCHAR(100),
  score FLOAT NOT NULL,
  submitted_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  FOREIGN KEY (id_quizz) REFERENCES quizzes(id)
);
INSERT INTO
  categories(category)
VALUES('JAVA'),('ANGULAR'),('JAVASCRIPT');
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES(
        'Byron',
        'Reynolds',
        'interdum.sed.auctor@hotmail.net'
      ) RETURNING id
  )
INSERT INTO
  stuffs(acc_password, id_user)
VALUES(
    'NM33IT8SV',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES('Petra', 'Dejesus', 'sem@aol.edu') RETURNING id
  )
INSERT INTO
  stuffs(acc_password, id_user)
VALUES(
    'AK42NI4RV',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES('Joy', 'Bradford', 'vitae.odio@yahoo.net') RETURNING id
  )
INSERT INTO
  stuffs(acc_password, id_user)
VALUES(
    'TT64ZM2DP',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES('Armand', 'Cleveland', 'rutrum@aol.org') RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES('Mariam', 'Sharpe', 'nisi.nibh@aol.net') RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES('Kay', 'Blevins', 'aliquam@icloud.ca') RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES('Odysseus', 'Pace', 'est@aol.edu') RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES(
        'Lisandra',
        'Hodge',
        'ipsum.dolor.sit@outlook.couk'
      ) RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES('Nicholas', 'Solis', 'sed.congue@outlook.ca') RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES('Diana', 'Snow', 'mauris.aliquam@outlook.com') RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES(
        'Luke',
        'Sexton',
        'mauris.blandit.mattis@aol.couk'
      ) RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES(
        'Kareem',
        'Sherman',
        'mattis.ornare.lectus@icloud.edu'
      ) RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(first_name, last_name, email)
    VALUES(
        'Martena',
        'Harrington',
        'egestas.duis.ac@protonmail.com'
      ) RETURNING id
  )
INSERT INTO
  students(classe, promo, id_user)
VALUES(
    'JAMES GOSLING',
    '2020',(
      SELECT
        id
      FROM
        last_inserted
    )
  );
COMMIT;