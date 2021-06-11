def solution(n, times):
    answer = 0
    left = 1
    right = max(times) * n
    
    while left < right:
        mid = (left + right) // 2
        total = 0
        
        for t in times:
            total += mid // t
        
        if total >= n: right = mid
        else: left = mid + 1
            
    answer = left
    return answer

    # 참고 사이트 : https://velog.io/@younge/Python-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9E%85%EA%B5%AD%EC%8B%AC%EC%82%AC-%EC%9D%B4%EB%B6%84%ED%83%90%EC%83%89