package seller;
import java.util.*;

import callingplan.CallingPlan_List;
import phone.Phone_List;

import java.io.*;

public class Seller {
	private String marketInfo;
	private String sellerInfo;
	private int businessNumber;
	private Phone_List phonelist;
	private CallingPlan_List callingplanlist;
	
	public Seller()
	{
		//파일 존재 여부 확인.
		if(!CheckExistFile("SellerInfo"))
		{
			System.out.println("최초실행입니다. 정보입력이 필요합니다.");
			GetFileInfo();
		}
		else
		{
			Scanner s;
			s = new Scanner(System.in);
			
			try {
				FileInputStream fin = new FileInputStream("SellerInfo");
				Reader reader = new InputStreamReader(fin, "euc-kr"); 
				BufferedReader in = new BufferedReader(reader);
				
				char b;
				String ID = "", PASSWD = "";
				String inputID, inputPASSWD;
				String temp = "";
				
				while((b = (char) in.read()) != '\0')
				{
					ID += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					PASSWD += b;
				}
				
				while(true)
				{
					/// 보안화 필요
					System.out.print("아이디 : ");
					inputID = s.nextLine();
					System.out.print("비밀번호 : ");
					inputPASSWD = s.nextLine();
					
					if(ID.equals(inputID) && PASSWD.equals(inputPASSWD))
						break;
					else
						System.out.println("틀렸습니다. 다시 한번 시도해주세요");
				}
				
				while((b = (char) in.read()) != '\0')
				{
					temp += b;
				}

				setBusinessNumber(Integer.parseInt(temp));
				
				temp = "";
				while((b = (char) in.read()) != '\0')
				{
					temp += b;
				}

				setMarketInfo(temp);
				
				temp = "";
				while((b = (char) in.read()) != '\0')
				{
					temp += b;
				}
				
				setSellerInfo(temp);
				
				System.out.println("사업자 번호 : " + getBusinessNumber());
				System.out.println("대리점 정보 : " + getMarketInfo());
				System.out.println("판매자 정보 : " + getSellerInfo());
				in.close();
				
			} catch (IOException e) {	//존재여부 확인하고 와서 들어갈 일 없음.
				e.printStackTrace();
			}
			
			while(true)
			{
				int selectadmin = choosemenu(4,"1: Phone, 2: CallingPlan, 3: Market, 4: Exit");
				
				if(selectadmin ==1)
				{
					//Phone admin
					phonelist = new Phone_List(1);
					phoneAdmin();
				}
				else if(selectadmin ==2)
				{
					//CallingPlan admin
					callingplanlist = new CallingPlan_List(1);
					callingplanAdmin();
				}
				else if(selectadmin == 3)
				{
					// Market admin, ID, PASSWD 정보 수정을 위한 공간. 이 메뉴를 클릭하게 되면 SellerInfo 지우고 다시 만들게 된다.
					marketAdmin();
				}
				else if(selectadmin == 4)
				{
					System.exit(0);
				}
			}
			// Admin_mode
		}
	}
	
	public boolean CheckExistFile(String filename)
	{
		File file = new File(filename);
		
		boolean isExists = file.exists();
		
		return isExists;
	}

	public void GetFileInfo()
	{
		Scanner s;
		s = new Scanner(System.in);
		
		System.out.println("사용할 ID와 PASSWIORD를 입력하세요.");
		System.out.print("아이디 : ");
		String s_ID = s.nextLine();
		
		String s_PASS1, s_PASS2;
		
		while(true)
		{
			/// 보안화 필요
			System.out.print("비밀번호 : ");
			s_PASS1 = s.nextLine();
			System.out.print("비밀번호 확인: ");
			s_PASS2 = s.nextLine();
			
			if(s_PASS1.equals(s_PASS2))
				break;
			else
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
		}
		
		System.out.print("사업자 번호를 입력하세요. : ");
		String temp = s.nextLine();
		int bn = Integer.parseInt(temp);
		setBusinessNumber(bn);
		
		System.out.print("대리점 정보를 입력하세요. : ");
		String minfo = s.nextLine();
		setMarketInfo(minfo);
		
		System.out.print("판매자 정보를 입력하세요. : ");
		String sinfo = s.nextLine();
		setSellerInfo(sinfo);
		
		try {
			// 각 정보마다 NULL을 통해 구분시킴.
			
			FileOutputStream out = new FileOutputStream("SellerInfo");
			
			out.write(s_ID.getBytes());
			out.flush();
			out.write(0x00);
			out.flush();
			
			out.write(s_PASS1.getBytes());
			out.flush();
			out.write(0x00);
			out.flush();
			
			out.write(Integer.toString(bn).getBytes());
			out.flush();
			out.write(0x00);	//NULL. NULL을 통해 내용 구분을 목적으로 입력.
			out.flush();
			
			out.write(minfo.getBytes());
			out.flush();
			out.write(0x00);
			out.flush();
			
			out.write(sinfo.getBytes());
			out.flush();
			out.write(0x00);
			out.flush();
			
			out.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
			
	public int choosemenu(int count, String condition)
	{
		int value;
		Scanner s = new Scanner(System.in);
		
		while(true)
		{
			value=0;

			 System.out.print("Choose Menu ("+condition+") : ");

			
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
	
	public void phoneAdmin()	//기종 입력 admin
	{
		while(true)
		{
			int mode_phone=choosemenu(3,"1: Insert, 2: Modify, Delete, 3: Quit");
			
			if(mode_phone == 1)
			{
				System.out.println("Insert Phone");
				phonelist.insert_Phone();
			}
			else if(mode_phone == 2)
			{
				System.out.println("Modify, Delete Phone");
				phonelist.Modifyanddelete();
			}
			else if(mode_phone == 3)
			{
				try {
					phonelist.WriteFile_PhoneList();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Quit");
				break;
			}
		}
		//sgadgafdgdfs
	}
	
	public void callingplanAdmin()	//요금제 입력 admin
	{
		while(true)
		{
			int mode_callingplan=choosemenu(3,"1: Insert, 2: Modify, Delete, 3: Quit");
	
			if(mode_callingplan == 1)
			{
				System.out.println("Insert CallingPlan");
				callingplanlist.insert_CallingPlan();
			}
			else if(mode_callingplan == 2)
			{
				System.out.println("Modify, Delete CallingPlan");
				callingplanlist.Modifyanddelete();
			}
			else if(mode_callingplan == 3)
			{
				try
				{
					callingplanlist.WriteFile_CallingPlanList();
				}
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Quit");
				break;
			}
		}
	}
	
	public void marketAdmin()
	{
		String s = "SellerInfo";
	    File f = new File(s);

	    if (f.delete()) {
	      System.out.println("Success Delete: " + s);
	    } else {
	      System.err.println("Fail Delete: " + s);
	    }
	    
	    GetFileInfo();

	}

	public int getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(int businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getSellerInfo() {
		return sellerInfo;
	}

	public void setSellerInfo(String sellerInfo) {
		this.sellerInfo = sellerInfo;
	}

	public String getMarketInfo() {
		return marketInfo;
	}

	public void setMarketInfo(String marketInfo) {
		this.marketInfo = marketInfo;
	}		
			
	
}
