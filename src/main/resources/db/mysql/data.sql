# 임시 데이터

# 회사
insert into company (company_id, name, code, logo_url, date_created, date_updated, date_deleted, is_deleted)
values (1, '더존비즈온', 'd0fd4068-d79b-4f83-9a16-83a9197e0e74', '6f5449a4-2f53-4004-9d07-15bad0c475e0.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (2, '회사1', '2995c735-91c7-419f-8237-52dc2084efc5', '084c0a77-3de0-4b7d-842f-db164a3566c9.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (3, '회사2', 'c193b8ad-2769-42f0-8d41-56a27eef0022', '767d5679-bbdf-4fc7-9b8f-8430a41f65d7.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (4, '회사3', '5dede0e6-df43-4d68-93e0-a533a66eb6bc', 'a7770c96-2e7a-47f6-a60c-421f3dfdfec3.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (5, '회사4', '8d840cbd-7c8c-4bb2-bde0-4a60caa15356', 'e16564a2-0e75-4003-afc9-d2a28b17a663.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (6, '회사5', '61398780-fa36-4de8-a479-0d052cf434c7', '3367c973-07ec-4508-937a-28d70ca934b9.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (7, '회사6', 'e569d32c-c8e2-4aac-8a1b-62e40dbc39e5', '1583daa4-409f-458d-afaa-42d53924d35e.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (8, '회사7', '5540a4b6-bb18-4369-b134-b2a88f85eacf', 'a027f459-2617-4c88-b288-73810cb9727b.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (9, '회사8', 'b9b2fa30-f850-43b1-962b-9d205e7cc8d5', '9e87827a-0f1e-435b-8956-c8bf37cc1342.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (10, '회사9', '673dae47-30d0-4405-a461-afe7fe1cd3f4', '6f08b6a2-194e-4553-a8da-d6878612354f.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0),
       (11, '회사10', '4e137296-1f90-48ee-b817-292bc7dcd8c4', 'a6adbbb1-3872-4395-a15e-8038a7fc2d1f.svg', '2023-01-01 00:00:00', '2023-01-01 00:00:00', null, 0);


# 관리자
insert into user (user_id, user_code, name, email, password, phone, hire_date, birthday, dept, position, distribution, date_created, date_updated, date_deleted, is_deleted, role, company_id)
values (1, '', '관리자', 'admin@email.com', '$2a$10$z5a7ragMOcu1rULsYwCaXO0NEjMVU9SH07cAL5FW07/O.FUn.ami2', '', '1970-01-01', '1970-01-01', '관리자', '서비스 관리자', 0, '1970-01-01 00:00:00', '1970-01-01 00:00:00', null, 0, 'SUPERADMIN', 0),
       (2, '', '관리자2', 'test@test.com', '$2a$10$qY6DuWcrl/y5hJjWszBz/uVGvPF0ivxM2v.d5b66I/MxzGGBIhxBm', '', '1970-01-01', '1990-01-01', '관리자', '서비스 관리자', 0, '1970-01-01 00:00:00', '1970-01-01 00:00:00', null, 0, 'SUPERADMIN', 0);

# 사용자 (비밀번호는 모두 123)
insert into user (user_id, user_code, name, email, password, phone, hire_date, birthday, dept, position, distribution, date_created, date_updated, date_deleted, is_deleted, role, company_id)
values (3, '202301001', '이예린', 'user1@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 1),
       (4, '202301002', '김오늘', 'user2@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (5, '202301003', '김내일', 'user3@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (6, '202301004', '이승민', 'user4@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (7, '202301005', '이예린', 'user5@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (8, '202301006', '박예준', 'user6@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (9, '202301007', '박영준', 'user7@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (10, '202301008', '이영준', 'user8@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (11, '202301009', '박하은', 'user9@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (12, '202301010', '박서연', 'user10@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (13, '202301011', '이서연', 'user11@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (14, '202301012', '박민우', 'user12@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (15, '202301013', '이수민', 'user13@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (16, '202301014', '이지민', 'user14@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (17, '202301015', '박서준', 'user15@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (18, '202301016', '박영우', 'user16@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (19, '202301017', '박재민', 'user17@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (20, '202301018', '김형준', 'user18@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (21, '202301019', '이서윤', 'user19@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (22, '202301020', '박서진', 'user20@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 1),
       (23, '202301001', '서준우', 'user21@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 2),
       (24, '202301002', '김지연', 'user22@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (25, '202301003', '이승훈', 'user23@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (26, '202301004', '박민지', 'user24@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (27, '202301005', '정민준', 'user25@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (28, '202301006', '윤서진', 'user26@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (29, '202301007', '한동규', 'user27@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (30, '202301008', '최은미', 'user28@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (31, '202301009', '송재호', 'user29@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (32, '202301010', '배지원', 'user30@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (33, '202301011', '임혜진', 'user31@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (34, '202301012', '황승민', 'user32@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (35, '202301013', '강주희', 'user33@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (36, '202301014', '신현우', 'user34@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (37, '202301015', '조윤서', 'user35@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (38, '202301016', '문재현', 'user36@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (39, '202301017', '임지혜', 'user37@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (40, '202301018', '오준호', 'user38@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (41, '202301019', '홍수민', 'user39@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (42, '202301020', '신지아', 'user40@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 2),
       (43, '202301001', '이승준', 'user41@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 3),
       (44, '202301002', '이민재', 'user42@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (45, '202301003', '박유준', 'user43@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (46, '202301004', '박승민', 'user44@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (47, '202301005', '이예원', 'user45@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (48, '202301006', '박영준', 'user46@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (49, '202301007', '이하율', 'user47@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (50, '202301008', '김승준', 'user48@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (51, '202301009', '박태우', 'user49@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (52, '202301010', '박주원', 'user50@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (53, '202301011', '이서연', 'user51@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (54, '202301012', '이윤서', 'user52@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (55, '202301013', '김지현', 'user53@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (56, '202301014', '박하율', 'user54@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (57, '202301015', '이민경', 'user55@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (58, '202301016', '김서하', 'user56@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (59, '202301017', '김태우', 'user57@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (60, '202301018', '박민재', 'user58@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (61, '202301019', '박서진', 'user59@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (62, '202301020', '박승우', 'user60@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 3),
       (63, '202301001', '김지민', 'user61@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 4),
       (64, '202301002', '김예린', 'user62@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (65, '202301003', '이은지', 'user63@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (66, '202301004', '이하은', 'user64@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (67, '202301005', '이민우', 'user65@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (68, '202301006', '박서연', 'user66@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (69, '202301007', '이민지', 'user67@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (70, '202301008', '박민우', 'user68@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (71, '202301009', '이영우', 'user69@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (72, '202301010', '김수아', 'user70@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (73, '202301011', '이승현', 'user71@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (74, '202301012', '박윤서', 'user72@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (75, '202301013', '박준우', 'user73@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (76, '202301014', '박민서', 'user74@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (77, '202301015', '김수아', 'user75@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (78, '202301016', '이서윤', 'user76@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (79, '202301017', '박승우', 'user77@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (80, '202301018', '김서연', 'user78@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (81, '202301019', '박하윤', 'user79@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (82, '202301020', '이서준', 'user80@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 4),
       (83, '202301001', '박지현', 'user81@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 5),
       (84, '202301002', '김민우', 'user82@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (85, '202301003', '박예원', 'user83@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (86, '202301004', '김예원', 'user84@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (87, '202301005', '박은지', 'user85@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (88, '202301006', '박서준', 'user86@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (89, '202301007', '김유준', 'user87@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (90, '202301008', '김서하', 'user88@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (91, '202301009', '김승준', 'user89@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (92, '202301010', '김지민', 'user90@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (93, '202301011', '박수민', 'user91@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (94, '202301012', '이하율', 'user92@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (95, '202301013', '이승준', 'user93@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (96, '202301014', '김민지', 'user94@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (97, '202301015', '박민지', 'user95@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (98, '202301016', '이예준', 'user96@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (99, '202301017', '이유준', 'user97@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (100, '202301018', '이서하', 'user98@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (101, '202301019', '이승우', 'user99@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (102, '202301020', '김유준', 'user100@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 5),
       (103, '202301001', '김주원', 'user101@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 6),
       (104, '202301002', '이서하', 'user102@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (105, '202301003', '김하윤', 'user103@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (106, '202301004', '이하윤', 'user104@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (107, '202301005', '김민재', 'user105@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (108, '202301006', '박수아', 'user106@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (109, '202301007', '김영우', 'user107@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (110, '202301008', '이민경', 'user108@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (111, '202301009', '김윤서', 'user109@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (112, '202301010', '이민우', 'user110@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (113, '202301011', '이지현', 'user111@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (114, '202301012', '박준우', 'user112@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (115, '202301013', '김민준', 'user113@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (116, '202301014', '김민서', 'user114@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (117, '202301015', '이주원', 'user115@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (118, '202301016', '박지민', 'user116@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (119, '202301017', '이지민', 'user117@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (120, '202301018', '박수민', 'user118@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (121, '202301019', '김영준', 'user119@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (122, '202301020', '이태우', 'user120@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 6),
       (123, '202301001', '김승우', 'user121@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 7),
       (124, '202301002', '이재민', 'user122@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (125, '202301003', '김하은', 'user123@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (126, '202301004', '김지우', 'user124@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (127, '202301005', '김하율', 'user125@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (128, '202301006', '박재민', 'user126@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (129, '202301007', '이예준', 'user127@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (130, '202301008', '이서준', 'user128@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (131, '202301009', '김정우', 'user129@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (132, '202301010', '김하은', 'user130@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (133, '202301011', '김지현', 'user131@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (134, '202301012', '이승민', 'user132@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (135, '202301013', '김예원', 'user133@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (136, '202301014', '이서진', 'user134@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (137, '202301015', '김민경', 'user135@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (138, '202301016', '김승민', 'user136@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (139, '202301017', '김승우', 'user137@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (140, '202301018', '김하윤', 'user138@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (141, '202301019', '박지우', 'user139@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (142, '202301020', '이은지', 'user140@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 7),
       (143, '202301001', '이태우', 'user141@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 8),
       (144, '202301002', '박예원', 'user142@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (145, '202301003', '박태우', 'user143@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (146, '202301004', '이지현', 'user144@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (147, '202301005', '김민재', 'user145@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (148, '202301006', '박하윤', 'user146@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (149, '202301007', '김승민', 'user147@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (150, '202301008', '박승현', 'user148@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (151, '202301009', '김태우', 'user149@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (152, '202301010', '박지우', 'user150@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (153, '202301011', '김주원', 'user151@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (154, '202301012', '박정우', 'user152@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (155, '202301013', '이민서', 'user153@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (156, '202301014', '박예린', 'user154@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (157, '202301015', '박서윤', 'user155@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (158, '202301016', '김수민', 'user156@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (159, '202301017', '박승민', 'user157@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (160, '202301018', '이서진', 'user158@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (161, '202301019', '이하은', 'user159@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (162, '202301020', '박민경', 'user160@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 8),
       (163, '202301001', '김서연', 'user161@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 9),
       (164, '202301002', '이준우', 'user162@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (165, '202301003', '김서진', 'user163@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (166, '202301004', '이지우', 'user164@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (167, '202301005', '김민경', 'user165@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (168, '202301006', '이윤서', 'user166@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (169, '202301007', '김예준', 'user167@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (170, '202301008', '박지민', 'user168@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (171, '202301009', '김서준', 'user169@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (172, '202301010', '이정우', 'user170@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (173, '202301011', '이민서', 'user171@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (174, '202301012', '박지현', 'user172@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (175, '202301013', '박주원', 'user173@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (176, '202301014', '이승우', 'user174@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (177, '202301015', '박민서', 'user175@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (178, '202301016', '박하율', 'user176@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (179, '202301017', '김재민', 'user177@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (180, '202301018', '박유준', 'user178@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (181, '202301019', '이영준', 'user179@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (182, '202301020', '김승현', 'user180@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 9),
       (183, '202301001', '김예린', 'user181@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1234-5678', '2023-01-02' , '1971-11-09', '인사', 'CEO', 1, '2023-01-02', '2023-01-02', NULL, 0, 'ADMIN', 10),
       (184, '202301002', '박서진', 'user182@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-9876-5432', '2023-01-02' , '1977-09-01', '인사', '부장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (185, '202301003', '박하은', 'user183@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1980-08-03', '기획', '차장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (186, '202301004', '이승민', 'user184@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1981-04-06', '개발', '과장', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (187, '202301005', '이예린', 'user185@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1981-03-11', '인사', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (188, '202301006', '박예준', 'user186@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1982-04-02', '개발', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (189, '202301007', '박영준', 'user187@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7890-1234', '2023-01-02' , '1983-12-07', '영업', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (190, '202301008', '이영준', 'user188@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-5678', '2023-01-02' , '1984-01-22', '기획', '대리', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (191, '202301009', '김준우', 'user189@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1985-02-28', '회계', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (192, '202301010', '박서연', 'user190@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-3456-7890', '2023-01-02' , '1986-06-18', '개발', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (193, '202301011', '이서연', 'user191@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-6789-0123', '2023-01-02' , '1987-12-16', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (194, '202301012', '박민우', 'user192@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2109-8765', '2023-01-02' , '1988-11-05', '인사', '주임', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (195, '202301013', '이수민', 'user193@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5432-1098', '2023-01-02' , '1989-10-15', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (196, '202301014', '이지민', 'user194@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8765-4321', '2023-01-02' , '1990-08-20', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (197, '202301015', '박서준', 'user195@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-1098-7654', '2023-01-02' , '1992-06-14', '개발', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (198, '202301016', '박영우', 'user196@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-4321-0987', '2023-01-02' , '1992-11-29', '인사', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (199, '202301017', '박재민', 'user197@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-7654-3210', '2023-01-02' , '1993-03-25', '기획', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (200, '202301018', '김영준', 'user198@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-2345-6789', '2023-01-02' , '1993-04-16', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (201, '202301019', '이서윤', 'user199@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-5678-9012', '2023-01-02' , '1994-06-08', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10),
       (202, '202301020', '김민지', 'user200@email.com', '$2a$10$fyon9e2MWNJ02yUZ4U7xt.WpW/wILOEgBVjFzs90/pijw8AYmFemi', '010-8901-2345', '2023-01-02' , '1994-09-01', '영업', '사원', 1, '2023-01-02', '2023-01-02', NULL, 0, 'USER', 10);


# 근로제
insert into work_group (work_group_id, name, type, date_created, date_updated, date_deleted, is_deleted, is_on, company_id)
values (1, '일반근로제 1팀', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 1),
       (2, '시차근로제 1팀', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 1),
       (3, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 2),
       (4, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 2),
       (5, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 3),
       (6, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 3),
       (7, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 4),
       (8, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 4),
       (9, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 5),
       (10, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 5),
       (11, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 6),
       (12, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 6),
       (13, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 7),
       (14, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 7),
       (15, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 8),
       (16, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 8),
       (17, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 9),
       (18, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 9),
       (19, '일반근로제A', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 10),
       (20, '시차근로제A', '시차', '2023-01-02', '2023-01-02', null, 0, 1, 10),
       (21, '일반근로제 2팀', '일반', '2023-01-02', '2023-01-02', null, 0, 1, 1);


# 시간범위
insert into time_range(time_range_id, type, start, end, work_group_id)
values (1, '근무', '09:00', '18:00', 1),
       (2, '휴게', '12:00', '13:00', 1),
       (3, '의무', '13:00', '16:00', 1),
       (4, '승인', '18:00', '23:45', 1),
       (5, '근무', '09:00', '18:00', 2),
       (6, '근무', '10:00', '19:00', 2),
       (7, '근무', '11:00', '20:00', 2),
       (8, '휴게', '12:00', '13:00', 2),
       (9, '의무', '13:00', '16:00', 2),
       (10, '승인', '20:00', '23:45', 2),
       (11, '근무', '09:00', '18:00', 3),
       (12, '휴게', '12:00', '13:00', 3),
       (13, '의무', '13:00', '16:00', 3),
       (14, '승인', '18:00', '23:45', 3),
       (15, '근무', '09:00', '18:00', 4),
       (16, '근무', '10:00', '19:00', 4),
       (17, '근무', '11:00', '20:00', 4),
       (18, '휴게', '12:00', '13:00', 4),
       (19, '의무', '13:00', '16:00', 4),
       (20, '승인', '20:00', '23:45', 4),
       (21, '근무', '09:00', '18:00', 5),
       (22, '휴게', '12:00', '13:00', 5),
       (23, '의무', '13:00', '16:00', 5),
       (24, '승인', '18:00', '23:45', 5),
       (25, '근무', '09:00', '18:00', 6),
       (26, '근무', '10:00', '19:00', 6),
       (27, '근무', '11:00', '20:00', 6),
       (28, '휴게', '12:00', '13:00', 6),
       (29, '의무', '13:00', '16:00', 6),
       (30, '승인', '20:00', '23:45', 6),
       (31, '근무', '09:00', '18:00', 7),
       (32, '휴게', '12:00', '13:00', 7),
       (33, '의무', '13:00', '16:00', 7),
       (34, '승인', '18:00', '23:45', 7),
       (35, '근무', '09:00', '18:00', 8),
       (36, '근무', '10:00', '19:00', 8),
       (37, '근무', '11:00', '20:00', 8),
       (38, '휴게', '12:00', '13:00', 8),
       (39, '의무', '13:00', '16:00', 8),
       (40, '승인', '20:00', '23:45', 8),
       (41, '근무', '09:00', '18:00', 9),
       (42, '휴게', '12:00', '13:00', 9),
       (43, '의무', '13:00', '16:00', 9),
       (44, '승인', '18:00', '23:45', 9),
       (45, '근무', '09:00', '18:00', 10),
       (46, '근무', '10:00', '19:00', 10),
       (47, '근무', '11:00', '20:00', 10),
       (48, '휴게', '12:00', '13:00', 10),
       (49, '의무', '13:00', '16:00', 10),
       (50, '승인', '20:00', '23:45', 10),
       (51, '근무', '09:00', '18:00', 11),
       (52, '휴게', '12:00', '13:00', 11),
       (53, '의무', '13:00', '16:00', 11),
       (54, '승인', '18:00', '23:45', 11),
       (55, '근무', '09:00', '18:00', 12),
       (56, '근무', '10:00', '19:00', 12),
       (57, '근무', '11:00', '20:00', 12),
       (58, '휴게', '12:00', '13:00', 12),
       (59, '의무', '13:00', '16:00', 12),
       (60, '승인', '20:00', '23:45', 12),
       (61, '근무', '09:00', '18:00', 13),
       (62, '휴게', '12:00', '13:00', 13),
       (63, '의무', '13:00', '16:00', 13),
       (64, '승인', '18:00', '23:45', 13),
       (65, '근무', '09:00', '18:00', 14),
       (66, '근무', '10:00', '19:00', 14),
       (67, '근무', '11:00', '20:00', 14),
       (68, '휴게', '12:00', '13:00', 14),
       (69, '의무', '13:00', '16:00', 14),
       (70, '승인', '20:00', '23:45', 14),
       (71, '근무', '09:00', '18:00', 15),
       (72, '휴게', '12:00', '13:00', 15),
       (73, '의무', '13:00', '16:00', 15),
       (74, '승인', '18:00', '23:45', 15),
       (75, '근무', '09:00', '18:00', 16),
       (76, '근무', '10:00', '19:00', 16),
       (77, '근무', '11:00', '20:00', 16),
       (78, '휴게', '12:00', '13:00', 16),
       (79, '의무', '13:00', '16:00', 16),
       (80, '승인', '20:00', '23:45', 16),
       (81, '근무', '09:00', '18:00', 17),
       (82, '휴게', '12:00', '13:00', 17),
       (83, '의무', '13:00', '16:00', 17),
       (84, '승인', '18:00', '23:45', 17),
       (85, '근무', '09:00', '18:00', 18),
       (86, '근무', '10:00', '19:00', 18),
       (87, '근무', '11:00', '20:00', 18),
       (88, '휴게', '12:00', '13:00', 18),
       (89, '의무', '13:00', '16:00', 18),
       (90, '승인', '20:00', '23:45', 18),
       (91, '근무', '09:00', '18:00', 19),
       (92, '휴게', '12:00', '13:00', 19),
       (93, '의무', '13:00', '16:00', 19),
       (94, '승인', '18:00', '23:45', 19),
       (95, '근무', '09:00', '18:00', 20),
       (96, '근무', '10:00', '19:00', 20),
       (97, '근무', '11:00', '20:00', 20),
       (98, '휴게', '12:00', '13:00', 20),
       (99, '의무', '13:00', '16:00', 20),
       (100, '승인', '20:00', '23:45', 20),
       (101, '근무', '09:00', '18:00', 21),
       (102, '휴게', '12:00', '13:00', 21),
       (103, '의무', '13:00', '16:00', 21),
       (104, '승인', '18:00', '23:45', 21);


# 근무요일타입
insert into work_day_type(work_day_type_id, mon, tue, wed, thu, fri, sat, sun, work_group_id)
values (1, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 1),
       (2, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 2),
       (3, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 3),
       (4, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 4),
       (5, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 5),
       (6, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 6),
       (7, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 7),
       (8, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 8),
       (9, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 9),
       (10, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 10),
       (11, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 11),
       (12, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 12),
       (13, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 13),
       (14, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 14),
       (15, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 15),
       (16, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 16),
       (17, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 17),
       (18, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 18),
       (19, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 19),
       (20, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 20),
       (21, '근무', '근무', '근무', '근무', '근무', '무급', '유급', 21);


# 근로제 이력
insert into work_group_record(work_group_record_id, date, work_group_name, work_group_type, time_range_type, start, end, mon, tue, wed, thu, fri, sat, sun, work_group_id)
values (1, '2023-01-02', '일반근로제 1팀', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 1),
       (2, '2023-01-02', '시차근로제 1팀', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 2),
       (3, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 3),
       (4, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 4),
       (5, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 5),
       (6, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 6),
       (7, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 7),
       (8, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 8),
       (9, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 9),
       (10, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 10),
       (11, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 11),
       (12, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 12),
       (13, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 13),
       (14, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 14),
       (15, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 15),
       (16, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 16),
       (17, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 17),
       (18, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 18),
       (19, '2023-01-02', '일반근로제A', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 19),
       (20, '2023-01-02', '시차근로제A', '시차', '근무, 근무, 근무, 휴게, 의무, 승인', '09:00, 10:00, 11:00, 12:00, 13:00, 20:00', '18:00, 19:00, 20:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 20),
       (21, '2023-01-02', '일반근로제 2팀', '일반', '근무, 휴게, 의무, 승인', '09:00, 12:00, 13:00, 18:00', '18:00, 13:00, 16:00, 23:45', '근무', '근무', '근무', '근무', '근무', '무급', '유급', 21);


# 배포
insert into distribution(distribution_id, date, user_id, work_group_id)
values (1, '2023-01-02', 3, 2),
       (2, '2023-01-02', 4, 1),
       (3, '2023-01-02', 5, 1),
       (4, '2023-01-02', 6, 1),
       (5, '2023-01-02', 7, 1),
       (6, '2023-01-02', 8, 1),
       (7, '2023-01-02', 9, 1),
       (8, '2023-01-02', 10, 1),
       (9, '2023-01-02', 11, 1),
       (10, '2023-01-02', 12, 1),
       (11, '2023-01-02', 13, 1),
       (12, '2023-01-02', 14, 1),
       (13, '2023-01-02', 15, 1),
       (14, '2023-01-02', 16, 1),
       (15, '2023-01-02', 17, 1),
       (16, '2023-01-02', 18, 1),
       (17, '2023-01-02', 19, 1),
       (18, '2023-01-02', 20, 1),
       (19, '2023-01-02', 21, 1),
       (20, '2023-01-02', 22, 1),
       (21, '2023-01-02', 23, 4),
       (22, '2023-01-02', 24, 3),
       (23, '2023-01-02', 25, 3),
       (24, '2023-01-02', 26, 3),
       (25, '2023-01-02', 27, 3),
       (26, '2023-01-02', 28, 3),
       (27, '2023-01-02', 29, 3),
       (28, '2023-01-02', 30, 3),
       (29, '2023-01-02', 31, 3),
       (30, '2023-01-02', 32, 3),
       (31, '2023-01-02', 33, 3),
       (32, '2023-01-02', 34, 3),
       (33, '2023-01-02', 35, 3),
       (34, '2023-01-02', 36, 3),
       (35, '2023-01-02', 37, 3),
       (36, '2023-01-02', 38, 3),
       (37, '2023-01-02', 39, 3),
       (38, '2023-01-02', 40, 3),
       (39, '2023-01-02', 41, 3),
       (40, '2023-01-02', 42, 3),
       (41, '2023-01-02', 43, 6),
       (42, '2023-01-02', 44, 5),
       (43, '2023-01-02', 45, 5),
       (44, '2023-01-02', 46, 5),
       (45, '2023-01-02', 47, 5),
       (46, '2023-01-02', 48, 5),
       (47, '2023-01-02', 49, 5),
       (48, '2023-01-02', 50, 5),
       (49, '2023-01-02', 51, 5),
       (50, '2023-01-02', 52, 5),
       (51, '2023-01-02', 53, 5),
       (52, '2023-01-02', 54, 5),
       (53, '2023-01-02', 55, 5),
       (54, '2023-01-02', 56, 5),
       (55, '2023-01-02', 57, 5),
       (56, '2023-01-02', 58, 5),
       (57, '2023-01-02', 59, 5),
       (58, '2023-01-02', 60, 5),
       (59, '2023-01-02', 61, 5),
       (60, '2023-01-02', 62, 5),
       (61, '2023-01-02', 63, 8),
       (62, '2023-01-02', 64, 7),
       (63, '2023-01-02', 65, 7),
       (64, '2023-01-02', 66, 7),
       (65, '2023-01-02', 67, 7),
       (66, '2023-01-02', 68, 7),
       (67, '2023-01-02', 69, 7),
       (68, '2023-01-02', 70, 7),
       (69, '2023-01-02', 71, 7),
       (70, '2023-01-02', 72, 7),
       (71, '2023-01-02', 73, 7),
       (72, '2023-01-02', 74, 7),
       (73, '2023-01-02', 75, 7),
       (74, '2023-01-02', 76, 7),
       (75, '2023-01-02', 77, 7),
       (76, '2023-01-02', 78, 7),
       (77, '2023-01-02', 79, 7),
       (78, '2023-01-02', 80, 7),
       (79, '2023-01-02', 81, 7),
       (80, '2023-01-02', 82, 7),
       (81, '2023-01-02', 83, 10),
       (82, '2023-01-02', 84, 9),
       (83, '2023-01-02', 85, 9),
       (84, '2023-01-02', 86, 9),
       (85, '2023-01-02', 87, 9),
       (86, '2023-01-02', 88, 9),
       (87, '2023-01-02', 89, 9),
       (88, '2023-01-02', 90, 9),
       (89, '2023-01-02', 91, 9),
       (90, '2023-01-02', 92, 9),
       (91, '2023-01-02', 93, 9),
       (92, '2023-01-02', 94, 9),
       (93, '2023-01-02', 95, 9),
       (94, '2023-01-02', 96, 9),
       (95, '2023-01-02', 97, 9),
       (96, '2023-01-02', 98, 9),
       (97, '2023-01-02', 99, 9),
       (98, '2023-01-02', 100, 9),
       (99, '2023-01-02', 101, 9),
       (100, '2023-01-02', 102, 9),
       (101, '2023-01-02', 103, 12),
       (102, '2023-01-02', 104, 11),
       (103, '2023-01-02', 105, 11),
       (104, '2023-01-02', 106, 11),
       (105, '2023-01-02', 107, 11),
       (106, '2023-01-02', 108, 11),
       (107, '2023-01-02', 109, 11),
       (108, '2023-01-02', 110, 11),
       (109, '2023-01-02', 111, 11),
       (110, '2023-01-02', 112, 11),
       (111, '2023-01-02', 113, 11),
       (112, '2023-01-02', 114, 11),
       (113, '2023-01-02', 115, 11),
       (114, '2023-01-02', 116, 11),
       (115, '2023-01-02', 117, 11),
       (116, '2023-01-02', 118, 11),
       (117, '2023-01-02', 119, 11),
       (118, '2023-01-02', 120, 11),
       (119, '2023-01-02', 121, 11),
       (120, '2023-01-02', 122, 11),
       (121, '2023-01-02', 123, 14),
       (122, '2023-01-02', 124, 13),
       (123, '2023-01-02', 125, 13),
       (124, '2023-01-02', 126, 13),
       (125, '2023-01-02', 127, 13),
       (126, '2023-01-02', 128, 13),
       (127, '2023-01-02', 129, 13),
       (128, '2023-01-02', 130, 13),
       (129, '2023-01-02', 131, 13),
       (130, '2023-01-02', 132, 13),
       (131, '2023-01-02', 133, 13),
       (132, '2023-01-02', 134, 13),
       (133, '2023-01-02', 135, 13),
       (134, '2023-01-02', 136, 13),
       (135, '2023-01-02', 137, 13),
       (136, '2023-01-02', 138, 13),
       (137, '2023-01-02', 139, 13),
       (138, '2023-01-02', 140, 13),
       (139, '2023-01-02', 141, 13),
       (140, '2023-01-02', 142, 13),
       (141, '2023-01-02', 143, 16),
       (142, '2023-01-02', 144, 15),
       (143, '2023-01-02', 145, 15),
       (144, '2023-01-02', 146, 15),
       (145, '2023-01-02', 147, 15),
       (146, '2023-01-02', 148, 15),
       (147, '2023-01-02', 149, 15),
       (148, '2023-01-02', 150, 15),
       (149, '2023-01-02', 151, 15),
       (150, '2023-01-02', 152, 15),
       (151, '2023-01-02', 153, 15),
       (152, '2023-01-02', 154, 15),
       (153, '2023-01-02', 155, 15),
       (154, '2023-01-02', 156, 15),
       (155, '2023-01-02', 157, 15),
       (156, '2023-01-02', 158, 15),
       (157, '2023-01-02', 159, 15),
       (158, '2023-01-02', 160, 15),
       (159, '2023-01-02', 161, 15),
       (160, '2023-01-02', 162, 15),
       (161, '2023-01-02', 163, 18),
       (162, '2023-01-02', 164, 17),
       (163, '2023-01-02', 165, 17),
       (164, '2023-01-02', 166, 17),
       (165, '2023-01-02', 167, 17),
       (166, '2023-01-02', 168, 17),
       (167, '2023-01-02', 169, 17),
       (168, '2023-01-02', 170, 17),
       (169, '2023-01-02', 171, 17),
       (170, '2023-01-02', 172, 17),
       (171, '2023-01-02', 173, 17),
       (172, '2023-01-02', 174, 17),
       (173, '2023-01-02', 175, 17),
       (174, '2023-01-02', 176, 17),
       (175, '2023-01-02', 177, 17),
       (176, '2023-01-02', 178, 17),
       (177, '2023-01-02', 179, 17),
       (178, '2023-01-02', 180, 17),
       (179, '2023-01-02', 181, 17),
       (180, '2023-01-02', 182, 17),
       (181, '2023-01-02', 183, 20),
       (182, '2023-01-02', 184, 19),
       (183, '2023-01-02', 185, 19),
       (184, '2023-01-02', 186, 19),
       (185, '2023-01-02', 187, 19),
       (186, '2023-01-02', 188, 19),
       (187, '2023-01-02', 189, 19),
       (188, '2023-01-02', 190, 19),
       (189, '2023-01-02', 191, 19),
       (190, '2023-01-02', 192, 19),
       (191, '2023-01-02', 193, 19),
       (192, '2023-01-02', 194, 19),
       (193, '2023-01-02', 195, 19),
       (194, '2023-01-02', 196, 19),
       (195, '2023-01-02', 197, 19),
       (196, '2023-01-02', 198, 19),
       (197, '2023-01-02', 199, 19),
       (198, '2023-01-02', 200, 19),
       (199, '2023-01-02', 201, 19),
       (200, '2023-01-02', 202, 19);


# 출퇴근기록 생성 프로시저
DROP PROCEDURE IF EXISTS CreateTimeRecordsAndSettlements;
DELIMITER //
CREATE PROCEDURE CreateTimeRecordsAndSettlements()
BEGIN
  DECLARE i INT DEFAULT 1;
  DECLARE cur_date DATE DEFAULT '2023-01-02';
  DECLARE start_work DATETIME;
  DECLARE leave_work DATETIME;
  DECLARE work_state VARCHAR(10);
  DECLARE date_created DATETIME;
  DECLARE date_updated DATETIME;
  DECLARE late_day DATE;
  DECLARE start_time TIME;
  DECLARE end_time TIME;
  DECLARE working_time TIME;
  DECLARE over_time TIME;
  DECLARE late_time TIME;
  DECLARE work_group_record_id INT DEFAULT 1;

  WHILE cur_date <= '2023-09-25' DO
    IF DAYOFWEEK(cur_date) NOT IN (1, 7) THEN -- 주말 제외
      SET i = 3;
      WHILE i <= 202 DO
        SET late_day = DATE_ADD(DATE_SUB(LAST_DAY(cur_date), INTERVAL FLOOR(RAND() * 20) DAY), INTERVAL 1 DAY);

        IF i MOD 20 = 3 THEN
        -- 시차근로제 회원
          SET start_work = CONCAT(cur_date, ' ', ADDTIME('08:40:00', SEC_TO_TIME(FLOOR(RAND() * 140) * 60))); -- cur_date와 08:40 ~ 10:59 랜덤 시작 시간을 결합

          SET leave_work = TIMESTAMPADD(SECOND, (9 * 3600) + FLOOR(RAND() * 2 * 3600), start_work); -- 퇴근 시간은 인정 출근 시간의 9~11시간 이후

          IF TIME(start_work) > '11:00:00' THEN
            SET work_state = '근태이상';
            SET late_time = TIMEDIFF(TIME(start_work), '11:00:00');
          ELSE
            SET work_state = '정상처리';
            SET late_time = '00:00:00';
          END IF;
        ELSE
        -- 일반근로제 회원
          IF cur_date = late_day THEN
            SET start_work = CONCAT(cur_date, ' ', ADDTIME('09:01:00', SEC_TO_TIME(FLOOR(RAND() * 59) * 60))); -- 지각: 09:01 ~ 09:59
          ELSE
            SET start_work = CONCAT(cur_date, ' ', ADDTIME('08:40:00', SEC_TO_TIME(FLOOR(RAND() * 21) * 60))); -- 정상: 08:40 ~ 09:00
          END IF;

          SET leave_work = TIMESTAMPADD(SECOND, FLOOR(RAND() * 120) * 60, CONCAT(cur_date, ' ', '18:00:00')); -- 18:00 ~ 20:00 랜덤 종료 시간

          IF TIME(start_work) > '09:00:00' THEN
            SET work_state = '근태이상';
            SET late_time = TIMEDIFF(TIME(start_work), '09:00:00');
          ELSE
            SET work_state = '정상처리';
            SET late_time = '00:00:00';
          END IF;
        END IF;

        SET date_created = start_work;
        SET date_updated = date_created;

        -- 출퇴근 기록 생성
        INSERT INTO `time_record` (`user_id`, `date`, `start_work`, `leave_work`, `work_state`, `date_created`, `date_updated`)
        VALUES (i, cur_date, start_work, leave_work, work_state, date_created, date_updated);


        -- ####### 정산 데이터 계산 #######
        -- 인정 출퇴근 시간 계산
        IF i MOD 20 = 3 THEN
        -- 시차근로제 회원
          IF HOUR(TIME(start_work)) < 9 THEN
            SET start_time = MAKETIME(9, 0, 0);
          ELSE
            SET start_time = TIME(start_work);
          END IF;

          SET end_time = TIME(leave_work);
        ELSE
        -- 일반근로제 회원
          IF HOUR(TIME(start_work)) < 9 THEN
            SET start_time = MAKETIME(9, 0, 0);
          ELSE
            SET start_time = TIME(start_work);
          END IF;

          SET end_time = TIME(leave_work);
        END IF;

        -- 소정 근무시간 계산
        SET working_time = TIMEDIFF(end_time, start_time);
        SET working_time = SUBTIME(working_time, '01:00:00'); -- 1시간 휴식 제외
        IF TIME_TO_SEC(working_time) > (8 * 3600) THEN
          SET working_time = '08:00:00'; -- 8시간 이상일 경우 8시간으로 지정
        END IF;
        -- 지각한 시간만큼 소정 근무시간에서 제외
        SET working_time = SUBTIME(working_time, late_time);

        -- 초과 근무 시간 계산
        IF i MOD 20 = 3 THEN
        -- 시차근로제 회원
          IF TIME(leave_work) > '20:00:00' THEN
            SET over_time = TIMEDIFF(TIME(leave_work), '20:00:00');
          ELSE
            SET over_time = '00:00:00';
          END IF;
        ELSE
        -- 일반근로제 회원
          IF TIME(leave_work) > '18:00:00' THEN
            SET over_time = TIMEDIFF(TIME(leave_work), '18:00:00');
          ELSE
            SET over_time = '00:00:00';
          END IF;
        END IF;
        -- 지각한 시간만큼 초과근무 시간에서 제외
        SET over_time = TIMEDIFF(over_time, late_time);


        -- 근무그룹 기록 ID 계산
        IF i MOD 20 = 3 THEN
        -- 시차근로제 회원
          SET work_group_record_id = (i - 3) / 10 + 2;
        ELSE
        -- 일반근로제 회원
          SET work_group_record_id = ((i - 4) DIV 20) * 2 + 1;
        END IF;

        -- 정산 테이블에 레코드 추가
        INSERT INTO `settlement` (`user_id`, `date`, `start_time`, `end_time`, `working_time`, `over_time`, `day_type`, `date_created`, `date_updated`, `work_group_record_id`)
        VALUES (i, cur_date, start_time, end_time, working_time, over_time, '근무', date_created, date_created, work_group_record_id);

        SET i = i + 1;
      END WHILE;
    END IF;
    SET cur_date = DATE_ADD(cur_date, INTERVAL 1 DAY);
  END WHILE;
END;
//
DELIMITER ;

CALL CreateTimeRecordsAndSettlements();

# 9/26일 더존비즈온 더미데이터
insert into time_record(user_id, date, start_work, leave_work, work_state, date_created, date_updated)
values
    (3, '2023-09-26', '2023-09-26 09:00:00', '2023-09-26 18:00:00', '미처리', '2023-09-26 09:00:00', '2023-09-26 18:00:00'),
    (4, '2023-09-26', '2023-09-26 09:00:00', '2023-09-26 18:00:00', '미처리', '2023-09-26 09:00:00', '2023-09-26 18:00:00'),
    (5, '2023-09-26', '2023-09-26 09:00:00', '2023-09-26 18:00:00', '미처리', '2023-09-26 09:00:00', '2023-09-26 18:00:00'),
    (6, '2023-09-26', '2023-09-26 09:00:00', '2023-09-26 19:26:00', '미처리', '2023-09-26 09:00:00', '2023-09-26 19:26:00'),
    (7, '2023-09-26', '2023-09-26 08:57:00', '2023-09-26 19:00:00', '미처리', '2023-09-26 08:57:00', '2023-09-26 19:00:00'),
    (8, '2023-09-26', '2023-09-26 08:51:00', '2023-09-26 18:30:00', '미처리', '2023-09-26 08:51:00', '2023-09-26 18:30:00'),
    (9, '2023-09-26', '2023-09-26 08:59:00', '2023-09-26 18:20:00', '미처리', '2023-09-26 08:59:00', '2023-09-26 18:20:00'),
    (10, '2023-09-26', '2023-09-26 08:52:00', '2023-09-26 18:44:00', '미처리', '2023-09-26 08:52:00', '2023-09-26 18:44:00'),
    (11, '2023-09-26', '2023-09-26 08:49:00', '2023-09-26 18:50:00', '미처리', '2023-09-26 08:49:00', '2023-09-26 18:50:00'),
    (12, '2023-09-26', '2023-09-26 08:50:00', '2023-09-26 20:21:00', '미처리', '2023-09-26 08:50:00', '2023-09-26 20:21:00'),
    (13, '2023-09-26', '2023-09-26 08:53:00', '2023-09-26 21:10:00', '미처리', '2023-09-26 08:53:00', '2023-09-26 21:10:00'),
    (14, '2023-09-26', '2023-09-26 08:58:00', '2023-09-26 19:40:00', '미처리', '2023-09-26 08:58:00', '2023-09-26 19:40:00'),
    (15, '2023-09-26', '2023-09-26 08:52:00', '2023-09-26 18:30:00', '미처리', '2023-09-26 08:52:00', '2023-09-26 18:30:00'),
    (16, '2023-09-26', '2023-09-26 08:48:00', '2023-09-26 18:00:00', '미처리', '2023-09-26 08:48:00', '2023-09-26 18:00:00'),
    (17, '2023-09-26', '2023-09-26 08:55:00', '2023-09-26 18:00:00', '미처리', '2023-09-26 08:55:00', '2023-09-26 18:00:00'),
    (18, '2023-09-26', '2023-09-26 08:51:00', '2023-09-26 19:25:00', '미처리', '2023-09-26 08:51:00', '2023-09-26 19:25:00'),
    (19, '2023-09-26', '2023-09-26 09:15:00', '2023-09-26 19:00:00', '미처리', '2023-09-26 09:15:00', '2023-09-26 19:00:00'),
    (20, '2023-09-26', '2023-09-26 09:10:00', '2023-09-26 18:30:00', '미처리', '2023-09-26 09:10:00', '2023-09-26 18:30:00'),
    (21, '2023-09-26', '2023-09-26 09:30:00', '2023-09-26 19:00:00', '미처리', '2023-09-26 09:30:00', '2023-09-26 19:00:00'),
    (22, '2023-09-26', '2023-09-26 09:25:00', '2023-09-26 20:10:00', '미처리', '2023-09-26 09:25:00', '2023-09-26 20:10:00');

insert into settlement(user_id, date, start_time, end_time, working_time, over_time, day_type, date_created, date_updated, work_group_record_id)
values
    (3, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 09:00:00', '2023-09-26 09:00:00', 2),
    (4, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 09:00:00', '2023-09-26 09:00:00', 1),
    (5, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 09:00:00', '2023-09-26 09:00:00', 1),
    (6, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 09:00:00', '2023-09-26 09:00:00', 1),
    (7, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:57:00', '2023-09-26 08:57:00', 1),
    (8, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:51:00', '2023-09-26 08:51:00', 1),
    (9, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:59:00', '2023-09-26 08:59:00', 1),
    (10, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:52:00', '2023-09-26 08:52:00', 1),
    (11, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:49:00', '2023-09-26 08:49:00', 1),
    (12, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:50:00', '2023-09-26 08:50:00', 1),
    (13, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:53:00', '2023-09-26 08:53:00', 1),
    (14, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:58:00', '2023-09-26 08:58:00', 1),
    (15, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:52:00', '2023-09-26 08:52:00', 1),
    (16, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:48:00', '2023-09-26 08:48:00', 1),
    (17, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:55:00', '2023-09-26 08:55:00', 1),
    (18, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 08:51:00', '2023-09-26 08:51:00', 1),
    (19, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 09:15:00', '2023-09-26 09:15:00', 1),
    (20, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 09:10:00', '2023-09-26 09:10:00', 1),
    (21, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 09:30:00', '2023-09-26 09:30:00', 1),
    (22, '2023-09-26', null, null, '00:00:00', '00:00:00', null, '2023-09-26 09:25:00', '2023-09-26 09:25:00', 1);