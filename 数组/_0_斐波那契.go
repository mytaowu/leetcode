package main

import "fmt"

func fib(n int) int {
	num1 := 1
	num2 := 2
	for i := 3; i <= n; i++{
		temp := num2
		num2 += num1
		num1 = temp
	}
	return num2
}

func main() {
	fmt.Println(fib(51))
}