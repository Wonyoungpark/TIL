def solution(bridge_length, weight, truck_weights):
    going = [0]*bridge_length
    time = 0
    
    while going:
        time += 1
        going.pop(0)
        if truck_weights:
            if sum(going) + truck_weights[0] <= weight:
                going.append(truck_weights.pop(0))
            else:
                going.append(0)
    return time