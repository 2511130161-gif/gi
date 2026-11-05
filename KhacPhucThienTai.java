
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
		// 1. tong kinh phí
		public double tongKinhPhi() {
			double tong = 0.0;
			for (NguonKinhPhi nkp : this.dsKinhPhi) {
				// Lưu ý: Thay "getSoTien()" thành tên hàm lấy số tiền trong lớp NguonKinhPhi của bạn
				tong += nkp.getGiaTri(); 
			}
			this.tongKinhPhi = tong; // Cập nhật lại thuộc tính của lớp
			return tong;
		}
		// 2. nguonkinhphilonnhat
		public double nguonKinhPhiLonNhat() {
			if (this.dsKinhPhi.isEmpty()) {
				return 0.0;
			}
			double max = Double.MIN_VALUE;
			for (NguonKinhPhi nkp : this.dsKinhPhi) {
				if (nkp.getGiaTri() > max) {
					max = nkp.getGiaTri();
				}
			}
			return max;
		}
		// 3. nguonkinhphinhonhat
		public double nguonKinhPhiNhoNhat() {
			if (this.dsKinhPhi.isEmpty()) {
				return 0.0;
			}
			double min = Double.MAX_VALUE;
			for (NguonKinhPhi nkp : this.dsKinhPhi) {
				if (nkp.getGiaTri() < min) {
					min = nkp.getGiaTri();
				}
			}
			return min;
		}
		// 4. Xóa nguồn kinh phí ra khỏi danh sách HashSet dựa trên tên nguồn truyền vào
		public void xoaNguonKinhPhi(String nguonKinhPhi) {
			NguonKinhPhi canXoa = null;
			for (NguonKinhPhi nkp : this.dsKinhPhi) {
				// Đối chiếu theo thuộc tính tenKP thông qua hàm getTenKP()
				if (nkp.getTenKP().equals(nguonKinhPhi)) {
					canXoa = nkp;
					break;
				}
			}
			if (canXoa != null) {
				this.dsKinhPhi.remove(canXoa);
			}
		}
		// 5. Thêm một nguồn kinh phí mới vào tập hợp HashSet
		public void themNguonKinhPhi(NguonKinhPhi nkp) {
			if (nkp != null) {
				this.dsKinhPhi.add(nkp);
			}
	}
		
		public static void main(String[] args) {
			System.out.println("====== CHƯƠNG TRÌNH KIỂM THỬ HỒ SƠ KHẮC PHỤC THIÊN TAI ======\n");

			// 1. Khởi tạo Hồ sơ khắc phục với các danh sách rỗng ban đầu
			Set<NguonKinhPhi> setKinhPhi = new HashSet<>();
			Map<DotCuuTro, Integer> mapCuuTro = new HashMap<>();
			KhacPhucThienTai hoSo = new KhacPhucThienTai("HS-2026-01", 0.0, null, setKinhPhi, mapCuuTro);

			// 2. Kiểm thử phương thức (5): Thêm các nguồn kinh phí vào tập hợp
			System.out.println("1. Tiến hành thêm các nguồn kinh phí tài trợ...");
			hoSo.themNguonKinhPhi(new NguonKinhPhi("Nguồn Ngân Sách Tỉnh", 500000000.0, "Tái thiết hạ tầng"));
			hoSo.themNguonKinhPhi(new NguonKinhPhi("Quỹ Doanh Nghiệp Ủng Hộ", 1200000000.0, "Mua nhu yếu phẩm"));
			hoSo.themNguonKinhPhi(new NguonKinhPhi("Nhà Hảo Tâm Đóng Góp", 1500000000.0, "Hỗ trợ hộ dân lẻ"));

			// 3. Kiểm thử phương thức (1): Tự động tính toán tổng kinh phí cộng dồn
			double tongKinhPhiHienTai = hoSo.tongKinhPhi();
			System.out.println("=> Tổng kinh phí tích lũy tự động: " + String.format("%,.0f", tongKinhPhiHienTai) + " VND.");

			// 4. Kiểm thử phương thức (2) & (3): Tự động tìm nguồn lớn nhất, nhỏ nhất
			System.out.println("\n2. Tự động phân tích các gói tài trợ:");
			System.out.println("=> Giá trị gói tài trợ LỚN NHẤT: " + String.format("%,.0f", hoSo.nguonKinhPhiLonNhat()) + " VND.");
			System.out.println("=> Giá trị gói tài trợ NHỎ NHẤT: " + String.format("%,.0f", hoSo.nguonKinhPhiNhoNhat()) + " VND.");

			// 5. Kiểm thử phương thức (4): Xóa một nguồn kinh phí bằng chuỗi tên
			System.out.println("\n3. Chạy lệnh xóa nguồn kinh phí:       ");
			hoSo.xoaNguonKinhPhi("Nguồn Ngân Sách Tỉnh");

			// 6. Tự động cập nhật lại tổng tiền sau khi xóa và in ra kết quả cuối cùng
			double tongKinhPhiSauXoa = hoSo.tongKinhPhi();
			System.out.println("=> Tổng kinh phí cập nhật mới sau khi xóa: " + String.format("%,.0f", tongKinhPhiSauXoa) + " VND.");
      }
	}

