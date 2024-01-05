from collections import Counter

def solution(array):
    c = Counter(array).most_common()
    
    if len(c)>1 and c[0][1]==c[1][1]: return -1
    
    return c[0][0]