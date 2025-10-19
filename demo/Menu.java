package demo;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public Menu() {
        int choice;
        QLNS st = new QLNS();

        do {
            System.out.println("_____MENU_____");
            System.out.println("1. Them nhan su");
            System.out.println("2. Sua nhan su");
            System.out.println("3. Xoa nhan su");
            System.out.println("4. Tim nhan su");
            System.out.println("5. In bang nhan su");
            System.out.println("6. Thong ke");
            System.out.println("7. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> st.Add();
                case 2 -> {
                    System.out.print("Nhap ID: ");
                    st.Edit(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Nhap ID: ");
                    st.Delete(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Nhap ID: ");
                    nhansu x = st.Search(sc.nextLine());
                    if (x != null) System.out.println(x);
                    else System.out.println("Khong tim thay");
                }
                case 5 -> st.View();
                case 6 -> st.thongKe();
                case 7 -> {
                    System.out.println("Dang luu file...");
                    st.ghiFile();
                    System.out.println("Thoat chuong trinh!");
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 7);
    }
}
