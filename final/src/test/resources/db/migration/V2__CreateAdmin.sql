insert into user (user_id, first_name, last_name, email, password, active)
    values (1, 'Приймальна комісія', 'Адмін', 'valdusjava@gmail.com', '$2a$08$ATp5HqCoqjAxUYmQK31xj.GWT46/osCgux8HwtLXS9metURpdSkMm', true);

insert into access_level (user_id, access_levels)
    values (1, 'ADMIN');