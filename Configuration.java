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
                sb.append(permutations[i].numbers[k] + 1);
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
