package ex.product;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;


public class HibernateDemo 
{
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"MENU\n======\n1.Add Product\n2.Update Product\n3.Delete Product\n4.Select Product\n5.Select Product\n6.Exit");
		int ch = sc.nextInt();

		switch (ch) {
		case 1: {
			Scanner sc1 = new Scanner(System.in);
			System.out.print("Enter name : ");
			String name = sc1.nextLine();
			System.out.print("Enter category : ");
			String cat = sc1.nextLine();
			System.out.print("Enter id : ");
			int id = sc1.nextInt();
			System.out.print("Enter price : ");
			int price = sc1.nextInt();
			Product st = new Product(id, price, name, cat);
			session.save(st);
			session.getTransaction().commit();
			System.out.println("Insertion done !!!");
			break;
		}
		case 2:
		{
			System.out.print("Enter id : ");
			int id=sc.nextInt();
			Scanner sc1 = new Scanner(System.in);
			System.out.print("Enter name : ");
			String name = sc1.nextLine();
			System.out.print("Enter category : ");
			String cat = sc1.nextLine();
			System.out.print("Enter price : ");
			int price = sc1.nextInt();
			Product st=(Product) session.get(Product.class,id);
			st.setName(name);
			st.setCategory(cat);
			st.setPrice(price);
			session.update(st);
			session.getTransaction().commit();
			System.out.println("Product Updated !!! ");
			break;
		}
		case 3:
		{
			System.out.print("Enter id : ");
			int id=sc.nextInt();
			Product st=(Product) session.get(Product.class,id);
			session.delete(st);
			session.getTransaction().commit();
			System.out.println("Product Deleted !!! ");
			break;
		}
		case 4:
		{
			Query query = session.createQuery("from Product"); 
			 List<Product> list = query.list();
			 for(int i=0;i<list.size();i++)
			 {
				 Product st = (Product) list.get(i);
				 System.out.println(st);
			 }
			 break;
		}
		case 5:
		{
			System.out.print("Enter id : ");
			int id=sc.nextInt();
			Product st=(Product) session.get(Product.class,id);
			System.out.println("Data for product\n===============");
			System.out.println("ID :  "+st.getPid());
			System.out.println("NAME :  "+st.getName());
			System.out.println("CATEGORY :  "+st.getCategory());
			System.out.println("PRICE :  "+st.getPrice());
		}
		case 6: {
			System.exit(0);
			break;
		}
		default: {
			System.out.println("Incorrect option !!!");
			break;
		}

		}
	}

}
