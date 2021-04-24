package 字符串

func convert(s string, numRows int) string {

	if numRows == 1 {
		return s
	}

	// 定义二维数组。
	var numsList [][] rune

	for i := 0 ; i < numRows ; i++ {
		nums := make([]rune, 0)
		numsList = append(numsList, nums)
	}

	cur := 0
	flag := false
	for i := 0; i < len(s) ; i++ {
		numsList[cur] = append(numsList[cur], rune(s[i]));
		if cur == 0 || cur == numRows - 1{
			flag = !flag;
		}
		if flag {
			cur += 1
		}else {
			cur -= 1
		}
	}

	var result string
	for i := 0 ; i < numRows ; i++ {
		result += string(numsList[i])
	}

	return result
}
