def solution(n, m, section):
    answer = 1
    start = section[0]
    
    for i in range(1,len(section)):
        if section[i]-start>=m:
            answer += 1
            start = section[i]
    return answer

# 참고 사이트 : https://dduniverse.tistory.com/entry/프로그래머스-덧칠하기-파이썬-python