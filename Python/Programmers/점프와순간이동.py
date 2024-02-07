def move(n,ans):
    if n%2!=0:
        ans+=1
        n -= 1
    n /= 2
    return n,ans
    
def solution(n):
    ans = 0
    
    while(n!=0):
        n,ans = move(n,ans)

    return ans