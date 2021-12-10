def solution(s):
    answer = 0
    if (s.isdigit()): answer = int(s)
    elif s[0] == "-": answer = -1*int(s[1:])
    else: answer = int(s[1:])
    return answer