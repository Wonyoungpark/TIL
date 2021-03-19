from itertools import combinations
def solution(numbers):
    answer = []
    cnt = 0
    
    for i in combinations(numbers,2):
        answer.append(sum(i))
        
    return sorted(set(answer))