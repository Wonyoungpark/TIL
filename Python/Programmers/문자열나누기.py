def solution(s):
    answer = 0
    same = 0
    diff = 0
    
    for i in range(len(s)):
        if same==diff:
            answer+=1
            x = s[i]
            same,diff = 0,0
        if s[i]==x: same+=1
        else: diff+=1
            
    return answer