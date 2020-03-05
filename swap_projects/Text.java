/**
 * Performs word duplicate removal in a string
 *
 * @author Lauren MacPherson, Wyatt Wisuri 
 * @version Dec 2019
 */
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Text
{
   private ArrayList<String> words;
    /**
     * Constructor for Text object
     */
   public Text()
   {
      words = new ArrayList<String>();
   }
    /**
     * Removes only word duplicates that are directly next to each other
     */
   public void removeAdjacentDuplicates()
   {
      for (int i = 0; i <= words.size()-2; i++)
      {
          String current = words.get(i);
          String next = words.get(i+1);
          if (current.equalsIgnoreCase(next))
          {
              words.remove(i);
              if (i <= words.size()-2)
              {
                  current = words.get(i);
                  next = words.get(i+1);
                  if (current.equalsIgnoreCase(next))
                  {
                      words.remove(i);
                  }
              }
          }
      } 
   }
   /**
     * Remove all duplicated words in the string
     */
   public void removeAllDuplicates()
   {
      for (int i = 0; i <= words.size()-1; i++)
      {
          String current = words.get(i);
          for (int k = i+1; k <= words.size()-1; k++)
          {
              if (current.equals(words.get(k)))
              {
                  words.remove(k);
                  if (k <= words.size()-1)
                  {
                      if (current.equals(words.get(k)))
                      {
                          words.remove(k);
                      }
                  }
              }
          }
          current = words.get(i);
          for (int k = i+1; k <= words.size()-1; k++)
          {
              if (current.equals(words.get(k)))
              {
                  words.remove(k);
                  if (k <= words.size()-1)
                  {
                      if (current.equals(words.get(k)))
                      {
                          words.remove(k);
                      }
                  }
              }
          }
      } 
   }

   /**
      Gets the words from this text.
      @return an array list containing the words
   */
   public ArrayList<String> getWords()
   {
      return words;
   }

   // Code below provided by professor 

   /**
      Lets the user pick a file for loading
   */
   public void pick()
   {
      JFileChooser chooser = new JFileChooser(".");
      if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
      {
         load(chooser.getSelectedFile().getAbsolutePath());
      }
   }   
   
   /**
      Loads a file.
      @param source a URL or file name
   */
   public boolean load(String source)
   {
      if (source == null) return false;
      try
      {
         Scanner in;
         if (source.startsWith("http://"))
         {
            in = new Scanner(new URL(source).openStream());
         }
         else
         {
            in = new Scanner(new FileReader(source));
         }
         in.useDelimiter("[^\\p{L}]");
         words = new ArrayList<String>();
         while (in.hasNext())
         {
            String word = in.next();
            if (word.length() > 0)
               words.add(word);
         }
         return true;
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
         return false;
      }
   }

   /**
      Displays the words in a text area
   */
   public void explore()
   {
      JTextArea area = new JTextArea(20, 40);
      JScrollPane scroll = new JScrollPane(area);
      for (String word : words)
         area.append(word + "\n");
      JOptionPane.showMessageDialog(null, scroll);    
   }
}
