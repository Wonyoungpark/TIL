/*
char: 1바이트 정수형 (int:4바이트)
character: 문자(반각문자: 알파벳, 숫자, 키보드로 입력 가능한 기호들)
*/

#include <stdio.h>

int main() {
	char a = 65;

	printf("%d\n", a);
	printf("%c\n", a);
	printf("%c\n", 65);
	printf("%d\n", 'A');
}

// ASCII: American Standard (문자 <-> 숫자)