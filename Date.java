
	public class Date {
		private int day;
		private int month;
		private int year;
		public Date(int day, int month, int year) {
			super();
			this.day = day;
			this.month = month;
			this.year = year;
		}
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		private boolean laNamNhuan(int y) {
			return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
		}
		
		public int soSanhNgay(Date other) {
			if (this.year != other.year) {
				return Integer.compare(this.year, other.year);
			}
			if (this.month != other.month) {
				return Integer.compare(this.month, other.month);
			}
			return Integer.compare(this.day, other.day);
		}

		public int tinhKhoangCanhNgay(Date other) {
			int namBatDau = Math.min(this.year, other.year);
			int namKetThuc = Math.max(this.year, other.year);
			int tongSoNgay = 0;
			
			// Vòng lặp gọn gàng hơn rất nhiều nhờ gọi hàm laNamNhuan(y)
			for (int y = namBatDau; y < namKetThuc; y++) {
				tongSoNgay += laNamNhuan(y) ? 366 : 365;
			}
			
			// Đoạn khởi tạo mảng tháng cũng ngắn hơn đáng kể
			// cho số 0 ở đầu để tránh lệch tháng vì cho int m = 1 
			int[] soNgayTrongThangThis = {0, 31, laNamNhuan(this.year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // các số tháng trong năm (nếu ngay tháng 2 thì sẽ check năm nhuận 
			int[] soNgayTrongThangOther = {0, 31, laNamNhuan(other.year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			
			int ngayCuaThis = this.day;
			for (int m = 1; m < this.month; m++) {
				ngayCuaThis += soNgayTrongThangThis[m];
			}
			
			int ngayCuaOther = other.day;
			for (int m = 1; m < other.month; m++) {
				ngayCuaOther += soNgayTrongThangOther[m];
			}
			
			if (this.year >= other.year) {
				tongSoNgay += (ngayCuaThis - ngayCuaOther);
			} else {
				tongSoNgay += (ngayCuaOther - ngayCuaThis);
			}
			
			return Math.abs(tongSoNgay);
		}
		
		public static void main(String[] args) {

			// Khởi tạo 2 mốc thời gian để chạy thử nghiệm
			Date d1 = new Date(28, 2, 2025); // Ngày 1
			Date d2 = new Date(7, 3, 2025);  // Ngày 2
			
			System.out.println("Mốc ngày 1: " + d1.getDay() + "/" + d1.getMonth() + "/" + d1.getYear());
			System.out.println("Mốc ngày 2: " + d2.getDay() + "/" + d2.getMonth() + "/" + d2.getYear());
			System.out.println("---------------------------------------------------------");

			// BƯỚC 1: Tính toán khoảng cách số ngày từ Ngày 1 đến Ngày 2
			int soNgay = d1.tinhKhoangCanhNgay(d2);
			
			// BƯỚC 2: In kết quả số ngày vừa tìm được ra màn hình
			System.out.println("1. Kết quả tính toán số ngày từ date 1 đến date 2 là: " + soNgay + " ngày.");

			// BƯỚC 3: Sau khi đã tính xong số ngày, tiến hành so sánh thứ tự thời gian
			int ketQuaSoSanh = d1.soSanhNgay(d2);
			
			System.out.print("2. Kết quả so sánh thứ tự: ");
			if (ketQuaSoSanh < 0) {
				System.out.println("Mốc date 1 đứng TRƯỚC mốc date 2.");
			} else if (ketQuaSoSanh > 0) {
				System.out.println("Mốc date 2 đứng TRƯỚC mốc date 1.");
			} else {
				System.out.println("Hai date ngày trùng nhau hoàn toàn.");
			}
	 }
}
	
	

	
