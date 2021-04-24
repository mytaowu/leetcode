package 动态规划;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * * https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick/困难题；

 */
public class _1547_切棍子的最小成本 {
	
	public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(n);
        for(int num : cuts){
            list.add(num);
        }
        Collections.sort(list);
        int m = list.size();
        int[][] dp = new int[m][m];
        for(int len = 2; len < m; len++){//枚举区间 
            for(int i = 0; i + len < m; i++){//枚举左端点
                int j = i + len;//右端点
                dp[i][j] = Integer.MAX_VALUE;
                // 枚举最后一个分割点
                for(int k = i+1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + list.get(j) - list.get(i));
                }
            }
        }
        return dp[0][m-1];
    }

}
