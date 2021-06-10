def solution(s):
    answer = []
    stack = []
    s = s.replace("{{","").replace("}}","")
    s_split = s.split("},{")
    for s in s_split:
        stack.append(s.split(","))
    stack.sort(key=len)
    
    for s in stack:
        for i in s:
            if i not in answer:
                answer.append(i)
    answer = list(map(int, answer))
    return answer