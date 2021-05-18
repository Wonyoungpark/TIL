def solution(nums):
    answer = 0
    
    n = len(nums)//2
    set_list = list(set(nums))
    if len(set_list) > n: answer = n
    else: answer = len(set_list)
        
    # from itertools import combinations
    # c_list = list(combinations(nums,int(len(nums)/2)))
    # test = [list(sorted(i)) for i in c_list]
    # dup = list(set(map(tuple, test)))
    # answer = len(dup)/2
    
    return answer