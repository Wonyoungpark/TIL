def solution(k, tangerine):
    answer = 0
    tdic = {}
    
    for t in tangerine:
        if t in tdic: tdic[t] += 1
        else: tdic[t] = 1
        # if t not in tdic:
        #     tdic[t] = tangerine.count(t)
    
    tdic = sorted(tdic.items(), key=lambda item:item[1])
            
    while (k and tdic):
        if k>=tdic[-1][1]:
            k -= tdic[-1][1]
            tdic.pop()
            answer += 1
        else:
            answer += 1
            break
            
    return answer

# 참고 사이트 : https://velog.io/@minmong/프로그래머스-Lv.2-귤-고르기-Python-velog