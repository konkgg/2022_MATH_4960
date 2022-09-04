import java.util.ArrayList;

public class TestPermutations {
    public static void main(String[] args)
    {
        // input array test
        int[] testArray = {0, 1, 2, 3, 4, 5};
        Permutations testArrayInput = new Permutations(testArray);
        // ArrayList Test
        ArrayList<Integer> tali = new ArrayList<>();
        for(int i = 0; i < 6; i++)
        {
            tali.add(i);
        }
        Permutations testArrayListInput = new Permutations(tali);

        // Initiator Test
        Permutations testIntInitiator = new Permutations(6);

        for(int i = 0; i < 6; i++)
        {
            if(i < testArrayInput.numbers.length)
            {
                System.out.println("ArrayInput : " + testArrayInput.numbers[i]);
            }
            if(i < testArrayListInput.numbers.length)
            {
                System.out.println("ArrayList : " + testArrayListInput.numbers[i]);
            }
            if(i < testIntInitiator.numbers.length)
            {
                System.out.println(String.format("Initiator : %d", testIntInitiator.numbers[i] + 1));
            }
        }
    }
}
