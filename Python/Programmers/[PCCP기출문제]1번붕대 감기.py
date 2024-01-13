from copy import copy

def solution(bandage, health, attacks):
    remain = copy(health)
    success = 0
    
    for t in range(1,attacks[-1][0]+1):
        if remain>health: remain=health # 체력을 초과할 경우
        
        if t==attacks[0][0]: # 공격받게 된다면
            remain-=attacks[0][1] # 체력 공격
            attacks.pop(0) # 공격 끝
            success=0 # 성공 초기화
            if remain<=0: return -1 # 체력 끝
        else:
            success+=1
            remain+=bandage[1]
            if success==bandage[0]: # 연속 성공
                remain+=bandage[2] # 추가 회복
                success=0
        
    return remain