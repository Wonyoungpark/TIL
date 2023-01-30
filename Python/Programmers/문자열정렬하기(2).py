def solution(my_string):
    answer = ''
    my_string = list(my_string.lower())
    my_string.sort()
    answer = ''.join(my_string)
    
    return answer