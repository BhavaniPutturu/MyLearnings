package week1.day2;

public class PrintOddNumbers {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
		{
			if(i%2 == 1)
				System.out.println(i);
		}
		PrintOddNumbers prn = new PrintOddNumbers();
		prn.add(2,4);
	}
	
	public void add(int a, int b)
	{
		add1(a,b);
	}
	public void add1(int a, int b)
	{
		System.out.println(a+b);
	}
	

}
