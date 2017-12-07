import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Phone_List {
	private ArrayList<Phone> total_phone_list;
	private ArrayList<Phone> output_phone_list;
	private Phone thinkPhone;
	private String Path = "./Phone/";
	
	public Phone_List()
	{
		
	}
	
	public Phone_List(int mode)
	{
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
		else if(mode == 2)	//구매자에게서 불러 왔을 때. 
		{
			
		}
		else if(mode == 3)	//추천 클래스에서 만들었을 때.
		{
			
		}
		else
		{
			
		}
		/*
		int index;
		String str;
		
		while(true)
		{
			index = 0; //파일인덱스번호
			str = Integer.toString(index) + ".txt"; //문자열로 형변환
			
			if(CheckExistFile(str)) //파라미터와 같은 파일이 존재하면
			{
				total_phone_list.add(index, inputData_Phone(index)); //파일을 읽어 전체 폰 리스트에 추가
			}
			else
			{
				break; //없으면 break
			}
			index++; //다음 인덱스 읽을 준비
		}
		*/
	}
	
	public Phone inputData_Phone(int index)//인덱스를 읽어 Phone클래스형 변수로 리턴
	{
		index = 0; //파일인덱스번호
		String str = Integer.toString(index); //문자열로 형변환
		Phone currentPhone = new Phone();
		
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
			currentPhone.setMODEL_NAME(s);
			s = input.readLine();
			currentPhone.setCPU_INFO(s);
			s = input.readLine();
			currentPhone.setDISPLAY(s);
			s = input.readLine();
			currentPhone.setRAM(s);
			s = input.readLine();
			currentPhone.setSTORAGE(s);
			s = input.readLine();
			currentPhone.setPRICE(s);
			s = input.readLine();
			currentPhone.setPERFORMANCE(s);
			input.close();
		}
		catch (IOException e)
		{
			  e.printStackTrace();
		}
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		return currentPhone;
	}
	
	public void Search_Phone(String thinkPhoneName)
	{
		Phone currentPhone = new Phone();
		thinkPhone = new Phone(thinkPhoneName, 1);
		
		int index = 0;
		int arraySize = total_phone_list.size(); ///////////에러나는부분!!!!!!!!!!!!!!!!!!!!
		while(currentPhone != null)
		{
			if(arraySize <= index) //리스트사이즈보다 찾는 인덱스의 값이 커졌을 떄
			{
				System.out.println("검색한 기종을 찾을수 없습니다.\n");
				break;
			}
			else //다음비교
			{
				currentPhone = total_phone_list.get(index);
			}
			
			if(currentPhone.equalName(thinkPhone)) //검색한 기종이 있을 경우
			{
				thinkPhone.printPhoneINFO(); //출력
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
	
	public void ReadFile_PhoneList()
	{
		if(!CheckExistFile(Path + "PhoneIndex"))
		{
			File file = new File(Path + "PhoneIndex");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileInputStream fin = new FileInputStream(Path + "PhoneIndex");
			Reader reader = new InputStreamReader(fin, "euc-kr"); 
			BufferedReader in = new BufferedReader(reader);
			
			char b;
			
			int BUFFER_SIZE = 1000;
			String serialNumber = null;
			String PhoneName = null;
			
			in.mark(BUFFER_SIZE);
			while(in.read() != '\0')
			{
				in.reset();
				while((b = (char) in.read()) != '\0')
				{
					serialNumber += b;
				}
				
				while((b = (char) in.read()) != '\0')
				{
					PhoneName += b;
				}
				in.mark(BUFFER_SIZE);
				
				FileInputStream fin_phone = new FileInputStream(Path + serialNumber);
				Reader reader_phone = new InputStreamReader(fin_phone, "euc-kr"); 
				BufferedReader in_phone = new BufferedReader(reader_phone);
				
				
				
				
				serialNumber = null;
				PhoneName = null;
			
			}
			
			
			
			
			fin.close();
			in.close();
			
		} catch (IOException e) {	//존재여부 확인하고 와서 들어갈 일 없음.
			e.printStackTrace();
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
