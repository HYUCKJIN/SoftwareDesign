import java.io.IOException;
import java.util.*;

public class main {
//test
	public static void main(String[] args) {
		 System.out.println("PHONE / CALLINGPLAN RECOMMAND SYSTEM");
		 int choose_mode=choosemenu(2, "1: Seller, 2:Buyer");
		
		 if(choose_mode == 1)
		 {
			 Seller seller = new Seller();
		 }
		 else if(choose_mode == 2)
		 {
			 Buyer buyer = new Buyer();
			 //기종 검색, 요금제 검색 추가.
			 System.out.println("무슨 일 때문에 오셨습니까?");
			 int choose_mode_inBuyer=choosemenu(2, "1: 기종검색, 2:요금제검색");
			 
			 if(choose_mode_inBuyer == 1)//기종검색
			 {
				  try
				  {
					  Phone_List plist = new Phone_List();
					  System.out.printf("생각하신 기종을 입력해주세요: ");
					  Scanner s = new Scanner(System.in);
					  String SearchPhone = s.nextLine();
					  plist.Search_Phone(SearchPhone);
				  }
				  catch (IOException e)
				  {
					  e.printStackTrace();
				  }
			 }
			 else if(choose_mode_inBuyer == 2)
			 {
				 CallingPlan_List cplist = new CallingPlan_List();	//요금제검색
			 }
			 
		 }
	}
	
	public static int choosemenu(int count, String condition)
	{
		int value;
		
		while(true)
		{
			value=0;

			 System.out.print("Choose Mode ("+condition+") : ");

			 Scanner s = new Scanner(System.in);
			 value = s.nextInt();
			 
			 for(int i =1;i<=count;i++)
			 {
				 if(value == i)
				 {
					 return value;
				 }
			 }
			 
			 System.out.println("Input Wrong Number");
		
		}		
	
	}

}
