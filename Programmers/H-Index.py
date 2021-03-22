def solution(citations):
    answer = 0
    citations.sort()
    leng = len(citations)
    print(citations)
    for i in range(leng):
        if citations[i] >= leng-i:
            print(i)
            return leng-i
            
    return answer