# Java Collection Framework

알고리즘 풀이에 자주 사용하는 컬렉션 프레임워크를 정리하고 그밖에 필요한 메소드 들을 정리

## String 다루기

- `charAt(int index)` : 해당 index의 문자값(Character) 반환
- `indexOf(String keyword)` : 해당 문자열에서 찾고자 하는 keyword의 시작 index 반환
- `lastIndexOf(String keyword)` : indexOf와 반대로 문자열의 끝에서 왼쪽으로 keyword를 찾아 index 반환
- `legnth()` : 문자열 길이 반환

## Collection sort

- `Collection.sort()` : 컬렉션 자동 정렬 메서드

```java
Collections.sort(list, new Comparator<Time>() {

			@Override
			public int compare(int o1, int o2) {
				// TODO Auto-generated method stub

				if (o1 > o2) {
					return 1;	
				} else if (o1.end == o2.end) {
                  	return 0;
                }else {
                    return -1
                }	
		});
```