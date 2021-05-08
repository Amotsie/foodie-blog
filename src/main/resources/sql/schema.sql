CREATE TABLE blog(id identity primary key,
	title varchar(255),
	body CLOB,
	category varchar(50),
	calories int,
	publishDate date, 
	tags ARRAY);

