import java.util.*;
import java.awt.*;
import java.net.*;

//this class will create the basic functionalities of cellphone
class Cellphone{
	protected int display;
	protected String operatingSystem;
	protected String batteryCapacity;
	protected int internalStorage;
	protected String connectivity;
	protected int RAM;
	protected String modelName;
	protected String phoneType;
	protected int simSlot;
	protected String batteryType;
	
	Scanner scan=new Scanner(System.in);
	
	void doMessage(){
		if(simSlot==2){
		System.out.print("\n 1.Sim1  2.sim2  Choose sim:" );
		int simChoice=scan.nextInt();}
		System.out.print("\n Enter number:");
		long mobileNumber=scan.nextLong();		
		System.out.print("\n Enter message here->");
		String message=scan.next();
		System.out.println("\n Sending message...");
		System.out.println(" Message sent!");
		
	}
	
	void doCall(){
		if(simSlot==2){
		System.out.print("\n 1.Sim1  2.sim2  choose sim:");
		int simChoice=scan.nextInt();
		}
		System.out.print("\n Dial number:");
		long mobileNumber=scan.nextLong();
		System.out.println(" Dialing...");
		System.out.println(" Connected!");
	}

	void doCalculate(){
		String choiceContinue="";
		do{
		System.out.print("\n 1.Addition  2.Substraction  3.multiplication  4.Division  ::");
		int choiceInput=scan.nextInt();
		System.out.print("\n Enter numbers:");
		int numberOne=scan.nextInt();
		int numberTwo=scan.nextInt();
		switch(choiceInput){
			case 1:System.out.print(" Addition result: "+(numberOne+numberTwo));
			break;
			case 2:System.out.print(" Substraction result: "+(numberOne-numberTwo));
			break;
			case 3:System.out.print(" Multiplication result: "+(numberOne*numberTwo));
			break;
			case 4:System.out.print(" Division result: "+(numberOne/numberTwo));
			break;
			default:System.out.print(" Invalid option!");
			break;
		}System.out.print("\n\n continue with calculator?");
	         choiceContinue=scan.next();
		 
		}while(choiceContinue.equals("yes"));
	}
	
	void showFeatures(int display,String operatingSystem, String batteryCapacity,int internalStorage,String connectivity,int RAM,
					String modelName,String phoneType,int simSlot,String batteryType){
						this.simSlot=simSlot;
						this.connectivity=connectivity;
						this.batteryCapacity=batteryCapacity;
						this.batteryType=batteryType;
						this.display=display;
						this.phoneType=phoneType;
						this.RAM=RAM;
						this.modelName=modelName;
						this.internalStorage=internalStorage;
						this.operatingSystem=operatingSystem;
						
	System.out.print("\n 1.display::"+display+"inch  \n 2.operatingSystem::"+operatingSystem+"  \n 3.batteryCapacity:: "+batteryCapacity);
	System.out.print("\n 4.internalStorage::"+internalStorage+"GB  \n 5.connectivity::"+connectivity+"  \n 6.RAM::"+RAM+"GB \n 7.modelName:: "+modelName);
	System.out.print("\n 8.phoneType::"+phoneType+"  \n 9.simSlot::"+simSlot+"  \n 10.batteryType::"+batteryType);

	
}}


class Samsung extends Cellphone{
	
	private int samsungPayBalance=0;
	String inputChoiceSamsungPay="";
	Scanner scan=new Scanner(System.in);
	void samsungPay(){
		
		
		do{
		System.out.print("\n samsungPay options:: 1.Add money  2.Transfer  3.Balance");
		System.out.print("\n Select one operation:");
		int samsungPayChoice=scan.nextInt();
		switch(samsungPayChoice){

		case 1:addMoney();
		break;
		case 2:sendMoney();
		break;
		case 3:showBalance();
		break;
	}System.out.print("\n Conitune with samsung pay::");
	 inputChoiceSamsungPay=scan.next();
	}while(inputChoiceSamsungPay.equals("yes"));
}
	void addMoney(){
		System.out.print("\n Enter account number to add money in samsungPay:");
		long accountNumber=scan.nextLong();
		System.out.print("\n Enter amount to add in samsungPay:");
		int amount=scan.nextInt();
		samsungPayBalance=samsungPayBalance+amount;
	}
	
	void sendMoney(){
		System.out.print("\n Enter amount to transfer money:");
		int amount=scan.nextInt();
		if(amount<=samsungPayBalance){
		System.out.print("\n\n Enter account number to transfer money:");
		long accountNumber=scan.nextLong();
		System.out.print("\n Money transfered..");
		samsungPayBalance=samsungPayBalance-amount;
		}
		else{
		System.out.print("\n Insufficient balance..");
		}
		
		
	}
	
	void showBalance(){
		System.out.print("\n\n Available balance in samsungPay:"+samsungPayBalance);
	}
	

}

class Iphone extends Cellphone{
	Scanner scan=new Scanner(System.in);
	
	void callSiri(){
		System.out.print("\n How can I help you:");
		String inputRequest=scan.next();
		try {
			  //URI is used to request the given url
			  Desktop desktop = Desktop.getDesktop();
			  URI objectURL = new URI(inputRequest);
			  desktop.browse(objectURL);
			} catch (Exception e) {
			  System.out.print("\n Getting some problem::"+e);
	}}
}
		
	
class CellphoneHandler{
public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	
	
	String inputChoiceFeatures="";
	
	do{
	System.out.print("\n Available brands: 1.Samsung  2.Iphone");
	System.out.print("\n your choice of brand:");
	int brandChoice=scan.nextInt();
	switch(brandChoice){
		case 1: Samsung samsungObject=new Samsung();
				System.out.println("\n Samsung features...");
				samsungObject.showFeatures(5,"Android","3000MaH",32,"3G",4,"Samsung note 4","smartphone",2,"Non removable");
				System.out.println("\n\n Samsung functions...");
				System.out.print("\n 1.Samsung pay  2.Call  3.Message  4.Calculator  Try any::");
				int samsungChoice=scan.nextInt();
				
				switch(samsungChoice){
					case 1:samsungObject.samsungPay();
					break;
					case 2:samsungObject.doCall();
					break;
					case 3:samsungObject.doMessage();
					break;
					case 4:samsungObject.doCalculate();
					break;


				}break;



				
		case 2: Iphone iphoneObject=new Iphone();
				System.out.print("\n Iphone features...");
				iphoneObject.showFeatures(5,"IOS","5000MaH",64,"4G",4,"Iphone 6S","smartphone",1,"Non removable");
				System.out.print("\n\n  Iphone functions...");
				System.out.print("\n  1.Siri intelligent assistant  2.Call  3.Message  4.Calculator  Try any::");
				int iphoneChoice=scan.nextInt();
				
				switch(iphoneChoice){
					case 1:iphoneObject.callSiri();
					break;
					case 2:iphoneObject.doCall();
					break;
					case 3:iphoneObject.doMessage();
					break;
					case 4:iphoneObject.doCalculate();
					break;
				}break;
				
		default:System.out.print("Invalid option");
		break;
		}
		System.out.print("\n Want to see another brand::");
		inputChoiceFeatures=scan.next();
	}while(inputChoiceFeatures.equals("yes"));	
}}		

	
	
	
	
	
	
	
	
	
	
