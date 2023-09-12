package aundreaproject.expense_tracker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

	private static String specialCharsRegexPattern = "[\\\\!\"#$%&()*+,./:;<=>?@\\[//]^_{|}~`]+";
	
	public ValidateUtil() {
		
	}
	
	public boolean isStringContainsSpecialChars(String str) {
		Pattern p = Pattern.compile(specialCharsRegexPattern);
		Matcher m = p.matcher(str);
		
		boolean characterFound = m.find();
		
		return characterFound;
		
	}
	
	public boolean containsNumsOnly(double amt) {
		Pattern p = Pattern.compile(numsRegexPattern);
		
	}
}
