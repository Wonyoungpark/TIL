def solution(n):
    arr = [s for s in str(n)]
    arr.sort(reverse=True)
    answer = int(('').join(arr))
        
    return answer