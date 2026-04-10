package com.inventory.HibernateCRUD;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO 
{
	public void insertProduct(Product p) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.save(p);

		tx.commit();
		session.close();
	}

	public Product getProduct(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Product p = session.get(Product.class, id);
		session.close();

		return p;
	}
	public void updateProduct(int id, double price, int quantity) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Product p = session.get(Product.class, id);

		p.setPrice(price);
		p.setQuantity(quantity);

		session.update(p);

		tx.commit();
		session.close();
	}
	public void deleteProduct(int id){

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Product p = session.get(Product.class,id);

		if(p != null){
		    session.delete(p);
		    System.out.println("Product deleted successfully");
		}
		else{
		    System.out.println("Product not found");
		}

		tx.commit();
		session.close();
		}
	
	

}
