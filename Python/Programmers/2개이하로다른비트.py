# def solution(numbers):
#     answer = []
#     for number in numbers:
#         bn = bin(number)[2:]
#         idx = bn.rfind('0')
        
#         if idx!=-1:
#             res = bn[:idx]+"1"+bn[idx+1:]
#             for i in range(idx,len(res)):
#                 if res[i]=="1":
#                     temp = res[:i]+"0"+res[i+1:]
#                     if bn<temp<res: res = temp
#                     break
#             result = int(res,2)
#         else:
#             result = int(bn[0]+"0"+bn[1:],2)
            
#         answer.append(result)
#     return answer


def solution(numbers):
    answer=[]
    
    for number in numbers:
        if number%2 == 0:
            answer.append(number+1)
            continue
            
        bnum = '0'+bin(number)[2:]
        bnum = bnum[:bnum.rindex('0')] + '10' + bnum[bnum.rindex('0')+2:]
        answer.append(int(bnum,2))
        
    return answer