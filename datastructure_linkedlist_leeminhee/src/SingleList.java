//단순연결리스트의 클래스
// 학생부 입력을 위한 연결리스트이므로, 학생부 데이터(이름+학번)을 하나의 String으로 보았다.
import java.util.NoSuchElementException;
public class SingleList {
	Node head; //가장 앞 순서의 노드
	int size;      //링크드리스트에 저장된 노드 수
	//생성자
	SingleList() {
		head = null;
		size = 0; 
	}

	//탐색 메소드 - 탐색하고자 하는 노드가 링크드리스트에 저장되어있는지 
	int search(String target) {
		Node a = head; //맨 앞 노드서부터 탐색
		for (int i = 0; i < size; i++) {
			if (a.getItem().equals(target)) {
				return i;
			}
			a = a.getNext(); //다음 노드로 이동
		}
		return -1; 
	}
	//빈 리스트에 노드 저장시.
	void setFirst(Node newNode) {
		head = newNode;
		size++;
	}
	//삽입 
	void insert(Node newNode, int ID) {
		Node a = head;
		if (a.getID() > ID) {  // 맨 앞에 삽입하는 경우
			newNode.setNext(a);
			head = newNode;
		}
		else {
			for (int i = 0; i < size; i++) {
				if (a.getNext() == null) {break;}
				if (a.getNext().getID() > ID) {break;}
				a = a.getNext();
			}
			if (a.getNext() == null) {  // 가장 끝에 삽입하는 경우
				a.setNext(newNode);
			}
			else { // 중간에 삽입하는 경우
				newNode.setNext(a.getNext());
				a.setNext(newNode);
			}
		}
		size++;
	}
	//삭제 - 첫 노드
	void deleteFront() {
		if (size == 0) { 
			throw new NoSuchElementException(); // 저장된 데이터(노드) 없을 시 강제 종료.
		} 
		head = head.getNext();
		size--;
	}
	//삭제 - 중간 노드 or 끝 노드
	void deleteMid(String target) {
		if (target == null) { 
			throw new NoSuchElementException(); // 저장된 데이터(노드) 없을 시 강제 종료.
		} 
		Node a = head;
		for (int i = 0; i < size-1; i++) {
			if (a.getNext().getItem().equals(target)) {
				break;
			}
			a = a.getNext();
		}  // a 레퍼런스 변수에 target을 항목으로 갖고 있는 노드의 '직전'노 저장.
		if (a.getNext().getNext() == null) { // 삭제하려는 노드가 가장 끝 노드인 경우
			a.setNext(null);
		}
		else {
			a.setNext(a.getNext().getNext());
		}
		size--;
	}
	
	//연결리스트의 모든 노드를 순차적으로 출력하는 메소드
	void print() {
		Node a = head;
		for (int i = 0; i < size; i++) {
			System.out.println(a.getItem());
			a = a.getNext();
		}
	}
}
