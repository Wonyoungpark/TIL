def solution(word):
    answer = len(word)
    alphabet = ["A","E","I","O","U"]
    
    # cnt = 0
    # for e,w in enumerate(word):
    #     idx = alphabet.index(w)
    #     answer += (5**e)*idx
    #     print(answer)
    
    rep = (((5+1)*5 +1)*5 +1)*5 +1
    for w in word:
        answer += rep * alphabet.index(w)
        rep = (rep-1) // 5
        
    return answer

# 참고 사이트 : https://ye333.tistory.com/entry/프로그래머스python-위클리-챌린지-5주차-모음-사전