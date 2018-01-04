# ADS04 Java 

## 수업 내용
- Collection과 Generic 학습
- Array 학습

## Code Review

1. Array

```Java

public void checkArray() {
		// 선언
		// 타입 이름[] or 타입[] 이름 = new 타입[배열공간크기];
		int intArray[] = new int[10];
		System.out.println(intArray[7]);

		// 기본형인 int, long 등은 공간을 할당하는 것만으로 기본값으로 0이 할당이 됨.
		Item itemArray[] = new Item[10]; // 클래스 타입이 앞에 들어감.
		int itemlength = itemArray.length;
		for (int i = 0; i < itemlength; i++) {// 반복문에서는 왠만하면 .length를 직접 하지 않는
												// 방향으로한다.
			itemArray[i] = new Item();
		}
		System.out.println(itemArray[7].getMyName());
	}

```

2. List

```Java
        // index를 포함하는 동적 객체배열
	public void checkList() {
		// 선언은 일반 객체를 초기화하는 것과 같다.
		ArrayList list = new ArrayList();

		// 입력
		list.add(new Item()); // <- 0번 index로 생성
		list.add(new Item()); // <- 1번 index로 생성
		// 조회
		list.get(0); // <- index가 0번째인 값을 가져온다.
		// 수정
		list.set(1, new Item());
		// add의 다른방법
		list.add(1, new Item()); // <= 1번부터 이후의 아이템 index를 하나씩 증가시키고
									// 자신이 1번으로 들어간다.
		// 삭제
		list.remove(1); // 삭제할 아이템의 index를 지정한다.
						// 삭제하면 다음 데이터들이 앞으로 한칸씩 이동해서 빈공간을 채운다.

	}
```

* Generic

```Java

	public void checkGeneric() {
		// 제네릭을 사용하는 방법
		// 타입<제네릭타입> 변수이름; // <- 제네릭 타입은 클래스만 가능
		// 타입을 제한할때 유용
		// 동적 배열을 사용할때는 제네릭을 많이 이용
		ArrayList<Item> list = new ArrayList<>();
		// list.add("Hello");
		list.add(new Item());
		// list.add(new Student());

		// for (int i =0; i<list.size(); i++){
		// System.out.println(list.get(i));
		// }

		for (Item item : list) {
			item.getMyName();
		}
	} 
```

3. Set

```Java

// List와 유사한데 중복값을 허용하지 않는 동적 객체배열
	public void checkSet() {
		HashSet<String> set = new HashSet();
		set.add("hello");
		set.add("Good to see you");
		set.add("Hello");
		set.add("jisang");

		set.remove("jisang");

		// set은 iterator을 달아서 순서대로 처리해 줄 수 있다. 마치 list처럼
		Iterator<String> iterator = set.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			// object형으로 리턴이 된다.
		}
	}

```

4. Map

```Java
// Key, Value로 구성된 동적 객체배열
	public void checkMap() {

		// map또한 interface
		// 선언
		HashMap<String, Integer> map = new HashMap<>(); // String을 key로 Integer를 Value로 설정
		// 입력
		map.put("key01", 123456);
		map.put("key02", 1234561234);
		// map.put("1234, "sdfef"); //<- 이는 에러
		// 조회
		System.out.println(map.get("key01"));

		// 맵을 반복문으로 처리하기
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(map.get(key));
		}
	}
```

## 보충설명

- 배열과 컬렉션의 차이? : 배열은 고정크기 이상의 객체를 관리 할 수 없다. 컬렉션은 가변크기로 객체의 개수를 고려하지 않아도 된다.

![Collection](http://postfiles16.naver.net/20160122_143/premiummina_1453441737058vb0Av_PNG/%C4%C3%B7%BA%BC%C7%B0%FA_%C0%CE%C5%CD%C6%E4%C0%CC%BD%BA%BF%CD_%C5%AC%B7%A1%BD%BA.png?type=w966)

- 컬렉션의 특징 : 제네릭의 기법으로 구현되어 있음, 컬렉션의 요소는 객체들만 가능함.

- iterator란 모든 컬렉션클래스에 데이터를 읽을때 사용

### List - ArrayList, LinkedList, Vector, Stack
- 특징: 요소의 저장 순서가 유지, 같은 요소의 중복저장을 허용
- 장점: 가변적인 배열(배열이 자동으로 늘어남) 
- 단점: 원하는 데이터가 뒤쪽에 위치하는 경우 속도의 문제
- 방식: equals()를 이용한 데이터 검색

### Set - HashSet, TreeSet
- 특징: 순서가 없고, 중복을 허용하지 않음.
- 장점: 빠른 속도
- 단점: 단순집합의 개념으로 정렬하려면 별도의 처리가 필요하다.
- 보충: HashSet == 데이터 입력의 순서를 유지하지 않는다. (사용빈도수 높음)
		LinkedHashSet == 데이터 입력의 순서를 유지한다. 
		TreeSet == 데이터를 사전식으로 정렬해준다. (ex. 로또번호)

### Map - HashMap, TreeMap
- 특징 : Key(키)와 Value(값)으로 나누어 데이터 관리, 순서는 없으며, 키에 대한 중복은 없음.
- 장점 : 빠른 속도
- 단점 : Key의 검색 속도가 검색속도를 좌우
- 보충 : key는 중복 불가, value는 중복 가능
        key 가 중복이 된다면 원래 값을 반환하고 새로운 값을 넣는다.
		index가 아닌 key로 접근하다보니 보다 더 직관적이다.
		HashMap == 데이터 입력의 순서를 유지하지 않는다.
		LinkedHashMap == 데이터 입력의 순서를 유지한다.
		TreeMap == 데이터를 사전식으로 정렬해준다.


 + 출처: http://platonic.tistory.com/entry/Java-Collections-자료구조-List-Set-Map-Tree-Stack-Iterator-Enumeration [Platonic의 조금은 재밌는 일상]
 + 출처: http://oingbong.tistory.com/69 [Oing] 

 ### Generic
 
 - Generic을 사용해야 하는 이유? 1. 컴파일 시 강한 타입 체크를 할 수 있다. 2. 타입 변환을 제거한다. 
 
 - Generic 타입은 타입을 파라미터로 가지는 클래스와 인터페이스를 말함.
 
 - 간단한 예제코드
 
 ```Java
 public class 클래스명<T>{ ... }
 public interface 인터페이스명<T>{ ... }
 ```
- 멀티 타입 파라미터로도, 메소드에서도 Generic을 통해 타입을 정해 줄 수 있다.

## TODO

- equals(), hashCode() 개념
    메모리가 달라도 검색이 가능해야 하는데 이를 위해서 java.lang.Object의 equals( )와 hashCode( )메소드가 사용된다
    equals(): 메모리상의 위치가 다르다고 해도 검색이 가능하도록 설계하려면 override해 준다. hashCode(): 해싱 알고리즘을 사용할 때 객체들을 분류하고 보관할때 기준이 되는 hash value를 만들어 내는 메소드

- 다형성 개념 공부(Collection과 Generic과 연관지어서)

-  Generic에 대한 예제를 만들어 보면서 그 용도를 파악하기 



+ 출처: http://platonic.tistory.com/entry/Java-Collections-자료구조-List-Set-Map-Tree-Stack-Iterator-Enumeration [Platonic의 조금은 재밌는 일상])

## Retrospect

- Collection은 굉장히 중요하고 많이 사용이 되는 부분이며 자료구조관점에서도 중요하기에 계속적인 예제코드 만들기 및 알고리즘을 풀면서 다양하게 사용을 해야할 것 같음. 

## Output
- 생략

