def solution(prices):
    answer = []
    now = 0
#     last = 0
#     leng = len(prices)
    
#     for i in range(leng):
#         now = prices[i]
        
        # for j in range(len(prices)):
        #     if j - now < 0:
        #         print(j-now)
        #         long = prices.index(i)-prices.index(j)
        #         answer.append(long)
        #     else:
        #         answer.append(8)
                
    print(answer)
    for i in range(len(prices)): 
        check_num = 0 
        for j in range(i+1, len(prices)): 
            check_num = check_num + 1 
            if prices[i] > prices[j]: 
                break 
        answer.append(check_num)

    return answer