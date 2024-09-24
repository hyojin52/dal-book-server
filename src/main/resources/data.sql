insert into church (address, created_at, denomination, name, pastor, phone, updated_at, id)
values ('서울 성북구 북악산로 913', now(), '대한예수교장로회 합동', '높은뜻교회', '김영채', '02-923-0419', now(), '9675111d-db0b-4e36-a3d7-83d501209268');

insert into church_member (id, church_id, name, memo)
values ('9675111d-db0b-4e36-a3d7-83d501209261', '9675111d-db0b-4e36-a3d7-83d501209268', '김효진', null),
       ('9675111d-db0b-4e36-a3d7-83d501209262', '9675111d-db0b-4e36-a3d7-83d501209268', '김유진', null),
       ('9675111d-db0b-4e36-a3d7-83d501209263', '9675111d-db0b-4e36-a3d7-83d501209268', '김하영', null);

