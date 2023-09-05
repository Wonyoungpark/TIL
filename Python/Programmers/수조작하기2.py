def solution(numLog):
    answer = ''
    con = {1:"w",-1:"s",10:"d",-10:"a"}
    for n in range(len(numLog)-1):
        answer += con[numLog[n+1]-numLog[n]]
    return answer