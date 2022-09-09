public class Configuration {
    //Fields
    protected Permutation[] permutations;

    //Constructors
    public Configuration()
    {
        permutations = new Permutation[30];
        for(int i = 0; i < permutations.length; i++)
        {
            permutations[i] = new Permutation(6);
        }
    }
    public Configuration(Permutation[] config)
    {
        permutations = new Permutation[config.length];
        for(int i = 0; i < permutations.length; i++)
        {
            permutations = config;
        }
    }
    public Configuration(int dieCount, int dieSides)
    {
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
        for(int i = 0; i < permutations.length; i++)
        {
            sb.append(String.format("\n Die:%d",(i + 1)));
            for(int k = 0; k < permutations[i].numbers.length; k++)
            {
                sb.append(" ");
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
