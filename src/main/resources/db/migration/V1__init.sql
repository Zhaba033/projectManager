CREATE SEQUENCE account_seq;
CREATE SEQUENCE project_seq;
CREATE SEQUENCE task_seq;

CREATE TABLE accounts (
	id BIGINT PRIMARY KEY DEFAULT nextval('account_seq'),
	username VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL
);

CREATE TABLE projects (
	id BIGINT PRIMARY KEY DEFAULT nextval('project_seq'),
	name VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL
);

CREATE TABLE tasks (
	id BIGINT PRIMARY KEY DEFAULT nextval('task_seq'),
	name VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	
	project_id BIGINT NOT NULL,
	
	CONSTRAINT fk_task_project FOREIGN KEY (project_id) REFERENCES Projects(id)	
);

CREATE TABLE tasks_accounts (
	task_id BIGINT,
	account_id BIGINT,
	PRIMARY KEY (task_id, account_id),
	
	FOREIGN KEY (task_id) REFERENCES Tasks(id),
	FOREIGN KEY (account_id) REFERENCES accounts(id)
);