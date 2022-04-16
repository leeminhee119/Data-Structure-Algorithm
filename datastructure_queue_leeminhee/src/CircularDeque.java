import java.util.NoSuchElementException;

public class CircularDeque<E> {
	DNode<E> front, rear;
	private int size;
	
//������ (ť �ʱ�ȭ)
	public CircularDeque() {
		front = null;
		rear = null;
		size = 0;
	}
//���� ��ȯ ���
	public int size() {
		return size;
	}
//ť�� ����ִ��� üũ
	public boolean isEmpty() {
		return size==0;  //Ȥ�� size()==0
	}
//�� �������� - by �ε��� (0~)
	public DNode<E> peek(int index) {
		if (index >= size) { throw new NoSuchElementException(); }
		DNode<E> a = front;
		for (int i = 0; i < index; i++) {
			a = a.getNext();
		}
		return a; //ã�� ��尡 ������ null ��ȯ.
	}
	
//������ �߰� �޼ҵ�
	
	//�� �ڿ� ����
	public void add_rear(E newItem) {
		DNode<E> newNode = new DNode<E>(newItem, null, null);
		if (isEmpty()) {
			newNode.setNext(newNode);
			newNode.setPrevious(newNode);
			front = newNode;
			rear = newNode;
		}
		else {
			newNode.setNext(front);    // �����̹Ƿ� �� �� ���� ������ �� �� ���Ҷ�� ����
			newNode.setPrevious(rear);
			rear.setNext(newNode);     // ���� rear�� �ִ� ����� ���� ��带 new ����
			rear = newNode;            // rear�� ���� ���Ե� new ��带 ����Ű����
			front.setPrevious(newNode);// �����̹Ƿ� �� �� ���� ������ �� �� ���Ҷ�� ����
		}  
		size++;
	}
	
	//�� �տ� ����
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
			newNode.setPrevious(rear); //���� ���߿��Ḯ��Ʈ- rear�� front�� ���ֺ���.
			front.setPrevious(newNode); // ���� front�� ����Ű�� ����� previous��带 new����.
			front = newNode; //front �� ������ new��带 ����Ű����
			rear.setNext(newNode); //���� ���߿��Ḯ��Ʈ- rear�� front�� ���ֺ���.
		}
		size++;
	}
	
// ������ ���� �޼ҵ�
	
	//�� �� ����, ������ �� ����
	public E delete_front() {
		E temp = front.getItem();
		front = front.getNext();
		front.setPrevious(rear);
		rear.setNext(front);
		size--;
		
		return temp;
	}
	
	//�� �� ����
	public E delete_rear() {
		E temp = rear.getItem();
		rear = rear.getPrevious();
		rear.setNext(front);
		front.setPrevious(rear);
		size--;
		
		return temp;
	}
}
