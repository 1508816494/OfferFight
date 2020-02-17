package javabase;

public class EqualExample {

    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        //1.判断是否为同一个引用
        if (this == obj) {
            return true;
        }

        //2.判断是否为同一个类型，不是则直接返回false
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        //3.将object转型
        EqualExample that = (EqualExample) obj;

        //4.判断关键域是否相等  使用==比较基本类型，使用equals()比较引用类型 数组类型可采用Arrays.equals()检测
        if (this.x != that.x) {
            return false;
        }
        return this.y == that.y && this.z == that.z;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }
}
