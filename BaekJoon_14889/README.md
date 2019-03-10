# 14889 스타트 링크

## 접근법

> DFS를 이용한 브루트포스(완전접근 법)

- N/2 의 start 팀 기준으로 팀원 구성의 경우의 수를 위해 DFS 를 이용한 BackTracking

- start 팀 기준으로 N/2 뽑은 인원은 `isUsed` boolean 배열을 이용해 뽑은지 안뽑은지를 기록
(visited 와 같은 원리)

- pseudo code

```java
void DFS(cnt,currentPeople) {
  if cnt == N/2 {
   	//ArayList를 이용해 start link 의 팀원을 추가
    //각 팀의 능력치를 구한뒤 이전의 능력치와 비교 -> 최소값 구한다
    return;
  }
  
  for(int i = currentPeople + 1; i < N ; i ++ ) {
    //아직 뽑히지 않았다면
    if isUsed[i] == false {
      isUsed[i] = true;
      DFS(i, cnt + 1);
      //핵심 = back tracking 을 이용해 뽑힌 사람을 다시 false 함으로써 완전 탐색이 가능하게 함
      isused[i] = false
      }
  }
```

## 개선방향

> DFS를 재귀 탐색이 아닌 iterative로 구현하고 메모리에 조금더 신경을 쓸 필요가 있다.

