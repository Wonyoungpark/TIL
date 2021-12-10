def solution(s):
    result =[]
    word = s.split(" ")
    for j in word:
        answer = ''
        for i in range(len(j)):
            if i%2 == 0: answer+= j[i].upper()
            else: answer += j[i].lower()
        result.append(answer)
    return (' ').join(result)