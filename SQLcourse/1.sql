truncate departments;
truncate locations;
TRUNCATE employees;

select "locations" as table_name, COUNT(*) as row_count 
from locations 
union all
select "departments", COUNT(*) 
from departments
union all
select "employees", COUNT(*)
from employees;
use hr;

set SQL_SAFE_UPDATES = 0;
truncate locations;
INSERT INTO locations (street_address, postal_code, city, state_province, country_id) 
SELECT DISTINCT street_address, postal_code, city, state_province, country_id
FROM REPORT
WHERE city IS NOT NULL AND country_id IS NOT NULL;

truncate departments;
INSERT INTO departments (department_name)
SELECT DISTINCT department_name
FROM REPORT
WHERE DEPARTMENT_NAME IS NOT NULL;

TRUNCATE employees;
INSERT INTO employees(first_name,last_name,email,phone_number,hire_date, job_id,salary,commission_pct)
SELECT DISTINCT r.first_name, r.last_name, r.last_name, r.phone_number, r.hire_date, r.job_id,  r.salary, r.commission_pct
FROM REPORT as r;


UPDATE DEPARTMENTS dep
JOIN REPORT rep ON dep.department_name=rep.department_name 
JOIN Employees em ON rep.DEPARTMENT_MANAGER_FIRST_NAME = em.first_name AND rep.department_manager_last_name=em.last_name
SET dep.Manager_id=em.employee_id;

UPDATE DEPARTMENTS dep 
JOIN Report rep ON dep.Department_name=rep.Department_name
JOIN Locations l ON rep.street_address=l.street_address
SET dep.Location_id=l.Location_id;


UPDATE EMPLOYEES em
JOIN REPORT rep ON em.first_name=rep.first_name AND em.last_name=rep.last_name
JOIN employees e ON e.first_name=rep.manager_first_name AND e.last_name=rep.manager_last_name
SET em.Manager_id=e.employee_id;


UPDATE EMPLOYEES em
JOIN REPORT rep ON em.first_name=rep.first_name AND em.last_name=rep.last_name
JOIN Departments dep ON rep.Department_name=dep.Department_name
SET em.Department_id=dep.Department_id;

UPDATE EMPLOYEES
SET salary=salary+100;

UPDATE EMPLOYEES em
INNER JOIN EMPLOYEES e ON em.employee_id=e.manager_id
SET em.SALARY=em.SALARY-100;

UPDATE employees 
SET salary = salary * 1.1
WHERE department_id IN (SELECT department_id FROM (SELECT  department_id, COUNT(department_id) AS n FROM employees
GROUP BY department_id) AS countTable
WHERE n < 10);

UPDATE employees
SET email= concat(SUBSTRING(first_name,1,5),SUBSTRING(last_name,1,5));

select "locations" as table_name, COUNT(*) as row_count 
from locations 
union all
select "departments", COUNT(*) 
from departments
union all
select "employees", COUNT(*)
from employees;