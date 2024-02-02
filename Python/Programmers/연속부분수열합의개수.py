def solution(elements):
    answer = 0
    l = len(elements)
    sums=[]
    for i in range(1,l+1):
        for j in range(l):
            end = j+i
            sums.append(sum(elements[j:end]))
            if end>l:
                sums.append(sum(elements[j:end]+elements[:end-l]))
    answer = len(set(sums))
    return answer