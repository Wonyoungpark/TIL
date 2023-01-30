from itertools import permutations

def solution(babbling):
    answer = 0
    pronounce = ["aya", "ye", "woo", "ma"]
    words = []
    
    for i in range(1,len(pronounce)+1):
        for p in permutations(pronounce,i):
            words.append(''.join(p))
    
    for b in babbling:
        if b in words:
            answer += 1
            
    return answer

