def solution(my_string, num1, num2):
    answer = ''
    m_list = list(my_string)
    x = m_list[num2]
    y = m_list[num1]
    m_list[num1] = x
    m_list[num2] = y
    answer = ''.join(m_list)
    return answer