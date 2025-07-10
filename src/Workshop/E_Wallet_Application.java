package Workshop;
import java.util.*;

public class E_Wallet_Application{
	static List<String> transactionHistory = new ArrayList<>();
	static HashMap<Integer,Integer> map = new HashMap<>();
	static HashMap<String,Integer> map2 = new HashMap<>();
	static HashMap<Integer,Integer> map3 = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String args[]) {
		
			System.out.println();
			System.out.println();
			
			System.out.println("Welcome to E-Wallet Application  :)");
			while(true) {
		System.out.println("==============================================");
		System.out.println(" \n Please Select A Operation");
		System.out.println("1.Register Me");
		System.out.println("2.Load Money");
		System.out.println("3.Transfer Funds");
		System.out.println("4.View Transection History");
		System.out.println("5.Exit me");
		System.out.println("\n=============================================");
		System.out.println();
		int choice = sc.nextInt();
		
//			System.out.println("Enter your choice again : ");
//			choice = sc.nextInt();
		if(choice == 5) {
			System.out.println("exiting");
			return;
		}
		switch(choice) {
		
		case 1 :
			System.out.println();
			regUser();
		
			break;
		case 2:
			System.out.println();
			LoadMoney();
			
			break;
		case 3 :
			System.out.println();
			Transaction();
			
			break;
		case 4 :
			System.out.println();
			TransactionHistory();
			break;
		
		default :
			System.out.println("Invalid Choice");
			
		}
		
	}
	}
	
	//static class fns{
		 
		private static void regUser() {
			
			System.out.print("Enter your name : ");
			String name = sc.next();
			System.out.print("Account No : ");
			int accno = sc.nextInt();
			System.out.print("Amount in your account : ");
			int amount = sc.nextInt();
			map.put(accno,amount);
			map2.put(name,amount);
			System.out.println("\nAccount Registered...");
					
			
		}
		

		private static void LoadMoney() {
			System.out.print("Enter Acc no. to See Amount in Your Account : ");
			//String showof = sc.nextLine();
			System.out.println();
			int input = sc.nextInt();
			System.out.println();
			System.out.println();
			if(map.containsKey(input)) {
				System.out.println("Your Account Balance is : "+map.get(input));
			}
			else {
				System.out.println("Account not found");
			}
			
			
			System.out.println();
		}
		
		
		public static void Transaction() {
		    System.out.println("Enter Sender's Account No.");
		    int senderacc = sc.nextInt();
		    if (!map.containsKey(senderacc)) {
		        System.out.println("Sender's account not found.");
		        return;
		    }
		    System.out.println("Enter Account No. of Receiver : ");
		    int receiveracc = sc.nextInt();
		    System.out.print("What Amount You want to Transfer : ");
		    int amountsent = sc.nextInt();
		    int senderBalance = map.get(senderacc);
		    if (amountsent > senderBalance) {
		        System.out.println("Insufficient Balance!");
		        return;
		    }
		    int receiverBalance = map.get(receiveracc);
		    senderBalance -= amountsent;
		    receiverBalance += amountsent;
		    map.put(senderacc, senderBalance);
		    map.put(receiveracc, receiverBalance);
		    System.out.println("Deducting money...");
		    System.out.println("Sending Money...");
		    System.out.println(" Done!");
		    System.out.println("Balance left in Sender's Account : ₹" + senderBalance);
		    String record = "Sender: " + senderacc + " | Receiver: " + receiveracc + " | Amount: ₹" + amountsent;
		    transactionHistory.add(record);
		}
		
		public static void TransactionHistory() {
		    System.out.println("=-=-=-=-=-=-= TRANSACTION HISTORY =-=-=-=-=-=-=-=");
		    if (transactionHistory.isEmpty()) {
		        System.out.println("No transactions yet.");
		    } else {
		        for (String record : transactionHistory) {
		            System.out.println(record);
		        }
		    }
		}
		
		
		
		

	
	
}