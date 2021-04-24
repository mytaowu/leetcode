package 数组

/**
https://leetcode-cn.com/problems/sign-of-the-product-of-an-array/
 */
func arraySign(nums []int) int {
	arge2 := true

	for _, value := range nums {
		if value < 0{
			arge2 = !arge2
		} else if value == 0 {
			return 0
		}
	}

	if arge2 {
		return 1
	}else {
		return -1
	}

}
