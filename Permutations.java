import java.util.ArrayList;

public class Permutations
{
    //Fields
    protected int[] numbers;

    //Constructors
    public Permutations(int[] numbers)
    {
        this.numbers = numbers;
    }
    public Permutations(ArrayList<Integer> inputList)
    {
        numbers = new int[inputList.size()];

        for(int i = 0; i < inputList.size(); i++)
        {
            numbers[i] = inputList.get(i);
        }
    }
    public Permutations(int initiator)
    {
        numbers = new int[initiator];

        for (int i = 0; i < initiator; i++) {
            numbers[i] = i;
        }
    }

}