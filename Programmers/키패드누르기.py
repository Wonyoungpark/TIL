def solution(numbers, hand):
    answer = ''
    l_hand = 10
    r_hand = 12
    
    for i in numbers:
        if i == 1 or i == 4 or i == 7:
            answer += 'L'
            l_hand = i
        elif i == 3 or i == 6 or i == 9:
            answer += 'R'
            r_hand = i
        else:
            i = 11 if i == 0 else i # 0을 11로 변환
            
            l_abs = abs(i-l_hand)
            r_abs = abs(i-r_hand)
            
            if sum(divmod(l_abs,3)) > sum(divmod(r_abs,3)):
                answer += 'R'
                r_hand = i
            elif sum(divmod(l_abs,3)) < sum(divmod(r_abs,3)):
                answer += 'L'
                l_hand = i
            else:
                if hand == 'left':
                    answer += 'L'
                    l_hand = i
                else:
                    answer += 'R'
                    r_hand = i
    return answer