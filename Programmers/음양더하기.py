def solution(absolutes, signs):
    answer = 0
    for number in zip(absolutes, signs):
        if number[1]:
            answer += number[0]
        else:
            answer -= number[0]
    return answer