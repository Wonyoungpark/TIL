def solution(s, skip, index):
    answer = ''
    skip = list(skip)
    alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    
    for i in s:
        cnt = index
        while (cnt!=0):
            idx = alpha.index(i)+1
            if idx >= 26: idx = idx-26
            char = alpha[idx]
            if char not in skip: cnt-=1
            i = char
        answer += char
    return answer