def solution(dots):
    dots.sort()
    return (dots[1][1]-dots[0][1])*(dots[-1][0]-dots[-3][0])