def solution(a, b):
    sum=0
    if a > b:
        temp = a
        a = b
        b = temp
    for num in range(a,b+1):
        sum += num
    return sum