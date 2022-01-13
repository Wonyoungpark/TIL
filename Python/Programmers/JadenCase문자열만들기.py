def solution(s):
    answer = ''
    # string = s.split(" ")
    # result=[]
    # for st in string:
    #     st = st[0].upper()+st[1:].lower()
    #     result.append(st)
    # answer = ' '.join(result)
    # return answer
    s = s.lower()
    L = s.split(" ")
    
    for i in L:
        i = i.capitalize()
        answer += i+" "
    return answer[:-1]

# 참고 사이트 : https://velog.io/@terry960302/알고리즘-풀이-프로그래머스-LV2-JadenCase-문자열-만들기-e8jwm1dqw0