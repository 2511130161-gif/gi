import java.util.ArrayList;

public class ThietHai_HaTang extends ThietHaiCoSoVatChat_NN {
    private String loaiKienTruc;
    private double dienTich;

    // Constructor đã được chuẩn hóa lại tham số
    public ThietHai_HaTang(String maCSVC, String loaiCSVC, double giaTri, String loaiKienTruc, double dienTich) {
        super(maCSVC, loaiCSVC, giaTri);
        this.loaiKienTruc = loaiKienTruc;
        this.dienTich = dienTich;
    }
    public String getLoaiKienTruc() {
        return loaiKienTruc;
    }
    public void setLoaiKienTruc(String loaiKienTruc) {
        this.loaiKienTruc = loaiKienTruc;
    }
    public double getDienTich() {
        return dienTich;
    }
    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }
    @Override
    //lấy giá trị thiệt hại
    public double tongGiaTriThietHai() {
        return super.getGiaTri();
    }
    @Override
    //tổng diện thích bị thiệt hại
    public double tongDienTichThietHai() {
        return this.dienTich;
    }
    //xác định xem mức độ thiệt hại được đánh giá thế nào
    public String xacDinhMucDoAnhHuong() {
        double gt = tongGiaTriThietHai();
        double dt = tongDienTichThietHai();
        // Logic đánh giá mức độ ảnh hưởng dựa trên giá trị và diện tích thiệt hại
        if (gt >= 1000000000 || dt >= 5000) {
            return "Đặc biệt nghiêm trọng";
        } else if (gt >= 500000000 || dt >= 2000) {
            return "Nghiêm trọng";
        } else if (gt >= 100000000 || dt >= 500) {
            return "Trung bình";
        } else {
            return "Nhẹ";
        }
    }
    @Override
    //trả về 1 ds đánh giá tổng quát về mức độ thiệt hại    
    public ArrayList<String> danhGiaMucDoNghiemTrong() {
        ArrayList<String> ds = super.danhGiaMucDoNghiemTrong();
        ds.add("Loại kiến trúc: " + this.loaiKienTruc);
        ds.add("Diện tích thiệt hại: " + this.dienTich + " m2");
        ds.add("Mức độ ảnh hưởng hạ tầng: " + xacDinhMucDoAnhHuong());
        return ds;
    }
}

