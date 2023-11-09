def solution(my_string, queries):
    my_string = list(my_string)
    
    for q in queries:
        for i in range((q[1]-q[0])//2+1):
            temp = my_string[i+q[0]]
            my_string[i+q[0]] = my_string[q[1]-i]
            my_string[q[1]-i] = temp
    return ''.join(my_string)