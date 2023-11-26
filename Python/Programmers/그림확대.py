def solution(picture, k):
    answer = []
    for pic in picture:
        string = ""
        for p in pic:
            string += p*k
        for i in range(k):
            answer.append(string)
    return answer