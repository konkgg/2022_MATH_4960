import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {
    //Fields
    protected Permutation[] permutations;
    protected int dieCount;
    protected int dieSides;

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
                  permutations[lineNumber].numbers[i] = Integer.parseInt(parts[i]);
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

        for(int i = 0; i < permutations.length; i++)
        {
            sb.append(String.format("%n Die %d: ",(i + 1)));
            for(int k = 0; k < permutations[i].numbers.length; k++)
            {
                sb.append("\t");
                sb.append(permutations[i].numbers[k]);
            }

        }
        return sb.toString();
    }

    //toString
    @Override
    public String toString()
    {
        return String.format(DisplayMethod());
    }

}
