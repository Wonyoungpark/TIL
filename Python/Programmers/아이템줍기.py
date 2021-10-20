import itertools

def is_movable(cur_x, cur_y, next_x, next_y, rectangles):
    x,y = (cur_x+next_x)/2, (cur_y+next_y)/2
    is_on_any_border = any((x in (x1,x2) and y1<=y<=y2) or (y in (y1,y2) and x1<=x<=x2) for x1,y1,x2,y2 in rectangles) # 사각형 테두리 좌표 찾기
    is_inside_any_rect = any(x1<x<x2 and y1<y<y2 for x1,y1,x2,y2 in rectangles) # 사각형 내부 좌표 찾기
    return is_on_any_border and not is_inside_any_rect
    

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    cur_pos = (characterX, characterY) # 현재 사람의 위치
    prev_pos = None
    
    for dist in itertools.count():
        if cur_pos == (characterX, characterY) and prev_pos: # 한바퀴 돌았는지 확인
            perimeter = dist
            break
        elif cur_pos == (itemX,itemY): # 현재 좌표가 목적지인지 확인
            dist_to_item = dist
        for dx, dy in ((1,0),(-1,0),(0,1),(0,-1)):
            next_pos = (cur_pos[0]+dx, cur_pos[1]+dy) # 다음으로 이동할 좌표
            if next_pos != prev_pos and is_movable(*cur_pos,*next_pos,rectangle): # 이동 가능한 좌표인지 확인
                prev_pos, cur_pos = cur_pos, next_pos
                break
                
    answer = min(dist_to_item, perimeter-dist_to_item)
    return answer

# 참고 사이트 : https://programmers.co.kr/learn/courses/30/lessons/87694/solution_groups?language=python3