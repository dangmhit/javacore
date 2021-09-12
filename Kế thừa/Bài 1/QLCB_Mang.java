import java.util.Scanner;

/**
 * Sử dụng mảng để lưu trữ danh sách cán bộ
 */
public class QLCB_Mang
{
	private Scanner sc;
	private CanBo danhSach[];
	private int soLuong;
	
	public QLCB_Mang(Scanner sc)
	{
		this.sc = sc;
		this.danhSach = new CanBo[1000];
		this.soLuong = 0;
	}
	
	/**
	 * Thêm mới cán bộ.
	 */
	public void themMoi() 
	{		
		CanBo cb = null;
		
		// Tạo cán bộ theo lựa chọn của người dùng
		System.out.println("Thêm CÁN BỘ mới");
		System.out.println("1. Thêm CÔNG NHÂN");
		System.out.println("2. Thêm KỸ SƯ");
		System.out.println("3. Thêm NHÂN VIÊN");
		int luaChon;
		do
		{
			System.out.print("Vui lòng chọn (1-3): ");
			luaChon = Util.readInt(sc);
		}
		while (luaChon < 1 || luaChon > 3);
		
		switch (luaChon)
		{
			case 1: cb = new CongNhan(); break;
			case 2: cb = new KySu(); break;
			case 3: cb = new NhanVien(); break;
		}
		
		// Đọc thông tin cho cán bộ
		cb.readInfo(sc);
		
		// thêm cán bộ vào mảng
		danhSach[soLuong] = cb;
		
		// tăng số lượng lên 1 (có thể viết tắt danhSach[soLuong++] = cb;)
		soLuong++;
	}

	/**
	 * Tìm kiếm theo họ tên.
	 */
	public void timKiemTheoHoTen() 
	{
		System.out.print("Nhập tên cần tìm kiếm: ");
		String keyword = sc.nextLine().toLowerCase();
		
		System.out.println("Kết quả tìm kiếm:");
		for (int i = 0; i < soLuong; i++)
		{
			String hoten = danhSach[i].getHoTen().toLowerCase();
			if (hoten.contains(keyword))
				danhSach[i].printInfo();
		}
	}

	/**
	 * Hiện thị thông tin về danh sách các cán bộ.
	 */
	public void hienThiDanhSach() 
	{
		if (soLuong == 0)
			System.out.println("Chưa có cán bộ nào");
		else
		{
			System.out.println("Danh sách tất cả cán bộ");
			for (int i = 0; i < soLuong; i++)
			{
				danhSach[i].printInfo();
			}
		}
	}
	
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		QLCB_Mang qlcb = new QLCB_Mang(sc);
		int luaChon;
		do
		{
			System.out.println("------------ MENU ------------");
			System.out.println("1. Thêm mới cán bộ.");
			System.out.println("2. Tìm kiếm theo họ tên.");
			System.out.println("3. Hiện thị thông tin về danh sách các cán bộ.");
			System.out.println("0. Thoát");
			System.out.print("Vui lòng chọn: ");
			
			luaChon = Util.readInt(sc);
			switch (luaChon)
			{
				case 1:
					qlcb.themMoi();
					break;
				case 2:
					qlcb.timKiemTheoHoTen();
					break;
				case 3:
					qlcb.hienThiDanhSach();
					break;					
				case 0: 
					System.out.println("Goodbye...");
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ");
			}
		}
		while (luaChon != 0);
		
		sc.close();
	}
}