package Workshop;

	 class cat{
		 String color = "yellow";
		static String breed;
		
		void displaycolor(String color){
			System.out.println(color);
			this.color = color;
			System.out.println(this.color);
			
		}
		void displayBreed(String breed) {
			
			System.out.println(breed);
		}
	}


class practicestring{
	public static void main(String args[]) {
		cat mycat = new cat();
//		mydog.color = "red";
//		mydog.breed = "meow";
		
		mycat.displaycolor("red");
		mycat.displayBreed("meow");
//		String s ="abc";
//		s = "abcd";
//		int hash= s.hashCode();
//		System.out.println(s);
//		System.out.println(hash);
		
	}
}