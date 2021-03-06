package buyer;
import callingplan.CallingPlan;
import callingplan.CallingPlan_List;
import phone.Phone;
import phone.Phone_List;

public class Recommand {
	private Phone_List Reco_Phone;
	private Phone StandPhone;
	private Phone UserPhone;
	private CallingPlan_List Reco_Calling;
	private CallingPlan StandCalling;
	private CallingPlan UserCalling; 
	private int[] arrPhone;
	private int[] arrScore;
	private int arrindex;
	private int Spec;
	//리스트마다 각요소의 일치함을 비교한뒤 점수로환산하며 5점이 제일근접한 값이고 그이하로 차례로 출력한다.
	
	public Recommand()
	{
		Reco_Phone = new Phone_List();
		StandPhone = new Phone();
		UserPhone = new Phone();
		Reco_Calling = new CallingPlan_List();
		StandCalling = new CallingPlan();
		UserCalling = new CallingPlan();
		arrPhone= new int[30];
		arrScore = new int[30];
	}
	
	//PhoneStand vs PhoneUser	방식
	
	public void Phone_Recommand(String Performance,String MF,String Price,String display,String Storage)
	{
		int i;
		UserPhone.setPERFORMANCE(Performance);
		UserPhone.setPRICE(Price);
		UserPhone.setDISPLAY(display);
		UserPhone.setSTORAGE(Storage);
			//UserPhone.setMANUFACTURE(MF);
		for(i=0;i<Reco_Phone.Get_Total_Phone_List_Size();i++)
		{
			Spec = 0;
			StandPhone = Reco_Phone.Get_SelectPhone(i);
			if(Double.parseDouble(StandPhone.getDISPLAY())==Double.parseDouble(UserPhone.getDISPLAY()))
				Spec++;
			if(Integer.parseInt(StandPhone.getPRICE())==Integer.parseInt(UserPhone.getPRICE()))
				Spec++;
			if(StandPhone.getPERFORMANCE()==UserPhone.getPERFORMANCE())
				Spec++;
			if(Integer.parseInt(StandPhone.getSTORAGE())==Integer.parseInt(UserPhone.getSTORAGE()))
				Spec++;
			if(StandPhone.getMANUFACTURE()==UserPhone.getMANUFACTURE())
				Spec++;
			if(Spec>2)
			{
				//3이상의 제품군을 일단 다저장함.
				arrScore[i]=Spec;
			}
					
		}
		sort(arrScore,5);
		System.out.println("추천해드리겠습니다!");
		for(i=0;i<arrPhone.length;i++) {
			System.out.printf("기존 기종 : 화면크기 > %10s인치\t제품형태 > %10s형\t용량크기 > %4sGB\t가격 > %10s원\t제조사 > %10s\n",UserPhone.getDISPLAY(),UserPhone.getPERFORMANCE(),UserPhone.getSTORAGE(),UserPhone.getPRICE(),"apple");
			System.out.printf("추천 기종 : 화면크기 > %10s인치\t제품형태 > %10s형\t용량크기 > %4sGB\t가격 > %10s원\t제조사 > %10s\n",Reco_Phone.Get_SelectPhone(i).getDISPLAY(),Reco_Phone.Get_SelectPhone(i).getPERFORMANCE(),Reco_Phone.Get_SelectPhone(i).getSTORAGE(),Reco_Phone.Get_SelectPhone(i).getPRICE(),"apple");
			i++;
			if(i==arrPhone.length)
				break;
			System.out.printf("추천 기종 : 화면크기 > %10s인치\t제품형태 > %10s형\t용량크기 > %4sGB\t가격 > %10s원\t제조사 > %10s\n",Reco_Phone.Get_SelectPhone(i).getDISPLAY(),Reco_Phone.Get_SelectPhone(i).getPERFORMANCE(),Reco_Phone.Get_SelectPhone(i).getSTORAGE(),Reco_Phone.Get_SelectPhone(i).getPRICE(),"apple");
		}
			
			
		
		
	}
	public void Calling_Recommand(String CALL,String MESSAGE,String DATA,String PRICE)
	{
		int i;
		UserCalling.setCALL(CALL);
		UserCalling.setDATA(DATA);
		UserCalling.setMESSAGE(MESSAGE);
		UserCalling.setPRICE(PRICE);
		
		for(i=0;i<Reco_Calling.Get_Total_CallingPlan_List_Size();i++)
		{
			Spec = 0;
			StandCalling = Reco_Calling.Get_SelectCallingPlan(i);
			if(Integer.parseInt(StandCalling.getCALL())==Integer.parseInt(UserCalling.getCALL()))
				Spec++;
			if(Integer.parseInt(StandCalling.getPRICE())==Integer.parseInt(UserCalling.getPRICE()))
				Spec++;
			if(Integer.parseInt(StandCalling.getDATA())==Integer.parseInt(UserCalling.getDATA()))
				Spec++;
			if(Integer.parseInt(StandCalling.getMESSAGE())==Integer.parseInt(UserCalling.getMESSAGE()))
				Spec++;
		
			if(Spec>1)
			{
				//2이상의 제품군을 일단 다저장함.
				arrScore[i]=Spec;
			}
					
		}
		sort(arrScore,5);
		System.out.println("추천해드리겠습니다!");
		for(i=0;i<arrPhone.length;i++) {
			System.out.printf("기존 요금제 : 통화량 > %10s분\t문자 > %5s개\t데이터 > %4sGB\t가격 > %10s원\n",UserCalling.getCALL(),UserCalling.getMESSAGE(),UserCalling.getDATA(),UserCalling.getPRICE());
			System.out.printf("추천 요금제 : 통화량 > %10s분\t문자 > %5s개\t데이터 > %4sGB\t가격 > %10s원\n",Reco_Calling.Get_SelectCallingPlan(i).getCALL(),Reco_Calling.Get_SelectCallingPlan(i).getMESSAGE(),Reco_Calling.Get_SelectCallingPlan(i).getDATA(),Reco_Calling.Get_SelectCallingPlan(i).getPRICE());
			i++;
			if(Reco_Phone.Get_SelectPhone(i)==null)
				break;
			System.out.printf("추천 요금제 : 통화량 > %10s분\t문자 > %5s개\t데이터 > %4sGB\t가격 > %10s원\n",Reco_Calling.Get_SelectCallingPlan(i).getCALL(),Reco_Calling.Get_SelectCallingPlan(i).getMESSAGE(),Reco_Calling.Get_SelectCallingPlan(i).getDATA(),Reco_Calling.Get_SelectCallingPlan(i).getPRICE());
			
		}		
	}
	public void sort(int[] arr,int stand)
	{
		int i,j,AB=0;
		for(i=0;i<(stand/4)*3;i++)					//오차확률 15%
		{
			for(j=0;j<arr.length;j++)
			{
				if(stand == arr[i])
				{
					arrPhone[AB]=i;					//score점수가 높은 페이지(index)를 여기다가저장함.
					AB++;
					stand--;
				}
			}
			
		}	
	}
	/*public int[] sort(int[] arr)
	{
		int i,j,temp=0;
		for(i=0;i<arr.length;i++)
			for(j=i+1;j<arr.length;j++)
			{
				if(arr[i]<=arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		for(i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		return arr;
	}*/

	public int getArrindex() {
		return arrindex;
	}

	public void setArrindex(int arrindex) {
		this.arrindex = arrindex;
	}
	
	
	
}
