def solution(n, words):
    answer = [0,0]
    cnt = 1

    for i in range(1, len(words)):
        word = words[i]
        cnt %= n
        if (word in words[0:i]) or (words[i-1][-1] != word[0]):
            answer = [cnt+1, 1+i//n]
            return answer
        cnt += 1

    return answer