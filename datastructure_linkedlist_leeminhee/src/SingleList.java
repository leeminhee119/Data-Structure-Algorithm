//�ܼ����Ḯ��Ʈ�� Ŭ����
// �л��� �Է��� ���� ���Ḯ��Ʈ�̹Ƿ�, �л��� ������(�̸�+�й�)�� �ϳ��� String���� ���Ҵ�.
import java.util.NoSuchElementException;
public class SingleList {
	Node head; //���� �� ������ ���
	int size;      //��ũ�帮��Ʈ�� ����� ��� ��
	//������
	SingleList() {
		head = null;
		size = 0; 
	}

	//Ž�� �޼ҵ� - Ž���ϰ��� �ϴ� ��尡 ��ũ�帮��Ʈ�� ����Ǿ��ִ��� 
	int search(String target) {
		Node a = head; //�� �� ��弭���� Ž��
		for (int i = 0; i < size; i++) {
			if (a.getItem().equals(target)) {
				return i;
			}
			a = a.getNext(); //���� ���� �̵�
		}
		return -1; 
	}
	//�� ����Ʈ�� ��� �����.
	void setFirst(Node newNode) {
		head = newNode;
		size++;
	}
	//���� 
	void insert(Node newNode, int ID) {
		Node a = head;
		if (a.getID() > ID) {  // �� �տ� �����ϴ� ���
			newNode.setNext(a);
			head = newNode;
		}
		else {
			for (int i = 0; i < size; i++) {
				if (a.getNext() == null) {break;}
				if (a.getNext().getID() > ID) {break;}
				a = a.getNext();
			}
			if (a.getNext() == null) {  // ���� ���� �����ϴ� ���
				a.setNext(newNode);
			}
			else { // �߰��� �����ϴ� ���
				newNode.setNext(a.getNext());
				a.setNext(newNode);
			}
		}
		size++;
	}
	//���� - ù ���
	void deleteFront() {
		if (size == 0) { 
			throw new NoSuchElementException(); // ����� ������(���) ���� �� ���� ����.
		} 
		head = head.getNext();
		size--;
	}
	//���� - �߰� ��� or �� ���
	void deleteMid(String target) {
		if (target == null) { 
			throw new NoSuchElementException(); // ����� ������(���) ���� �� ���� ����.
		} 
		Node a = head;
		for (int i = 0; i < size-1; i++) {
			if (a.getNext().getItem().equals(target)) {
				break;
			}
			a = a.getNext();
		}  // a ���۷��� ������ target�� �׸����� ���� �ִ� ����� '����'�� ����.
		if (a.getNext().getNext() == null) { // �����Ϸ��� ��尡 ���� �� ����� ���
			a.setNext(null);
		}
		else {
			a.setNext(a.getNext().getNext());
		}
		size--;
	}
	
	//���Ḯ��Ʈ�� ��� ��带 ���������� ����ϴ� �޼ҵ�
	void print() {
		Node a = head;
		for (int i = 0; i < size; i++) {
			System.out.println(a.getItem());
			a = a.getNext();
		}
	}
}
