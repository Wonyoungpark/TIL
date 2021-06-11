def rank(count):
    if count == 6:
        return 1
    elif count == 5:
        return 2
    elif count == 4:
        return 3
    elif count == 3:
        return 4
    elif count == 2:
        return 5
    else:
        return 6

def solution(lottos, win_nums):
    answer = []
    lottos.sort()
    win_nums.sort()
    cnt = 0
    zero = lottos.count(0)
    
    for i in win_nums:
        if i in lottos:
            cnt += 1
            
    maxi = rank(cnt + zero)
    mini = rank(cnt)
    answer = [maxi, mini]
    
    return answer