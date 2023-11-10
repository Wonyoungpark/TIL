def solution(intStrs, k, s, l):
    answer = []
    for instr in intStrs:
        a = int(instr[s:s+l])
        if a>k: answer.append(a)
    return answer