# def solution(strings, n):
#     answer = []
#     dic = {}
#     for e,i in enumerate(strings):
#         dic[e]=i[n]
#     sort_dic = sorted(dic.items(),key=(lambda x:x[1]))
    
#     dupl = []
#     vals = []
#     for a,b in sort_dic:
#         vals.append(b)
#     if len(vals) != len(set(vals)):
#         print(vals-(set(vals)))
    
#     print(sort_dic)
#     for n,x in sort_dic:
#         answer.append(strings[n])
#     return answer

def solution(strings, n):
    return sorted(sorted(strings), key=lambda x: x[n])

# 참고 사이트 : https://sinsomi.tistory.com/entry/프로그래머스-Python-문자열-내-마음대로-정렬하기