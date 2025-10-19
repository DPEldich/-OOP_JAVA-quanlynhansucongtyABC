package demo;

public class quanly extends nhansu {

    private double luongCoBan;
    private double heSoLuong;
    private double phuCap;

    public quanly(String id, String name, int age, double luongCoBan, double heSoLuong, double phuCap) {
        super(id, name, age);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong + phuCap;
    }

    @Override
    public String toString() {
        return super.toString() + ",QuanLy," + luongCoBan + "," + heSoLuong + "," + phuCap;
    }
}
