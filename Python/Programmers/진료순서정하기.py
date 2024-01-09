def solution(emergency):
    order = sorted(emergency, reverse=True)
    answer = [order.index(e)+1 for e in emergency]
    
    return answer