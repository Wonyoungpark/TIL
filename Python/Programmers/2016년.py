def solution(a, b):
    days = ["THU","FRI","SAT","SUN","MON","TUE","WED"]
    month = [31, 29, 31, 30, 31, 30 , 31, 31, 30, 31, 30, 31]
    answer = days[(sum(month[:a-1])+b)%7]
    
#     days = ["FRI","SAT","SUN","MON","TUE","WED","THU"]
#     day = 0
#     a = a-1
#     if a == 0:
#         day = 0
#     elif a == 2:
#         day = 29
#     elif a<=7 and a%2==0:
#         day = 30
#     elif a<=7 and a%2==1:
#         day = 31
#     elif a>=7 and a%2==0:
#         day = 31
#     else:
#         day = 30
    
#     result = (a*day+b)%7
#     answer = days[result]
    return answer