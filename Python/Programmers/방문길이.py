def solution(dirs):
    answer = 0
    dm = {
        'U':(0,1),
        'D':(0,-1),
        'R':(1,0),
        'L':(-1,0)
    }
    x,y = 0,0
    moving = set()
    
    for d in dirs:
        dx,dy = dm[d]
        if -5<=dx+x<=5 and -5<=dy+y<=5:
            moving.add((x,y,x+dx,y+dy))
            moving.add((x+dx,y+dy,x,y))
            x+=dx
            y+=dy
    answer = len(moving)//2
    return answer