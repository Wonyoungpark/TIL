def solution(table, languages, preference):
    answer_table = []
    j_table = []
    test = {}
    
    # table 분해
    for t in table:
        j_table.append(t.split())
    
    # 입력 언어별 언어 선호도 조사
    for lang in languages:
        s_table = []
        for jobs in j_table:
            if lang in jobs:
                score = 6-jobs.index(lang)
            else:
                score = 0
            s_table.append(score)
        test[lang] = s_table
    
    # 언어 선호도 * 직업군 언어
    cnt = 0
    for t,v in test.items():
        import numpy as np
        nv = np.array(v)
        nv *= preference[cnt]
        cnt += 1
        test[t] = nv.tolist()
        
    # 값 더하기
    answer_table =  [0,0,0,0,0]
    for i in range(len(test.values())):
        import operator
        answer_table = list(map(operator.add, answer_table, test[languages[i]]))
        
    answer=''
    idx = list(filter(lambda x: answer_table[x] == max(answer_table), range(len(answer_table))))
    if idx != 1: # 같은 직업군이 여러 개일 경우
        a = [j_table[i][0] for i in idx]
        a.sort()
        answer = a[0]
    else:
        answer = j_table[idx][0]
        
    return answer