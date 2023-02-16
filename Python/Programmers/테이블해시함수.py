def solution(data, col, row_begin, row_end):
    answer = 0
    
    # 튜플 정렬
    data.sort(key=lambda x:(x[col-1],-x[0]))
    
    for i in range(row_begin,row_end+1):
        s_i = 0
        for d in data[i-1]:
            s_i += d%i
        answer = answer ^ s_i # XOR

    return answer