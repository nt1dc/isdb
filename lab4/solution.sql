-- Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:
-- Таблицы: Н_ЛЮДИ, Н_СЕССИЯ.
-- Вывести атрибуты: Н_ЛЮДИ.ИД, Н_СЕССИЯ.ДАТА.
-- Фильтры (AND):
-- a) Н_ЛЮДИ.ИД = 163484.
-- b) Н_СЕССИЯ.ЧЛВК_ИД < 151200.
-- Вид соединения: LEFT JOIN.
explain analyse
select "Н_ЛЮДИ"."ИД", "Н_СЕССИЯ"."ДАТА"
from "Н_ЛЮДИ"
         left join "Н_СЕССИЯ" on "Н_ЛЮДИ"."ИД" = "Н_СЕССИЯ"."ИД"
where "Н_ЛЮДИ" = 163484
  and "Н_СЕССИЯ"."ЧЛВК_ИД" < 15120;
-- Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:
-- Таблицы: Н_ЛЮДИ, Н_ВЕДОМОСТИ, Н_СЕССИЯ.
-- Вывести атрибуты: Н_ЛЮДИ.ИД, Н_ВЕДОМОСТИ.ИД, Н_СЕССИЯ.УЧГОД.
-- Фильтры (AND):
-- a) Н_ЛЮДИ.ИД = 163484.
-- b) Н_ВЕДОМОСТИ.ИД = 39921.
-- c) Н_СЕССИЯ.УЧГОД < 2001/2002.
-- Вид соединения: RIGHT JOIN.
explain analyse
select "Н_ЛЮДИ"."ИД", "Н_ВЕДОМОСТИ"."ИД", "Н_СЕССИЯ"."УЧГОД"
from "Н_ЛЮДИ"
         right join "Н_ВЕДОМОСТИ" on "Н_ЛЮДИ"."ИД" = "Н_ВЕДОМОСТИ"."ИД"
         right join "Н_СЕССИЯ" on "Н_СЕССИЯ"."ЧЛВК_ИД" = "Н_ЛЮДИ"."ИД"
where "Н_ЛЮДИ"."ИД" = 163484
  and "Н_ВЕДОМОСТИ"."ИД" = 39921
  and "Н_СЕССИЯ"."УЧГОД" < 2001 / 2002;