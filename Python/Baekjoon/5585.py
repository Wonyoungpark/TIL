def solution():
    import sys

    input = int(sys.stdin.readline()) # 입력값 받기
    coins = [500,100,50,10,5,1] # 거슬러줄 수 있는 동전 종류
    cnt = 0 # 동전 지불한 횟수
    charge = 1000 - input # 잔돈 계산

    for c in coins:
        cnt += charge//c # 금액이 큰 동전부터 지불, 나누어떨어지는 몫만큼 지불
        charge %= c # 지불 후 남은 금액 == 나머지

    return cnt

print(solution())