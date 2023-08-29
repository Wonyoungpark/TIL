def solution(str1, str2):
    answer = ''
    for a,b in zip(str1,str2):
        answer += (a+b)
    return answer