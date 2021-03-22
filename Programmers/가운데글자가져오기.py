import math
def solution(s):
    s_list=[]
    for j in s:
        s_list.append(j)

    if (len(s_list) % 2 == 1):
        i = math.floor(len(s_list)/2)
        print(i)
        return s_list[i]
    else:
        i=int(len(s_list)/2)
        return s_list[i-1]+s_list[i]
    # answer = ''
    # return answer