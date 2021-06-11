def solution(array, commands):
    answer = []
    for command in commands:
        i,j,k = command[0], command[1], command[2]
        slices = array[i-1:j]
        slices.sort()
        answer.append(slices[k-1])
    return answer