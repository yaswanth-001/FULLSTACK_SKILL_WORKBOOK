package com.inventory.HibernateCRUD;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HQLQueries {

public static void runQueries() {

Session session = HibernateUtil.getSessionFactory().openSession();

System.out.println("----Sort by price ASC----");

Query<Product> q1 = session.createQuery(
"FROM Product ORDER BY price ASC", Product.class);
List<Product> list1 = q1.list();

for(Product p : list1)
System.out.println(p.getName()+" "+p.getPrice());


System.out.println("----Sort by price DESC----");

Query<Product> q2 = session.createQuery(
"FROM Product ORDER BY price DESC", Product.class);
List<Product> list2 = q2.list();

for(Product p : list2)
System.out.println(p.getName()+" "+p.getPrice());


System.out.println("----Sort by quantity DESC----");

Query<Product> q3 = session.createQuery(
"FROM Product ORDER BY quantity DESC", Product.class);
List<Product> list3 = q3.list();

for(Product p : list3)
System.out.println(p.getName()+" "+p.getQuantity());


// Pagination
System.out.println("----First 3 Products----");

Query<Product> q4 = session.createQuery(
"FROM Product", Product.class);

q4.setFirstResult(0);
q4.setMaxResults(3);

for(Product p : q4.list())
System.out.println(p.getName());


System.out.println("----Next 3 Products----");

Query<Product> q5 = session.createQuery(
"FROM Product", Product.class);

q5.setFirstResult(3);
q5.setMaxResults(3);

for(Product p : q5.list())
System.out.println(p.getName());


// Aggregate Functions
System.out.println("Total Products:");

Query<Long> q6 = session.createQuery(
"SELECT COUNT(*) FROM Product", Long.class);

System.out.println(q6.uniqueResult());


System.out.println("Products where quantity > 0");

Query<Long> q7 = session.createQuery(
"SELECT COUNT(*) FROM Product WHERE quantity > 0", Long.class);

System.out.println(q7.uniqueResult());


System.out.println("Min and Max Price");

Query<Object[]> q8 = session.createQuery(
"SELECT MIN(price), MAX(price) FROM Product");

Object[] result = q8.uniqueResult();

System.out.println("Min: "+result[0]+" Max: "+result[1]);


// GROUP BY
System.out.println("Group By Description");

Query<Object[]> q9 = session.createQuery(
"SELECT description, COUNT(*) FROM Product GROUP BY description");

for(Object[] row : q9.list())
System.out.println(row[0]+" "+row[1]);


// WHERE price range
System.out.println("Products between price range");

Query<Product> q10 = session.createQuery(
"FROM Product WHERE price BETWEEN 1000 AND 20000", Product.class);

for(Product p : q10.list())
System.out.println(p.getName()+" "+p.getPrice());


// LIKE queries
System.out.println("Names starting with 'P'");

Query<Product> q11 = session.createQuery(
"FROM Product WHERE name LIKE 'P%'", Product.class);

for(Product p : q11.list())
System.out.println(p.getName());


System.out.println("Names ending with 'r'");

Query<Product> q12 = session.createQuery(
"FROM Product WHERE name LIKE '%r'", Product.class);

for(Product p : q12.list())
System.out.println(p.getName());


System.out.println("Names containing 'on'");

Query<Product> q13 = session.createQuery(
"FROM Product WHERE name LIKE '%on%'", Product.class);

for(Product p : q13.list())
System.out.println(p.getName());


System.out.println("Names with length 5");

Query<Product> q14 = session.createQuery(
"FROM Product WHERE name LIKE '_____'", Product.class);

for(Product p : q14.list())
System.out.println(p.getName());


session.close();

}
}