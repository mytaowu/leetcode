package 其他;
/**
 * https://leetcode-cn.com/problems/power-of-three/
 * 此题使用了快速幂算法;
 * @author 涛宝宝
 *
 */
public class _326_3的幂 {
	
	public static boolean isPowerOfThree(int n) {
	
		if (n == 0) {
			return false;
		}

		for (int i = 0; i <= 20; i++) {
			if (n == quickpower(3, i)) {
				return true;
			}
		}
		
		return false;
    }
	
	// 快速幂运算;
	static int quickpower(int x,int y)
	{
	    int ans=1,cnt=x;
	    while(y != 0)
	    {
	        if((y & 1) == 1)
	        {
	            ans*=cnt;
	        }
	        cnt*=cnt;
	        y>>=1;
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(9));
	}

}
