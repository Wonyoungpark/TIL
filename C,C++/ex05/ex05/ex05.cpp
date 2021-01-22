#include <stdio.h>

int main() {
	// int: 32비트(4바이트), 정수
	/*int a = 5;
	int b = 3;

	int hap = a + b;
	int cha = a - b;
	int gop = a * b;
	int mok = a / b;
	int namuji = a % b;

	printf("%d + %d = %d\n", a, b, hap);
	printf("%d - %d = %d\n", a, b, cha);
	printf("%d * %d = %d\n", a, b, gop);
	printf("%d / %d = %d\n", a, b, mok);
	printf("%d %% %d = %d\n", a, b, namuji);
	*/

	// float: 32비트(4바이트), 실수 => 정확도 높이려면 double(64비트) 사용
	float a = 9.8;
	float b = 3.14;

	float hap = a + b;
	float cha = a - b;
	float gop = a * b;
	float mok = a / b;

	printf("%f + %f = %f\n", a, b, hap);
	printf("%f - %f = %f\n", a, b, cha);
	printf("%f * %f = %f\n", a, b, gop);
	printf("%f / %f = %f\n", a, b, mok);

	// 부동소수점(floating point)
}

/*
8비트 = 1바이트
바이트: 컴퓨터에서 데이터를 처리하는 가장 작은 단위

자료형 - 정수형, 실수형
정수형 - char(문자, 1바이트, 8비트), short(2바이트), long(4바이트), long long(8바이트), int(long)
실수형 - float(4바이트), double(8바이트)

unsigned, signed
부호없는 정수형 변수 : unsigned int a;

void: 리턴값이 없는 함수의 자료형

bool: 참/거짓을 저장하는 자료형(=char)
*/