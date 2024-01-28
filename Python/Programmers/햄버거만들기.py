def solution(ingredient):
    answer = 0
    keep = []
    
    for i in ingredient:
        keep.append(i)
        if keep[-4:] == [1,2,3,1]:
            answer+=1
            for _ in range(4): keep.pop()
    return answer

# 참고 사이트 : https://chan-lab.tistory.com/33