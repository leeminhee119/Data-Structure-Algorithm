//이중연결리스트 클래스

import java.util.NoSuchElementException;

public class DoublyList<E> {
	DNode head, tail;  // 왜 자료에는 <E>를 생략?
	int size;
	//생성
	DoublyList() {
		//dummy node - head, tail
		head = new DNode(null, null, null);
		tail = new DNode(null, head, null);
		head.setNext(tail);
		size = 0;
	}
	//값 가져오기 메소드
	int peek_index(E target) {
		DNode a = head;
		for (int i = 0; i < size; i++) {
			a = a.getNext();
			if (a.getItem().equals(target)) {
				return i;
			}
		} 
		return -1; //찾는 값이 없으면 -1을 반환.
	}
	
	DNode peek_node(E target) {
		DNode a = head;
		for (int i = 0; i < size; i++) {
			a = a.getNext();
			if (a.getItem().equals(target)) {
				return a;
			}
		}
		return null; //찾는 노드가 없으면 null 반환.
	}
	
	//삽입
	void insertAfter(E newItem, DNode prev) {
		// 인자로 주어지는 prev 노드 앞에 삽입
		DNode newNode = new DNode(newItem, prev, prev.getNext());
		prev.setNext(newNode);
		if (newNode.getNext() != null) { //맨 끝 삽입이 아니라면
			newNode.getNext().setPrevious(newNode);
		}
		size++;
	}
	void insertBefore(E newItem, DNode fore) {
		//인자로 주어지는 fore 노드 뒤에 삽입
		DNode newNode = new DNode(newItem, fore.getPrevious(), fore);
		if (fore.getPrevious() != null) { //맨 앞 삽입이 아니라면
			fore.getPrevious().setNext(newNode);
		}
		fore.setPrevious(newNode);
		size++;
	}

	//삭제
	void delete(DNode target) {
		if (target == null) {
			throw new NoSuchElementException();
		}
		target.getPrevious().setNext(target.getNext()); 
		target.getNext().setPrevious(target.getPrevious());
		size--;
	}
	
	// 노드 전부 출력
	void print() {
		System.out.println("아이템 목록:");
		DNode a = head;
		for (int i = 0; i < size; i++) {
			a = a.getNext();
			System.out.println(a.getItem());
		}
		System.out.println();
	}
}
