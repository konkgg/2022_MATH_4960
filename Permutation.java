import java.util.ArrayList;

public class Permutation
{
    //Fields
    protected int[] numbers;
    protected int numbersSum;

    //Constructors
    public Permutation(int[] numbers)
    {
        this.numbers = numbers;
        for(int i = 0; i < numbers.length; i++)
            numbersSum += numbers[i];
    }
    public Permutation(ArrayList<Integer> inputList)
    {
        numbers = new int[inputList.size()];

        for(int i = 0; i < inputList.size(); i++)
        {
            numbers[i] = inputList.get(i);
            numbersSum += numbers[i];
        }
        
    }
    public Permutation(int initiator)
    {
        numbers = new int[initiator];

        for (int i = 0; i < initiator; i++) {
            numbers[i] = i;
            numbersSum += numbers[i];
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
        numbersSum = 0;
        for(int i = 0; i < numbers.length; i++)
            numbersSum += numbers[i];
    }
    public void setNumber(int index, int num)
    {
        numbersSum -= numbers[index];
        numbers[index] = num;
        numbersSum += num;
    }

}