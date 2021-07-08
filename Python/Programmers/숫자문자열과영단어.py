def solution(s):
    answer = 0
    diction = ["zero","one","two","three","four","five","six","seven","eight","nine"]
    number = ""
    stack = ""
    
    for i in s:
        if i.isdigit():
            number += str(i)
        else:
            stack += i
            if stack in diction:
                number += str(diction.index(stack))
                stack=""
    answer = int(number)
    return answer