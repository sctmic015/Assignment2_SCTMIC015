/** implementation of a AVL Tree
* @author https://www.sanfoundry.com/java-program-implement-avl-tree/
*/

import java.util.Scanner;

/* Class AVLNode */
class AVLNode
{

  AVLNode left, right;
  LSItems data;
  int height;

  /* Constructor */
  public AVLNode()
  {
    this.left = null;
    this.right = null;
    this.data = null;
    this.height = 0;
  }
  /* Constructor */
  public AVLNode(LSItems n)
  {
     this.left = null;
     this.right = null;
     this.data = n;
     this.height = 0;
   }
   
   public LSItems getData()
     {
         return data;
     }

}

/* Class AVLTree */
 public class AVLTree
 {
     public AVLNode root;
     public int insertCount = 0;
     public int searchCount;

     /* Constructor */
     public AVLTree()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         root = null;
     }
     /* Function to insert data */
     public void insert(LSItems data)
     {
         insertCount=0;
         root = insert(data, root);
     }
     /* Function to get height of node */
     private int height(AVLNode t )
     {
         return t == null ? -1 : t.height;
     }
     /* Function to max of left/right node */
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     /* Function to insert data recursively */
     private AVLNode insert(LSItems x, AVLNode t)
     {
         if (t == null)
             t = new AVLNode(x);
         else if (x.getInformation().compareTo((t.getData()).getInformation()) < 0) //(x.compareTo(t.data)<0)
         {
             t.left = insert(x, t.left );
             insertCount++;
             if( height( t.left ) - height( t.right ) == 2 ){
                 insertCount++;
                 if (x.getInformation().compareTo((t.left.getData()).getInformation()) < 0) 
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
              }
         }
         else if (x.getInformation().compareTo((t.getData()).getInformation()) > 0)
         {
             insertCount++;
             t.right = insert( x, t.right );
             // insertCounter++;
             if( height( t.right ) - height( t.left ) == 2 ){
                 insertCount++;
                 if(x.getInformation().compareTo((t.right.getData()).getInformation()) > 0)
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
             }
         }
         else
           ;  // Duplicate; do nothing
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     /* Rotate binary tree node with left child */
     private AVLNode rotateWithLeftChild(AVLNode k2)
     {
         AVLNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }

     /* Rotate binary tree node with right child */
     private AVLNode rotateWithRightChild(AVLNode k1)
     {
         AVLNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
     /**
      * Double rotate binary tree node: first left child
      * with its right child; then node k3 with new left child */
     private AVLNode doubleWithLeftChild(AVLNode k3)
     {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */
     private AVLNode doubleWithRightChild(AVLNode k1)
     {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     private int countNodes(AVLNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
     public LSItems search(String val)
     {
         return search(root, val);
     }
     private LSItems search(AVLNode r, String val)
     {
      boolean found = false;
         searchCount = 0;
         // AVLNode current = root;
         while ((r != null) && !found)
         {
             LSItems rval = r.data;
             searchCount++; // counting comparison operator
             if (val.compareTo(rval.getInformation()) < 0)
                 r = r.left;
             else if (val.compareTo(rval.getInformation()) > 0)
                 r = r.right;
             else
             {
                 found = true;
                 // break;
                 return r.data;
             }
             // current = search(r, val);
         }
         return null;

     }
     /* Function for inorder traversal */
    /* public void inorder()
     {
         inorder(root);
     }
     private void inorder(AVLNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.data);
             inorder(r.right);
         }
     }*/
     
     public void inorder(AVLNode root) {
      if (root != null) {
         inorder(root.left);
         System.out.println(root.data);
         inorder(root.right);
      }
    }

     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(AVLNode r)
     {
         if (r != null)
         {
             System.out.print(r.data +" ");
             preorder(r.left);
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(AVLNode r)
     {
         if (r != null)
         {
             postorder(r.left);
             postorder(r.right);
             System.out.print(r.data +" ");
         }
     }
 }