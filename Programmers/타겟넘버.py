def solution(numbers, target):
    answer = [0]
    for i in numbers:
        test = []
        for j in answer : 
            test.append(j+i)
            test.append(j-i)
        answer = test
    return answer.count(target)