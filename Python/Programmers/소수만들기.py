def find_prime(n):
    if n != 1:
        for i in range(2,n):
            if n % i == 0:
                return False
    else:
        return False
    return True

def solution(nums):
    answer = 0

    from itertools import combinations
    lists = list(combinations(nums,3))
    for l in lists:
        if find_prime(sum(l)):
            answer += 1
    return answer