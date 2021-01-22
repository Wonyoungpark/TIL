/*
1. 두 숫자를 입력 받아서 그 숫자들의 합을 출력하는 프로그램을 만들어 보세요.
*/

#include <stdio.h>

int main() {
	float a, b;


	scanf_s("%f%f", &a, &b);

	float sum = a + b;

	printf("%f + %f = %.2f\n", a, b, sum);
}