package 串;

import java.util.Scanner;

public class _0_判断合法字符串 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input == null) {
        	System.out.println("false");
        	return;
        }
        if (input.length() == 0) {
        	System.out.println("false");
        	return;
        }
        
        if (input.length() == 1) {
        	System.out.println("false");
        	return;
        }
        if (input.indexOf("\"") == 0 && input.lastIndexOf("\"") == input.length()-1){
        	int left = 1;
        	int right = input.length() - 2;
        	char[] array = input.toCharArray();
        	while (left < right) {
        		if (array[left] == '\"' || array[right] == '\"') {
        			System.out.println("false");
        			return;
        		}
        		left++;
        		right--;
        	}
        	System.out.println("true");
        	return;
        }else {
        	System.out.println("false");
		}
        // 
        // or
        // 
	}

}
