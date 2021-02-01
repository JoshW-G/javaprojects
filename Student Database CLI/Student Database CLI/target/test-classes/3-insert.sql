INSERT INTO student(student_Id, student_name, degree_scheme) VALUES("S10345", "John Smith", "BSc Computer Science");
INSERT INTO student(student_Id, student_name, degree_scheme) VALUES("S10346", "Sian Evans", "BSc Computer Science");
INSERT INTO student(student_Id, student_name, degree_scheme) VALUES("S10347", "Sean Crossan", "BSc Electronic Engineering");
INSERT INTO student(student_Id, student_name, degree_scheme) VALUES("S10348", "Jaimie McDonald", "BSc Mathematics");

INSERT INTO staff(staff_Id, staff_name,staff_grade) VALUES("E10010", "Alan Turing", "Senior Lecturer");
INSERT INTO staff(staff_Id, staff_name,staff_grade) VALUES("E10011", "Tony Hoare", "Reader");
INSERT INTO staff(staff_Id, staff_name,staff_grade) VALUES("E10012", "Seymour Cray", "Lecturer");

INSERT INTO module(module_Id, module_name,credits) VALUES("CS101", "Introduction to Computing", 10);
INSERT INTO module(module_Id, module_name,credits) VALUES("CS203", "Data Structures and Algorithms", 10);
INSERT INTO module(module_Id, module_name,credits) VALUES("CS204", "Computer Architecture", 10);
INSERT INTO module(module_Id, module_name,credits) VALUES("M101", "Foundation Mathematics", 20);


INSERT INTO registered(student_Id, module_Id) VALUES("S10345","CS101");
INSERT INTO registered(student_Id, module_Id) VALUES("S10346", "CS203");
INSERT INTO registered(student_Id, module_Id) VALUES("S10346", "CS204");
INSERT INTO registered(student_Id, module_Id) VALUES("S10347", "CS204");
INSERT INTO registered(student_Id, module_Id) VALUES("S10348", "M101");
INSERT INTO registered(student_Id, module_Id) VALUES("S10348", "CS101");

INSERT INTO teaches(staff_Id, module_Id) VALUES("E10010", "CS101");
INSERT INTO teaches(staff_Id, module_Id) VALUES("E10011", "CS203");
INSERT INTO teaches(staff_Id, module_Id) VALUES("E10012", "CS204");
INSERT INTO teaches(staff_Id, module_Id) VALUES("E10010", "CS204");
INSERT INTO teaches(staff_Id, module_Id) VALUES("E10011", "M101");
INSERT INTO teaches(staff_Id, module_Id) VALUES("E10011", "CS101");

