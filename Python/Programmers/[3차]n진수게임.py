def solution(n, t, m, p):
    answer = ''
    temp = []
    
    # 진수 변환
    def convert(num,n):
        arr = "0123456789ABCDEF"
        q,r = divmod(num,n)
        if q==0: return arr[r]
        else: return convert(q,n)+arr[r]
    
    
    for i in range(t*m):
        conv = convert(i,n)
        for c in conv: temp.append(c)
    
    for i in range(p-1,t*m,m): answer += temp[i]
    return answer