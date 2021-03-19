def solution(skill, skill_trees):
    answer = 0

    for test in skill_trees:
        skill_list = list(skill)
        for t in test:
            # if t in skill:
            if t != skill_list.pop(0):
                break
        else:
            answer += 1

    return answer