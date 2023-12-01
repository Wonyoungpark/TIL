def solution(myStr):
    myStr = myStr.replace("a"," ").replace("b"," ").replace("c"," ").split(" ")
    answer = [s for s in myStr if s!=""]
    if answer==[]: return ["EMPTY"]
    return answer