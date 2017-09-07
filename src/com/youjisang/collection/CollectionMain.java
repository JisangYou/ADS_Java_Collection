package com.youjisang.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionMain /*extends Object*/ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CollectionMain main = new CollectionMain(); // �޸𸮿� ��ü ����.
		main.checkArray();
		main.checkSet();
	}

	public void checkArray() {
		// ����
		// Ÿ�� �̸�[] or Ÿ��[] �̸� = new Ÿ��[�迭����ũ��];
		int intArray[] = new int[10];
		System.out.println(intArray[7]);

		// �⺻���� int, long ���� ������ �Ҵ��ϴ� �͸����� �⺻������ 0�� �Ҵ��� ��.
		Item itemArray[] = new Item[10]; // Ŭ���� Ÿ���� �տ� ��.
		int itemlength = itemArray.length;
		for (int i = 0; i < itemlength; i++) {// �ݺ��������� �ظ��ϸ� .length�� ���� ���� �ʴ�
												// ���������Ѵ�.
			itemArray[i] = new Item();
		}
		System.out.println(itemArray[7].getMyName());
	}

	// index�� �����ϴ� ���� ��ü�迭
	public void checkList() {
		// ������ �Ϲ� ��ü�� �ʱ�ȭ�ϴ� �Ͱ� ����.
		ArrayList list = new ArrayList();

		// �Է�
		list.add(new Item()); // <- 0�� index�� ����
		list.add(new Item()); // <- 1�� index�� ����
		// ��ȸ
		list.get(0); // <- index�� 0��°�� ���� �����´�.
		// ����
		list.set(1, new Item());
		// add�� �ٸ����
		list.add(1, new Item()); // <= 1������ ������ ������ index�� �ϳ��� ������Ű��
									// �ڽ��� 1������ ����.
		// ����
		list.remove(1); // ������ �������� index�� �����Ѵ�.
						// �����ϸ�  ���� �����͵��� ������ ��ĭ�� �̵��ؼ� ������� ä���.

	}
	
	public void checkGeneric(){
		//���׸��� ����ϴ� ���
		//Ÿ��<���׸�Ÿ��> �����̸�; // <- ���׸� Ÿ���� Ŭ������ ����
		// Ÿ���� �����Ҷ� ����
		//���� �迭�� ����Ҷ��� ���׸��� ���� �̿�
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

	// List�� �����ѵ� �ߺ����� ������� �ʴ� ���� ��ü�迭
	public void checkSet() {
		HashSet<String> set = new HashSet();
		set.add("hello");
		set.add("Good to see you");
		set.add("Hello");
		
		//set�� iterator�� �޾Ƽ� ������� ó���� �� �� �ִ�. ��ġ listó��
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}

	// Key, Value�� ������ ���� ��ü�迭
	public void checkMap() {

		HashMap map = new HashMap();
	}

}

class Item {
	private String myName = "����";

	public String getMyName() {
		return myName;
	}
}