def solution(N,stages):
    result = {}
    num = len(stages)
    
    for s in range(1,N+1):
        if num != 0:
            cnt = stages.count(s)
            result[s] = cnt / num
            num -= cnt
        else:
            result[s] = 0
    return sorted(result, key=lambda x: result[x],reverse = True)


# def find_fail(num, stages):
#     whole = 0
#     stay = 0
#     for s in stages:
#         if s >= num:
#             whole += 1
#         if s == num:
#             stay += 1
#     return stay/whole
            
# def solution(N, stages):
#     answer = {}
    
#     for n in range(1,N+1):
#         answer[n] = find_fail(n, stages)
        
#     import operator
#     sdict = sorted(answer.items(), key=operator.itemgetter(1),reverse=True)
    
#     result = []
#     for d in sdict:
#         result.append(d[0])
#     return result