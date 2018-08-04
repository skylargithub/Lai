package leetCode;

public class Class418 {
	
	public int wordsTyping(String[] sentence, int rows, int cols) {
        int i = 0;
        int index = 0;
        if(sentence.length == 0) return 0;
        int count = 0;
        while(i < rows) {
            int j = 0;
            while(j + sentence[index].length() <= cols) {       
            	j += sentence[index].length() + 1;
                if(index == sentence.length - 1) {
                    index = 0;
                    count++;
                } else {           
                    index++;
                }
            }
            i++;
        }
        return count;
    }
	
	 public static void main(String[] args) {
		   
	    	Class418 class418= new Class418();
	    	System.out.println(class418.wordsTyping(new String[]{"qs","h","uechao","i","ibhyytfo","lf","rpiutgkhgo","chmq","qhvga","nvgbasxuq"}, 9388, 8318));
	    	
	    	}


}
