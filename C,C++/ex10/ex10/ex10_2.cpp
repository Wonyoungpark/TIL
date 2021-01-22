#include <stdio.h>

int main() {
	int a = 5;

	a = a + 6;
	a += 6;
	a *= 7;
	a -= 5;
	a %= 5;

	// 전치
	a = a + 1;
	a += 1;
	a++;

	a = a - 1;
	a -= 1;
	a--;

	//후치
	++a;
	--a;

	int m = 10;
	int n;
	printf("==전치 증가 연산==\n");
	n = ++m;
	printf("m: %d\n", m);
	printf("n: %d\n", n);

	int g = 10;
	int h;
	printf("==후치 증가 연산==\n");
	h = g++;
	printf("g: %d\n", g);
	printf("h: %d\n", h);
}