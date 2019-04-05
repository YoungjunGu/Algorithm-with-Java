# 타겟넘버

## 접근법

> DFS를 활용하여 모든 경우의 수의 연산을 구한뒤 조건에 맞게 DFS 재귀 함수를 탈출하자!

- target에 해당하는 숫자가 구해지면 answer을 증가시킨다

- DFS 구조
```java
// target == 구하고자 하느 수,  cnt == 연산자의 셋팅이 완료된 횟수 
 public void dfs(int[] numbers, int target, int cnt) {
        // 연산자가 모두 셋티 되었으면 값을 구한뒤 비교후 적절히 탈출하면 된다.
        if(cnt == numbers.length) {
            int sum = 0;
            for(int i = 0 ; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if(sum == target) {
                answer++;
                return;
            } else {
                return;
            }
        }       
            dfs(numbers, target,cnt+1);
            numbers[cnt] *= -1;
            dfs(numbers, target,cnt+1);
            numbers[cnt] *= 1;
        return;
    }
```    


## 다른 사람 풀이

```java
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
```
