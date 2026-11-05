
import java.util.LinkedList;

public class NguoiDan {

	private String CCCD;
	private String HoTen;
	private String GioiTinh;
	private Date NgaySinh;
	private String TinhTrangHonNhan;
	private boolean conSong; 
	
	private String quanHeChuHo;
	public NguoiDan(String cCCD, String hoTen, String gioiTinh, Date ngaySinh, String tinhTrangHonNhan, 
			String quanHeChuHo) {
		super();
		CCCD = cCCD;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		TinhTrangHonNhan = tinhTrangHonNhan;
		this.quanHeChuHo = quanHeChuHo;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getTinhTrangHonNhan() {
		return TinhTrangHonNhan;
	}
	public void setTinhTrangHonNhan(String tinhTrangHonNhan) {
		TinhTrangHonNhan = tinhTrangHonNhan;
	}
	
	public String getQuanHeChuHo() {
		return quanHeChuHo;
	}
	public void setQuanHeChuHo(String quanHeChuHo) {
		this.quanHeChuHo = quanHeChuHo;
	}
	
	public boolean isConSong() {
		return conSong;
	}
	public void setConSong(boolean conSong) {
		this.conSong = conSong;
	}
	public LinkedList<String> phanChiaDoTuoiUuTien() {
        LinkedList<String> danhSachUuTien = new LinkedList<>();
        
        // Lấy năm hiện tại trừ đi năm sinh bằng hàm getYear() của lớp Date
        int namHienTai = 2026; 
        int tuoi = namHienTai - this.NgaySinh.getYear(); // <--- Kiểm tra dòng này xem có bị viết nhầm thành .length() không
        
        if (tuoi <= 6) {
            danhSachUuTien.add("Trẻ em dưới 6 tuổi");
        } else if (tuoi >= 60) {
            danhSachUuTien.add("Người cao tuổi");
        } else {
            danhSachUuTien.add("Độ tuổi bình thường");
        }
        
        return danhSachUuTien;
    }

	public class Main {
	    public void main(String[] args) {
	        
	        System.out.println("=== CHƯƠNG TRÌNH KIỂM THỬ QUẢN LÝ NGƯỜI DÂN ===\n");

	        // 1. Tạo các đối tượng ngày sinh bằng lớp Date tự định nghĩa
	        Date ngaySinhBong = new Date(15, 5, 2023); // 2026 - 2023 = 3 tuổi (Trẻ em)
	        Date ngaySinhAn = new Date(20, 10, 2000);  // 2026 - 2000 = 26 tuổi (Bình thường)
	        Date ngaySinhCuong = new Date(1, 1, 1955);  // 2026 - 1955 = 71 tuổi (Người già)

	        // 2. Khởi tạo danh sách các người dân để test dữ liệu hàng loạt
	        LinkedList<NguoiDan> danhSachNguoiDan = new LinkedList<>();

	        danhSachNguoiDan.add(new NguoiDan("001203004567", "Nguyen Van An", "Nam", ngaySinhAn, "Doc than", "Con trai"));
	        danhSachNguoiDan.add(new NguoiDan("001223001122", "Le Thi Bong", "Nu", ngaySinhBong, "Chua ket hon", "Con gai"));
	        danhSachNguoiDan.add(new NguoiDan("001055009988", "Tran Van Cuong", "Nam", ngaySinhCuong, "Da ket hon", "Chu ho"));

	        // 3. Duyệt qua danh sách và in kết quả kiểm thử các phương thức ra màn hình
	        for (NguoiDan nd : danhSachNguoiDan) {
	            System.out.println("------------------------------------------------");
	            System.out.println("Họ tên: " + nd.getHoTen());
	            System.out.println("Năm sinh: " + nd.getNgaySinh().getYear());
	            System.out.println("Mối quan hệ với chủ hộ: " + nd.getQuanHeChuHo());
	            
	            // Test phương thức kiểm tra tình trạng còn sống
	            System.out.println("Tình trạng còn sống: " + (nd.isConSong() ? "Còn sống" : "Đã mất"));

	            // Test phương thức phân chia độ tuổi ưu tiên
	            LinkedList<String> phanLoai = nd.phanChiaDoTuoiUuTien();
	            System.out.println("Phân loại diện ưu tiên: " + phanLoai);
	        }
	        
	        System.out.println("------------------------------------------------");
	    }}}






