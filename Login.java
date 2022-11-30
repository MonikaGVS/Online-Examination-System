import java.util.Scanner;

public class Login {

    public void CreateLoginForm(Object username) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println(" ******************************* ");
            System.out.println("|         LOGIN PAGE             |");
            System.out.println(" ******************************* ");
            System.out.println(" ------------------------------");
            System.out.println("|           username:           |");
            System.out.println(" ------------------------------");
            username = input.next();
            System.out.println("\n");
            System.out.println(" ------------------------------");
            System.out.println("|           password:           |");
            System.out.println(" ------------------------------");
            Object password = input.next();
        }
    
    }
}
