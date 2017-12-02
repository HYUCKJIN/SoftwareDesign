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

		
		System.out.println("고객님의 이름은 "+getName()+"이고 나이는 "+getAge()+"이며 핸드폰 번호는 "+getPhone()+" 입니다." );
		System.out.println("+===============================================+\n\t\t원하는 메뉴를 고르세요\n\n1.기종검색\n2.요금제검색\n3.종료\n+===============================================+\n\n메뉴선택 : ");
		if(keyboard.nextInt() == 1)
		{
			//1.기종검색
			Phone_List Buyer_Phone = new Phone_List();								//폰 리스트불러와서 사용자로부터 폰기종 입력받았을떄 검색할준비.
			Recommand Buyer_Recommand = new Recommand();							//Recommand 불러와서 마지막에 추천 받을껀지 안받을껀지 보고 추천할것
			if(keyboard.nextLine().equals("temp"))//폰리스트중의이름)																	//if문안에는 사용자로부터 입력받은거랑 폰 이름같은거 확인해보고 if문 안에서 결과출력할것.
			{
					
			}
			Buyer_Recommand.Recommand("Parameter"/*받을파라미터*/);
			
		}
		else if(keyboard.nextInt() == 2)
		{
			//2.요금제검색
			
		}
		else
		{
			//3.종료
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
