import java.util.ArrayList;

public class permutationsString
{
   public String stringSet;
   public ArrayList<String> stringsList;
      
   public permutationsString()
   {
      this.stringSet = "";
      this.stringsList = new ArrayList<String>();
   }
   public permutationsString(String in)
   {
      this.stringSet = in;
      this.stringsList = new ArrayList<String>();
   }
   
   public void permute()
   {
      permute(stringSet, "");
   }
   
   public void permute(String in, String out)
   {
      if(in.length() == 0)
      {
         stringsList.add(out);
         return;
      }
      
      for(int i = 0; i < in.length(); i++)
      {
         char ch = in.charAt(i);
         String left = in.substring(0,i);
         String right = in.substring(i + 1);
         String combined = left + right;
         permute(combined, out + combined);
      }
   }
}