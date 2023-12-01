def solution(arr):
    answer = 1
    l = len(arr)
    for i in range(l):
        for j in range(l):
            if arr[i][j] != arr[j][i]: return 0
    return answer