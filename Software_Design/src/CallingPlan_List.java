import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class CallingPlan_List {
	private ArrayList<CallingPlan> total_CallingPlan_list;
	private ArrayList<CallingPlan> output_CallingPlan_list;
	private CallingPlan thinkCallingPlan;
	private String Path = "./CallingPlan/";
	
	public CallingPlan_List()
	{
		
	}
	
	public CallingPlan_List(int mode)
	{
		total_CallingPlan_list = new ArrayList<CallingPlan>();
		
		if (mode == 1)	//판매자에서 불러 왔을 때.
		{
			boolean check_dir;
		
			check_dir=CheckExistDir("CallingPlan");
			
			if(check_dir)
			{
				ReadFile_CallingPlanList();
			}
			else	//CallingPlan이라는 폴더 없을 때 생성.
			{
				File dir_phone = new File("CallingPlan");
				if(!dir_phone.mkdirs())
				{
					System.err.println("MKDIR Error");
				}	
			}
		}
		else if(mode == 2)	//구매자에게서 불러 왔을 때. 
		{
			ReadFile_CallingPlanList();
		}
		else if(mode == 3)	//추천 클래스에서 만들었을 때.
		{
			
		}
		else
		{
			
		}
	}
	
	public CallingPlan inputData_CallingPlan(String str)//인덱스를 읽어 Phone클래스형 변수로 리턴
	{
		CallingPlan currentCallingPlan = new CallingPlan();
		
		///////////파일읽는부분/////////////////////////////////////////////////////////////////////
		File file = new File(str);
		FileReader fr;
		BufferedReader input; 
		try
		{
			fr = new FileReader(file);
			input = new BufferedReader(fr);
			String s = null;
			s = input.readLine();
			currentCallingPlan.setPAY_NAME(s);
			s = input.readLine();
			currentCallingPlan.setMESSAGE(s);
			s = input.readLine();
			currentCallingPlan.setCALL(s);
			s = input.readLine();
			currentCallingPlan.setDATA(s);
			s = input.readLine();
			currentCallingPlan.setPRICE(s);
			input.close();
		}
		catch (IOException e)
		{
			  e.printStackTrace();
		}
		/////////////////////////////////////////////////////////////////////////////////////////
		
		return currentCallingPlan;
	}
	
	public void Search_Phone(String thinkCallingPlanName)
	{
		CallingPlan currentCallingPlan = new CallingPlan();
		thinkCallingPlan = new CallingPlan(thinkCallingPlanName, 1);
		
		int index = 0;
		int arraySize = total_CallingPlan_list.size(); ///////////에러나는부분!!!!!!!!!!!!!!!!!!!!
		while(currentCallingPlan != null)
		{
			if(arraySize <= index) //리스트사이즈보다 찾는 인덱스의 값이 커졌을 떄
			{
				System.out.println("검색한 요금제를 찾을수 없습니다.\n");
				break;
			}
			else //다음비교
			{
				currentCallingPlan= total_CallingPlan_list.get(index);
			}
			
			if(currentCallingPlan.equalName(thinkCallingPlan)) //검색한 기종이 있을 경우
			{
				thinkCallingPlan.printCallingPlanINFO(); //출력
				break;
			}
			index++;
		}
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
	public void insert_CallingPlan(String File)
	{
		Scanner s;
		s = new Scanner(System.in);
		
		String PAY_NAME;	//index 1
		System.out.print("PAY_NAME : ");
		PAY_NAME = s.nextLine();
		String MESSAGE;	//index 2
		System.out.print("MESSAGE : ");
		MESSAGE = s.nextLine();
		String CALL;		//index 3
		System.out.print("CALL : ");
		CALL = s.nextLine();
		String DATA;			//index 4
		System.out.print("DATA : ");
		DATA = s.nextLine();
		String PRICE;		//index 5
		System.out.print("PRICE : ");
		PRICE = s.nextLine();
		
		try {
			// 각 정보마다 NULL을 통해 구분시킴.
			
			FileOutputStream out = new FileOutputStream(Path+File);
			
			out.write(PAY_NAME.getBytes());
			out.flush();
			out.write('\n');
			out.flush();
			
			out.write(MESSAGE.getBytes());
			out.flush();
			out.write('\n');
			out.flush();
			
			out.write(CALL.getBytes());
			out.flush();
			out.write('\n');
			out.flush();
			
			out.write(DATA.getBytes());
			out.flush();
			out.write('\n');
			out.flush();
			
			out.write(PRICE.getBytes());
			out.flush();
			out.write('\n');
			out.flush();
			
			out.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void ReadFile_CallingPlanList()
	{
		if(!CheckExistFile(Path + "CallingPlanIndex"))
		{
			File file = new File(Path + "CallingPlanIndex");
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
			FileInputStream fin = new FileInputStream(Path + "CallingPlanIndex");
			Reader reader = new InputStreamReader(fin, "euc-kr"); 
			BufferedReader in = new BufferedReader(reader);
			
			char b;
			int chc;
			
			int BUFFER_SIZE = 1000;
			String serialNumber = null;
			String CallingPlanName = null;
			
			in.mark(BUFFER_SIZE);
			while((chc = in.read() )!= -1)
			{

				in.reset();
				while((b = (char) in.read()) != '\0')
				{
					serialNumber += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					CallingPlanName += b;
				}
				in.mark(BUFFER_SIZE);
				
				if(serialNumber == null)
				{
					break;
				}
				
				total_CallingPlan_list.add(inputData_CallingPlan(Path+serialNumber));
				
				serialNumber = null;
				CallingPlanName = null;
			}
			
			fin.close();
			in.close();
			
		} catch (IOException e) {	//존재여부 확인하고 와서 들어갈 일 없음.
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<CallingPlan> getTotal_CallingPlan_list() {
		return total_CallingPlan_list;
	}

	public void setTotal_CallingPlan_list(ArrayList<CallingPlan> total_CallingPlan_list) {
		this.total_CallingPlan_list = total_CallingPlan_list;
	}

	public ArrayList<CallingPlan> getOutput_CallingPlan_list() {
		return output_CallingPlan_list;
	}

	public void setOutput_CallingPlan_list(ArrayList<CallingPlan> output_CallingPlan_list) {
		this.output_CallingPlan_list = output_CallingPlan_list;
	}

	public CallingPlan getThinkCallingPlan() {
		return thinkCallingPlan;
	}

	public void setThinkCallingPlan(CallingPlan thinkCallingPlan) {
		this.thinkCallingPlan = thinkCallingPlan;
	}
	
}
