package 剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_15_二进制中1的个数 {
    public int hammingWeight(int n) {
    	
    	int count = 0;
    	while (n != 0) {
    		if ((n & 1) == 1) {
    			count++;
    		}

    		ConcurrentHashMap map = new ConcurrentHashMap<Integer, Integer>();
    		n >>>= 1;
    	}
    	return count;
    }
}
