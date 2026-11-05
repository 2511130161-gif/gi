
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

	public class KhuVuc implements Comparable<KhuVuc>{
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
		// 1. Tính tổng số người ban đầu của toàn khu vực
		public int tongNguoiBanDau() {
			int tong = 0;
			for (HoDan hd : dsHoDan) {
				// Giả sử lớp HoDan có hàm lấy số nhân khẩu ban đầu như getSoNhanKhau()
				tong += hd.getSoNhanKhau();
			}
			return tong;
		}

		// 2. Tính tổng số hộ dân trong khu vực
		public int tongSoHoDan() {
			int tong = 0;
		    
		    // Duyệt qua từng hộ dân có trong danh sách dsHoDan
		    for (HoDan hd : this.dsHoDan) {
		        // Cứ mỗi lần gặp một hộ dân, ta cộng thêm 1 vào biến tổng
		        tong += 1; 
		    }
		    
		    return tong;
		}

		// 3. Tính tổng số người mất (Hàm này giúp biến mất hoàn toàn lỗi gạch đỏ ở hàm compareTo)
		public int tongSoNguoiMat() {
			int tong = 0;
			for (HoDan hd : dsHoDan) {
				tong += hd.getSoNguoiMat(); // Gọi sang phương thức nghiệp vụ của lớp HoDan
			}
			return tong;
		}
/**
 * lấy từ hộ dân
 * @return
 */
		// 4. Tổng hợp các loại thiệt hại trong khu vực (Dùng HashSet để lọc trùng)
		public HashSet<String> tongThietHaiKhuVuc() {
			HashSet<String> danhSachThietHai = new HashSet<>();
			for (HoDan hd : dsHoDan) {
				// Giả sử hộ dân trả về loại thiệt hại, gom vào HashSet để tự lọc trùng
				danhSachThietHai.add(hd.getLoaiThietHai());
			}
			return danhSachThietHai;
		}

		// 5. Thêm hộ dân mới vào danh sách
		public boolean themHoDan(HoDan hoMoi) {
			if (hoMoi != null) {
				return this.dsHoDan.add(hoMoi);
			}
			return false;
		}

		// 6. Xóa hộ dân ra khỏi danh sách theo mã hộ khẩu (maHK)
		public boolean xoaHoDanTheoMa(String maHK) {
			HoDan canXoa = timKiemHoDan(maHK);
			if (canXoa != null) {
				return this.dsHoDan.remove(canXoa);
			}
			return false;
		}

		// 7. Lấy hộ dân tại một vị trí (index) xác định trong danh sách
		public HoDan layHoDanTheoViTri(int index) {
			if (index >= 0 && index < dsHoDan.size()) {
				return this.dsHoDan.get(index);
			}
			return null;
		}
/**
 * đợi gộp hàm của hộ dân ms viết tiếp đc
 * @param maHK
 * @return
 */
		// 8. Tìm kiếm hộ dân theo mã hộ khẩu (maHK)
		public HoDan timKiemHoDan(String maHK) {
			for (HoDan hd : dsHoDan) {
				// Giả sử lớp HoDan có hàm getMaHK() để lấy mã hộ khẩu
				 if (hd.getMaHK().equals(maHK)) {
				     return hd;
				 }
			}
			return null;
		}

		@Override
		public int compareTo(KhuVuc o) {
		// Mặc định: Khu vực nào có tổng số người mất nhiều hơn sẽ được xếp lên đầu hàng đợi ưu tiên
			   return Integer.compare(o.tongSoNguoiMat(), this.tongSoNguoiMat());
		}
		

	}


