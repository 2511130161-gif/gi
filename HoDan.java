import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HoDan {
	private String maHK;//hộ khẩu
	private String diaChiNha;
	private NguoiDan ChuHo;
	private List<NguoiDan> dsThanhVienHoDan = new LinkedList<>();
	private List<NguoiDan> dsThietHai_Nguoi = new LinkedList<>();
	private Map<String,Double> thietHai_CuaCai = new TreeMap<>();
	public HoDan(String maHK, String diaChiNha, NguoiDan chuHo, List<NguoiDan> dsThanhVienHoDan,
			List<NguoiDan> dsThietHai_Nguoi, Map<String, Double> thietHai_CuaCai) {
		super();
		this.maHK = maHK;
		this.diaChiNha = diaChiNha;
		ChuHo = chuHo;
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
	

}
