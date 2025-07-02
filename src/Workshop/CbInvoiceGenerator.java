package Workshop;

import java.util.*;


public class CbInvoiceGenerator{
	double distance;
	double time;
	static final double MINIMUM_FARE = 5.0;
	static final double COST_PER_KM = 10.0;
	static final double COST_PER_MIN = 1.0;
	int[] ride;
	

	 public CbInvoiceGenerator(double distance, double time) {
		 this.distance = distance;
			this.time = time;
		// TODO Auto-generated constructor stub
	}


	
	
	
public int call(){
		
		int fare = (int) Math.max(distance*COST_PER_KM+ time*COST_PER_MIN,5);
		
		return fare;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CbInvoiceGenerator ride  = new CbInvoiceGenerator(10.0,2.0);
		double a=ride.call();
		System.out.println(a);
	
		
		
		
		int agge = 0;
		
		
		
//		int n = 2;
//		for(int i=0;i<n;i++) {
//			System.out.print("Enter Distance (KM) for "+(i+1)+" number of ride : ");
//			int dis = sc.nextInt();
//			System.out.print("Enter Time (in min) for "+ (i+1)+" number of ride : ");
//			int time = sc.nextInt();
//			int total = call(dis,time);
//			System.out.println("Fare of  Ride "+(i+1)+" : "+total);
//			agge += total;
//			
//		}
//		System.out.println("Total no of rides : "+n);
//		System.out.println("Total fare of "+n+" rides is "+agge);
//		System.out.println("Average Fare for each ride is "+agge/n);
//		
//		
		
//		System.out.print("Enter Distance (KM) : ");
//		int dis = sc.nextInt();
//		System.out.print("Enter Time (in min) : ");
//		int time = sc.nextInt();
//		System.out.println(call(dis,time));
		
		
		
		
		
		
	}
	
	
	
}
