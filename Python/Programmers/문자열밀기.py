def solution(A, B):
    answer = 0
    
    # A,B 일치할 경우
    if A == B: return answer

    # 그 외
    for l in range(len(A)):
        A = A[-1] + A[:-1]
        answer += 1
        if A == B: return answer
        else: continue
        
    return -1