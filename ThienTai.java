import java.util.PriorityQueue;
import java.util.TreeSet;

public class ThienTai {
	private String MaTT;
	private String ten;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private PriorityQueue<KhuVuc> dsKhuVucAnhHuong = new PriorityQueue<>();
	private TreeSet<ThietHaiCoSoVatChat_NN> dsThietHaiCSVC_NN = new TreeSet<>();
	public String getMaTT() {
		return MaTT;
	}
	public void setMaTT(String maTT) {
		MaTT = maTT;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public PriorityQueue<KhuVuc> getDsKhuVucAnhHuong() {
		return dsKhuVucAnhHuong;
	}
	public void setDsKhuVucAnhHuong(PriorityQueue<KhuVuc> dsKhuVucAnhHuong) {
		this.dsKhuVucAnhHuong = dsKhuVucAnhHuong;
	}
	public TreeSet<ThietHaiCoSoVatChat_NN> getDsThietHaiCSVC_NN() {
		return dsThietHaiCSVC_NN;
	}
	public void setDsThietHaiCSVC_NN(TreeSet<ThietHaiCoSoVatChat_NN> dsThietHaiCSVC_NN) {
		this.dsThietHaiCSVC_NN = dsThietHaiCSVC_NN;
	}

}
