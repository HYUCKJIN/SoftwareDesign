import java.io.IOException;
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

		
		System.out.println("������ �̸��� "+getName()+"�̰� ���̴� "+getAge()+"�̸� �ڵ��� ��ȣ�� "+getPhone()+" �Դϴ�." );
		System.out.println("+===============================================+\n\t\t���ϴ� �޴��� ������\n\n1.�����˻�\n2.������˻�\n3.����\n+===============================================+\n\n�޴����� : ");
		if(keyboard.nextInt() == 1)
		{
			//1.�����˻�
			Phone_List Buyer_Phone = new Phone_List();								//�� ����Ʈ�ҷ��ͼ� ����ڷκ��� ������ �Է¹޾����� �˻����غ�.
			Recommand Buyer_Recommand = new Recommand();							//Recommand �ҷ��ͼ� �������� ��õ �������� �ȹ������� ���� ��õ�Ұ�
			if(keyboard.nextLine().equals("temp"))//������Ʈ�����̸�)																	//if���ȿ��� ����ڷκ��� �Է¹����Ŷ� �� �̸������� Ȯ���غ��� if�� �ȿ��� �������Ұ�.
			{
					
			}
			Buyer_Recommand.Recommand("Parameter"/*�����Ķ����*/);
			
		}
		else if(keyboard.nextInt() == 2)
		{
			//2.������˻�
			
		}
		else
		{
			//3.����
		}
		
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
