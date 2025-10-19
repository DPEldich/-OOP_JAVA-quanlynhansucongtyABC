package demo;

import java.io.*;
import java.util.*;

public class QLNS implements Ichucnang {

    List<nhansu> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private String filePath = "D:\\nhansu.txt";

    public QLNS() {
        docFile();
    }

    @Override
    public void Add() {
        System.out.print("Nhap MA Nhan su: ");
        String ID = sc.nextLine();

        System.out.print("Nhap ten Nhan su: ");
        String name = sc.nextLine();

        System.out.print("Nhap tuoi Nhan su: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Loai nhan su (1 - NhanVien, 2 - QuanLy): ");
        int loai = Integer.parseInt(sc.nextLine());

        if (loai == 1) {
            System.out.print("Nhap luong co ban: ");
            double lcb = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap he so luong: ");
            double hsl = Double.parseDouble(sc.nextLine());
            list.add(new nhanvien(ID, name, age, lcb, hsl));
        } else {
            System.out.print("Nhap luong co ban: ");
            double lcb = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap he so luong: ");
            double hsl = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap phu cap: ");
            double pc = Double.parseDouble(sc.nextLine());
            list.add(new quanly(ID, name, age, lcb, hsl, pc));
        }

        System.out.println("Da them nhan su. Tong nhan su: " + nhansu.getCount());
    }

    @Override
    public void Edit(String ID) {
        nhansu x = Search(ID);
        if (x != null) {
            System.out.print("Nhap ten moi: ");
            String name = sc.nextLine();
            System.out.print("Nhap tuoi moi: ");
            int age = Integer.parseInt(sc.nextLine());

            x.setName(name);
            x.setAge(age);

            System.out.println("Da sua nhan su.");
        } else {
            System.out.println("Khong tim thay nhan su can sua!");
        }
    }

    @Override
    public void Delete(String ID) {
        nhansu x = Search(ID);
        if (x != null) {
            list.remove(x);
            nhansu.giamCount();
            System.out.println("Da xoa nhan su. Tong nhan su: " + nhansu.getCount());
        } else {
            System.out.println("Khong tim thay nhan su!");
        }
    }

    @Override
    public nhansu Search(String ID) {
        for (nhansu x : list) {
            if (x.getID().equals(ID)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public void View() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
        } else {
            System.out.println("____DANH SANH NHAN SU____");
            for (nhansu x : list) {
                System.out.println(x);
            }
            System.out.println("Tong nhan su: " + nhansu.getCount());
        }
    }

    private void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] t = line.split(",");
                if (t.length < 3) {
                    continue;
                }

                String id = t[0];
                String name = t[1];
                int age = Integer.parseInt(t[2]);
                list.add(new nhanvien(id, name, age, 0, 1));
            }
        } catch (IOException e) {
            System.out.println("Khong tim thay file, se tao moi khi thoat.");
        }
    }

    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (nhansu x : list) {
                bw.write(x.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void thongKe() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        int countNhanVien = 0;
        int countQuanLy = 0;

        nhansu nguoiLonTuoiNhat = list.get(0);
        nhanvien nhanVienLuongCaoNhat = null;
        quanly quanLyLuongCaoNhat = null;
        double maxLuongNV = Double.MIN_VALUE;
        double maxLuongQL = Double.MIN_VALUE;

        for (nhansu x : list) {
            if (x instanceof nhanvien) {
                countNhanVien++;
                double luong = x.tinhLuong();
                if (luong > maxLuongNV) {
                    maxLuongNV = luong;
                    nhanVienLuongCaoNhat = (nhanvien) x;
                }
            } else if (x instanceof quanly) {
                countQuanLy++;
                double luong = x.tinhLuong();
                if (luong > maxLuongQL) {
                    maxLuongQL = luong;
                    quanLyLuongCaoNhat = (quanly) x;
                }
            }

            if (x.getAge() > nguoiLonTuoiNhat.getAge()) {
                nguoiLonTuoiNhat = x;
            }
        }

        System.out.println("____THONG KE____");
        System.out.println("So luong nhan vien: " + countNhanVien);
        System.out.println("So luong quan ly: " + countQuanLy);
        System.out.println("Nguoi lon tuoi nhat: " + nguoiLonTuoiNhat.getName() + " (" + nguoiLonTuoiNhat.getAge() + " tuoi)");

        if (nhanVienLuongCaoNhat != null) {
            System.out.println("Nhan vien luong cao nhat: " + nhanVienLuongCaoNhat.getName() + " (" + nhanVienLuongCaoNhat.tinhLuong() + ")");
        } else {
            System.out.println("KHONG co nhan vien.");
        }

        if (quanLyLuongCaoNhat != null) {
            System.out.println("Quan ly luong cao nhat: " + quanLyLuongCaoNhat.getName() + " (" + quanLyLuongCaoNhat.tinhLuong() + ")");
        } else {
            System.out.println("KHONG co quan ly.");
        }
    }

}
