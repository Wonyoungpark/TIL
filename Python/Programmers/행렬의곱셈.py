def solution(A, B):
    import numpy as np
    A = np.array(A)
    B = np.array(B)
    answer = np.dot(A,B).tolist()
    return answer