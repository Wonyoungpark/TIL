from collections import deque

def solution(queue1, queue2):
    answer = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    s1 = sum(queue1)
    s2 = sum(queue2)
    
    if (s1+s2)%2==1: return -1
    limit = len(queue1)*4
    
    while True:
        if answer==limit: return -1
        if s1>s2:
            tmp = queue1.popleft()
            queue2.append(tmp)
            s1-=tmp
            s2+=tmp
        elif s1<s2:
            tmp = queue2.popleft()
            queue1.append(tmp)
            s2-=tmp
            s1+=tmp
        else: break
        answer += 1
    return answer
