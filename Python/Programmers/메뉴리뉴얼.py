def solution(orders, course):
    answer = []
    
    for c in course:
        if get_courses(orders, c) is not None:
            answer.extend(get_courses(orders, c))
    answer.sort()
    return answer

def get_courses(orders, num):
    if len(orders) < num: return None
    lists = []
    
    from itertools import combinations
    for o in orders:
        x = list(map(''.join, combinations(o, num)))
        lists.extend(x)
    test = []
    for l in lists:
        test.append(''.join(sorted(l)))
    
    from collections import Counter
    c = Counter(test).most_common()
    maximum = c[0][1]
    modes = []
    for num in c:
        if num[1] == maximum and num[1] > 1:
            modes.append(num[0])
    return modes