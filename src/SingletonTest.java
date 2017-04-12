/**
 * Created by Saurav on 10-04-2017.
 */
public class SingletonTest {

    private static SingletonTest singletonTest;

    public static SingletonTest getSingletonTest() {
        if (null == singletonTest){
            synchronized (SingletonTest.class){
                singletonTest = new SingletonTest();
            }
        }
        return singletonTest;
    }

    public static void main(String[] args) {
        System.out.println(getSingletonTest());
    }
}
