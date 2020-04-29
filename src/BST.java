/** Modified Class for Binary Search Tree objects
* @author https://www.sanfoundry.com/java-program-implement-binary-search-tree/
*/

import java.util.Scanner;

/** Class for the Binary Search Tree*/
public class BST
 {
     /** Node of BST */
     public BSTNode root;
     /** count insertion operations */
     public static int insertCount;
     /** Count search operations */
     public static int searchCount;

     /** Constructor */
     public BST()
     {
         root = null;
     }
     /** Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /** Functions to insert data */
     public void insert(LSItems data)
     {
         insertCount = 0;
         root = insert(root, data);
     }
     /** Function to insert data recursively */
     private BSTNode insert(BSTNode node, LSItems data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data.getInformation().compareTo((node.getData()).getInformation()) <= 0){
                 insertCount ++;
                 node.left = insert(node.left, data);
             }
             else {
                 insertCount++;
                 node.right = insert(node.right, data);
             }
         }
         return node;
     }
     
      /*public void insert(LSItems id){
  		BSTNode newNode = new BSTNode(id);
      insertCount = 0;
      // insertCounter++;
  		if(root==null){
  			root = newNode;
  			return;
  		}
  		BSTNode current = root;
  		BSTNode parent = null;
  		while(true){
  			parent = current;
        insertCount++;
  			if(id.getInformation().compareTo((current.getData()).getInformation()) < 0){ //(id.getInformation().compareTo((current.getData()).getInformation()) < 0)
  				current = current.left;
          // insertCounter++;
  				if(current==null){
  					parent.left = newNode;
  					return;
  				}
  			}else{
  				current = current.right;
          // insertCounter++;
  				if(current==null){
  					parent.right = newNode;
  					return;
  				}
  			}
  		}
  	} */

     /* Functions to search for an element */
   /*  public LSItems search(String val)
     {
         return search(root, val);
     }
     /* Function to search for an element recursively */
     /*private LSItems search(BSTNode r, String val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             String rval = (r.getData()).getInformation();
             if (val.compareTo(rval) < 0)
                 r = r.getLeft();
             else if (val.compareTo(rval) > 0)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;


     }  */

     /** Function to search for an element.
     */
      public LSItems search(String info){
      searchCount = 0;
  		BSTNode current = root;
  		while(current!=null){
         searchCount++;
         //System.out.println(current.data.getInformation());
  			if(current.data.getInformation().equals(info)){
            
  				return current.data;
  			}else if(current.data.getInformation().compareTo(info)>0){
  				current = current.left;
  			}else{
  				current = current.right;
  			}
  		}
  		return null;
  	} 
   


    /** Function for inorder traversal
    */
    public void inorder(BSTNode root) {
      if (root != null) {
         inorder(root.left);
         System.out.println(root.data);
         inorder(root.right);
      }
    }
 }


 /** Class BSTNode */
 class BSTNode
 {
     BSTNode left, right;
     LSItems data;


     /** Constructor */
     public BSTNode(LSItems n)
     {
         left = null;
         right = null;
         data = n;
     }
     /** Function to set left node */
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     /** Function to set right node */
     public void setRight(BSTNode n)
     {
         right = n;
     }
     /** Function to get left node */
     public BSTNode getLeft()
     {
         return left;
     }
     /** Function to get right node */
     public BSTNode getRight()
     {
         return right;
     }
     /** Function to set data to node */
     public void setData(LSItems d)
     {
         data = d;
     }
     /** Function to get data from node */
     public LSItems getData()
     {
         return data;
     }
 }

 /* Class BST */
