drop table product;
create table product(id number,name varchar(200),expiry_date date);
insert into product values(1,'Pen',DATE '2023-01-01');
insert into product values(2,'Pencil',DATE '2023-01-01');
insert into product values(3,'Milk',DATE '2023-01-01');
commit;
select * from product;

echo "# product-app" >> README.md
git init
git add README.md
git commit -m "first commit"

git remote add origin https://github.com/Ajithkumarmanikandan/product-app.git
git branch -M main
git push -u origin main


1. git repo
2. create project in eclipse
3. create sql file,execute and store inside project 
4. Addd jar 
5. create packages
6. model class 
7. exception class
8. dao 
9. service
10. client