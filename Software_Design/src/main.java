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
			Phone_List plist = new Phone_List();
			plist.ReadFile_PhoneList();
			
			int last = plist.print_Phone_List();
			
			System.out.println("���Ͻô� �׸��� ��ȣ�� �Է����ּ���");
			
			Scanner input = new Scanner(System.in);
			int inputNUM = input.nextInt();
			
			if(inputNUM == last)
			{
				
				/////////////////Recommend (�����󼼰˻� ����)
				
			}
			else
			{
				Phone selectPhone = plist.Get_SelectPhone(inputNUM);
				
				System.out.println("�����Ͻ� ������ " + selectPhone.getMODEL_NAME() + " �Դϴ�.\n");
				
				selectPhone.printPhoneINFO();
			}
		 }
		 else if(choose_mode_inBuyer == 2)//������˻�
		 {
			 CallingPlan_List clist = new CallingPlan_List();
			clist.ReadFile_CallingPlanList();
			
			int last = clist.print_CallingPlan_List();
				
			System.out.println("���Ͻô� �׸��� ��ȣ�� �Է����ּ���");
				
			Scanner input = new Scanner(System.in);
			int inputNUM = input.nextInt();
			
			if(inputNUM == last)
			{
				
				/////////////////Recommend (������󼼰˻� ����)
				
			}
			else
			{
				CallingPlan selectCallingPlan = clist.Get_SelectCallingPlan(inputNUM);
				
				System.out.println("�����Ͻ� ������� " + selectCallingPlan.getPAY_NAME() + " �Դϴ�.\n");
				
				selectCallingPlan.printCallingPlanINFO();
			}
		 }
		 else if(choose_mode_inBuyer == 3)
		 {
			 System.exit(0);
		 }
	}

}
