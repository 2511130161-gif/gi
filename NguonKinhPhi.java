
public class NguonKinhPhi {
	private String tenKP;
	private double giaTri;
	private String mucDichSuDung;
	public NguonKinhPhi(String tenKP, double giaTri, String mucDichSuDung) {
		super();
		this.tenKP = tenKP;
		this.giaTri = giaTri;
		this.mucDichSuDung = mucDichSuDung;
	}
	public String getTenKP() {
		return tenKP;
	}
	public void setTenKP(String tenKP) {
		this.tenKP = tenKP;
	}
	public double getGiaTri() {
		return giaTri;
	}
	public void setGiaTri(double giaTri) {
		this.giaTri = giaTri;
	}
	public String getMucDichSuDung() {
		return mucDichSuDung;
	}
	public void setMucDichSuDung(String mucDichSuDung) {
		this.mucDichSuDung = mucDichSuDung;
	}
	public void capNhatSoTienTaiTro(double soTienMoi) {
		giaTri = soTienMoi;
	}
	//mục đích sử dụng là gì
	public String kiemTraMucDichSuDung(){
		return mucDichSuDung;
	}
	//phân loại nguồn kinh phí từ đâu mà có
	public String phanLoaiNguonKinhPhi(){
		String name = "";
		// Kiểm tra xem tên kinh phí có tồn tại (không bị null) hay không
		if (tenKP != null) {
		    name = tenKP.toLowerCase(); // Nếu có thì chuyển sang chữ thường
		}
		if(name.contains("nhà nước")||name.contains("ngân sách")) {
		return"kinh phí nhà nước";
		}else if(name.contains("đóng góp")||name.contains("nhà hảo tâm")|name.contains("quyên góp")) {
		return"kinh phí từ thiện từ người dân";
		}else if(name.contains("quốc tế")||name.contains("nước ngoài")||name.contains("ngoại")) {
		return"kinh phí tài trợ từ nước ngoài";
		}else {
		return "khác";
		}
	}
	//lịch sử giao dịch hay là nguồn kinh phí
	public String xuatNhatKyGiaoDich(){
		return "tên nguồn kinh phí : "+tenKP+"giá trị của nguồn kinh phí này : "+giaTri+"mục đích sử dụng của nguồn kinh phí này : "+mucDichSuDung;
	}
	//kiểm tra xem cái mục tài trợ đó có đủ tiền ko
	public boolean kiemTraHanMucTaiTro(double soTienCanRut){
		if(giaTri <= soTienCanRut) {
		return true;
		}
		return false;
	}
}
