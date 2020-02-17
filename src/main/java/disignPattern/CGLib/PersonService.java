package disignPattern.CGLib;


public class PersonService {

    public PersonService() {
        System.out.println("Person Service 构造函数");
    }

    //定义为final的无法被子类覆盖
    final public Object getPerson(String code) {
        System.out.println("Person Service get person : " + code);
        return null;
    }

    public void setPerson() {
        System.out.println("Person Service set person ----");
    }

}
