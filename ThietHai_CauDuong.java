import java.util.ArrayList;

public class ThietHai_CauDuong extends ThietHaiCoSoVatChat_NN {
    private String tuyenDuong_cau;
    private KhuVuc diemDau;
    private KhuVuc diemCuoi;
    private double doDaiDuongDi; //tính bằng mét (m)
    private double chieuRong;    //tính bằng mét (m)

    public ThietHai_CauDuong(String maCSVC, String loaiCSVC, double giaTri, 
                             String tuyenDuong_cau, KhuVuc diemDau, KhuVuc diemCuoi, 
                             double doDaiDuongDi, double chieuRong) {
        super(maCSVC, loaiCSVC, giaTri);
        this.tuyenDuong_cau = tuyenDuong_cau;
        this.diemDau = diemDau;
        this.diemCuoi = diemCuoi;
        this.doDaiDuongDi = doDaiDuongDi;
        this.chieuRong = chieuRong;
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
    public double getChieuRong() {
    	return chieuRong;
    	}
    public void setChieuRong(double chieuRong) {
    	this.chieuRong = chieuRong;
    	}

    @Override
    //tổng giá trị thiệt hại
    public double tongGiaTriThietHai(){
        return super.getGiaTri();
    }

    @Override
    //tính diện tích cầu đường bị hỏng
    public double tongDienTichThietHai(){
        return this.doDaiDuongDi * this.chieuRong;
    }
    //xác định mức độ bị ảnh hưởng
    public String xacDinhMucDoAnhHuong() {
        double gt = tongGiaTriThietHai();
        if (gt > 1000000000) return "Đặc biệt nghiêm trọng";
        if (gt >= 500000000) return "Nghiêm trọng";
        if (gt >= 100000000) return "Trung bình";
        return "Nhẹ";
    }
    //thông tin lộ trình là từ đâu đến đâu
    public String thongTinLoTrinh() {
        String diaDauStr = diemDau.getLang_xa_thon() + ", " + diemDau.getQuan_huyen() + ", " + diemDau.getTinh_thanhpho();
        String diaCuoiStr = diemCuoi.getLang_xa_thon() + ", " + diemCuoi.getQuan_huyen() + ", " + diemCuoi.getTinh_thanhpho();
        return "Từ (" + diaDauStr + ") đến (" + diaCuoiStr + ")";
    }

    // Kiểm tra xem tuyến đường là nội tỉnh hay liên tỉnh
    public boolean kiemTraLienTinh() {
        if (diemDau != null && diemCuoi != null) {
            // Nếu tỉnh/thành phố của điểm đầu khác điểm cuối thì là liên tỉnh
            return !diemDau.getTinh_thanhpho().equalsIgnoreCase(diemCuoi.getTinh_thanhpho());
        }
        return false;
    }

    @Override
    //trả về 1 danh sách đánh giá xem tổng quan bị thiệt hại
    public ArrayList<String> danhGiaMucDoNghiemTrong(){
        ArrayList<String> ds = super.danhGiaMucDoNghiemTrong();
        ds.add("Tuyến: " + this.tuyenDuong_cau);
        ds.add("Lộ trình: " + thongTinLoTrinh());
        ds.add("Phạm vi ảnh hưởng: " + (kiemTraLienTinh() ? "Đường liên tỉnh (Nghiêm trọng hơn)" : "Đường nội tỉnh"));
        ds.add("Mức độ thiệt hại tài sản: " + xacDinhMucDoAnhHuong());
        ds.add("Tổng diện tích thiệt hại mặt đường: " + tongDienTichThietHai() + " m2");
        
        if (this.doDaiDuongDi > 5000) {
            ds.add("Tình trạng: Gây chia cắt giao thông diện rộng");
        }
        return ds;
    }
}
