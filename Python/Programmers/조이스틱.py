def solution(name):
    answer = 0
    
    name = list(name)
    i = 0
    
    while True:
        answer += min(ord(name[i])-ord('A'), ord('Z')-ord(name[i])+1)
        name[i]='A'
        
        if name.count('A') == len(name): return answer
        
        left, right = 1, 1
        for l in range(1, len(name)):
            if name[i-l] =='A': left += 1
            else: break
        for r in range(1, len(name)):
            if name[i+r] == 'A': right += 1
            else: break
        
        if left < right:
            answer += left
            i -= left
        else:
            answer += right
            i += right
            
            
#     alphabet = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
#     index_list = []
    
#     for a in name:
#         if a!= 'A':
#             index_list.append(alphabet.index(a)-1)
#         else:
#             index_list.append(alphabet.index(a))
            
#     prev = 0
#     prevj = 0
#     while index_list:
#         i = index_list.index(min(index_list))
#         j = min(index_list)
        
#         answer += j-prevj+i-prev
#         prev = i
#         prevj = j
#         index_list.pop(i)
    return answer