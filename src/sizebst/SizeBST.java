package sizebst;

/**
 * Class SizeBST represents a Binary Search Tree that can also be used, for any integer j,
 *  to answer the question "how many numbers in the tree are less than or equal to j" in worst 
 *  case time h where h is the height of the tree (not the number of nodes).
 * 
 *  The actual nodes of the tree are of class SizeBSTN.  SizeBST represents the overall tree.
 *  IF instance variable rootNode is null, the tree is empty, otherwise rootNode is the root
 *  of the tree of SizeBSTN's
 * @author lou
 *
 */
public class SizeBST 
{
	SizeBSTN rootNode;

	public SizeBST(SizeBSTN root)
	{
		rootNode =  root;
	}
	
	public String toString()
	{
		if (rootNode == null)
			return "(null)";
		else 
		{
			return "("+ rootNode.toString() + ")";
		}
	}
	
	/**
	 * @param target the number to search for
	 * @return true if target is in this tree
	 */
	public boolean search(int target)
	{
		if(this.rootNode == null)
            return false;   
		else if(target == this.rootNode.data)
            return true;   
		else if(target < this.rootNode.data)
		{
            rootNode = this.rootNode.LSubtree;
            search(target);
		}
		else if(target > this.rootNode.data)
		{
            rootNode = this.rootNode.RSubtree;
            search(target);
		}
		return false;
	}
	
	/**
	 * insert newData into tree;  if already there, do not change tree
	 * @param newData int to insert
	 */
	public void insert(int newData)
	{
		SizeBSTN newNode = new SizeBSTN(newData);
	    if (rootNode == null)
	    	rootNode = newNode;
	    SizeBSTN currentNode = rootNode.getNode(newData);
	    if (rootNode != null)
	    {	
    		if (currentNode.data > newData && currentNode.LSubtree == null)
    			currentNode.LSubtree = newNode;
    		else if (currentNode.data < newData && currentNode.RSubtree == null)
				currentNode.RSubtree = newNode;
	    }
	}          
	
	/**
	 * @return returns how many numbers in the tree are less than or equal to target.  Returns -1 if tree is empty
	 * @param target
	 */
	public int numLEq(int target)
	{
		int count = 0;
		SizeBSTN place = rootNode;
		if(place == null)
			count = -1; 
		while(place != null)
		{
			if(place.data <= target)
			{
				count += place.size;
				place = place.RSubtree;
			}
			else
				place = place.LSubtree;				
		}
		return count;
	}
	public static void main(String args [])
	{
		SizeBST tree1 = new SizeBST(null);
		System.out.println("empty: "+tree1);
		tree1.insert(40);
		System.out.println("40 "+tree1);
		// add any test code you want here - this is not graded
	}
}