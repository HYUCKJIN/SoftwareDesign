package phone;

public class Phone {
	
	private String MODEL_NAME;	//index 1
	private String CPU_INFO;	//index 2
	private String DISPLAY;		//index 3
	private String RAM;			//index 4
	private String STORAGE;		//index 5
	private String PRICE;		//index 6
	private String PERFORMANCE;	//index 7
	private String MANUFACTURE; //index 8
	
	public Phone()
	{
		
	}
	
	public Phone(String Value, int index) //index값으로 Value의 정보를 판단
	{
		if(index == 1) setMODEL_NAME(Value);
		else if(index == 2) setCPU_INFO(Value);
		else if(index == 3) setDISPLAY(Value);
		else if(index == 4) setRAM(Value);
		else if(index == 5) setSTORAGE(Value);
		else if(index == 6) setPRICE(Value);
		else if(index == 7) setPERFORMANCE(Value);
		else if(index == 8) setMANUFACTURE(Value);
		else setMODEL_NAME(null);
	}
	
	public Phone(String MODEL_NAME, String CPU_INFO, String DISPLAY, String RAM, String STORAGE, String PRICE, String PERFORMENCE, String MANUFACTURE)
	{
		setMODEL_NAME(MODEL_NAME);
		setCPU_INFO(CPU_INFO);
		setDISPLAY(DISPLAY);
		setRAM(RAM);
		setSTORAGE(STORAGE);
		setPRICE(PRICE);
		setPERFORMANCE(PERFORMENCE);
		setMANUFACTURE(MANUFACTURE);
	}
	
	public void printPhoneINFO()
	{
		System.out.printf("이름:		" + MODEL_NAME + "\n");
		System.out.printf("CPU:		" + CPU_INFO + "\n");
		System.out.printf("화면크기:		" + DISPLAY + "\n");
		System.out.printf("램:		" + RAM + "\n");
		System.out.printf("저장용량:		" + STORAGE + "\n");
		System.out.printf("가격:		" + PRICE + "\n");
		System.out.printf("성능:		" + PERFORMANCE + "\n");
		System.out.printf("제조사:		" + MANUFACTURE + "\n");
	}
	
	public boolean equal(Phone currentPhone) //상세비교
	{
		String str = null;
		if((str = currentPhone.getMODEL_NAME()) != MODEL_NAME)
			return false;
		else if((str = currentPhone.getCPU_INFO()) != CPU_INFO)
			return false;
		else if((str = currentPhone.getDISPLAY()) != DISPLAY)
			return false;
		else if((str = currentPhone.getRAM()) != RAM)
			return false;
		else if((str = currentPhone.getSTORAGE()) != STORAGE)
			return false;
		else if((str = currentPhone.getPRICE()) != PRICE)
			return false;
		else if((str = currentPhone.getPERFORMANCE()) != PERFORMANCE)
			return false;
		else if((str = currentPhone.getMANUFACTURE()) != MANUFACTURE)
			return false;
		return true;
	}
	
	public boolean equalName(Phone currentPhone) //이름비교
	{
		String str = null;
		if((str = currentPhone.getMODEL_NAME()) != MODEL_NAME)
			return false;
		return true;
	}
	
	public String getMODEL_NAME() {
		return MODEL_NAME;
	}

	public void setMODEL_NAME(String mODEL_NAME) {
		MODEL_NAME = mODEL_NAME;
	}

	public String getCPU_INFO() {
		return CPU_INFO;
	}

	public void setCPU_INFO(String cPU_INFO) {
		CPU_INFO = cPU_INFO;
	}

	public String getDISPLAY() {
		return DISPLAY;
	}

	public void setDISPLAY(String dISPLAY) {
		DISPLAY = dISPLAY;
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}

	public String getSTORAGE() {
		return STORAGE;
	}

	public void setSTORAGE(String sTORAGE) {
		STORAGE = sTORAGE;
	}

	public String getPRICE() {
		return PRICE;
	}

	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

	public String getPERFORMANCE() {
		return PERFORMANCE;
	}

	public void setPERFORMANCE(String pERFORMANCE) {
		PERFORMANCE = pERFORMANCE;
	}

	public String getMANUFACTURE() {
		return MANUFACTURE;
	}

	public void setMANUFACTURE(String mANUFACTURE) {
		MANUFACTURE = mANUFACTURE;
	}
}
