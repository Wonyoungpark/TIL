def solution(num_list):
    e = 0
    o = 0
    for n in range(len(num_list)):
        if n%2==1: e += num_list[n]
        else: o += num_list[n]
    return max(e,o)