# def count_amount(enroll, referral, a,idx):
#     while(referral[idx]!="-"):
#         prev_idx = enroll.index(referral[idx])
#         answer[idx] += round(a*0.9)
#         idx = prev_idx
#         a = round(a*0.1)
#     answer[idx] += round(a*0.9)
    
# def solution(enroll, referral, seller, amount):
#     global answer
#     answer = [0]*len(enroll)
    
#     for e, sell in enumerate(seller):
#         idx = enroll.index(sell) # 판매자의 인덱스
#         if referral[idx] != "-":
#             count_amount(enroll, referral, amount[e]*100,idx)
#         else: # 추천인이 없는 경우
#             answer[idx] += round(amount[e]*100*0.9)
    
#     return answer

import math

def solution(enroll, referral, seller, amount):
    parentTree = dict(zip(enroll, referral))
    answer = dict(zip(enroll, [0 for i in range(len(enroll))]))
    
    for i in range(len(seller)):
        earn = amount[i]*100
        target = seller[i]
        
        while True:
            if earn < 10:
                answer[target] += earn
                break
            else:
                answer[target] += math.ceil(earn*0.9)
                if parentTree[target] == "-": break
                earn = math.floor(earn*0.1)
                target = parentTree[target]
    return list(answer.values())

# 참고 사이트 : https://muhly.tistory.com/102