def solution(answers):
    answer = []
    result = []
    cnt1,cnt2,cnt3 = 0,0,0
    
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        if answers[i]==one[i%len(one)]: cnt1 += 1
        if answers[i]==two[i%len(two)]: cnt2 += 1
        if answers[i]==three[i%len(three)]: cnt3 += 1
    result = [cnt1,cnt2,cnt3]
    
    for e, r in enumerate(result):
        if r == max(result):
            answer.append(e+1)
    return answer

# import math
# def find_index(data, target):
#     res = []
#     lis = data
#     while True:
#         try:
#             res.append(lis.index(target) + (res[-1]+1 if len(res)!=0 else 0))
#             lis = data[res[-1]+1:]
#         except:
#             break     
#     return res

# def solution(answers):
#     answer = []
    
#     lists = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
#     result = []
#     for e,l in enumerate(lists):
#         a_lists = answers*math.ceil(len(l)/5)
#         D = [i for i, j in zip(l, a_lists) if i == j]
#         result.append(len(D))
    
#     for i in find_index(result, max(result)):
#         answer.append(i+1)
#     answer.sort()
#     return answer