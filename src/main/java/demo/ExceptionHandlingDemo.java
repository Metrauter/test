package demo;

public class ExceptionHandlingDemo {
    public static void main(String[] args) throws Exception {

        demo();
        demo1();

    }

    public static void demo() {
        try {
            System.out.println("Hello World");
            int i = 1 / 0;
            System.out.println("Completed");
        } catch (Exception exp) {
            System.out.println("I am inside catch block");
            System.out.println("Message is : " + exp.getMessage());
            System.out.println("Cause is : " + exp.getCause());
            exp.printStackTrace();
        } finally {
            System.out.println("I am inside finally block");
        }
    }

    public static void demo1() throws Exception {

        System.out.println("Hello World");
        int i = 1 / 0;
        System.out.println("Completed");

    }
}