import java.io.IOException;
import java.util.*;

public class main {
//test
	public static void main(String[] args) throws IOException {
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

			 main_recommand();
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
					 System.out.println(" "); // ������
					 return value;
				 }
			 }
			 
			 System.out.println("Input Wrong Number");
		
		}		
	
	}
	
	public static void main_recommand()
	{
		System.out.println("���� �� ������ ���̽��ϱ�?");
		 int choose_mode_inBuyer=choosemenu(2, "1: �����˻�, 2:������˻�, 3: ����");
		 int Mode = 2;
		 if(choose_mode_inBuyer == 1)//�����˻�
		 {
			Phone_List plist = new Phone_List(Mode);
			System.out.printf("�����Ͻ� ������ �Է����ּ���: ");
			Scanner s = new Scanner(System.in);
			String SearchPhone = s.nextLine();
			plist.Search_Phone(SearchPhone);
		 }
		 else if(choose_mode_inBuyer == 2)//������˻�
		 {
			CallingPlan_List cplist = new CallingPlan_List();
			System.out.printf("�����Ͻ� ������� �Է����ּ���: ");
			Scanner s = new Scanner(System.in);
			String SearchPhone = s.nextLine();
			cplist.Search_Phone(SearchPhone);
		 }
		 else if(choose_mode_inBuyer == 3)
		 {
			 System.exit(0);
		 }
	}

}
