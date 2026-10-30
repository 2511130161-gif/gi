
public class ThietHai_CauDuong extends ThietHaiCoSoVatChat_NN{
	private String tuyenDuong_cau;
	private KhuVuc diemDau;
	private KhuVuc diemCuoi;
	private double  doDaiDuongDi;
	public ThietHai_CauDuong(String tuyenDuong_cau, KhuVuc diemDau, KhuVuc diemCuoi, double doDaiDuongDi) {
		super(tuyenDuong_cau, tuyenDuong_cau, doDaiDuongDi);
		this.tuyenDuong_cau = tuyenDuong_cau;
		this.diemDau = diemDau;
		this.diemCuoi = diemCuoi;
		this.doDaiDuongDi = doDaiDuongDi;
	}
	public String getTuyenDuong_cau() {
		return tuyenDuong_cau;
	}
	public void setTuyenDuong_cau(String tuyenDuong_cau) {
		this.tuyenDuong_cau = tuyenDuong_cau;
	}
	public KhuVuc getDiemDau() {
		return diemDau;
	}
	public void setDiemDau(KhuVuc diemDau) {
		this.diemDau = diemDau;
	}
	public KhuVuc getDiemCuoi() {
		return diemCuoi;
	}
	public void setDiemCuoi(KhuVuc diemCuoi) {
		this.diemCuoi = diemCuoi;
	}
	public double getDoDaiDuongDi() {
		return doDaiDuongDi;
	}
	public void setDoDaiDuongDi(double doDaiDuongDi) {
		this.doDaiDuongDi = doDaiDuongDi;
	}
	

}
