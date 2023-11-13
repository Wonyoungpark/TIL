def solution(str_list):
    answer = []
    for s in range(len(str_list)):
        if str_list[s]=="l": return str_list[:s]
        elif str_list[s]=="r": return str_list[s+1:]
    return answer