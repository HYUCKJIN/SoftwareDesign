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
	}
	
	public Phone inputData_Phone(int index) throws IOException //�ε����� �о� PhoneŬ������ ������ ����
	{
		index = 0; //�����ε�����ȣ
		String str = Integer.toString(index) + ".txt"; //���ڿ��� ����ȯ
		Phone currentPhone = new Phone();
		
		///////////�����дºκ�/////////////////////////////////////////////////////////////////////
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
