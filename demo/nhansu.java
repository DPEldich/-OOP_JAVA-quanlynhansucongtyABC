package demo;

public abstract class nhansu {

    private String ID;
    private String name;
    private int age;
    private static int count = 0;

    public nhansu(String ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        count++;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double tinhLuong();

    @Override
    public String toString() {
        return ID + "," + name + "," + age;
    }

    public static int getCount() {
        return count;
    }

    public static void giamCount() {
        if (count > 0) {
            count--;
        }
    }
}
