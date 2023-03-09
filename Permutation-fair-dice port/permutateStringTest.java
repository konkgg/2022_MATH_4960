public class permutateStringTest
{
   public static void main(String[] args)
   {
      permutationsString string = new permutationsString("ABC");
      
      string.permute();
      System.out.println(string.stringsList);
   }
}