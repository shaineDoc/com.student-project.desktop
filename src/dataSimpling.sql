insert into jc_street (street_code, street_name)
VALUES (1, 'Стара Загора'),
       (2, 'Московское Шоссе'),
       (3, 'проспект Карла-Маркса'),
       (4, 'Революционная'),
       (5, 'Ленина');

insert into jc_country_struct (area_id, area_name)
VALUES ('010000000000', 'Город'),
       ('010010000000', 'Город Район 1'),
       ('010020000000', 'Город Район 2'),
       ('010030000000', 'Город Район 3'),
       ('010040000000', 'Город Район 4'),

       ('020000000000', 'Край'),
       ('020010000000', 'Край Область 1'),
       ('020010010000', 'Край Область 1 Район 1'),
       ('020010010001', 'Край Область 1 Район 1 поселение 1'),
       ('020010010002', 'Край Область 1 Район 1 поселение 2'),
       ('020010020000', 'Край Область 1 Район 2'),
       ('020010020001', 'Край Область 1 Район 2 поселение 1'),
       ('020010020002', 'Край Область 1 Район 2 поселение 2'),
       ('020010020003', 'Край Область 1 Район 2 поселение 3'),
       ('020020000000', 'Край Область 2'),
       ('020020010000', 'Край Область 2 район 1'),
       ('020020010001', 'Край Область 2 район 1 поселение 1'),
       ('020020010002', 'Край Область 2 район 1 поселение 2'),
       ('020020010003', 'Край Область 2 район 1 поселение 3'),
       ('020020020000', 'Край Область 2 район 2'),
       ('020020020001', 'Край Область 2 район 2 поселение 1'),
       ('020020020002', 'Край Область 2 район 2 поселение 2');

insert into jc_university (university_id, university_name) VALUES
(1 , 'Самарский Аэрокосмический Университет'),
(2 , 'Самарский Политехнический Университет'),
(3 , 'Самарский Институт Связи');

insert into jc_passport_office (p_office_id, p_office_area_id, p_office_name)
values (1, '010010000000', 'Паспортный стол района 1 города'),
       (2, '010020000000', 'Паспортный стол 1 района 2 города'),
       (3, '010020000000', 'Паспортный стол 2 района 2 города'),
       (4, '010010000000', 'Паспортный стол района 3 города'),
       (5, '020010010001', 'Паспортный стол Область 1 поселения 1'),
       (6, '020010020002', 'Паспортный стол Область 1 поселения 2'),
       (7, '020020010000', 'Паспортный стол Область 2 район 1'),
       (8, '020020020000', 'Паспортный стол Область 2 район 2');

insert into jc_register_office (r_office_id, r_office_area_id, r_office_name)
values (1, '010010000000', 'ЗАГС 1 района 1 города'),
       (2,'010010000000', 'ЗАГС 2 района 1 города'),
       (3,'010020000000', 'ЗАГС района 2 города'),
       (4,'020010010001', 'ЗАГС область 1 поселения 1'),
       (5,'020010020002', 'ЗАГС область 1 поселения 2'),
       (6,'020020010000', 'ЗАГС область 2 район 1'),
       (7,'020020020000', 'ЗАГС область 2 район 2');


