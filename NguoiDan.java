
public class NguoiDan {
	private String CCCD;
	private String HoTen;
	private String GioiTinh;
	private Date NgaySinh;
	private String TinhTrangHonNhan;
	private boolean conSong;
	private String quanHeChuHo;
	public NguoiDan(String cCCD, String hoTen, String gioiTinh, Date ngaySinh, String tinhTrangHonNhan, boolean conSong,
			String quanHeChuHo) {
		super();
		CCCD = cCCD;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		TinhTrangHonNhan = tinhTrangHonNhan;
		this.conSong = conSong;
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
	public boolean isConSong() {
		return conSong;
	}
	public void setConSong(boolean conSong) {
		this.conSong = conSong;
	}
	public String getQuanHeChuHo() {
		return quanHeChuHo;
	}
	public void setQuanHeChuHo(String quanHeChuHo) {
		this.quanHeChuHo = quanHeChuHo;
	}
	

}
