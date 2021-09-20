# def calc_grade(avg):
#     grade = ''
#     if avg >=90: grade='A'
#     elif avg>=80 and avg<90: grade='B'
#     elif avg>=70 and avg<80: grade='C'
#     elif avg>=50 and avg<70: grade='D'
#     else: grade='F'
#     return grade

# def solution(scores):
#     answer = ''
    
#     # 행열 전환
#     scores = list(map(list,zip(*scores)))
    
#     # 자체 채점 최고/최저 점수 제거
#     self_list = []
#     for e,s in enumerate(scores):
#         self_list.append(s[e])
#     if self_list.count(max(self_list)) == 1:
#         idx = self_list.index(max(self_list))
#         del scores[idx][idx]
#     if self_list.count(min(self_list)) == 1:
#         idx = self_list.index(min(self_list))
#         del scores[idx][idx]
    
#     for score in scores:
#         avg = sum(score)/len(score) # 평균 계산
#         answer += calc_grade(avg) # 학점 계산
        
#     return answer

def solution(scores):
    answer = ''
    for j in range(len(scores)):
        cnt = len(scores)
        add = 0
        high = 0
        low = 101
        for i in range(len(scores)):
            add += scores[i][j]
            if i == j:
                continue
            if high < scores[i][j]:
                high = scores[i][j]
            elif low > scores[i][j]:
                low = scores[i][j]

        if scores[j][j] > high or scores[j][j] < low:
            add -= scores[j][j]
            cnt -= 1
        grade = add / cnt
        if grade >= 90:
            answer += 'A'
        elif 80 <= grade < 90:
            answer += 'B'
        elif 70 <= grade < 80:
            answer += 'C'
        elif 50 <= grade < 70:
            answer += 'D'
        else:
            answer += 'F'

    return answer

# 참고 사이트 : https://bingbing-study.tistory.com/192