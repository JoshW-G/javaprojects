CREATE SCHEMA IF NOT EXISTS utopia_uni; 
CREATE TABLE IF NOT EXISTS student (
    student_Id VARCHAR(20) UNIQUE NOT NULL,
    student_name VARCHAR(255) NOT NULL,
    degree_scheme VARCHAR(255) NOT NULL,
    PRIMARY KEY (student_id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS staff (
    staff_Id VARCHAR(20) UNIQUE NOT NULL,
    staff_name VARCHAR(255) NOT NULL,
    staff_grade VARCHAR(255) NOT NULL,
    PRIMARY KEY (staff_Id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS module (
    module_Id VARCHAR(20) UNIQUE NOT NULL,
    module_name VARCHAR(255) NOT NULL,
    credits SMALLINT NOT NULL,
    PRIMARY KEY (module_Id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS registered (
    student_Id VARCHAR(20) NOT NULL,
    module_Id VARCHAR(20) NOT NULL,
    PRIMARY KEY (student_Id , module_Id),
    FOREIGN KEY (student_Id)
        REFERENCES Student (student_Id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (module_Id)
        REFERENCES module (module_Id)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS teaches (
    staff_Id VARCHAR(20) NOT NULL,
    module_Id VARCHAR(20) NOT NULL,
    PRIMARY KEY (staff_Id , module_Id),
    FOREIGN KEY (staff_Id)
        REFERENCES Staff (staff_Id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (module_Id)
        REFERENCES module (module_Id)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;