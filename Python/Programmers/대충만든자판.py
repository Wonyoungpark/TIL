def solution(keymap, targets):
    answer = []
    for target in targets:
        cnt = 0
        for tar in target:
            keys = []
            for key in keymap:
                k = key.find(tar)
                if k!=-1: keys.append(k)
            keys.sort()
            if keys:
                cnt += keys[0]+1
            else:
                cnt = -1
                break
        answer.append(cnt)
    return answer