# Java Collection Framework

알고리즘 풀이에 자주 사용하는 컬렉션 프레임워크를 정리하고 그밖에 필요한 메소드 들을 정리

## String 다루기


- startWith: 문자열이 지정한 문자로 시작하는지 판단 같으면 true반환 아니면 false를 반환한다.(대소문자구별)

```java
String str = "apple";
boolean startsWith = str.startsWith("a");
System.out.println("startsWith: " + startsWith);
결과값:true
```

- endWith:문자열 마지막에 지정한 문자가 있는지를 판단후 있으면 true, 없으면 false를 반환한다.(대소문자구별)

```java
String str = "test";
boolean endsWith = str.endsWith("t");
System.out.println("endsWith: " + endsWith);
결과값:true
```

- equals:두개의 String에 값만을 비교해서 같으면 true, 다르면 false를 반환한다.(대소비교)

```java
String str1 = "java";
String str2 = "java";
boolean equals = str1.equals(str2);
System.out.println("equals: " + equals);
결과값:true
```

- indexOf:지정한 문자가 문자열에 몇번째에 있는지를 반환한다.

```java
String str = "abcdef";
int indexOf = str.indexOf("d");
System.out.println("indexOf: " + indexOf);
결과값:3
```
  

- lastindexOf:문자열에 지정한 문자가 마지막몇번째에 있는 int를 반환한다.

```java
String str = "AdnroidApp";
int lastIndexOf = str.lastIndexOf("A");
System.out.println("lastIndexOf:" + lastIndexOf);
결과값:7
```

- length:문자열의 길이를 반환한다.

```java
String str = "abcdef";
int length = str.length();
System.out.println("length: " + length);
결과값:6
```

- replace:문자열에 지정한 문자" "가 있으면 새로 지정한 문자" "로 바꿔서 출력한다.

```java
String str = "A*B*C*D";
String replace = str.replace("*", "-");
System.out.println("replace: " + replace);
결과값: A-B-C-D
```


- replaceAll:정규표현식을 지정한 문자로 바꿔서 출력한다.

```java
String str = "AB CD";
String replaceAll = str.replaceAll("\\p{Space}", "*");
System.out.println("replaceAll: " + replaceAll);
결과값: AB*CD
```

- split:지정한 문자로 문자열을 나눌수 있다.(배열로 반환)

```java
String str = "A:B:C:D:abcd";
String[] split = str.split(":");
System.out.println("split: " + split[1]);
결과값:B
```

- substring:문자열에 지정한 범위에 속하는 문자열을 반환한다.(시작범위에 값은 포함하고, 끝나는 범위에 값은 포함하지않는다.)

```java
String str = "ABCDEF";
String substring = str.substring(0, 2);
System.out.println("substring: " + substring);
결과값:AB
```

- toLowerCase: 문자열에 대문자를 소문자로 변환한다.

```java
String str = "abcDEF";
String toLowerCase = str.toLowerCase();
System.out.println("toLowerCase: " + toLowerCase);
결과값:abcdef
```

- toUpperCase:문자열에 소문자를 대문자로 변환한다.

```java
String str = "abcDEF";
String toUppercase = str.toUpperCase();
System.out.println("toUppercase: " + toUppercase);
결과값:ABCDEF
```

- toString:문자열을 그대로 반환해준다.

```java
String str = "1234";
String toString = str.toString();
System.out.println("toString: " + toString);
결과값:1234
```

- trim:문자열에 공백을 없에준다.

```java
String s = "     java java java     ";
String v;
v = s.trim();
System.out.println("trim:" + v);
결과값:java java java
```


- valueOf:지정한 개체의 원시 값을 반환

```java
int i = 12345;
long l = 1L;
char c = '1';
System.out.println("valueOf: " + String.valueOf (i));
System.out.println("valueOf: " + String.valueOf (l));
System.out.println("valueOf: " + String.valueOf (c));
결과값:
valueOf: 12345
valueOf: 1
valueOf: 1
```

- compareTo:두개의 String를 앞에서부터 순사적으로 비교하다가 틀린부분이 있으면 비교하는 String에 캐릭터값을 반환한다.(대소문자를 구별)

```java
String str1 = "A";
String str2 = "B";
int compareTo = str1.compareTo(str2);

if(compareTo > 0){

       System.out.println(str1 + " > " +str2);
} else if (compareTo == 0){
       System.out.println(str1 + " = " +str2);
} else{
       System.out.println(str1 + " < " +str2);
}
결과값:
A < B
```

- contains:두개의 String을 비교해서 비교대상 String을 포함하고 있으면true, 다르면 false를 반환한다.

```java
String str1 = "abcd";
String str2 = "c";
boolean contains = str1.contains(str2);
System.out.println("contains: " + contains);
결과값:true
```  
  

- charAt:지정한 index번째에 문자를 반환한다.

```java
String str = "charAt";
char charAt = str.charAt(2);
System.out.println("charAt: " + charAt);
결과값:a
```


- concat:문자와 문자를 결합해준다.

```java
String str1 = "Han";
String str2 = "SeeJin";
String concat = str1.concat(str2);
System.out.println("concat: " + concat);
결과값:HanSeeJin
```

- format:서식문자열을 이용해서 서식화된 문자열을 반환한다.

```java
int i = 123456789;
String str = String.format("%,d", i);
System.out.println("format: " + str);
결과값:123,456,789
```

- matches:지정한 정규 표현과 일치 할때 true를 반환한다.

```java
int i = 123456;
String str1 = String.format("%,d", i);
String str2 = "123456";
boolean matches = str1.matches(str2);
System.out.println("matches: " + matches);
결과값:false
```

- replaceFirst:문자열에 지정한 문자" "가 있으면 첫번째만 새로지정한 문자" "로 바꿔서 출력한다.

```java
String str = "Aman";
String replaceFirst = str.replaceFirst("A", "super");
System.out.println("replaceFirst: " + replaceFirst);
```


출처: https://sks3297.tistory.com/entry/자바-문자열-함수 [SIM's Review]

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


## HashMap

- HashMap(): HashMap 객체를 생성

```java
HashMap<String , Integer> map = new HashMap<String , Integer>();

      Map<String, Integer> map = new HashMap<String, integer>();
```

- HashMap(int initlalCapacity): 지정된 값을 초기 용량으로 하는 HashMap객체를 생성한다.

- HashMap(int initlalCapacity, float loadFactory) : 지정된 값을 초기용량과 load factory의 HashMap 객체를 생성한다. 

- HashMap(Map m) : 주어진 Map에 저장된 모든 요소를 포함하는 HashMap을 생성한다. 

- void clear(): HashMap에 저장된 모든 객체를 제거한다. 

```java
map.clear();
```

- Object clone(): 현재 HashMap을 복제하여 반환한다.

```java
ex) newmap = (HashMap)map.clone();
```

- boolean containsKey(Object Key): HashMap에 저장된 Key - Value갑슬 엔트리(키와 값을 결합)의 형태로 Set에 저장하여 반환

```java
      map.put("A", 1);

      map.put("B", 2);

      map.put("C", 3);

      Set set = map.entrySet();

      System.out.println("set values are" + set);

      (result) set values : [A=1,B=2,C=3]
```

- Object get(Object Key) :지정된 Key 의 값을 반환한다. 

```java
      map.put("A", 1);

      map.put("B", 2);

      map.put("C", 3);

      String  val = (String)map.get("B");

      System.out.println("Value for key B is: " + val);

  

 (result) 
Value 
for key B is 2
```

- bloolean isEmpty: HashMap이 비어있는지 확인한다.

```java
boolean val = map.isEmpty();
//비었으면 true 비지 않았으면 false
```

- Set keySet(): HashMap에 저장된 모든 키가 저장된 Set을 반환한다.

```java
      map.put("A", 1);

      map.put("B", 2);

      map.put("C", 3);

      Set keyset = map.keySet();

      System.out.println("Key set values are" + keyset);

      (result) 
      Key set values are [A,B,C]
```

- Object put(Object Key, Object Value): HashMap에 키와 값을 저장.

```java
      map.put("A", "aaa");

      map.put("B", "bbb");

      map.put("C", "ccc");
```

- void putAll(Map m) : Map에 해당하는 모든 요소를 HashMap에 저장한다. 

- Object remove(Object Key) : HashMap에서 지정된 키로 지정된 값을 제거한다.

ex) map.remove("key");

- int size() : HashMap에 저장된 요소의 개수를 반환한다. 

- Collection values(): HashMap에 저장된 모든 값을 컬렉션 형태로 반환한다.

출처: https://vaert.tistory.com/107 [Vaert Street]



