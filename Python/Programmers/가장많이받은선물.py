from collections import defaultdict

def solution(friends, gifts):
    g_record = {}
    answer = [0]*len(friends)
    
    # 선물 주고 받을 친구 목록 생성
    for give in friends:
        g_record[give] = [0,{}]
        for take in friends:
            if give!=take: g_record[give][1][take] = 0
    
    for gift in gifts:
        a,b = gift.split()
        g_record[a][0] += 1 #자신의 선물지수 +1
        g_record[a][1][b] += 1 #선물 준 친구 +1
        g_record[b][0] -= 1 #선물 받은 친구의 선물지수 -1
        g_record[b][1][a] -= 1 #선물 받은 친구가 나에게 준 선물 횟수 차감
        
    for a,values in g_record.items():
        idx = friends.index(a)
        my_rate = values[0] # 나의 선물지수
        for b,cnt in values[1].items(): #선물 받은 친구들의 선물지수
            if cnt>0: answer[idx] += 1 #자신이 친구한테 선물을 더 많이 준 경우, 자신이 선물 받는다.
            elif cnt==0: #선물 주고 받은 횟수가 동일한 친구
                if my_rate>g_record[b][0]: # 선물지수 비교
                    answer[idx] += 1 #나의 선물지수가 더 큰 경우, 자신이 선물을 받는다.
            
    return max(answer)