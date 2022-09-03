import java.util.ArrayList;

public class TestPermutations {
    public static void main(String[] args)
    {
        System.out.println("input array test");
        int[] testArray = {0, 1, 2, 3, 4, 5,};
        Permutations testArrayInput = new Permutations(testArray);
        for(int i = 0; i < testArrayInput.numbers.length; i++)
        {
            System.out.println(testArrayInput.numbers[i] + 1);
        }

        System.out.println("input arraylist test");
        ArrayList<Integer> tali = new ArrayList<>();
        for(int i = 0; i < 6; i++)
        {
            tali.add(i);
        }

        Permutations testArrayListInput = new Permutations(tali);
        for(int i = 0; i < testArrayListInput.numbers.length; i++)
        {
            System.out.println(testArrayListInput.numbers[i] + 1);
        }


        System.out.println("Initiator test");
        Permutations testIntInitiator = new Permutations(6);
        for(int i = 0; i < testIntInitiator.numbers.length; i++)
        {
            System.out.println(testIntInitiator.numbers[i] + 1);
        }
    }
}
