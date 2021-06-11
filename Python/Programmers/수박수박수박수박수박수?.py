def solution(n):
    string=""
    for i in range(1,n+1):
        if i%2 == 0:
            string += "박"
        else:
            string += "수"
    
    return string