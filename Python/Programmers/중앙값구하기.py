def solution(array):
    answer = 0
    array.sort()
    l = len(array)//2
    answer = array[l]
    return answer