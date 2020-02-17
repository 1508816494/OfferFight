package offer;

public class Test {

    static {
        System.out.println("blockB");
    }

    public static Test t1 = new Test();



    {
        System.out.println("blockA");
    }



    public static void main(String[] args){
        Test t2=new Test();
    }
}
