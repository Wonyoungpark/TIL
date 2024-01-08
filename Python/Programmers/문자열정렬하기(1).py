def solution(my_string):
    answer = []
    for m in my_string:
        if m.isdigit(): answer.append(int(m))
    answer.sort()
    return answer