import java.io.*;
import java.util.*;

public class LZWAlgorithm {
	
	//512 bits, 9 digits total
	private static int dictSize = 256;
	private static HashMap<String, Integer> dictionary = new HashMap<>();
	public String fileName = "lzw-file1.txt";
	public String initial;
	
	public LZWAlgorithm() {}
	
	public String gottaGetTheText 
	
	public static ArrayList<String> compress(String initial) {
		String first = "";
		ArrayList<String> compressed = new ArrayList<>();
		
		for (char extract: initial.toCharArray()) {
			String combined = first + extract;
			if (dictionary.containsKey(combined))
				first = combined;
			compressed.add(convertToBinary(dictionary.get(first)));
			dictionary.put(combined, dictSize++);
			first = "" + extract;
		}
		
		if(!first.equals(""))
			compressed.add(convertToBinary(dictionary.get(first)));
		return compressed;
	}
	
	private static String convertToBinary (int i) {
		String output = Integer.toBinaryString(i);
		while (output.length() < 10) {
			output = "0" + output;
		}
		return output;
	}
	
	public void initializeDictionary() {
		for (int i=0; i<255; i++) {
			dictionary.put("" + (char) i, i);
		}
	}
}