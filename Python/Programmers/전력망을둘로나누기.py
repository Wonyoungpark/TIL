def solution(n, wires):
    # lights = [0]*n
    # for wire in wires:
    #     lights[wire[0]-1] += 1
    #     lights[wire[1]-1] += 1
    # many = {}
    # for e, l in enumerate(lights):
    #     if l > 1:
    #         many[e+1] = l
    # cp_list = []
    # for w in wires:
    #     if w[0] in many.keys() and w[1] in many.keys():
    #         cp_list.append(w)
    
    from collections import defaultdict
    graph = defaultdict(list)
    answer = 101
    for a,b in wires:
        graph[a].append(b)
        graph[b].append(a)
    for a,b in wires:
        nodes,cnt,visited = [a],0,[b]
        while nodes:
            node = nodes.pop()
            if node in visited: continue
            visited.append(node)
            cnt += 1
            nodes += graph[node]
        answer = min(answer,abs(n-cnt*2))
    return answer

# 참고 사이트 : https://velog.io/@edhz8888/TIL211006프로그래머스-위클리챌린지-9주차