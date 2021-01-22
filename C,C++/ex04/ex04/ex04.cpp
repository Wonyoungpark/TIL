#include <stdio.h>

int main() {
	// 변수 선언
	int a; // int형 변수는 정수형 변수

	a = 3; // a에 3을 할당
	printf("%d\n", a);

	a = 5; // a에 5를 할당, 3이라는 값은 삭제됨
	printf("%d\n", a);
}