public class FizzBuzz {
    public static void main(String[] args) {
		String print;
		for(int i = 0; i < 100; i++){
			if(i % 5 == 0 && i % 7 == 0){
				print = "fizzbluzz";
			}
			else if (i % 5 == 0){
				print = "fizz";
			}
			else if (i % 7 == 0){
				print = "buzz";
			}
			else{
				print = Integer.toString(i);
			}
			System.out.println(print);
		}
    }
}