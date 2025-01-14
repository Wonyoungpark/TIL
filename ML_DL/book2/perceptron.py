import numpy as np

class Perceptron(object):
    def __init__(self, eta=0.01, n_iter=50, random_state=1):
        self.eta = eta
        self.n_iter = n_iter
        self.random_state = random_state
    
    def fit(self, X, y): # 훈련 데이터 학습
        rgen = np.random.RandomState(self.random_state)
        self.w_ = rgen.normal(loc=0.0, scale=0.01, size=1+X.shape[1])
        self.errors_ = []
        
        for _ in range(self.n_iter):
            errors = 0
            for xi, target in zip(X,y):
                update = self.eta * (target-self.predict(xi))
                self.w_[1:] += update*xi
                self.w_[0] += update
                errors += int(update!=0.0)
            self.errors_.append(errors)
            
        return self
    
    def net_input(self, X): # 입력 계산
        return np.dot(X, self.w_[1:]) + self.w_[0]
    
    def predict(self, X): # 단위 계단 함수를 사용해 클래스 레이블을 반환
        return np.where(self.net_input(X)>=0.0, 1, -1)

