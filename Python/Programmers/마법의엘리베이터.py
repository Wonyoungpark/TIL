import math

def solution(storey):
    answer = 0
    
    while storey:
        num = storey%10
        storey = math.floor(storey/10)
        
        if num<5:
            answer += num
        elif num>5:
            answer += (10-num)
            storey += 1
        else:
            if (storey%10) < 5: answer += num
            else:
                answer += (10-num)
                storey += 1
    return answer

    # 참고 사이트 : https://velog.io/@isayaksh/알고리즘-Programmers-마법의-엘리베이터-Python