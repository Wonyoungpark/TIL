def solution(k, dungeons):
    answer = 0
    
    # while(dungeons[0][0]<=k):
    #     dungeons.sort(key=lambda x:x[0],reverse=True)
    #     if dungeons[0][0]==k:
    #         k-=dungeons[0][1]
    #         dungeons.pop(0)
    #         answer += 1
    #     elif dungeons[0][0]<k:
    #         dungeons.sort(key=lambda x:(x[0],-x[1]))
    #         k-=dungeons[0][1]
    #         dungeons.pop(0)
    #         answer += 1
    #     if len(dungeons)==0:
    #         break
    
    from itertools import permutations
    
    for condition in permutations([i for i in range(len(dungeons))]): # 순열로 모든 조합
        kTemp, ansTemp = k,0
        for idx in condition:
            left,use = dungeons[idx]
            if kTemp>=left:
                kTemp -= use
                ansTemp += 1
        answer = max(answer, ansTemp)
    return answer

# 참고 사이트 : https://sangsangss.tistory.com/205