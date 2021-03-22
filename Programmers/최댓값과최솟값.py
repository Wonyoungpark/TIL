def solution(s):
    s_list = s.split(' ')
    s_list = list(map(int,s_list))
    big = max(s_list)
    small = min(s_list)
    answer = str(small) + ' ' + str(big)
    return answer