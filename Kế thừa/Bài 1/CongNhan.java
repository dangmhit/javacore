import java.util.Scanner;

public class CongNhan extends CanBo
{
	/** Bậc (1 đến 10).*/
	protected int bac;
	
	public CongNhan()
	{
		super();
		this.bac = -1;
	}
	
	@Override
	public void readInfo(Scanner sc)
	{
		System.out.println("Nhap thong tin cho Cong Nhan");
		super.readInfo(sc);
		
		do
		{
			System.out.print("Nhap cap bac (1 đến 10): ");
			this.bac = Util.readInt(sc);
		}
		while (this.bac < 1 || this.bac > 10);
	}
	
	@Override
	public void printInfo()
	{
		System.out.println("Thong tin cua Cong Nhan");
		super.printInfo();
		System.out.println("Cap bac    : " + this.bac);
	}
}