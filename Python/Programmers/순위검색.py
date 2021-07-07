def solution(info, query):
    answer = []
    
    from itertools import combinations
    from collections import defaultdict
    import bisect
    
    people = defaultdict(list)
    for i in info:
        person = i.split()
        score = int(person[-1])
        people[''.join(person[:-1])].append(score)
        for j in range(4):
            candi = list(combinations(person[:-1],j))
            for c in candi:
                people[''.join(c)].append(score)
    for i in people:
        people[i].sort()
    for i in query:
        key = i.split()
        score = int(key.pop())
        key = ''.join(key)
        key = key.replace('and','').replace(' ','').replace('-','')
        
        answer.append(len(people[key])-bisect.bisect_left(people[key], score))
        
#     q_list = [q.split(" and ") for q in query]
#     i_list = [i.split(" ") for i in info]
    
#     for q in q_list:
#         result = 0
#         for i in i_list:
#             if i[0] == q[0] or q[0]=="-":
#                 if i[1] == q[1] or q[1]=="-":
#                     if i[2] == q[2] or q[2]=="-":
#                         l = q[3].split()
#                         if i[3] == l[0] or l[0]=="-":
#                             if int(i[4]) >= int(l[1]):
#                                 result += 1
#         answer.append(result)
    return answer

# 참고 사이트 : https://juhi.tistory.com/29