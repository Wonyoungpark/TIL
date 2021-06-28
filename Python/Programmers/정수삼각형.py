def solution(triangle):
    triangle = [[0]+line+[0] for line in triangle]
    
    for i in range(1,len(triangle)):
        for j in range(1,i+2):
            print(triangle[i-1][j-1], triangle[i-1][j])
            print(triangle[i][j])
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
    return max(triangle[-1])
    
#     answer = triangle[0][0]
#     index = 0
#     triangle.pop(0)
    
#     for t in triangle:
#         answer += max(t[index],t[index+1])
#         if max(t[index],t[index+1]) == t[index+1]:
#             index += 1
#     return answer

# 참고 사이트 : https://velog.io/@tjdud0123/정수-삼각형