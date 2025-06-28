package Workshop;

import java.util.*;

public class countfrequency{
	public static void main(String[] args) {
        String n = "ABCDABCC";
        int[] freq = new int[256]; 
        

           for (char c : n.toCharArray()) {
            freq[c]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + ": " + freq[i]);
            }
        }
    }
    
	
	
	}


//for(int j = i+1; j<n.length();j++){
//
//
//if(n.charAt(i) == n.charAt(j)) {
//	count ++;
//}
//
//}



//for(int i=0;i<n.length()/2;i++) 
//
//{
//System.out.println(n.charAt(i));
//for(int j=i+1;j<n.length();j++) 
//{
//	
//	if(n.charAt(i) == n.charAt(j)) 
//	{
//		freq[i]++;
//	}				
//	
//}
//
//System.out.println(n.charAt(i)+":"+freq[i]);
//count =0; // 
//}