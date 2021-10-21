def solution(sizes):
    answer = 0
    
    for size in sizes:
        size.sort()
    
    first = [s[0] for s in sizes]
    last = [s[1] for s in sizes]
    answer = max(first)*max(last)
    return answer