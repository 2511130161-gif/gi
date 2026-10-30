import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KhacPhucThienTai {
	private String maHS;//mã hồ sơ
	private double tongKinhPhi;
	private ThienTai thientai;//thiên tai cần khắc phục
	private Set<NguonKinhPhi> dsKinhPhi = new HashSet<>();
	private Map<DotCuuTro,Integer> dsDotCuuTro = new HashMap<>();
	public KhacPhucThienTai(String maHS, double tongKinhPhi, ThienTai thientai, Set<NguonKinhPhi> dsKinhPhi,
			Map<DotCuuTro, Integer> dsDotCuuTro) {
		super();
		this.maHS = maHS;
		this.tongKinhPhi = tongKinhPhi;
		this.thientai = thientai;
		this.dsKinhPhi = dsKinhPhi;
		this.dsDotCuuTro = dsDotCuuTro;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public double getTongKinhPhi() {
		return tongKinhPhi;
	}
	public void setTongKinhPhi(double tongKinhPhi) {
		this.tongKinhPhi = tongKinhPhi;
	}
	public ThienTai getThientai() {
		return thientai;
	}
	public void setThientai(ThienTai thientai) {
		this.thientai = thientai;
	}
	public Set<NguonKinhPhi> getDsKinhPhi() {
		return dsKinhPhi;
	}
	public void setDsKinhPhi(Set<NguonKinhPhi> dsKinhPhi) {
		this.dsKinhPhi = dsKinhPhi;
	}
	public Map<DotCuuTro, Integer> getDsDotCuuTro() {
		return dsDotCuuTro;
	}
	public void setDsDotCuuTro(Map<DotCuuTro, Integer> dsDotCuuTro) {
		this.dsDotCuuTro = dsDotCuuTro;
	}

}
