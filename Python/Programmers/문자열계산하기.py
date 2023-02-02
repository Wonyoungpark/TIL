def solution(my_string):
    answer = 0
    m_list = my_string.split()
    pos = True
    
    for m in m_list:
        if m == '+': pos = True
        elif m == '-': pos = False
        else:
            if pos: answer += int(m)
            else: answer -= int(m)
    return answer