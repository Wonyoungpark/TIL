def solution(arr):
    answer = []
    for a in arr:
        if not answer: answer.append(a)
        if a == answer[-1]: continue
        else: answer.append(a)
    return answer