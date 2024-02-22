def solution(date1, date2):
    answer = 0
    d1 = "".join(str(d) for d in date1)
    d2 = "".join(str(d) for d in date2)
    if d1<d2: return 1
    return answer


from datetime import datetime

def solution2(date1, date2):
    answer = 0
    d1 = datetime(date1[0],date1[1],date1[2])
    d2 = datetime(date2[0],date2[1],date2[2])
    if d1<d2: return 1
    return answer