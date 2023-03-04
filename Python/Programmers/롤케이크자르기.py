from collections import Counter

def solution(topping):
    answer = 0
    counts = Counter(topping)
    slices = set()
    
    for i in topping:
        counts[i] -= 1
        slices.add(i)
        if counts[i]==0: counts.pop(i)
        if len(counts)==len(slices): answer+=1

    return answer

# 참고 사이트 : https://engineer-jjini.tistory.com/276