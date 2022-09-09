import java.util.ArrayList;

public class TestPermutation {
    public static void main(String[] args)
    {
        // input array test
        int[] testArray = {0, 1, 2, 3, 4, 5};
        Permutation testArrayInput = new Permutation(testArray);
        // ArrayList Test
        ArrayList<Integer> tali = new ArrayList<>();
        for(int i = 0; i < 6; i++)
        {
            tali.add(i);
        }
        Permutation testArrayListInput = new Permutation(tali);

        // Initiator Test
        Permutation testIntInitiator = new Permutation(6);

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
