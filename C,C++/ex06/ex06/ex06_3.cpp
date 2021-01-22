// 형 변환: 자료형을 다른 자료형으로 바꾸는 작업

#include <stdio.h>

int main() {
	int math = 90, korean = 95, english = 96;
	int sum = math + korean + english;
	double avg = sum / 3; 

	printf("%f\n", avg); // 예상:93.66667

}

/*
정수 / 정수 = 정수 => 93.0000
실수 / 정수 = 실수
1) double sum = math + korean + english;
2) double avg = (double)sum / 3; 
실수 / 실수 = 실수


정수 + 정수 = 정수
실수 + 실수 = 실수
실수 + 정수 = 실수
*/