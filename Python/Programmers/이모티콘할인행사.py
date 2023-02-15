from itertools import product

def solution(users, emoticons):
    answer = [0,0]
    data = [10,20,30,40]
    
    # 이모티콘 할인율
    discount = list(product(data,repeat=len(emoticons)))
    
    for d in discount:
        sold = [0,0] # 판매액
        for sale, money in users:
            sold_emoticon = 0
            for emoticon, dis in zip(emoticons, d):
                if dis >= sale: # 할인 기준 이상
                    sold_emoticon += emoticon*(1-dis/100)
            if sold_emoticon >= money: # 구매 기준 이상
                sold[0]+=1 # 플러스 가입
            else:
                sold[1] += sold_emoticon
        # 최대 목적 달성
        answer = max(answer,sold)
    
    return answer

    # 참고 사이트 : https://comdoc.tistory.com/entry/이모티콘-할인행사