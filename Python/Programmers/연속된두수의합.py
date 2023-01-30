def solution(num, total):
    mid = int(total/num)
    answer = []
    
#     if num%2 == 1:
#         for i in range(1,int(num/2)+1):
#             answer.append(mid+i)
#             answer.append(mid-i)
#     else:
#         answer.append(mid)
    
#     answer.sort()

    answer = [i for i in range(mid-(num-1)//2, mid+(num+2)//2)]
    return answer