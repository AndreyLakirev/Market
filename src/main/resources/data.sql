INSERT INTO products (name, status, material, weight, cost)
VALUES ('TestProduct1', 'Available', 'Gold', 200, 1000),
       ('TestProduct2', 'Available', 'Silver', 120, 210),
       ('TestProduct3', 'Sold', 'Gold', 85, 250),
       ('TestProduct4', 'Available', 'Gold, Silver', 235, 750);

INSERT INTO employees (name, surname, status)
VALUES ('EmployeeName1', 'EmployeeSurname1', 'Fired'),
       ('EmployeeName2', 'EmployeeSurname2', 'Redundanced'),
       ('EmployeeName3', 'EmployeeSurname3', 'Established'),
       ('EmployeeName4', 'EmployeeSurname4', 'Established');

INSERT INTO customers (name, surname)
VALUES ('CustomerName1', 'CustomerSurname1'),
       ('CustomerName2', 'CustomerSurname2'),
       ('CustomerName3', 'CustomerSurname3'),
       ('CustomerName4', 'CustomerSurname4');

INSERT INTO purchases (datetime, productID, customerID, employeeID)
VALUES ('20210629 10:35:12', 1, 1, 1),
       ('20210629 12:35:12', 2, 2, 2),
       ('20210629 12:35:12', 3, 3, 3),
       ('20210629 12:35:12', 4, 4, 4);