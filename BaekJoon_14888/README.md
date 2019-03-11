# 14888 연산자 끼워넣기

## 접근법

> DFS를 이용해 Backtracking 을 통한 완전 탐색

- DFS를 통해 완전 탐색

```java
//index : 피연산자 인덱스, 지금까지 해온 연산결과 총값
void dfs(int index, int totalNum) {
  
  if (index == N) {
    //최대값 최소값 구한다.
  }
  
  if(oper[i] > 0 ) {
    oper[i]--;
    dfs(inedx + 1, total +, -, *, / array[index]);
    //핵심 : 완전탐색을 위해 백트랙킹을 해주어야 한다.
    oper[i]++;
  }
}
```

- backtracking 을 통해 완전탐색 즉 모든 경우의 수를 구하기 위해서는 `해당 구역 방문 -> DFS -> 해당 구역 방문 해제` 구조를 통해 모든 경우의 수를 구한다.

## 개선방향

> BFS를 통해 구현도 해볼것, DFS 및 백트랙킹 완전탐색에 대해서 완벽 이해 후 코드 개선 필요.
  
