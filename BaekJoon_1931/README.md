# 1913 회의실 배정

처음에 DP로 접근할려다가 N의 사이즈가 상당히 큰걸로 보아 비효율적으로 판단했다.

## 접근법

> Greedy 와 조건에 의한 정렬

- 회의 시간은 `(strat ,end)` 로 최대한의 회의를 실시할수있는 횟수를 구해야한다.
- 이전 종료 시간(end)과 동일하거나 그 이상의 시작시간(start)가 있어야 회의를 할 수 있다.
	- ex) 2 , 5 -> 5, 7 or 6, 8 가능

- 예외와 히든 케이스를 생각해야한다
	- 우선 회의의 시작과 종료시간 차이가 0이 될수도있다 (1, 1) (1, 1) (1, 2) (2, 2) (2, 3) 이런식으로도 가능하다 회의 시간은 중복이 될수도 있다는 걸 유념해야한다
   
    
## Collections.sort() 사용

Java 내에서 제공하는 sort() 함수를 변형하여 문제를 풀었다.

- 종료 시간(end)을 기준으로 정렬하되 종료 시간이 같을 경우 시작 시간을 비교하여 시작시간이 빠른 순으로 정렬한다

```java
Collections.sort(list, new Comparator<Time>() {

			@Override
			public int compare(Time o1, Time o2) {
				// TODO Auto-generated method stub
              //종료시간 기준으로 정렬
				if (o1.end > o2.end) {
					return 1;	
                  //같은 경우
				} else if (o1.end == o2.end) {
                  //시작시간을 비교하여 오름차순
					if(o1.start > o2.start)
						return 1;
					else
						return -1;
				} else {
					return -1;
				}
			}
			
		});
```

