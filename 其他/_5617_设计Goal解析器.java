package 其他;

/**
 * https://leetcode-cn.com/contest/weekly-contest-218/problems/goal-parser-interpretation/
 * 
 * @author 涛宝宝
 *
 */
public class _5617_设计Goal解析器 {
	public String interpret(String command) {

		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < command.length() - 1; i++) {
			if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
				String tempString = command.substring(i + 1, i + 3);
				stringBuffer.append(tempString);
				i += 3;
			}else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
				stringBuffer.append('o');
				i++;
			}else {
				stringBuffer.append('G');
			}
		}
		
		if (command.charAt(command.length() - 1) == 'G') {
			stringBuffer.append('G');
		}
		
		return stringBuffer.toString();
		
	}
}
