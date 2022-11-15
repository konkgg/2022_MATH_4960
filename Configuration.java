import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Configuration {
    //Fields
    protected Permutation[] permutations;
    protected int dieCount;
    protected int dieSides;
    protected String fileName;

    //Constructors
    public Configuration()
    {
        dieCount = 30;
        dieSides = 6;
        permutations = new Permutation[dieCount];
        for(int i = 0; i < permutations.length; i++)
        {
            permutations[i] = new Permutation(dieSides);
        }
    }
    //Configuration object from file
    //Current implementation seems moderately shitty
    public Configuration(String fileName)
    {
        this.fileName = fileName;
        //Find number of die or number of lines within csv file
        this.dieCount = 0; // linecount or diecount
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
        {
          while (reader.readLine() != null)
          {
            this.dieCount++; // add one to lineCount or dieCount
          }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        //Read file and generate permutations based on the value stored
        //Find way of setting dieSides accurately a single time and compare the dieSides to the number of values in a line and close the program if they don't
        try(FileReader fr = new FileReader(fileName);
          BufferedReader in = new BufferedReader(fr))
        {
            String line = in.readLine();
            int lineNumber = 0;
            permutations = new Permutation[dieCount];
            while(line != null)
            {
                String[] parts = line.split(",");
                this.dieSides = parts.length;
                permutations[lineNumber] = new Permutation(dieSides);
                for(int i = 0; i < parts.length; i++)
                {
                  permutations[lineNumber].numbers[i] = (Integer.parseInt(parts[i]) - 1);
                }
                lineNumber++;
                line = in.readLine();
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }    
    }
    public Configuration(Permutation[] config)
    {
        permutations = new Permutation[config.length];
        for(int i = 0; i < permutations.length; i++)
        {
            permutations = config;
        }
        dieCount = permutations.length;
        dieSides = 2;
        System.out.println(String.format("%d, %d",dieCount, dieSides));
    }
    public Configuration(int dieCount, int dieSides)
    {
            this.dieCount = dieCount;
            this.dieSides = dieSides;
            permutations = new Permutation[dieCount];
            for (int i = 0; i < permutations.length; i++) {
                permutations[i] = new Permutation(dieSides);
            }
        }

    //get and set Methods
    public Permutation[] getPermutations()
    {
        return permutations;
    }
    public void setPermutations(Permutation[] permutations)
    {
        this.permutations = permutations;
    }


    //Display Method
    public String DisplayMethod()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Permutation\t");
        for(int i = 0; i < dieSides; i++)
        {
            sb.append(String.format("P%d\t",i + 1));
        }
        sb.append(String.format("Sides Total: %d", getTotalSides()));

        for(int i = 0; i < permutations.length; i++)
        {
            sb.append(String.format("%n Die %d: ",(i + 1)));
            for(int k = 0; k < permutations[i].numbers.length; k++)
            {
                sb.append("\t");
                sb.append(permutations[i].numbers[k] + 1);
            }
            sb.append("\t");
            sb.append(String.format("RowSum: %d \t", getRowSum(i)));
            sb.append(String.format("RowSqaureSum: %.1f \t", getRowSquareSum(i)));
            sb.append(String.format("RowInvertCount: %d", getDieInversions(i)));

        }
        sb.append("\n ColumnSum");
        for(int i = 0; i < dieSides; i++)
        {
            sb.append(String.format("\t%d",getColumn(i)));
        }
        sb.append("\n InverCount");
        for(int i = 0; i < dieSides; i++)
        {
            sb.append(String.format("\t%d",getPermutationInversions(i)));
        }
        return sb.toString();
    }

    public void SaveConfigMethod(String name)
    {
        String dataSet = new String();
        for(int i = 0; i < permutations.length; i++)
        {
            for(int k = 0; k < permutations[i].numbers.length; k++)
                {
                    dataSet += (permutations[i].numbers[k] + 1) + ",";
                }
            if(i<permutations.length-1)
               dataSet += "\n";
        }
        try(FileWriter wr = new FileWriter(name);
        BufferedWriter out = new BufferedWriter(wr))
        {
            out.write(dataSet);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }    
        
    }

    // Maybe we should make a file name that matches the input file so that we can run many data sets for analysis
    public void FileOutputMethod()
    {
        try(FileWriter wr = new FileWriter(fileName + " output.txt");
        BufferedWriter out = new BufferedWriter(wr))
        {
            out.write(DisplayMethod());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }    
    }
    /* Math methods
    had to add one to each number due to permutation making pos 0 equal 0 instead of 1 and us just adding one in the display
    */
    public void randomWinner()
    {
        Random r = new Random();
        int[] tempArr = new int[dieCount];
        for(int i = 0; i < dieSides; i++)
        {
            // soon ill make this not require a temp Array and just do everything in the permutations
            //create arr for shuffle
            for(int k = 0; k < dieCount; k++)
            {
            tempArr[k] = i * k;
            }
            //shuffle
            for(int j = tempArr.length -1; j > 0; j--)
            {
            int index = r.nextInt(j);
            int num = tempArr[index];
            tempArr[index] = tempArr[j];
            tempArr[j] = num;
            }
        setPermutation(i,tempArr);
        }

    }

    public int getTotalSides()
    {
        return dieCount * dieSides;
    }

    public int getRowSum(int a)
    {
        int sum = 0;
        for(int i = 0; i < dieSides; i++)
        {
            sum += permutations[a].numbers[i] + 1;
        }
        return sum;
    }

    public double getRowSquareSum(int a)
    {
        double sum = 0;
        for(int i = 0; i < dieSides; i++)
        {
            sum += (permutations[a].numbers[i] + 1) * (permutations[a].numbers[i] + 1);
        }
        return sum;
    }

    public int getColumn(int a)
    {
        int sum = 0;
        for(int i = 0; i < dieCount; i++)
        {
            sum += permutations[i].numbers[a] + 1;
        }

        return sum;
    }
    public int[] getPermutation(int index)
    {
        int[] arr = new int[dieCount];
        for(int i = 0; i < dieCount; i++)
        {
            arr[i] = permutations[index].numbers[i];
        }

        return arr;
    }
    public void setPermutation(int index,int[] arr)
    {
        for(int i = 0; i < dieCount; i++)
        {
            permutations[i].numbers[index] = arr[i];
        }
    }

    //Count inversions using mergeSort class
    public int getDieInversions(int d)
    {
        int inversions = MergeSort.getInversions(permutations[d].numbers);
        MergeSort.resetCount();
        return inversions;

    }
    public int getPermutationInversions(int p)
    {
        int[] CurrentPermutation = new int[dieCount];
        for(int i = 0; i < dieCount; i++)
        {
            CurrentPermutation[i] = permutations[i].numbers[p];
        }
        int inversions = MergeSort.getInversions(CurrentPermutation);
        MergeSort.resetCount();
        return inversions;
    }

    //toString
    @Override
    public String toString()
    {
        return String.format(DisplayMethod());
    }

}
