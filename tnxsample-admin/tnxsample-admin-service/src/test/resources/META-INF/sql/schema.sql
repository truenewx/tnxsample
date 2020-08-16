CREATE TABLE t_manager (
 id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 username VARCHAR(20) NOT NULL,
 password CHAR(64),
 job_no VARCHAR(32),
 head_image_url VARCHAR(80),
 full_name VARCHAR(20) NOT NULL,
 top BIT(1) DEFAULT 0 NOT NULL,
 disabled BIT(1) DEFAULT 0 NOT NULL,
 create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 
 UNIQUE KEY unique_manager_username (username)
);


CREATE TABLE t_role (
 id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 role_name VARCHAR(20) NOT NULL,
 remark VARCHAR(200),
 ordinal BIGINT NOT NULL,
 permission_string VARCHAR(4000)
);


CREATE TABLE t_manager_r_role (
 manager_id INT NOT NULL,
 role_id INT NOT NULL,

 PRIMARY KEY (manager_id,role_id),

 FOREIGN KEY (manager_id) REFERENCES t_manager (id),
 FOREIGN KEY (role_id) REFERENCES t_role (id)
);
