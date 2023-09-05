def solution(n, control):
    answer = n
    con = {"w":1,"s":-1,"d":10,"a":-10}
    for c in control:
        answer += con[c]
    return answer