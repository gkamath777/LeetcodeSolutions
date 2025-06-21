package com.pgk.problems.generic;

/**
 * 
 * Problem Statement:
 * 
 * You are given a string caption representing the caption for a video.
 * 
 * The following actions must be performed in order to generate a valid tag for
 * the video:
 * 
 * Combine all words in the string into a single camelCase string prefixed with
 * '#'. A camelCase string is one where the first letter of all words except the
 * first one is capitalized. All characters after the first character in each
 * word must be lowercase.
 * 
 * Remove all characters that are not an English letter, except the first '#'.
 * 
 * Truncate the result to a maximum of 100 characters.
 * 
 * Return the tag after performing the actions on caption.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: caption = "Leetcode daily streak achieved"
 * 
 * Output: "#leetcodeDailyStreakAchieved"
 * 
 * Explanation:
 * 
 * The first letter for all words except "leetcode" should be capitalized.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: caption = "can I Go There"
 * 
 * Output: "#canIGoThere"
 * 
 * Explanation:
 * 
 * The first letter for all words except "can" should be capitalized.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: caption =
 * "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 * 
 * Output:
 * "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 * 
 * Explanation:
 * 
 * Since the first word has length 101, we need to truncate the last two letters
 * from the word.
 * 
 *  
 * 
 * Constraints:
 * 
 * 1 <= caption.length <= 150 caption consists only of English letters and ' '.
 * 
 * 
 * Test case Inputs: 
 * 
 * "Leetcode daily streak achieved" "can I Go There"
 * "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 * "FkVsgzfhQxPYKr WtaCvDuHQeo roeVHIoPorZuIuMDxhYVs jlfCrXCDqBVjgmzxxmZOpUpCc
 * eHMpZrNxilBPngylMcS"
 * "GgpNjaKUgxmMADcZZYuTpTwiEgUfbYMfNBqPSyvSgkvHJYYTMKFEmqiHWkFPonfeadBhDuQHywxwPFdQtLnlyDkOnjrNNnGYamza"
 * " fPysaRtLQLiMKVvRhMkkDLNedQKffPnCjbITBTOVhoVjiKbfSawvpisDaNzXJctQkn" 
 * "  fi Love you b"
 * 
 */


public class generateTag {
	
	public static void main(String[] args) {
//		String sentence = "   fi Love122 you$#@ b123";
		String sentence = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
		System.out.println(generateCaption(sentence));
		
	}
	
	public static String generateCaption(String caption) {
		
		/**
		 * Solution:
		 * 
		 * 1. Remove the leading white spaces before the first word.
		 * 2. Split the sentences into Array of words of lower case. 
		 * 3. Concatenate the words.
		 * 		3.a. Append the first word.
		 *      3.b. Append the next subsequent words by capitalizing the first letter of the word.
		 * 4. Remove all non English characters. 
		 * 5. Append '#' before the beginning.
		 * 6. Reduce the length of the string to 100 characters. 
		 * 
		 */
		
		
		caption = caption.stripLeading();
		String[] words = caption.toLowerCase().split(" ");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< words.length; i++) {
			if(i == 0) {
				sb.append(words[i]);
			} else {
				String word = words[i];
				if(!word.isEmpty()) {
					sb.append(word.toUpperCase().charAt(0)).append(word.substring(1));
				}
			}
		}
		caption = "#"+sb.toString().replaceAll("[^a-zA-Z]", "");
		if(caption.length() > 100)
			caption = caption.substring(0, 100);
	
		
		
		return caption;
	}

}
