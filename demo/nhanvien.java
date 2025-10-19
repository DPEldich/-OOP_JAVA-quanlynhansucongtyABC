package demo;

public class nhanvien extends nhansu {

    private double luongCoBan;
    private double heSoLuong;

    public nhanvien(String id, String name, int age, double luongCoBan, double heSoLuong) {
        super(id, name, age);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    @Override
    public String toString() {
        return super.toString() + ",NhanVien," + luongCoBan + "," + heSoLuong;
    }
}
