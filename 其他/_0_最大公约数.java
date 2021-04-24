package 其他;

public class _0_最大公约数 {
	
	public int commonDivisor(int a, int b) {
		if (b == 0) return a;
		return commonDivisor(b, a % b);
	}
}
