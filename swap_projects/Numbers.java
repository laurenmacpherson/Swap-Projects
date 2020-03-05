public class Numbers
{
   /**
      Computes the number of even and odd values in a given array
      @param values an array of integer values
      @return an array of length 2 whose 0 entry contains the count
      of even elements and whose 1 entry contains the count of odd
      values
   */
   public static int[] evenOdds(int[] values)
   {
      int [] count = {0,0};
      for (int current: values)
      {
          if (current % 2 == 0) //even
          {
              count[0]++;
          }
      }
      count[1] = values.length - count[0];
      return count; 
   }
}
