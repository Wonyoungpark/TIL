def solution(d, budget):
    d.sort()
    while budget < sum(d):
        d.pop()
    return len(d)

    # 참고 사이트 : https://it-garden.tistory.com/233