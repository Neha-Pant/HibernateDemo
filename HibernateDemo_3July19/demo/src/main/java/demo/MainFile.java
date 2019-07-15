package demo;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import demo.user.StudentModel;
import demo.util.HibernateUtil;

public class MainFile {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"MENU\n======\n1.Add Student\n2.Update Student\n3.Delete Student\n4.Select Students\n5.Select Student\n6.Exit");
		int ch = sc.nextInt();

		switch (ch) {
		case 1: {
			Scanner sc1 = new Scanner(System.in);
			System.out.print("Enter name : ");
			String name = sc1.nextLine();
			System.out.print("Enter course : ");
			String course = sc1.nextLine();
			System.out.print("Enter id : ");
			int id = sc1.nextInt();
			System.out.print("Enter marks : ");
			int marks = sc1.nextInt();
			StudentModel st = new StudentModel(id, marks, name, course);
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
			System.out.print("Enter course : ");
			String course = sc1.nextLine();
			System.out.print("Enter marks : ");
			int marks = sc1.nextInt();
			StudentModel st=(StudentModel) session.get(StudentModel.class,id);
			st.setName(name);
			st.setCourse(course);
			st.setMarks(marks);
			session.update(st);
			session.getTransaction().commit();
			System.out.println("Student Updated !!! ");
			break;
		}
		case 3:
		{
			System.out.print("Enter id : ");
			int id=sc.nextInt();
			StudentModel st=(StudentModel) session.get(StudentModel.class,id);
			session.delete(st);
			session.getTransaction().commit();
			System.out.println("Student Deleted !!! ");
			break;
		}
		case 4:
		{
			Query query = session.createQuery("from StudentModel"); 
			 List<StudentModel> list = query.list();
			 for(int i=0;i<list.size();i++)
			 {
				 StudentModel st = (StudentModel) list.get(i);
				 System.out.println(st);
			 }
			 break;
		}
		case 5:
		{
			System.out.print("Enter id : ");
			int id=sc.nextInt();
			StudentModel st=(StudentModel) session.get(StudentModel.class,id);
			System.out.println("Data for student\n===============");
			System.out.println("ID :  "+st.getId());
			System.out.println("NAME :  "+st.getName());
			System.out.println("COURSE :  "+st.getCourse());
			System.out.println("MARKS :  "+st.getMarks());
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
