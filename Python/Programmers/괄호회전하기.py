def count_s(s):
    stack = []
    cnt = 0
    
    for i in s:
        if i=="[" or i=="(" or i=="{":
            stack.append(i)
        else:
            if stack == []:
                continue
            elif stack[-1]=="[" and i=="]":
                stack.pop()
                cnt += 1
            elif stack[-1]=="{" and i=="}":
                stack.pop()
                cnt += 1
            elif stack[-1]=="(" and i==")":
                stack.pop()
                cnt += 1
                
    if cnt == len(s)/2:
        return True
    else:
        return False

def solution(s):
    answer = 0
    
    for i in range(len(s)):
        num = s[0]
        s = s[1:]+num
            
        if (count_s(s)):
            answer += 1
    
    return answer