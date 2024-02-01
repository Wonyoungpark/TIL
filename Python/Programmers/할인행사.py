def solution(want, number, discount):
    answer = 0
    ld = len(discount)
    for i in range(ld-9):
        for e,w in enumerate(want):
            flag = True
            if discount[i:i+10].count(w)<number[e]:
                flag = False
                break
        if flag: answer += 1
    return answer