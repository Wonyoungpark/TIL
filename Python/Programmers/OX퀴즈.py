def solution(quiz):
    answer = []
    
    for q in quiz:
        num = 0
        q = q.split()
        if q[1] == '-':
            num = int(q[0])-int(q[2])
        else:
            num = int(q[0])+int(q[2])
        if int(q[4]) == num: answer.append("O")
        else: answer.append("X")
    return answer