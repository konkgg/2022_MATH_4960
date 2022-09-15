import java.util.Scanner;

public class TextConfiguration
{
    public static void main(String[] args)
    {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of die");
        int dieCount = scanner.nextInt();
        System.out.println("Enter Number of sides");
        int dieSides = scanner.nextInt();

        Configuration ConfigA = new Configuration(dieCount,dieSides);

        System.out.println(ConfigA);

         */

        Configuration ConfigA = new Configuration(4,6);
        Configuration ConfigB = new Configuration(20,6);
        System.out.println(ConfigA);
        System.out.println(ConfigB);
    }
}
