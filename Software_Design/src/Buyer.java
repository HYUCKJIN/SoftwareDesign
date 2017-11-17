import java.util.*;


public class Buyer {
	private String name;
	private int age;
	private String Phone;
	
	public Buyer()
	{
		Scanner keyboard;
		
		keyboard  = new Scanner(System.in);
		System.out.print("Name : ");
		setName(keyboard.nextLine());

		System.out.print("Age : ");
		setAge(keyboard.nextInt());
		
		keyboard.nextLine(); 	//Flush Buffer

		System.out.print("PhoneNumber : ");
		setPhone(keyboard.nextLine());

		
		System.out.println("고객님의 이름은 "+getName()+"이고 나이는 "+getAge()+"이며 핸드폰 번호는 "+getPhone()+" 입니다." );
	}

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}



}
