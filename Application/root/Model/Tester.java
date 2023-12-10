package Model;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Tester {
    public static void main(String[] args) {
        Commercial a = new Commercial("bla","bla");
        System.out.println(a.getEndDate().getDay());
        System.out.println(a.getEndDate().getMonth());
        System.out.println(a.getEndDate().getYear());

        try{
            OutputStream outputStream = new FileOutputStream("..\\..\\saves\\main.bin");
        } catch (Exception e){
            System.out.println("error");
        }
    }
}
