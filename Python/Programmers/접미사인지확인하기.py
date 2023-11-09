def solution(my_string, is_suffix):
    
    while my_string:
        if is_suffix == my_string: return 1
        else:
            my_string = my_string[1:]
    return 0