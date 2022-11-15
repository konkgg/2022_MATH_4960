import java.util.ArrayList;

public class Permutation
{
    //Fields
    protected int[] numbers;

    //Constructors
    public Permutation(int[] numbers)
    {
        this.numbers = numbers;
    }
    public Permutation(ArrayList<Integer> inputList)
    {
        numbers = new int[inputList.size()];

        for(int i = 0; i < inputList.size(); i++)
        {
            numbers[i] = inputList.get(i);
        }
    }
    public Permutation(int initiator)
    {
        numbers = new int[initiator];

        for (int i = 0; i < initiator; i++) {
            numbers[i] = i;
        }
    }
    public int[] getNumbers()
    {
        return numbers;
    }
    public int getNumber(int index)
    {
        return numbers[index];
    }
    public void setNumbers(int[] numbers)
    {
        this.numbers = numbers;
    }
    public void setNumber(int index, int num)
    {
        numbers[index] = num;
    }

}