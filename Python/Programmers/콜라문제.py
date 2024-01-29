def solution(a, b, n):
    answer = 0
    while(n>=a):
        keep = 0
        if n%a==0:
            n=(n//a)*b
        else:
            n, keep = divmod(n,a)
            n *= b
        answer+=n
        n+=keep
    return answer