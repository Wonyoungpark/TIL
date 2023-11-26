def solution(myString):
    string = myString.split("x")
    answer = [len(s) for s in string]
    return answer