def solution(order):
    answer=0
    stack=[]
    i=1

    while i!=(len(order)+1):
        stack.append(i)
        while stack and stack[-1]==order[answer]:
            answer+=1
            stack.pop()
        i+=1
    return answer