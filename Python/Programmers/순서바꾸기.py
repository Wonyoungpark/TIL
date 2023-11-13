def solution(num_list, n):
    nlist = num_list[n:]
    nlist.extend(num_list[:n])
    return nlist