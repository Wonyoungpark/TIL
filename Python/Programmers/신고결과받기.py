def solution(id_list, report, k):
    answer = [0]*len(id_list)
    stopped = ['']*len(id_list)
    report = list(set(report))
    
    for id in report:
        id = id.split(" ")
        stopped[id_list.index(id[1])] += (id[0]+' ')

    for s in range(len(stopped)):
        st = stopped[s].split(" ")
        st.remove('')
        if len(st)>=k:
            for j in st:
                answer[id_list.index(j)]+=1
    return answer