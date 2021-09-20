def solution(price, money, count):
    answer = -1
    use = 0

    for i in range(1,count+1):
        use += price*i
    if use > money:
        answer = use - money
    else:
        answer = 0
    return answer