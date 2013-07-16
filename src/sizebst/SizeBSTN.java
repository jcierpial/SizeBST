package sizebst;

/**
 * Instances of class SizeBSTN are Nodes of the Size Binary Search Tree 
 * @author lou
 *
 */
public class SizeBSTN 
{
	SizeBSTN LSubtree;  // left subtree of this tree (may be null)
	SizeBSTN RSubtree;  // right subtree of this tree (may be null)
	int data; // data at this node of the tree
	int size; // number of tree entries that are less than or equal to data

/**
 * create a new leaf of the tree with the given data
 * @param data
 */
	public SizeBSTN(int data)
	{
		LSubtree = null;
		RSubtree = null;
		this.data = data;
		size = 1;
	}
	
	/* see assignment for proper format for toString
	 */
	public String toString()
	{
		String node = "";
		String LSide = "";
		String RSide = "";
		if(LSubtree == null)
			LSide = null;
		else
			LSide =  LSubtree.toString();
		if(RSubtree == null)
			RSide = null;
		else
			RSide = RSubtree.toString();
		node = "[" + LSide + " " + data + "," + size + " " + RSide + "]";
		return node;
	}
	
	/**
	 * search for the number target in this tree
	 * @param target number to search for
	 * @return either the node that holds target,
	 * if there is one, or the node which should point to the node that 
	 * will hold target if it is added now  
	 */
	 public SizeBSTN getNode(int target)
	 {
         SizeBSTN place = this;
         while (true)
         {
        	 if (target == place.data)
        		 return place;
             else if (target < place.data) 
             {
            	 if (place.LSubtree == null)
            	 {
            		 place.size++;
            		 return place;
            	 }
                 else 
                 {
                	 place.size++;
                	 place = place.LSubtree;
                 }
             }
             else if (target > place.data)
             {
            	 if (place.RSubtree == null)
            		 return place;
                 else 
                     place = place.RSubtree;
             }
         }
	 }
	
	/**
	 * like getNode but increments size fields as appropriate
	 * @param target number to search for
	 */
	 public void getNodeIncr(int target)
	 {
	     if (target < this.data && this.LSubtree == null) 
	         this.size++;
	     if (target < this.data && this.LSubtree != null)
	     {
	    	 this.LSubtree.size++;
	         this.LSubtree.getNodeIncr(target);
	     }
	     if (target > this.data && this.RSubtree != null)
	    	 this.RSubtree.getNodeIncr(target); 
	 }
	
	/**
	 * actually calculates number of numbers <= target.  
	 * Does search for target like getNode but adds up 
	 * the size fields of all nodes whose data is <= target.
	 * @return the number of nodes in this tree with data <= target
	 */
	 public int getNodeSum(int target)
	 {
		 int count = 0;
		 SizeBSTN place = this;
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
}	