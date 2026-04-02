package com.inventory.HibernateCRUD;

public class MainApp {

public static void main(String[] args){

	ProductDAO dao = new ProductDAO();

	Product p1 = new Product("Laptop","Electronics",50000,10);
	Product p2 = new Product("Phone","Electronics",25000,20);
	Product p3 = new Product("Tablet","Electronics",15000,15);
	Product p4 = new Product("Mouse","Accessories",800,50);
	Product p5 = new Product("Keyboard","Accessories",1200,40);
	Product p6 = new Product("Monitor","Electronics",12000,12);
	Product p7 = new Product("Speaker","Accessories",3000,25);

	dao.insertProduct(p1);
	dao.insertProduct(p2);
	dao.insertProduct(p3);
	dao.insertProduct(p4);
	dao.insertProduct(p5);
	dao.insertProduct(p6);
	dao.insertProduct(p7);

	Product product = dao.getProduct(1);
	System.out.println("Product Name: " + product.getName());

	dao.updateProduct(1,48000,8);

	dao.deleteProduct(2);

	System.out.println("CRUD Operations Completed");
	HQLQueries.runQueries();

}
}