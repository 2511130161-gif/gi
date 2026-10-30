
public class ThietHai_HaTang extends ThietHaiCoSoVatChat_NN{
	private String loaiKienTruc;
	private double giaTri;
	private double dienTich;
	public ThietHai_HaTang(String maCSVC, String loạiCSVC, double giaTri, String loaiKienTruc, double giaTri2,
			double dienTich) {
		super(maCSVC, loạiCSVC, giaTri);
		this.loaiKienTruc = loaiKienTruc;
		giaTri = giaTri2;
		this.dienTich = dienTich;
	}
	public String getLoaiKienTruc() {
		return loaiKienTruc;
	}
	public void setLoaiKienTruc(String loaiKienTruc) {
		this.loaiKienTruc = loaiKienTruc;
	}
	public double getGiaTri() {
		return giaTri;
	}
	public void setGiaTri(double giaTri) {
		this.giaTri = giaTri;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

}
