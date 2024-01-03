def solution(rank, attendance):
    answer = 0
    stu = []
    l = len(rank)
    
    for i in range(l):
        idx = rank.index(i+1)
        if attendance[idx]: stu.append(idx)
        if len(stu)==3: break
    return 10000*stu[0] + 100*stu[1] + stu[2]