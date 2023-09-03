def solution(num_list):
    mult = 1
    summ = 0
    for n in num_list:
        mult*=n
        summ+=n
    if mult<summ**2: return 1
    else: return 0