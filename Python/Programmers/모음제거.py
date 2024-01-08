def solution(my_string):
    alph = [ 'a', 'e', 'i', 'o', 'u']
    for a in alph:
        if a in my_string: my_string = my_string.replace(a,'')
    return my_string