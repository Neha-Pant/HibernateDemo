package ex.product;

public class Product implements java.io.Serializable
{
	private int pid,price;
	private String name,category;
	
	public Product(int a,int b,String c,String d)
	{
		pid=a;
		price=b;
		name=c;
		category=d;
	}
	public Product() {}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString()
	{
		return "ID : "+pid+"\tNAME : "+name+"\tCATEGORY : "+category+"\tPRICE : "+price;
	}
}
