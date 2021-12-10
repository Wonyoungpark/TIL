def solution(s, n):
    answer = ''
    for i in s:
        if i==" ": answer += i
        else:
            num = ord(i)+n
            if num>122 and i.islower():
                num = 96+ (num-122)
            elif num>90 and i.isupper():
                num = 64+ (num-90)
            answer += chr(num)
    return answer