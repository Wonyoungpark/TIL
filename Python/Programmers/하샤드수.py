def solution(x):
    num = [int(i) for i in str(x)]
    if (x%sum(num))==0: return True
    else: return False