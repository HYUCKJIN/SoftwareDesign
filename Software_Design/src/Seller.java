import java.util.*;
import java.io.*;

public class Seller {
	private String marketInfo;
	private String sellerInfo;
	private int businessNumber;
	
	public Seller()
	{
		//���� ���� ���� Ȯ��.
		if(!CheckExistFile("SellerInfo"))
		{
			GetFileInfo();
		}
		//������ ���ο� ���� �Է�. �� ������ ��� ���.
		
		choosemenu(2,"1: Insert, 2: Modify, Delete");
		
	}
	
	public boolean CheckExistFile(String filename)
	{
		File file = new File(filename);
		
		boolean isExists = file.exists();
		
		return isExists;
	}
	
	public void GetFileInfo()
	{
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("����� ��ȣ�� �Է��ϼ��� : ");
		int bn = s.nextInt();
		setBusinessNumber(bn);
			
		System.out.print("�븮�� ������ �Է��ϼ���. ");
		String minfo = s.nextLine();
		setMarketInfo(minfo);
			
		System.out.print("�Ǹ��� ������ �Է��ϼ���. : ");
		String sinfo = s.nextLine();
		setSellerInfo(sinfo);
		
		try {
			FileOutputStream out = new FileOutputStream("SellerInfo");
			out.write(Integer.toString(bn).getBytes());
			out.flush();
			out.write(0x00);
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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

			 System.out.print("Choose Mode ("+condition+") : ");

			
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
