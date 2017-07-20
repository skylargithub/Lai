package mainRun;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import ata.UpClinterface;
import mainRun.StingI.StringOfAnother;
import mainRun.StringII.ReverseWord;
import mainRun.adcancedIII.LCAII;
import mainRun.adcancedIII.TreeLevel;
import mainRun.advancedI.AnyNodeToAny;
import mainRun.advancedIV.SubsetsII;
import mainRun.advancedIV.SubsetsIIp;
import mainRun.advancedIV.TwoSum;
import mainRun.advancedV.LargestProduct;
import mainRun.advancedVIIII.MostPoints;
import mainRun.advancedVIIII.MostPointsII;
import mainRun.bfs.Biparity;
import mainRun.bit.NumberOfDifferent;
import mainRun.bit.NumberOfUnique;
import mainRun.bit.PowerOfTwo;
import mainRun.dfs.Substring;
import mainRun.dp1.ArrayHopper;
import mainRun.dp2.ArrayHopperII;
import mainRun.hash.TopFrequency;
import mainRun.recursionII.SpiralOrder;
import mainRun.recursionII.SpiralOrderII;
import mainRun.util.GraphNode;
import mainRun.util.Point;
import mainRun.util.TestChild;
import mainRun.util.TestParent;
import mainRun.util.TreeNode;
import mainRun.util.TreeNodeP;

public class MainRun {
	  private List<List<Integer>> result = new ArrayList<List<Integer>>();
	    private Deque<TreeNode> deque = new LinkedList<TreeNode>();
	    private TreeNode temp;

	public static void main(String[] args) throws SQLException, Exception {


   
 
   // Substring.findSubstringPerm(new char[]{'a','b','c'}, 2, new ArrayList<String>());
   
	//	System.out.print(ArrayHopper.arryHop(new int[]{0}));
		
		//System.out.print(Integer.toBinaryString(-8).toString());
		//System.out.print(Integer.toBinaryString(-9).toString());
 //  NumberOfDifferent.diffBits(533, 2342);
  // System.out.print(NumberOfUnique.allUnique("aa"));
//	System.out.print(StringOfAnother.strstr("mississippi", "issip"));
 //System.out.print(ArrayHopperII.minJump(new int[]{2, 1, 1, 0, 2}));


		
	///	LargestProduct l = new LargestProduct();
	//	System.out.print(l.largestProduct(new String[]{"abc","d"}));
		

		
//		UpClinterface upCliterface = new UpClinterface();
	//	int[]    SQLCODE = new int[20];
	//	String[] SQLMessage = new String[20];
	//	upCliterface.upClinterface("IT", SQLCODE, SQLMessage);
		GraphNode a = new GraphNode(0);
		GraphNode b = new GraphNode(1);
		GraphNode c = new GraphNode(2);
		
		List<GraphNode> ag = new ArrayList<GraphNode>();
		ag.add(b);
		ag.add(c);
		a.neighbors = ag;
		
		List<GraphNode> bg = new ArrayList<GraphNode>();
		bg.add(a);
		bg.add(c);;
		b.neighbors = bg;
		
		List<GraphNode> cg = new ArrayList<GraphNode>();
		cg.add(b);
		cg.add(a);
		c.neighbors = cg;
		
		List<GraphNode> master = new ArrayList<GraphNode>();
		master.add(a);
		master.add(b);
		master.add(c);
		 Biparity  biparity = new  Biparity();
		 System.out.print(biparity.isBipartite(master));
		
	//	TestParent a = new TestChild();
	//	System.out.print(a.hashCode());
		
		
				


		
		
	
	
}
	
	
}
		  
	  
	  
	
	  

