import string
import math

# 진수 변환
def convert(n,k):
    tmp = string.digits + string.ascii_lowercase
    q,r = divmod(n,k)
    if q==0: return tmp[r]
    else: return convert(q,k)+tmp[r]

def solution(n, k):
    answer = 0
    con_str = convert(n,k).split("0")
    
    for c in con_str:
        if c=='1' or c=='' or '0' in c: continue
        c=int(c)
        flag=True
        for i in range(2,int(math.sqrt(c))+1): # 소수 판별
            if c%i==0: # 소수가 아닌 경우
                flag=False
                break
        if flag: answer+=1 # 소수인 경우
    return answer