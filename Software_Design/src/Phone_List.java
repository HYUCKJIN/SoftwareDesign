import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Phone_List {
	private ArrayList<Phone> total_phone_list;
	private ArrayList<Phone> output_phone_list;
	private Phone thinkPhone;
	
	
	public Phone_List() throws IOException
	{
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
	}
	
	public Phone inputData_Phone(int index) throws IOException //인덱스를 읽어 Phone클래스형 변수로 리턴
	{
		index = 0; //파일인덱스번호
		String str = Integer.toString(index) + ".txt"; //문자열로 형변환
		Phone currentPhone = new Phone();
		
		///////////파일읽는부분/////////////////////////////////////////////////////////////////////
		File file = new File(str);
		BufferedReader input = new BufferedReader(new FileReader(file)); 
		
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
		/////////////////////////////////////////////////////////////////////////////////////////
		
		return currentPhone;
	}
	
	public void Search_Phone(String thinkPhoneName)
	{
		Phone currentPhone = new Phone();
		thinkPhone = new Phone(thinkPhoneName, 1);
		
		int index = 0;
		int arraySize = total_phone_list.size();
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
