def solution(str1, str2):
    answer = 0
    string1 = []
    string2 = []
    
    for s1, s in zip(str1,str1[1:]):
        join_str = "".join([s1,s])
        if join_str.isalpha():
            string1.append(join_str.lower())
    for s2, s in zip(str2,str2[1:]):
        join_str = "".join([s2,s])
        if join_str.isalpha():
            string2.append(join_str.lower())
    
    # 교집합
    if len(string1) > len(string2):
        intersection = [string1.remove(x) for x in string2 if x in string1]
    else:
        intersection = [string2.remove(x) for x in string1 if x in string2]
    
    # 합집합
    union = len(string1+string2)
    if union == 0:
        return 65536
    answer = int(len(intersection)/union * 65536)
    return answer


# def solution(str1, str2):
#     answer = 0
#     str1 = str1.upper()
#     str2 = str2.upper()
#     string1 = []
#     string2 = []
            
#     for i in range(len(str1)):
#         string1.append(str1[i:i+2])
#     for i in range(len(str2)):
#         string2.append(str2[i:i+2])
        
#     for s in string1:
#         if s.isalpha() == False or len(s)!=2:
#             string1.remove(s)
#     for s in string2:
#         if s.isalpha() == False or len(s)!=2:
#             string2.remove(s)
    
#     if string1 == [] or string2 == []:
#         return 65536
    
#     intersection = []
#     union = []
#     union.extend(string2)
#     for i in string1:
#         if i in string2:
#             intersection.append(i)
#         else:
#             union.append(i)
            
#     import math
#     answer = math.trunc(len(intersection)/len(union)*65536)
    
#    return answer

# 참고 사이트 : https://velog.io/@good159897/프로그래머스-Python-뉴스-클러스터링