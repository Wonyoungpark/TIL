/*
2. 체중(kg, 실수)과 키(m, 실수)를 입력받아서 체질량 지수를 구하는 프로그램을 만들어 보세요.
*/

#include <stdio.h>

int main() {
	float t, w;

	printf("체중을 입력하세요.(단위:kg) : ");
	scanf_s("%f", &w);
	printf("키를 입력하세요. (단위:m) : ");
	scanf_s("%f", &t);

	float bmi = w / (t*t);

	printf("당신의 체질량 지수는 %.3f입니다.", bmi);
}