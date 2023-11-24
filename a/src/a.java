import java.util.Arrays;

public class a {
    public static void main(String[] args) {
        String a = String.valueOf(java.time.LocalDate.now());
        System.out.println(a);
        String[] temp = a.split("-");
        System.out.println(Arrays.toString(temp));
    }
}
