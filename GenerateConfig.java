public class GenerateConfig
{
   public static void main(String args[])
   {
      int dieSides = 4;
      int dieCount = 4;
      Configuration config = new Configuration(dieCount,dieSides);
      int[] seriesA = new int[dieCount];
      for(int i = 1; i <= dieCount; i++)
         seriesA[i - 1] = i;
      int currentIndex = 0;
      while(currentIndex < dieSides)
      {
         int[] seriesB = config.getPermutation(currentIndex);
         for(int i = 0; i < dieCount; i++)
            seriesB[i] = seriesB[i] + i;
      
         config.setPermutation(currentIndex, seriesB);
         currentIndex++;
      }
      System.out.println(config);
   }
   
}