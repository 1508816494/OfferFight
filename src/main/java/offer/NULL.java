package offer;

public class NULL {
    private int a = 9;
    public static void haha() {
        System.out.println("haha");
    }
    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        ((NULL)null).haha();
//        System.out.println(((NULL)null).getA());
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1 == str2);
    }

}
