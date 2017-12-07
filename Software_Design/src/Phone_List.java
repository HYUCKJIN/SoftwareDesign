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
		if (mode == 1)	//�Ǹ��ڿ��� �ҷ� ���� ��.
		{
			boolean check_dir;
		
			check_dir=CheckExistDir("Phone");
				
			if(check_dir)
			{
					ReadFile_PhoneList();
			}
			else	//Phone�̶�� ���� ���� �� ����.
			{
				File dir_phone = new File("Phone");
				if(!dir_phone.mkdirs())
				{
					System.err.println("MKDIR Error");
				}	
			}
				
			
			
			
		}
		else if(mode == 2)	//�����ڿ��Լ� �ҷ� ���� ��. 
		{
			
		}
		else if(mode == 3)	//��õ Ŭ�������� ������� ��.
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
			index = 0; //�����ε�����ȣ
			str = Integer.toString(index) + ".txt"; //���ڿ��� ����ȯ
			
			if(CheckExistFile(str)) //�Ķ���Ϳ� ���� ������ �����ϸ�
			{
				total_phone_list.add(index, inputData_Phone(index)); //������ �о� ��ü �� ����Ʈ�� �߰�
			}
			else
			{
				break; //������ break
			}
			index++; //���� �ε��� ���� �غ�
		}
		*/
	}
	
	public Phone inputData_Phone(int index)//�ε����� �о� PhoneŬ������ ������ ����
	{
		index = 0; //�����ε�����ȣ
		String str = Integer.toString(index); //���ڿ��� ����ȯ
		Phone currentPhone = new Phone();
		
		///////////�����дºκ�/////////////////////////////////////////////////////////////////////
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
		int arraySize = total_phone_list.size(); ///////////�������ºκ�!!!!!!!!!!!!!!!!!!!!
		while(currentPhone != null)
		{
			if(arraySize <= index) //����Ʈ������� ã�� �ε����� ���� Ŀ���� ��
			{
				System.out.println("�˻��� ������ ã���� �����ϴ�.\n");
				break;
			}
			else //������
			{
				currentPhone = total_phone_list.get(index);
			}
			
			if(currentPhone.equalName(thinkPhone)) //�˻��� ������ ���� ���
			{
				thinkPhone.printPhoneINFO(); //���
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
			
		} catch (IOException e) {	//���翩�� Ȯ���ϰ� �ͼ� �� �� ����.
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
