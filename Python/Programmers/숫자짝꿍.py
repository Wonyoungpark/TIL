# def compare(X,Y):
#     res = []
#     for x in X:
#         if x in Y:
#             res.append(x)
#             Y.remove(x)
#     return res


# def solution(X, Y):
#     X, Y = list(X), list(Y)
    
#     res = compare(Y,X)
    
#     if (set(res)=={'0'}): return '0'
#     elif res:
#         res.sort(reverse=True)
#         return "".join(res)
#     return "-1"


def solution(X, Y):
    answer = ''
    
    for i in range(9,-1,-1):
        answer += str(i)*min(X.count(str(i)),Y.count(str(i)))
    if answer=='': return "-1"
    elif len(answer)==answer.count("0"): return "0"
    else: return answer

# 참고 사이트 : https://chan-lab.tistory.com/36