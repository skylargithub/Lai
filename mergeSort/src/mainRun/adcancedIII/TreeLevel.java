package mainRun.adcancedIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import mainRun.util.TreeNode;

public class TreeLevel {
	/*
	 * 	TreeLevel treeLevel = new TreeLevel();
		TreeNode root = treeLevel.reconstruct(new int[]{1,3,4,5,8,11}, new int[]{5,3,8,1,4,11});
	 * */
	
	private HashMap<Integer, Integer> inHash = new HashMap<Integer, Integer>();
	  private int[] in;
	  public TreeNode reconstruct(int[] in, int[] level) {
	    if(in.length == 0 || level.length == 0) return null;
	    // Map<value, index>
	    Integer[] levelList = new Integer[level.length];
	    for(int i=0; i < in.length; i++) {
	      inHash.put(in[i], i);
	      levelList[i] = level[i];
	    }
	    
	    return helper(levelList);
	  }
	  
	  public TreeNode helper(Integer[] level) {
		  if(level.length == 0) return null;
	    TreeNode root = new TreeNode(level[0]);
	    int index = inHash.get(level[0]);
	    List<Integer> levelLeft = new ArrayList<Integer>();
	    List<Integer> levelRight = new ArrayList<Integer>();

	    if(level.length == 1) return root;
	    
	    
	    for(int i = 1; i < level.length; i++) {
	      if(inHash.get(level[i]) < index) {
	        levelLeft.add(level[i]);
	      } else {
	        levelRight.add(level[i]);
	      }
	    }
	    
	    root.left = helper(levelLeft.toArray(new Integer[levelLeft.size()]));
	    root.right = helper(levelRight.toArray(new Integer[levelRight.size()]));
	    
	    return root;
	  }

}
