insert into user_details(id,birth_date,name)
values(10001,current_date(),'Paniz');

insert into user_details(id,birth_date,name)
values(10002,current_date(),'Pedram');

insert into user_details(id,birth_date,name)
values(10003,current_date(),'Azam');

insert into user_details(id,birth_date,name)
values(10004,current_date(),'Reza');

insert into post(id,description,user_id)
values(2000,'I want to learn c#',10001);

insert into post(id,description,user_id)
values(2001,'I want to learn java',10002);

insert into post(id,description,user_id)
values(2002,'I want to learn kotlin',10001);

insert into post(id,description,user_id)
values(2003,'I want to use functional programming',10003);

insert into post(id,description,user_id)
values(2004,'I want to know react',10004);
