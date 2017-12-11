package phone;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class Phone_List {
	private ArrayList<Phone> total_phone_list;
	private ArrayList<Phone> output_phone_list;
	private Phone thinkPhone;
	private String Path = "./Phone/";
	private String FILENAME ="PHONEINFO";
	
	public Phone_List()
	{
		
	}
	
	public Phone_List(int mode)
	{
		total_phone_list = new ArrayList<Phone>();
		
		if (mode == 1)	//판매자에서 불러 왔을 때.
		{
			boolean check_dir;
		
			check_dir=CheckExistDir("Phone");
			
			if(check_dir)
			{
				ReadFile_PhoneList();
			}
			else	//Phone이라는 폴더 없을 때 생성.
			{
				File dir_phone = new File("Phone");
				if(!dir_phone.mkdirs())
				{
					System.err.println("MKDIR Error");
				}	
			}
		}
		else if(mode == 2)	//구매자에게서 불러 왔을 때. and 추천에서 불러 왔을 때.
		{
			boolean check_dir;
			
			check_dir=CheckExistDir("Phone");
			
			if(check_dir)
			{
				ReadFile_PhoneList();
			}
			else
			{
				File dir_phone = new File("Phone");
				if(!dir_phone.mkdirs())
				{
					System.err.println("MKDIR Error");
				}	
			}
		}
		else
		{
			
		}
	}
	
	public int Get_Total_Phone_List_Size() //기종 목록 사이즈 리턴
	{
		return total_phone_list.size();
	}
	
	public Phone Get_SelectPhone(int num) //기종 목록 항목중 하나 선택해서 리턴
	{
		Phone tempP = total_phone_list.get(num);
		return tempP;
	}
	
	public boolean CheckExistFile(String filename)
	{
		File file = new File(filename);
		
		boolean isExists = file.exists();
		
		return isExists;
	}
	
	public boolean CheckExistDir(String dirname)

	{
		File dir = new File(dirname);
		
		boolean isExists = dir.isDirectory();
		
		return isExists;
	}

	public void insert_Phone()
	{
		Scanner s;
		s = new Scanner(System.in);
		
		String MODEL_NAME;	//index 1
		System.out.print("MODEL_NAME : ");
		MODEL_NAME = s.nextLine();
		String CPU_INFO;	//index 2
		System.out.print("CPU_INFO : ");
		CPU_INFO = s.nextLine();
		String DISPLAY;		//index 3
		System.out.print("DISPLAY : ");
		DISPLAY = s.nextLine();
		String RAM;			//index 4
		System.out.print("RAM : ");
		RAM = s.nextLine();
		String STORAGE;		//index 5
		System.out.print("STORAGE : ");
		STORAGE = s.nextLine();
		String PRICE;		//index 6
		System.out.print("PRICE : ");
		PRICE = s.nextLine();
		String PERFORMENCE;	//index 7
		System.out.print("PERFORMANCE : ");
		PERFORMENCE = s.nextLine();
		String MANUFACTURE;	//index 8
		System.out.print("MANUFACTURE : ");
		MANUFACTURE = s.nextLine();
		
		Phone temp = new Phone(MODEL_NAME, CPU_INFO, DISPLAY, RAM, STORAGE, PRICE, PERFORMENCE, MANUFACTURE);
		total_phone_list.add(temp);		
	}
	public void WriteFile_PhoneList() throws IOException
	{
		FileOutputStream out;
		try {
			out = new FileOutputStream(Path + FILENAME);
			
			for(int i=0;i<total_phone_list.size();i++)
			{
				Phone temp = total_phone_list.get(i);
				
				out.write(temp.getMODEL_NAME().getBytes());
				out.flush();
				out.write(0x00);
				out.flush();
				
				out.write(temp.getCPU_INFO().getBytes());
				out.flush();
				out.write(0x00);
				out.flush();
				
				out.write(temp.getDISPLAY().getBytes());
				out.flush();
				out.write(0x00);	//NULL. NULL을 통해 내용 구분을 목적으로 입력.
				out.flush();
				
				out.write(temp.getRAM().getBytes());
				out.flush();
				out.write(0x00);
				out.flush();
				
				out.write(temp.getSTORAGE().getBytes());
				out.flush();
				out.write(0x00);
				out.flush();
				
				out.write(temp.getPRICE().getBytes());
				out.flush();
				out.write(0x00);
				out.flush();
				
				out.write(temp.getPERFORMANCE().getBytes());
				out.flush();
				out.write(0x00);
				out.flush();
				
				out.write(temp.getMANUFACTURE().getBytes());
				out.flush();
				out.write(0x00);
				out.flush();
				
				char c = 10;
				out.write(c);
				out.flush();
					
					
			
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void ReadFile_PhoneList()
	{
		String MODEL_NAME="";	//index 1
	
		String CPU_INFO="";		//index 2
	
		String DISPLAY="";		//index 3
	
		String RAM="";			//index 4
	
		String STORAGE="";		//index 5
		
		String PRICE="";		//index 6
	
		String PERFORMENCE="";	//index 7
	
		String MANUFACTURE="";	//index 8
		
		
		if(!CheckExistFile(Path + FILENAME))
		{
			File file = new File(Path + FILENAME);
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		try
		{
			FileInputStream fin = new FileInputStream(Path + FILENAME);
			Reader reader = new InputStreamReader(fin, "euc-kr"); 
			BufferedReader in = new BufferedReader(reader);
			Scanner s= new Scanner(System.in);
			
			char b;
			String line="";
			
			int BUFFER_SIZE = 1000;
			
			in.mark(BUFFER_SIZE);
			while((line=in.readLine()) != null)
			{
				//System.out.print(line);
				in.reset();
				
				while((b = (char) in.read()) != '\0')
				{
					//System.out.print(b);
					MODEL_NAME += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					CPU_INFO += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					DISPLAY += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					RAM += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					STORAGE += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					PRICE += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					PERFORMENCE += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					MANUFACTURE += b;
				}
				
				
				
				if((b = (char) in.read()) != 10)
				{
					System.out.println("Error");
				}
				in.mark(BUFFER_SIZE);
				Phone temp = new Phone(MODEL_NAME, CPU_INFO, DISPLAY, RAM, STORAGE, PRICE, PERFORMENCE, MANUFACTURE);
				total_phone_list.add(temp);	
				
				MODEL_NAME="";	//index 1
				
				CPU_INFO="";	//index 2
			
				DISPLAY="";		//index 3
			
				RAM="";			//index 4
			
				STORAGE="";		//index 5
				
				PRICE="";		//index 6
			
				PERFORMENCE="";	//index 7
			
				MANUFACTURE="";	//index 8
				
			}
			
			fin.close();
			in.close();
			
		} catch (IOException e) {	//존재여부 확인하고 와서 들어갈 일 없음.
			e.printStackTrace();
		}
		
	}
	
	public void Modifyanddelete()
	{
		for(int i=0;i<total_phone_list.size();i++)
		{
			System.out.println(i+". "+total_phone_list.get(i).getMODEL_NAME());
		}
		
		int value=0;
		boolean flag=true;
		while(flag)
		{
			value=0;

			 System.out.print("Choose Delete or Modify Phone Number : ");

			 Scanner s = new Scanner(System.in);
			 value = s.nextInt();
			 
			 for(int i =0;i<total_phone_list.size();i++)
			 {
				 if(value == i)
				 {
					 flag=false;
					 break;
				 }
			 } 
		}
		
		int tem;

		while(true)
		{
			tem=0;

			 System.out.print("Choose 1: Modify 2: Delete : ");

			 Scanner s = new Scanner(System.in);
			 tem = s.nextInt();
			 
			if(tem == 1)
			{
				total_phone_list.remove(value);
				insert_Phone();
				break;
			}
			else if(tem == 2)
			{
				total_phone_list.remove(value);
				break;
			}
			else
			{
				System.out.println("Wrong Number");
			}
		}
	}
	
	public ArrayList<Phone> getTotal_phone_list() {
		return total_phone_list;
	}

	public void setTotal_phone_list(ArrayList<Phone> total_phone_list) {
		this.total_phone_list = total_phone_list;
	}

	public ArrayList<Phone> getOutput_phone_list() {
		return output_phone_list;
	}

	public void setOutput_phone_list(ArrayList<Phone> output_phone_list) {
		this.output_phone_list = output_phone_list;
	}

	public Phone getThinkPhone() {
		return thinkPhone;
	}

	public void setThinkPhone(Phone thinkPhone) {
		this.thinkPhone = thinkPhone;
	}
}
