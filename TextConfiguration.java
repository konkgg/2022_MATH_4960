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
        System.out.println(ConfigA.rowSumIsEqual());
        System.out.println(ConfigA);
        */
        

        Configuration ConfigA = new Configuration("ConfigA.csv");
        System.out.println(ConfigA);
        ConfigA.FileOutputMethod();
        ConfigA.sorted();
        Configuration ConfigB = new Configuration("ConfigB.csv");
        System.out.println(ConfigB);
        ConfigB.FileOutputMethod();
    }
}
