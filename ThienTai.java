
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
		//1. phương thức tính tổng thiệt hại về người 
		public int tinhTongThietHai_Nguoi() {
	        int tong = 0;
	        for (KhuVuc kv : dsKhuVucAnhHuong) {	        
	        // Gọi trực tiếp phương thức tính tổng số người mất của từng Khu Vực
	           tong += kv.tongSoNguoiMat(); 	            
	        }
	        return tong;

	}
		// 2. Tính tổng thiệt hại về của (tài sản cá nhân/hộ gia đình)
	    public int tinhTongThietHai_Cua() {
	        int tong = 0;
	        for (KhuVuc kv : dsKhuVucAnhHuong) {
	            // Giả sử lớp KhuVuc có phương thức getThietHaiCua() hoặc tương tự
	            tong += kv.getThietHaiCua();
	        }
	        return tong;
	    }
	    // 3. Tính tổng thiệt hại cơ sở vật chất
	    public double tinhTongThietHai_CSVC() {
	    	double tong = 0.0;
	        
	        // Duyệt qua từng đối tượng ThietHaiCoSoVatChat_NN có trong TreeSet
	        for (ThietHaiCoSoVatChat_NN th : dsThietHaiCSVC_NN) {
	            // Cách 1: Gọi phương thức nghiệp vụ đã viết ở lớp ThietHaiCoSoVatChat_NN
	            tong += th.tongGiaTriThietHai(); 
	        }	        
	        return tong;
	    }
	    // 4. Tính tổng diện tích bị ảnh hưởng
	    public double tongDienTichBiAnhHuong() {
	        double tongDienTich = 0.0;
	        for (KhuVuc kv : dsKhuVucAnhHuong) {
	        	
	            tongDienTich += kv.getDienTich();
	        }
	        return tongDienTich;
	    }
	    // 5. Thêm khu vực cần cứu trợ vào hàng đợi ưu tiên
	    public void themKhuVucCanCuuTro(KhuVuc kv) {
	        if (kv != null) {
	            this.dsKhuVucAnhHuong.add(kv);
	        }
	    }
	    // 7. Thay đổi mức độ ưu tiên của một khu vực dựa vào mã khu vực
	    public void thaydoiMucDoUuTienKhuVuc(String maKV, int mucDoMoi) {
	        KhuVuc target = null;
	        
	        // Tìm khu vực trong PriorityQueue
	        for (KhuVuc kv : dsKhuVucAnhHuong) {
	            // Giả sử lớp KhuVuc có phương thức getMaKV()
	            if (kv.getMaKV().equals(maKV)) {
	                target = kv;
	                break;
	            }
	        }
	        
	        // Vì PriorityQueue không tự động sắp xếp lại khi thuộc tính của đối tượng thay đổi,
	        // chúng ta phải xóa đối tượng cũ ra, cập nhật giá trị rồi thêm lại vào hàng đợi.
	        if (target != null) {
	            dsKhuVucAnhHuong.remove(target);
	            // target.setMucDoUuTien(mucDoMoi); // Giả sử lớp KhuVuc có phương thức này
	            dsKhuVucAnhHuong.add(target);
	        }
	    }
	
	    

}
	


