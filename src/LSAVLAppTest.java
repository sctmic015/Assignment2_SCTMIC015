/** LSBSTAppTest for sorting LSItmes into a tree*
* @author SCTMIC015
*/

import java.io.*;
import java.util.*;

/** Class for the LSAVLAppTest used to test all information from the created subsets */
public class LSAVLAppTest {
   private static AVLTree tree;
   private static int searchCount = 0;
   //private static int insertCount = 0;

   /** Modified main method to take a subset from the command line and to output the searched for data and opCOunt to a csv file
   */

   public static void main(String[] args) throws IOException {
      File file = new File(args[0] +".txt");

      tree = new AVLTree();
      Scanner scan;


      try {
         scan = new Scanner(file);
         int count = 0;
         while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] splitString = splitString(line);
            LSItems lsItem = new LSItems(splitString[0], splitString[1]);
            tree.insert(lsItem);
            //tree.searchCount = 0;
            //tree.search(lsItem.getInformation());
            //System.out.println(tree.insertCount);
            try {
               writeInsertOperationsToCSV(lsItem.getInformation(), tree.insertCount, args[0]);
            }
            catch (IOException e) {
               throw new RuntimeException(e);
            }
         }
         scan.close();
      }
      catch(FileNotFoundException e) {
         throw new RuntimeException(e);
      }
      if (args.length>0) {

         Scanner scan2;

         try{
            scan = new Scanner(file);
            String searchItem;
            while (scan.hasNextLine()){
               String line = scan.nextLine();
               String[] splitString = splitString(line);
               searchItem = splitString[0];
               tree.search(searchItem);
               try {
                  writeOperationsToCSV(searchItem, tree.searchCount, args[0]);
               }
               catch (IOException e) {
                  throw new RuntimeException(e);
               }
         }

      }
         catch(FileNotFoundException e) {
         throw new RuntimeException(e);
         }

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
   * @param information String value for the stage, day and time queried.
   */
   public static void printAreas(String information) {
      LSItems searchLS = tree.search(information);
      if (searchLS != null)
         System.out.println(searchLS);
      else
         System.out.println("information not found");
    }

     /** Method that writes the number of operations used to find an area when given the corresponding stage, day and start time.
     * @throws IOException if fails to write the paramters to file
     * @param information String value for the stage, day and time queried.
     * @param opCount int value for number of operations used
     */
     public static void writeOperationsToTxt(String information, int opCount) throws IOException{
       FileWriter fw = null;
       BufferedWriter bw = null;
       PrintWriter pw = null;

       try {
           fw = new FileWriter("opCountTree", true);
           bw = new BufferedWriter(fw);
           pw = new PrintWriter(bw);

           pw.println("Data Structure: Tree" + '\n' + "Stage, date and start time tested: "
               + information + '\n' + "Operations counted: "
               + Integer.toString(opCount) + '\n');
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


 /** Method to write information to a csv file
 */
     /** Method that writes the search count into a csv file
     * @param information String Value for the stage, day and time queried
     * @param searchCount int value for the value of the operatons we want written into the line of the file.
     * @param filename string value for the file with which we wish to write to.
     */
      public static void writeOperationsToCSV(String information, int searchCount, String filename) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;


        try {
            fw = new FileWriter((filename + "AVLTree.csv"), true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            //pw.println("Data Structure: Array" + '\n' + "Stage, date and start time tested: "
              //  + information + '\n' + "Operations counted: "
                //+ Integer.toString(opCount) + '\n');

            pw.println(information + " , " + Integer.toString(searchCount));
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

      /** Method that writes the insert count into a csv file
        * @param information String Value for the stage, day and time queried
        * @param insertCount int value for the value of the operatons we want written into the line of the file.
        * @param filename string value for the file with which we wish to write to.
        */
 public static void writeInsertOperationsToCSV(String information, int insertCount, String filename) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;


        try {
            fw = new FileWriter((filename + "AVLTreeInsert.csv"), true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            //pw.println("Data Structure: Array" + '\n' + "Stage, date and start time tested: "
              //  + information + '\n' + "Operations counted: "
                //+ Integer.toString(opCount) + '\n');

            pw.println(information + " , " + Integer.toString(insertCount));
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


	/** Method to count num of lines of file passed through terminal
	*/
   public static int lineCounter(String inputFile) throws IOException{
        File file = new File(inputFile);
        Scanner scan = new Scanner(file);
        int count = 0;
        while (scan.hasNextLine()){
          count++;
          System.out.println(scan.nextLine());
        }
        System.out.print(count);
        return count;
      }

}
