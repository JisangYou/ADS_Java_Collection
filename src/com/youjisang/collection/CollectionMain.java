package com.youjisang.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionMain /*extends Object*/ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CollectionMain main = new CollectionMain(); // 메모리에 객체 생성.
		main.checkArray();
		main.checkSet();
	}

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
						// 삭제하면  다음 데이터들이 앞으로 한칸씩 이동해서 빈공간을 채운다.

	}
	
	public void checkGeneric(){
		//제네릭을 사용하는 방법
		//타입<제네릭타입> 변수이름; // <- 제네릭 타입은 클래스만 가능
		// 타입을 제한할때 유용
		//동적 배열을 사용할때는 제네릭을 많이 이용
		ArrayList<Item> list = new ArrayList<>();
//		list.add("Hello");
		list.add(new Item());
//		list.add(new Student());
		
//		for (int i =0; i<list.size(); i++){
//			System.out.println(list.get(i));
//		}
		
		for(Item item : list){
			item.getMyName();
		}
	}

	// List와 유사한데 중복값을 허용하지 않는 동적 객체배열
	public void checkSet() {
		HashSet<String> set = new HashSet();
		set.add("hello");
		set.add("Good to see you");
		set.add("Hello");
		
		//set은 iterator을 달아서 순서대로 처리해 줄 수 있다. 마치 list처럼
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}

	// Key, Value로 구성된 동적 객체배열
	public void checkMap() {

		HashMap map = new HashMap();
	}

}

class Item {
	private String myName = "지코";

	public String getMyName() {
		return myName;
	}
}