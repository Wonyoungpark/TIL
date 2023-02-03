def solution(n):
    answer = []
    cnt = 1
    
    while(cnt <= n):
        if n % cnt == 0: answer.append(cnt)
        cnt += 1
    return answer