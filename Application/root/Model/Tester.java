package Model;

public class Tester {
    public static void main(String[] args) {
        Commercial a = new Commercial();
        System.out.println(a.getEndDate().getDay());
        System.out.println(a.getEndDate().getMonth());
        System.out.println(a.getEndDate().getYear());


    }
}
