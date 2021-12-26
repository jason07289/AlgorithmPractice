package d2021_12_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class B1148 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> wordList = new ArrayList<>();
		while(true) {
			String word = br.readLine();
			if("-".equals(word)) {
				break;
			}
			wordList.add(word);
		}
		ArrayList<Character> charList = new ArrayList<>();
		int puzzleChar[];
		int puzzleCnt[];
		int puzzleTotalCnt[];
		Map<Character, Integer> wordMap= new HashMap<>();
		while(true) {
			String puzzle = br.readLine();
			if("#".equals(puzzle)) {
				break;
			}
			
			puzzleTotalCnt = new int[puzzle.length()];
			for(int i =0; i<wordList.size(); i++) {
				String word = wordList.get(i);
				puzzleCnt = new int[puzzle.length()];
				int[] wordChar = new int[word.length()];
				for(int j=0; j<puzzle.length(); j++) {
					puzzleChar = new int[puzzle.length()];
					for(int k =0; k<word.length(); k++) {
						if (wordChar[k]==0&&puzzleChar[j]==0) {
							if(puzzle.charAt(j) == word.charAt(k)) {
								wordChar[k]=1;
								puzzleChar[j]=1;
								puzzleCnt[j]++;
							}
						}
					}
				}
				boolean status=true;
				for(int k =0; k<word.length(); k++) {
					if (wordChar[k]==0) {
						status =false;
					}
				}
				if(status) {
					//System.out.println("word: "+word);
					//System.out.println(Arrays.toString(puzzleCnt));
					for(int j =0; j<puzzleTotalCnt.length; j++) {
						puzzleTotalCnt[j] = puzzleTotalCnt[j]+puzzleCnt[j];
					}
					
				}
			}//word
//			System.out.println("puzzle------------");
//			System.out.println(puzzle);
//			System.out.println(Arrays.toString(puzzleTotalCnt));
			
			wordMap.clear();
			int maxCnt=0;
			int minCnt=Integer.MAX_VALUE;
			for(int i=0; i<puzzleTotalCnt.length; i++) {
				char nowChar = puzzle.charAt(i);
				int nowCnt = puzzleTotalCnt[i];
				
				if(wordMap.get(nowChar)!=null) {
					int largeCnt = Math.max(wordMap.get(nowChar), nowCnt);
					wordMap.put(nowChar,largeCnt);
				}else {
					wordMap.put(nowChar,nowCnt);
				}
			}
			//System.out.println(wordMap);
			Iterator<Character> keys = wordMap.keySet().iterator();
	        while( keys.hasNext() ){
	        	Character key = keys.next();
	        	maxCnt = Math.max(maxCnt, wordMap.get(key));
	        	minCnt = Math.min(minCnt, wordMap.get(key));
	        }
	        //System.out.println(minCnt+ " " +maxCnt);
	        charList.clear();
	        Set<Entry<Character, Integer>> entrySet = wordMap.entrySet();
	        for (Entry<Character, Integer> entry : entrySet) {
		        if (entry.getValue()==minCnt) {
		        	charList.add(entry.getKey());
		        }
	        }
	        Collections.sort(charList);
	        for(int i=0; i<charList.size(); i++) {
	        	System.out.print(charList.get(i));
	        }
	        System.out.print(" ");
	        System.out.print(minCnt+ " ");
	        charList = new ArrayList<>();
	        for (Entry<Character, Integer> entry : entrySet) {
		        if (entry.getValue()==maxCnt) {
		        	charList.add(entry.getKey()); 
		        }
	        }
	        Collections.sort(charList);
	        for(int i=0; i<charList.size(); i++) {
	        	System.out.print(charList.get(i));
	        }
	        System.out.print(" ");
	        System.out.print(maxCnt+ " ");
	        System.out.println();
		}
		
		
	}
}
