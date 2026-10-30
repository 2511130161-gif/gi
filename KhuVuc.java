import java.util.ArrayList;
import java.util.List;

public class KhuVuc {
	private String maKV;
	private String tinh_thanhpho;
	private String quan_huyen;
	private String lang_xa_thon;
	private double dienTich;
	private List<HoDan> dsHoDan = new ArrayList<>();
	public KhuVuc(String maKV, String tinh_thanhpho, String quan_huyen, String lang_xa_thon, double dienTich,
			List<HoDan> dsHoDan) {
		super();
		this.maKV = maKV;
		this.tinh_thanhpho = tinh_thanhpho;
		this.quan_huyen = quan_huyen;
		this.lang_xa_thon = lang_xa_thon;
		this.dienTich = dienTich;
		this.dsHoDan = dsHoDan;
	}
	public String getMaKV() {
		return maKV;
	}
	public void setMaKV(String maKV) {
		this.maKV = maKV;
	}
	public String getTinh_thanhpho() {
		return tinh_thanhpho;
	}
	public void setTinh_thanhpho(String tinh_thanhpho) {
		this.tinh_thanhpho = tinh_thanhpho;
	}
	public String getQuan_huyen() {
		return quan_huyen;
	}
	public void setQuan_huyen(String quan_huyen) {
		this.quan_huyen = quan_huyen;
	}
	public String getLang_xa_thon() {
		return lang_xa_thon;
	}
	public void setLang_xa_thon(String lang_xa_thon) {
		this.lang_xa_thon = lang_xa_thon;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public List<HoDan> getDsHoDan() {
		return dsHoDan;
	}
	public void setDsHoDan(List<HoDan> dsHoDan) {
		this.dsHoDan = dsHoDan;
	}
	

}
