n,m = map(int,input().split())
x,y,direction = map(int,input().split())

answer = [[0]*m for _ in range(n)]
answer[x][y] = 1 # 현재 위치는 방문 처리
game_map = []

for _ in range(n):
      game_map.append(list(map(int,input().split())))

#0북,1동,2남,3서
dx=[-1,0,1,0]
dy=[0,1,0,-1]

#왼쪽 방향 회전
def turn_left():
  global direction
  direction -= 1 # 북(0) -> 서(3) -> 남(2) -> 동(1)
  if direction == -1:
    direction = 3

count = 1 # 처음 위치 포함
turn_time = 0

while True:
  turn_left()
  # nx, ny는 이동 위치
  nx = x + dx[direction]
  ny = y + dy[direction]

  # 안 가봤고, 칸이 존재하는 경우 이동
  if answer[nx][ny] == 0 and game_map[nx][ny] == 0:
    answer[nx][ny] = 1
    x = nx
    y = ny
    count += 1
    turn_time = 0
    continue
  else:
    turn_time += 1
  if turn_time == 4: # 돌만큼 돌았다면
    nx = x - dx[direction]
    ny = y - dy[direction]
    # 뒤로 갈 수 있으면 이동, 뒤가 바다라면 움직임 멈춤
    if game_map[nx][ny] == 0:
      x = nx
      y = ny
    else:
      break
    turn_time = 0

print(count)