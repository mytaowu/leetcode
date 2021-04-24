package 串;

public class KMP {

	public static void main(String[] args) {

		String text = "helloWorld";
		System.out.println(KMP(text, "Wo"));

	}

	// KMP算法,巧妙的借助next数组来实现跳跃;
	public static int KMP(String text, String pattern) {
		// 暴力的字符串匹配算法
		if (text == null || pattern == null) {
			return -1;
		}
		char[] textCharArray = text.toCharArray();
		char[] patternCharArray = pattern.toCharArray();
		int tLen = textCharArray.length;
		int pLen = patternCharArray.length;
		// 进行条件的判断；
		if (tLen == 0 || pLen == 0 || tLen < pLen) {
			return -1;
		}
		int next[] = next(pattern);
		int ti = 0, pi = 0;
		while (pi < pLen && ti - pi < tLen - pLen) {
			// 相等的情况；
			if (pi < 0 || textCharArray[ti] == patternCharArray[pi]) {
				ti++;
				pi++;
			} else {
				pi = next[pi];
			}
		}
		return pi == pLen ? ti - pi : -1;

	}

	// 返回next数组的方法;
	private static int[] next(String pattern) {
		int len = pattern.length();
		int next[] = new int[len];
		next[0] = -1;
		int n = -1, i = 0;
		while(i < len - 1) {
			if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
				next[++i] = ++n;
			}else {
				n = next[n];
			}
		}
		return next;
	}

	// 暴力的字符串匹配算法优化03,ti不发生改变
	public static int bruteForce(String text, String pattern) {
		if (text == null || pattern == null) {
			return -1;
		}
		char[] textCharArray = text.toCharArray();
		char[] patternCharArray = pattern.toCharArray();
		int tLen = textCharArray.length;
		int pLen = patternCharArray.length;
		// 进行条件的判断；
		if (tLen == 0 || pLen == 0 || tLen < pLen) {
			return -1;
		}
		int ti = 0;
		// 把范围弄小;
		for (; ti < textCharArray.length; ti++) {
			int pi = 0;
			for (; pi < patternCharArray.length; pi++) {
				if (textCharArray[ti + pi] != patternCharArray[pi])
					break;
			}
			if (pi == pLen)
				return ti;
		}
		return -1;
	}

	// // 暴力的字符串匹配算法优化02
	// public static int bruteForce02(String text, String pattern) {
	// if (text == null || pattern == null) {
	// return -1;
	// }
	// char[] textCharArray = text.toCharArray();
	// char[] patternCharArray = pattern.toCharArray();
	// int tLen = textCharArray.length;
	// int pLen = patternCharArray.length;
	// // 进行条件的判断；
	// if (tLen == 0 || pLen == 0 || tLen < pLen) {
	// return -1;
	// }
	// int ti = 0, pi = 0;
	// //把范围弄小;
	// while (pi < pLen && ti -pi <= tLen - pLen) {
	// // 相等的情况；
	// if (textCharArray[ti] == patternCharArray[pi]) {
	// ti++;
	// pi++;
	// } else {
	// // 实配的情况；
	// ti -= pi - 1;
	// pi = 0;
	// }
	// }
	// return pi == pLen ? ti - pi : -1;
	//
	// }

	// // 暴力的字符串匹配算法
	// public static int bruteForce01(String text, String pattern) {
	// if (text == null || pattern == null) {
	// return -1;
	// }
	// char[] textCharArray = text.toCharArray();
	// char[] patternCharArray = pattern.toCharArray();
	// int tLen = textCharArray.length;
	// int pLen = patternCharArray.length;
	// // 进行条件的判断；
	// if (tLen == 0 || pLen == 0 || tLen < pLen) {
	// return -1;
	// }
	// int ti = 0, pi = 0;
	// while (pi < pLen && ti < tLen) {
	// // 相等的情况；
	// if (textCharArray[ti] == patternCharArray[pi]) {
	// ti++;
	// pi++;
	// } else {
	// // 实配的情况；
	// ti -= pi - 1;
	// pi = 0;
	// }
	// }
	// return pi == pLen ? ti - pi : -1;
	// }

}
