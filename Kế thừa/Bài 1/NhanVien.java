import java.util.Scanner;

public class NhanVien extends CanBo
{
	/** công việc..*/
	protected String congViec;
	
	public NhanVien()
	{
		super();
		this.congViec = "";
	}
	
	@Override
	public void readInfo(Scanner sc)
	{
		System.out.println("Nhap thong tin cho Nhan Vien");
		super.readInfo(sc);
		
		System.out.print("Nhap cong viec: ");
		this.congViec = sc.nextLine();
	}
	
	@Override
	public void printInfo()
	{
		System.out.println("Thong tin cua Nhan Vien");
		super.printInfo();
		System.out.println("Cong viec  : " + this.congViec);
	}
}