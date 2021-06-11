def solution(N, number):
    S = []
    answer = -1
    
    for i in range(1,9): # N만큼 반복
        case = {int(str(N)*i)} # number 개수 추가
        for j in range(0,i-1):
            for x in S[j]:
                for y in S[-j-1]:
                    case.add(x+y)
                    case.add(x-y)
                    case.add(y-x)
                    case.add(x*y)
                    if y!=0: case.add(x//y)
        if number in case:
            answer = i
            break
        S.append(case)
        
    return answer

# 참고 https://velog.io/@j_user0719/N으로-표현-PYTHON