import java.util.NoSuchElementException;

public class CircularDeque<E> {
	DNode<E> front, rear;
	private int size;
	
//생성자 (큐 초기화)
	public CircularDeque() {
		front = null;
		rear = null;
		size = 0;
	}
//개수 반환 기능
	public int size() {
		return size;
	}
//큐가 비어있는지 체크
	public boolean isEmpty() {
		return size==0;  //혹은 size()==0
	}
//값 가져오기 - by 인덱스 (0~)
	public DNode<E> peek(int index) {
		if (index >= size) { throw new NoSuchElementException(); }
		DNode<E> a = front;
		for (int i = 0; i < index; i++) {
			a = a.getNext();
		}
		return a; //찾는 노드가 없으면 null 반환.
	}
	
//데이터 추가 메소드
	
	//맨 뒤에 삽입
	public void add_rear(E newItem) {
		DNode<E> newNode = new DNode<E>(newItem, null, null);
		if (isEmpty()) {
			newNode.setNext(newNode);
			newNode.setPrevious(newNode);
			front = newNode;
			rear = newNode;
		}
		else {
			newNode.setNext(front);    // 원형이므로 맨 뒤 원소 다음이 맨 앞 원소라고 본다
			newNode.setPrevious(rear);
			rear.setNext(newNode);     // 원래 rear에 있던 노드의 다음 노드를 new 노드로
			rear = newNode;            // rear가 새로 삽입된 new 노드를 가리키도록
			front.setPrevious(newNode);// 원형이므로 맨 앞 원소 이전이 맨 뒤 원소라고 본다
		}  
		size++;
	}
	
	//맨 앞에 삽입
	public void add_front(E newItem) {
		DNode<E> newNode = new DNode<E>(newItem, null, null);
		if (isEmpty()) {
			newNode.setNext(newNode);
			newNode.setPrevious(newNode);
			front = newNode;
			rear = newNode;
		}
		else {
			newNode.setNext(front);
			newNode.setPrevious(rear); //원형 이중연결리스트- rear와 front가 마주본다.
			front.setPrevious(newNode); // 원래 front가 가리키던 노드의 previous노드를 new노드로.
			front = newNode; //front 가 이제는 new노드를 가리키도록
			rear.setNext(newNode); //원형 이중연결리스트- rear와 front가 마주본다.
		}
		size++;
	}
	
// 데이터 삭제 메소드
	
	//맨 앞 삭제, 삭제한 값 리턴
	public E delete_front() {
		E temp = front.getItem();
		front = front.getNext();
		front.setPrevious(rear);
		rear.setNext(front);
		size--;
		
		return temp;
	}
	
	//맨 뒤 삭제
	public E delete_rear() {
		E temp = rear.getItem();
		rear = rear.getPrevious();
		rear.setNext(front);
		front.setPrevious(rear);
		size--;
		
		return temp;
	}
}
