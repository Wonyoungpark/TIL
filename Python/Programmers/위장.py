def solution(clothes):
    answer = 1
    dic = dict()
    for clothe in clothes:
        key = clothe[1]
        if key in dic:
            dic[key].append(clothe[0])
        else:
            dic[key] = [clothe[0]]
    
    for k,v in dic.items():
        answer = answer * (len(v) + 1)
    return answer - 1