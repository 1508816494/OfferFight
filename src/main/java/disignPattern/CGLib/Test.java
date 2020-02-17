package disignPattern.CGLib;

import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new CGLibProxyInterceptor());
        PersonService proxy = (PersonService) enhancer.create();
        proxy.setPerson();
        proxy.getPerson("yyt");
    }
}
