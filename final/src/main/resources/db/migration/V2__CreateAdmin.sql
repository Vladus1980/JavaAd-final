insert into user (user_id, first_name, last_name, email, password, active)
    values (1, 'Приймальна комісія', 'Адміністратор', 'valdusjava@gmail.com', '123456', true);

insert into accsses_level (user_id, access_levels)
    values (1, 'USER'), (1, 'ADMIN'); 