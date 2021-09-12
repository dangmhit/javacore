import java.util.Scanner;

public class Util 
{
	public static int readInt(Scanner sc)
	{
		while (true)
		{
			try
			{
				int i = sc.nextInt();
				return i;
			}
			catch(java.util.InputMismatchException x)
			{
				System.out.print("Ban hay nhap so: ");
			}
			finally
			{
				sc.nextLine(); // Remove 'Enter'
			}
		}
	}
}