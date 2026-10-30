
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
	

}
