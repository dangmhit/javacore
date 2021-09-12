import java.util.Scanner;

public class KySu extends CanBo
{
	/** Nghành đào tạo.*/
	protected String nganhDaoTao;
	
	public KySu()
	{
		super();
		this.nganhDaoTao = "";
	}
	
	@Override
	public void readInfo(Scanner sc)
	{
		System.out.println("Nhap thong tin cho Ky Su");
		super.readInfo(sc);
		
		System.out.print("Nhap nganh dao tao: ");
		this.nganhDaoTao = sc.nextLine();
	}
	
	@Override
	public void printInfo()
	{
		System.out.println("Thong tin cua Ky Su");
		super.printInfo();
		System.out.println("Nganh dao tao:" + this.nganhDaoTao);
	}
}