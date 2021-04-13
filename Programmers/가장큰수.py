def solution(numbers):
    numbers = list(map(str,numbers))
    numbers.sort(key = lambda x: x*3, reverse = True)
    answer = str(int(''.join(numbers)))
    
    # numbers = [str(i) for i in numbers]
    # import itertools
    # str_num = list(map(''.join, itertools.permutations(numbers)))
    # answer = max(str_num)
    return answer