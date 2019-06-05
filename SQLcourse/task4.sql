SET SQL_SAFE_UPDATES = 0;
set foreign_key_checks = 0;
use hr;
select * from departments;

update departments d
join report r
ON d.department_name = r.department_name
join employees e
on r.department_manager_first_name = e.first_name
and r.department_manager_last_name = e.last_name
set d.manager_id = e.employee_id;

/*LEFT JOIN REPORT r on e.first_name=r.first_name AND e.last_name=r.last_name
RIGHT JOIN employees er on er.first_name=r.manager_first_name AND er.last_name=r.manager_last_name
SET e.Manager_id=er.employee_id;
*/

select * from EMPLOYEES;