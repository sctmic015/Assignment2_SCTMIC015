/** LSAVLApp for sorting LSItems into an AVL tree *
* @author SCTMIC015
*/

import java.util.*;
import java.io.*;

public class LSAVLApp {
  private static AVLTree tree;
  //private static int searchCount = 0;
 // private static int insertCount = 0;

  public static void main(String[] args) throws IOException {
    File file = new File("boobies.txt");

    tree = new AVLTree();
    Scanner scan;

    try {
         scan = new Scanner(file);
         int count = 0;
         while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] splitString = splitString(line);
            //System.out.println(Arrays.toString(splitString));
            LSItems lsItem = new LSItems(splitString[0], splitString[1]);
            tree.insert(lsItem);
            System.out.println(tree.insertCount);
            count++;
         }
         scan.close();
      }
      catch(FileNotFoundException e) {
         throw new RuntimeException(e);
      }

      if (args.length != 0) {
         printAreas(args[0]);
            try {
               writeOperationsToTxt(args[0], tree.searchCount);
            }
            catch(FileNotFoundException e) {
               throw new RuntimeException(e);
            }
      }
      else {
         printAllAreas();
      }

  }
  /** Method to split each line in the file so that it can be read into the Array
   */
   public static String[] splitString(String str) {
      String line = str.trim();
      String info = "";
      String areas = "";
      for (int i = 0; i < line.length(); i ++) {
         if (i <= 6)
            info += line.charAt(i);
         else
            areas += line.charAt(i);
      }
      info = info.trim();
      areas = areas.trim();
      String[] splitString = new String[]{info, areas};
      return splitString;
   }

   /** Method to print out the Areas of the given the corresponding date, stage and start time.
   * Returns Areas not found if there is no match
   * @param String information String value for the stage, day and time queried.
   */
   public static void printAreas(String information) {
      LSItems searchLS = tree.search(information);
      if (searchLS != null)
         System.out.println(searchLS);
      else
         System.out.println("information not found");
    }

    /** Method to print out all the "day, stage and start time" and their corresponding areas via an inorder traversal of the tree
   */
   public static void printAllAreas() {
      tree.inorder(tree.root);
    }

    /** Method that writes the number of operations used to find an area when given the corresponding stage, day and start time.
     * @throws IOException if fails to write the paramters to file
     * @param String information String value for the stage, day and time queried.
     * @param int opCount int value for number of operations used
     */
     public static void writeOperationsToTxt(String information, int searchCount) throws IOException{
       FileWriter fw = null;
       BufferedWriter bw = null;
       PrintWriter pw = null;

       try {
           fw = new FileWriter("opCountTree2.txt", true);
           bw = new BufferedWriter(fw);
           pw = new PrintWriter(bw);

           pw.println("Data Structure: Tree" + '\n' + "Stage, date and start time tested: "
               + information + '\n' + "Operations counted: "
               + Integer.toString(searchCount) + '\n');
           pw.flush();

       } finally {
           try {
               pw.close();
               bw.close();
               fw.close();
           } catch (IOException io) {// can't do anything }
           }

       }

     }


}
