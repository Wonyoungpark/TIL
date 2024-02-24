import string

def solution(msg):
    answer = []
    dic = [a for a in string.ascii_uppercase]
    i=0
    cnt=0
    
    while i<len(msg):
        w=msg[i]
        for j in range(i+1,len(msg)+1):
            if msg[i:j] in dic: w=msg[i:j]
            else: break
        dic.append(msg[i:j])
        answer.append(dic.index(w)+1)
        cnt += len(w)
        if cnt==len(msg): return answer
        else: i = j-1
        
# 참고 사이트 : https://enlqn1010.tistory.com/99