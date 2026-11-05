import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Comparator;

public class HoDan {
	private String maHK;//hộ khẩu
	private String diaChiNha;
	private NguoiDan ChuHo;
	private boolean daDuocCuuTro;
	private List<NguoiDan> dsThanhVienHoDan = new LinkedList<>();
	private List<NguoiDan> dsThietHai_Nguoi = new LinkedList<>();
	private Map<String,Double> thietHai_CuaCai = new TreeMap<>();
	public HoDan(String maHK, String diaChiNha, NguoiDan chuHo, boolean daDuocCuuTro, List<NguoiDan> dsThanhVienHoDan,
			List<NguoiDan> dsThietHai_Nguoi, Map<String, Double> thietHai_CuaCai) {
		super();
		this.maHK = maHK;
		this.diaChiNha = diaChiNha;
		ChuHo = chuHo;
		this.daDuocCuuTro = daDuocCuuTro;
		this.dsThanhVienHoDan = dsThanhVienHoDan;
		this.dsThietHai_Nguoi = dsThietHai_Nguoi;
		this.thietHai_CuaCai = thietHai_CuaCai;
	}
	public String getMaHK() {
		return maHK;
	}
	public void setMaHK(String maHK) {
		this.maHK = maHK;
	}
	public String getDiaChiNha() {
		return diaChiNha;
	}
	public void setDiaChiNha(String diaChiNha) {
		this.diaChiNha = diaChiNha;
	}
	public NguoiDan getChuHo() {
		return ChuHo;
	}
	public void setChuHo(NguoiDan chuHo) {
		ChuHo = chuHo;
	}
	public List<NguoiDan> getDsThanhVienHoDan() {
		return dsThanhVienHoDan;
	}
	public void setDsThanhVienHoDan(List<NguoiDan> dsThanhVienHoDan) {
		this.dsThanhVienHoDan = dsThanhVienHoDan;
	}
	public List<NguoiDan> getDsThietHai_Nguoi() {
		return dsThietHai_Nguoi;
	}
	public void setDsThietHai_Nguoi(List<NguoiDan> dsThietHai_Nguoi) {
		this.dsThietHai_Nguoi = dsThietHai_Nguoi;
	}
	public Map<String, Double> getThietHai_CuaCai() {
		return thietHai_CuaCai;
	}
	public void setThietHai_CuaCai(Map<String, Double> thietHai_CuaCai) {
		this.thietHai_CuaCai = thietHai_CuaCai;
	}
	public void themThietHaiTaiSan(String tenTaiSan,double giaTri) {
		thietHai_CuaCai.put(tenTaiSan, giaTri);
	}
	public void setDaDuocCuuTro(boolean daDuocCuuTro) {
		this.daDuocCuuTro = daDuocCuuTro;
	}
	//nó sẽ lấy từ cái treemap dữ liệu từ double sau đó cộng lại
	public double tinhTongThietHaiTaiSan(){
		double total = 0.0;
		for(double trigia : thietHai_CuaCai.values()) {
				total += trigia;
			}
		return total;
	}
	//xóa thiệt hại bên trong ds thiệt hại của cải
	public void xoaMucThietHai(String tenTaiSan) {
		thietHai_CuaCai.remove(tenTaiSan);
	}
	//thêm vô người chết vào ds thiệt hại người
	public void ghiNhanThietHaiVeNguoi(NguoiDan nguoibithietmang){
		dsThietHai_Nguoi.add(nguoibithietmang);
	}
	//tìm người trong hộ gia đình đó
	public NguoiDan timNguoiTrongHo(String CCCD){
		if(ChuHo != null && ChuHo.getCCCD().equals(CCCD)) {
			return ChuHo;
		}			
		if(!dsThanhVienHoDan.isEmpty()) {
			for(NguoiDan nguoi : dsThanhVienHoDan) {
				if(nguoi != null && nguoi.getCCCD().equals(CCCD)) {
					return nguoi;
				}
			}		
		}
		return null;
	}
	//tạo 1 danh sách xếp hàng ai trong hộ đc di tảng trước
	public PriorityQueue<NguoiDan> doiTuongUuTienDiTang(){
		PriorityQueue<NguoiDan> pq = new PriorityQueue<NguoiDan>(new Comparator<NguoiDan>() {
			@Override
			public int compare(NguoiDan o1, NguoiDan o2) {
				// Tiêu chí 1: phương thức phanChiaDuouTien() ở lớp người dân
				int kq1 = Integer.compare(o2.phanChiaDuouTien(), o1.phanChiaDuouTien());
				if (kq1 != 0) {
					return kq1;
				}
				// Tiêu chí 2: Tuổi (Tăng dần: o1 trước o2)
				int kq2 = Integer.compare(o1.baoNhieuTuoi(), o2.baoNhieuTuoi());
				if (kq2 != 0) {
					return kq2;
				}
				// Tiêu chí 3: Họ tên (A-Z)
				return o1.getHoTen().compareTo(o2.getHoTen());
			}
		});
		return pq;
	}
	//đã được cứu trợ chưa 
	public boolean isDaDuocCuuTro() {
		return daDuocCuuTro;
	}
	//cập nhật thông tin về được cứu trợ chưa
	public void capNhatThongTin(boolean trangThaiMoi) {
	    this.daDuocCuuTro = trangThaiMoi;
	}
	public int getSoNguoiMat() {
	    int dem = 0;
	    // dsThanhVien là danh sách chứa các đối tượng NguoiDan trong hộ
	    for (NguoiDan nd : this.dsThanhVienHoDan) { 
	        if (!nd.isConSong()) { // Nếu conSong() trả về false (nghĩa là đã mất)
	            dem++;
	        }
	    }
	    return dem;
	}
}
