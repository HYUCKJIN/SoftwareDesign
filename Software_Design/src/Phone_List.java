import java.io.File;
import java.util.ArrayList;

public class Phone_List {
	private ArrayList<Phone> total_phone_list;
	private ArrayList<Phone> output_phone_list;
	private Phone thinkPhone;
	
	
	public Phone_List()
	{
		if(CheckExistFile("PhoneList"))
		{
			
		}
		else
		{
			total_phone_list=null;
		}
	}
	
	public boolean CheckExistFile(String filename)
	{
		File file = new File(filename);
		
		boolean isExists = file.exists();
		
		return isExists;
	}

}
