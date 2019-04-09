# 땅따먹기

## Reference

[프로그래머스 땅따먹기](https://programmers.co.kr/learn/courses/30/lessons/12913)

## 접근법

> DP: 규칙속에 점화식 도출

- 규칙 : 전에 밟았더 땅의 idnex는 바로 다음에 밟을 수 없다.

![image](https://user-images.githubusercontent.com/33486820/55765995-7cbb4300-5aad-11e9-94a3-4aea01423425.png)

```java

        for(int i = 0 ; i < land.length - 1; i++) {
        	land[i+1][0] = Math.max(land[i][1], Math.max(land[i][2], land[i][3])) + land[i + 1][0];
        	land[i+1][1] = Math.max(land[i][0], Math.max(land[i][2], land[i][3])) + land[i + 1][1];
        	land[i+1][2] = Math.max(land[i][0], Math.max(land[i][1], land[i][3])) + land[i + 1][2];
        	land[i+1][3] = Math.max(land[i][0], Math.max(land[i][1], land[i][2])) + land[i + 1][3];
        }
        answer = Math.max(Math.max(land[last - 1][0], land[last-1][1]), Math.max(land[last -1 ][2], land[last-1][3]));
```


위의 그림 처럼 K (i행) 의 그다음 밟을 수 있는 땅의 선택지는 b, c, d 3가지 이다. 그러면 매순간 선택을 할때 다음 행에 가중치를 더해서 최대의 값을 갖게 update를 해주면된다.
K 이전의 행도 그런 식으로 진행을 해오면 결국 마지막 행에는 각 열에서 시작한 가중치의 총합이 들어가있고 최대의 값은 마지막행에서 도출해내면 된다.
