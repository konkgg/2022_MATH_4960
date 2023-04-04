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
   public permutationsString(String out)
   {
      this.stringSet = out;
      this.stringsList = new ArrayList<String>();
   }
   
   public void permute()
   {
      permute("", stringSet);
   }
   
   public void permute(String in, String out)
   {
      if(out.length() == 0)
      {
         stringsList.add(in);
      }
      else
      {
      for(int i = 0; i < out.length(); i++)
      {
         String left = in + out.charAt(i);
         String right = out.substring(0, i) + out.substring(i + 1);
         permute(left, right);
      }
      }
   }
}
