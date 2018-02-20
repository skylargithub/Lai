package amazonOA;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	List<String>[] array = new ArrayList<String>[5];
		List<String>[] array1 = new ArrayList[5];
	   array1[0] = new ArrayList<String>();
	   array1[1] = new ArrayList();
	   
	   
	   
	   //1. K - Distinct
	   List<String> res = new ArrayList<String>();
	   KDisctinct kDistinct = new KDisctinct();
	   res = kDistinct.k1Distinct("abacdefgefg", 20);
	  for(String s: res) {
		  System.out.println(s);
	  }
	   
	   //bac, acd, cde, efg
	   int a = 1;
	   
	   TargetTag targetTag = new TargetTag();
	   List<String> source = new ArrayList<String>();
	   List<String> target = new ArrayList<String>();
/*	   source.add("made");
	   source.add("weather");
	   source.add("forecast");
	   source.add("says");
	   source.add("that");
	   source.add("made");
	   source.add("rain");
	   source.add("in");
	   source.add("spain");
	   source.add("stays");
	   
	   target.add("made");
	   target.add("in");
	   target.add("Spain"); */
	   
	 /*  source.add("hello");
	   target.add("hello");
	   */
	   
	  /* source.add("hello");
	   source.add("hello");
	   source.add("hello");
	   target.add("hello"); */
	   
	  /* source.add("foo");
	   source.add("bar");
	   target.add("hello"); */
	   
	  
	
	   source.add("foo");
	   source.add("bar");
	   source.add("yo");
	   source.add("hello");
	   target.add("hello");

	

	   List<Integer> res1 = new ArrayList<Integer>();
	   res1 = targetTag.subSequenceTags(source, target);
	   for(Integer num: res1) {
		   System.out.println(num);
	   }
	}
}
