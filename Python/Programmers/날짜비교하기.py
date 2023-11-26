def solution(date1, date2):
    answer = 0
    d1 = "".join(str(d) for d in date1)
    d2 = "".join(str(d) for d in date2)
    if d1<d2: return 1
    return answer