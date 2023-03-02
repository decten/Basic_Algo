n,m = map(int,input().split())
answer = 0

for i in range(n):
  data = list(map(int, input().split()))
  value = min(data)
  answer = max(value, answer)

print(answer)