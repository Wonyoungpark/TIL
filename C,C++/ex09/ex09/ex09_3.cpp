/*
3. 알파벳을 입력받아서 그 다음 알파벳을 출력하는 프로그램을 만들어 보세요.(z제외)
*/

#include <stdio.h>

int main() {
	char a;

	printf("알파벳을 입력하세요 : ");
	scanf_s("%c", &a);

	printf("%c의 다음 알파벳은 %c입니다.", a, int(a) + 1);
}