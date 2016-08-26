
public class fizzbuzz{
	public static void main(String[] arg){
		for (int i=0;i<100;i++){
			if (i%3 == 0){
				System.out.println(i);
				System.out.println("Fizz");
			}
			if (i%5 == 0){
				System.out.println(i);
				System.out.println("Buzz");
			}
			if (i%3 ==0 && i%5 == 0){
				System.out.println(i);
				System.out.println("FizzBuzz");
			}
		}
	}
}
