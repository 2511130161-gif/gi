import java.util.ArrayList;

public class ThietHaiCoSoVatChat_NN {
    private String maCSVC;
    private String loaiCSVC;
    private double giaTri; // Giá trị ban đầu hoặc thiệt hại cơ bản

    // Constructor đầy đủ tham số
    public ThietHaiCoSoVatChat_NN(String maCSVC, String loaiCSVC, double giaTri) {
        this.maCSVC = maCSVC;
        this.loaiCSVC = loaiCSVC;
        this.giaTri = giaTri;
    }
    // Getters và Setters
    public String getMaCSVC() {
        return maCSVC;
    }
    public void setMaCSVC(String maCSVC) {
        this.maCSVC = maCSVC;
    }
    public String getLoaiCSVC() {
        return loaiCSVC;
    }
    public void setLoaiCSVC(String loaiCSVC) {
        this.loaiCSVC = loaiCSVC;
    }
    public double getGiaTri() {
        return giaTri;
    }
    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }
    // Phương thức tính tổng giá trị thiệt hại
    public double tongGiaTriThietHai() {
        return this.giaTri;
    }

    // Phương thức tính tổng diện tích thiệt hại (mặc định trả về 0.0, lớp con sẽ override)
    public double tongDienTichThietHai() {
        return 0.0;
    }

    // Phương thức đánh giá mức độ nghiêm trọng chung cơ bản
    public ArrayList<String> danhGiaMucDoNghiemTrong() {
        ArrayList<String> dsCacMucDoThietHai = new ArrayList<>();
        dsCacMucDoThietHai.add("Mã cơ sở vật chất: " + this.maCSVC);
        dsCacMucDoThietHai.add("Loại: " + this.loaiCSVC);
        
        if (this.giaTri >= 1000000000) {
            dsCacMucDoThietHai.add("Đánh giá chung: Thiệt hại tài sản lớn (Trên 1 tỷ VNĐ)");
        } else if (this.giaTri >= 100000000) {
            dsCacMucDoThietHai.add("Đánh giá chung: Thiệt hại tài sản đáng kể (Trên 100 triệu VNĐ)");
        } else {
            dsCacMucDoThietHai.add("Đánh giá chung: Thiệt hại tài sản ở mức nhỏ");
        }
        
        return dsCacMucDoThietHai;
    }
}
