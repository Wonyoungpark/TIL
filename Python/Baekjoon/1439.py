def solution():
    import sys

    input = sys.stdin.readline() # 입력값 받기
    s = input[0] # 뒤집을지 말지 비교하는 기준점 설정 (제일 첫 문자)
    result = [s] # 기준점이 변경될 때마다 저장할 리스트

    for i in range(1,len(input)):
        if s!=input[i]: # 만약 문자열이 뒤집어야한(변경된)다면
            result.append(input[i]) # 변경되는 문자 저장
            s = input[i] # 기준점 변경

    cnt = min(result.count('0'), result.count('1')) # 0과 1 중에서 덜 출현한 문자를 뒤집기

    return cnt

print(solution())