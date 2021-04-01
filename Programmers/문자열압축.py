def solution(s):
    leng = len(s)
    cnt = 1
    answer = [leng]
    
    for spl in range(1,leng):
        result = ""
        split_str = [ s[i:i+spl] for i in range(0,leng, spl)] # 문자열 갯수별로 쪼개기
        stack = [[split_str[0],1]]
        
        for unit in split_str[1:]:
            if stack[-1][0] != unit: # 이전값과 다른 경우
                stack.append([unit,1])
            else: # 이전값과 같은 경우
                stack[-1][cnt] += 1
        
        result += ('').join([str(cnt) + w if cnt > 1 else w for w, cnt in stack])
        answer.append(len(result))
    return min(answer)

    # 참고 https://velog.io/@tjdud0123/문자열-압축-2020-카카오-공채-python