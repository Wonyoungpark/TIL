def solution(babbling):
    answer = 0
    pron = ["aya", "ye", "woo", "ma"]
    
    for bab in babbling:
        if bab in pron: answer += 1
        else:
            temp = ""
            prev = ""
            
            for b in bab:
                temp+=b
                if temp in pron and prev!=temp:
                    prev=temp
                    temp = ""
                elif len(temp)>3: break
            if temp=="": answer += 1
                
            
    return answer