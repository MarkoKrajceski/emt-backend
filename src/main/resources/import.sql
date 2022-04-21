insert into category (name) values ( 'NOVEL' );
insert into category (name) values ( 'THRILER' );
insert into category (name) values ( 'HISTORY' );
insert into category (name) values ( 'FANTASY' );
insert into category (name) values ( 'BIOGRAPHY' );
insert into category (name) values ( 'CLASSICS' );
insert into category (name) values ( 'DRAMA' );


insert into countries (name, continent) values ('Canada', 'North America') ;
insert into countries (name, continent) values ('USA', 'North America') ;
insert into countries (name, continent) values ('UK', 'Europe') ;

insert into Author(name, surname, country_id) values ( 'Jordan', 'Peterson', 0);
insert into Author(name, surname, country_id) values ( 'Joanne', 'Rowling', 2);
insert into Author(name, surname, country_id) values ( 'Mark', 'Twain', 1);
insert into Author(name, surname, country_id) values ( 'Raymond', 'Chandler ', 1);
insert into Author(name, surname, country_id) values ( 'Charles', 'Dickens ', 2);
insert into Author(name, surname, country_id) values ( 'Charles', 'Allens ', 2);

insert into Book(name, category_id, author_id, available_copies) values ( '12 Rules for Life', 0, 0, 15 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Beyond Order', 0, 0, 10 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Harry Potter and the Philosophers Stone', 3, 1, 5 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Fantastic Beasts and Where to Find Them', 3, 1, 7 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Harry Potter and the Prisoner of Azkaban', 3, 1, 2 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Harry Potter and the Half-Blood Prince', 3, 1, 9 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Harry Potter and the Deathly Hallows', 3, 1, 1 );
insert into Book(name, category_id, author_id, available_copies) values ( 'Harry Potter and the Goblet of Fire', 3, 1, 0 );


