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
    public Configuration(Permutation[] config)
    {
        permutations = new Permutation[config.length];
        for(int i = 0; i < permutations.length; i++)
        {
            permutations = config;
        }
        dieCount = permutations.length;
        dieSides = config[0].numbers.length;
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
                sb.append(permutations[i].numbers[k] + 1);
            }
            sb.append("\t");
            sb.append(String.format("RowSum: %d", getRowSum(i)));

        }
        sb.append("\n ColumnSum");
        for(int i = 0; i < dieSides; i++)
        {
            sb.append(String.format("\t%d",getColumn(i)));
        }
        return sb.toString();
    }


    /* Math methods

    had to add one to each number due to permutation making pos 0 equal 0 instead of 1 and us just adding one in the display
    */
    public int getRowSum(int a)
    {
        int sum = 0;
        for(int i = 0; i < dieSides; i++)
        {
            sum += permutations[a].numbers[i] + 1;
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


    //toString
    @Override
    public String toString()
    {
        return String.format(DisplayMethod());
    }

}
