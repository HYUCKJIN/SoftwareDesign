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
			 //���� �˻�, ����� �˻� �߰�.
			 System.out.println("���� �� ������ ���̽��ϱ�?");
			 int choose_mode_inBuyer=choosemenu(2, "1: �����˻�, 2:������˻�");
			 
			 if(choose_mode_inBuyer == 1)//�����˻�
			 {
				  try
				  {
					  Phone_List plist = new Phone_List();
					  System.out.printf("�����Ͻ� ������ �Է����ּ���: ");
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
				 CallingPlan_List cplist = new CallingPlan_List();	//������˻�
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
