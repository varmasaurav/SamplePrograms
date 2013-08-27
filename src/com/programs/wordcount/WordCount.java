import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WordCount {
	
	public static void main(String arg[]) {
		System.out.println("Testing");
		
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		
		BufferedReader br = null;
		
		try {
			String sCurrentLine;
			 
			br = new BufferedReader(new FileReader("C:\\Users\\savarma\\Personal\\workspace\\Sample\\src\\testing.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				String[] word = sCurrentLine.split("[.;,\\s+]");
				System.out.println(word.length);
				
				for(int i = 0; i<word.length;i++){
					word[i]=word[i].toLowerCase();
					if(!word[i].matches("\\s+")){
					if(wordCount.containsKey(word[i])) {
						wordCount.put(word[i], wordCount.get(word[i]) + 1);
						
					}else {
						wordCount.put(word[i], 1);
					}
					
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println(wordCount);
	}

}
