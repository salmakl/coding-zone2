CREATE DATABASE codingzone;
CREATE TABLE users(
  id INT NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE stuffs(
  id INT NOT NULL,
  acc_password VARCHAR(100) NOT NULL,
  id_user INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_user) REFERENCES users(id)
);
CREATE TABLE students(
  id INT NOT NULL,
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
  id INT NOT NULL,
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
CREATE TABLE questions_opts(
  id_question INT NOT NULL,
  id_opt INT NOT NULL,
  PRIMARY KEY (id_opt, id_question),
  FOREIGN KEY (id_question) REFERENCES questions(id),
  FOREIGN KEY (id_opt) REFERENCES answers(id)
);
CREATE TABLE open_sessions(
  id VARCHAR(1000) NOT NULL,
  id_quizz INT NOT NULL,
  id_student INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_quizz) REFERENCES quizzes(id),
  FOREIGN KEY (id_student) REFERENCES students(id)
);
CREATE TABLE archives(
  id INT NOT NULL,
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
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    642006,
    'Byron',
    'Reynolds',
    'interdum.sed.auctor@hotmail.net'
  );
INSERT INTO
  stuffs(id, acc_password, id_user)
VALUES(158764, 'NM33IT8SV', 642006);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    459069,
    'Petra',
    'Dejesus',
    'sem.aliquam@aol.edu'
  );
INSERT INTO
  stuffs(id, acc_password, id_user)
VALUES(592724, 'AK42NI4RV', 459069);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    789272,
    'Joy',
    'Bradford',
    'vitae.odio@yahoo.net'
  );
INSERT INTO
  stuffs(id, acc_password, id_user)
VALUES(742666, 'TT64ZM2DP', 789272);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    954074,
    'Armand',
    'Cleveland',
    'rutrum.cleveland@aol.org'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(976116, 'JAMES GOSLING', 2020, 954074);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    231002,
    'Mariam',
    'Sharpe',
    'nisit.sharpe@aol.net'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(785428, 'JAMES GOSLING', 2020, 231002);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    476632,
    'Kay',
    'Blevins',
    'aliquam.nullam@icloud.ca'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(182056, 'JAMES GOSLING', 2020, 476632);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    895208,
    'Odysseus',
    'Pace',
    'estodysseus@aol.edu'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(332196, 'JAMES GOSLING', 2020, 895208);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    936101,
    'Lisandra',
    'Hodge',
    'ipsum.dolor.sit@outlook.couk'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(821098, 'JAMES GOSLING', 2020, 936101);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    410953,
    'Nicholas',
    'Solis',
    'sed.congue@outlook.ca'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(758741, 'JAMES GOSLING', 2020, 410953);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    675242,
    'Diana',
    'Snow',
    'mauris.aliquam@outlook.com'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(128011, 'JAMES GOSLING', 2020, 675242);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    822321,
    'Luke',
    'Sexton',
    'mauris.blandit.mattis@aol.couk'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(560945, 'JAMES GOSLING', 2020, 822321);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    343327,
    'Kareem',
    'Sherman',
    'mattis.ornare.lectus@icloud.edu'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(787527, 'JAMES GOSLING', 2020, 343327);
COMMIT;
BEGIN;
INSERT INTO
  users(id, first_name, last_name, email)
VALUES(
    603109,
    'Martena',
    'Harrington',
    'egestas.duis.ac@protonmail.com'
  );
INSERT INTO
  students(id, classe, promo, id_user)
VALUES(270516, 'JAMES GOSLING', 2020, 603109);
COMMIT;
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Interprété', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Compilé', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Compilé et Interprété', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Ni compilé ni interprété', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Hewlett-Packard', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Sun Microsystems', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Microsoft', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Oracle', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('L’encapsulation', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Le polymorphisme', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('L’héritage', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('La marginalisation', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('public', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('protected', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('private', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('default', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('[0, 255]', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('[0, 256]', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('[-128, 127]', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('[-127, 128]', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Dépend du compilateur', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('64 bits', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('128 bits', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('8 bits', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('contentType', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('typeXML', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('generateXML', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('contentXML', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('jspDestroy()', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('_jspService()', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('jspInit()', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  ('Tout les réponses sont vrais', 1);
INSERT INTO
  answers(answer, id_category)
VALUES
  (
    '<c: choose> fonctionne comme une déclaration de switch en Java dans un sens qu’il vous permet de choisir entre plusieurs alternatives',
    1
  );
INSERT INTO
  answers(answer, id_category)
VALUES
  (
    'La balise <c: choose> a des balises <c: when>',
    1
  );
INSERT INTO
  answers(answer, id_category)
VALUES
  (
    'La balise <c: choose> a <else> comme clause par défaut',
    1
  );
INSERT INTO
  answers(answer, id_category)
VALUES('Utilisation de la balise <%jsp: param>', 1);
INSERT INTO
  answers(answer, id_category)
VALUES('Utilisation de la balise <%jsp: page>', 1);
INSERT INTO
  answers(answer, id_category)
VALUES('Utilisation de la balise <%jsp: import>', 1);
INSERT INTO
  answers(answer, id_category)
VALUES('Utilisation de la balise <%jsp: useBean>', 1);
INSERT INTO
  answers(answer, id_category)
VALUES('*ngApp', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('ngApp', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Un composant "root"', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Aucune', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('import { NgForm } from "@angular/common";', 2);
INSERT INTO
  answers(answer, id_category)
VALUES(
    'import { FormBuilder, ControlGroup, Control, Validators } from "angular2/common";',
    2
  );
INSERT INTO
  answers(answer, id_category)
VALUES(
    'import { FormsModule } from "@angular/forms";',
    2
  );
INSERT INTO
  answers(answer, id_category)
VALUES('jQuery', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('zonejs', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('vuejs', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('ember', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('moduleId: module.id', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('moduleId: __moduleName', 2);
INSERT INTO
  answers(answer, id_category)
VALUES(
    'Aucune le chemin relatif est le mode par défaut',
    2
  );
INSERT INTO
  answers(answer, id_category)
VALUES('Les deux', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Un compilateur SASS', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Un gestionnaire de modules', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Une machine virtuelle Java', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Un serveur nodejs', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('@Host', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('@ViewChild', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('@Service', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('@Injectable', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Smalltalk', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('TypeScript', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Java', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Javascript', 2);
INSERT INTO
  answers(answer, id_category)
VALUES(
    'bootstrap(AppComponent).catch(err = > console.error(err));',
    2
  );
INSERT INTO
  answers(answer, id_category)
VALUES('bootstrap(AppComponent, [HeroService]);', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('platform.bootstrapModule(AppModule);', 2);
INSERT INTO
  answers(answer, id_category)
VALUES(
    'System.import("src/hello").then(function(src) { ng.bootstrap(src.HelloWorld);});',
    2
  );
INSERT INTO
  answers(answer, id_category)
VALUES(
    'Les classes de modules externes à l’application',
    2
  );
INSERT INTO
  answers(answer, id_category)
VALUES('Les classes des services', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('Toute classe utilitaire non Angular', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('<input type="text" (value)="user.name" />', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('<input type="text" *ngValue="user.name" />', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('<input type="text" [value]="user.name" />', 2);
INSERT INTO
  answers(answer, id_category)
VALUES('<input type="text" [ngModel]="user.name" />', 2);
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES('Java est un langage?', 1, 3, 1) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    1
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    2
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    4
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Java est un langage développé par?',
        1,
        8,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    5
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    6
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    7
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'La liaison tardive est essentielle pour assurer?',
        40,
        10,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    9
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    11
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    12
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Nommez le modificateur d’accès qui, lorsqu’il est utilisé avec une méthode, le rend accessible à toutes les classes du même package et à toutes les sous-classes de la classe.',
        30,
        14,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    13
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    15
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    16
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quelle est la plage de valeurs autorisée pour une variable déclarée avec le type byte?',
        30,
        19,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    17
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    18
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    20
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'La longueur d’une variable de type double en Java est _____?',
        40,
        22,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    21
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    23
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    24
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Si un JSP doit générer une page XML, quel attribut de la directive «page» devrait-il utiliser?',
        30,
        25,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    26
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    27
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    28
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quelles sont les méthodes de Servlet généré?',
        30,
        32,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    29
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    30
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    31
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Lequel des énoncés suivants est vrai à propos de la balise <c: choose>?',
        40,
        32,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    33
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    34
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    35
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Comment passer des informations d’une page JSP à une page JSP inclus?',
        30,
        36,
        1
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    37
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    38
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    39
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quelle directive est indispensable pour afficher une application Angular 2?',
        30,
        42,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    40
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    41
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    43
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quelle instruction utiliser pour les directives de formulaire?',
        30,
        46,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    44
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    45
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    43
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quelle est la librairie Javascript indispensable?',
        50,
        48,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    47
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    49
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    50
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quelle configuration de composant est correcte pour charger le template en chemin relatif?',
        40,
        54,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    51
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    52
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    53
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quel est le composant indispensable pour Angular 2?',
        50,
        56,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    55
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    57
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    58
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quelle Annotation n’existe pas?',
        30,
        61,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    59
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    60
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    62
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Quel est le langage préconisé pour développer en Angular 2?',
        30,
        64,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    63
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    65
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    66
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(
        question,
        time_limit,
        id_answer,
        id_category
      )
    VALUES(
        'Comment initialiser une application Angular 2?',
        30,
        69,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    67
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    68
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    70
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(question, time_limit, id_answer, id_category)
    VALUES(
        'Quelles sont les classes dites declarable au sein d’un Module Angular 2?',
        30,
        43,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    71
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    72
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    73
  );
COMMIT;
BEGIN;
WITH last_inserted AS (
    INSERT INTO
      questions(question, time_limit, id_answer, id_category)
    VALUES(
        'Comment utiliser le data binding sur un composant de type input?',
        30,
        76,
        2
      ) RETURNING id
  )
INSERT INTO
  questions_opts(id_question, id_opt)
VALUES
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    74
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    75
  ),
  (
    (
      SELECT
        id
      FROM
        last_inserted
    ),
    77
  );
COMMIT;
BEGIN;
INSERT INTO
  quizzes(id, quizz_name, quizz_description, id_category)
VALUES(1001, 'JAVA QUIZZ', 'This is a Java quizz!', 1);
INSERT INTO
  quizz_questions(id_quizz, id_question)
VALUES(1001, 1),(1001, 2),(1001, 3),(1001, 4),(1001, 5),(1001, 6),(1001, 7),(1001, 8),(1001, 9),(1001, 10);
COMMIT;
----------------------------------------------------------------------
  ----------------------------------------------------------------------
  BEGIN;
WITH last_inserted AS (
    INSERT INTO
      users(id, first_name, last_name, email)
    VALUES(
        642006,
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
---- Select quizz details with
SELECT
  quizz_name,
  quizz_description,
  category
FROM
  quizzes
  JOIN categories ON quizzes.id_category = categories.id
  AND quizzes.id = 1001;
---- Select quizz with questions and opts
SELECT
  questions.question,
  a.answer,
  (
    SELECT
      ARRAY_AGG(op.answer)
    FROM
      answers op,
      questions_opts
    WHERE
      questions_opts.id_opt = op.id
      AND questions_opts.id_question = questions.id
  ) AS options
FROM
  questions
  JOIN answers a ON a.id = questions.id_answer
  JOIN questions_opts ON questions_opts.id_question = questions.id
  JOIN quizz_questions ON quizz_questions.id_question = questions.id
  AND quizz_questions.id_quizz = 1001
GROUP BY
  questions.id,
  a.id;