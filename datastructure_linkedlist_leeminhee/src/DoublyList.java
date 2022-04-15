//���߿��Ḯ��Ʈ Ŭ����

import java.util.NoSuchElementException;

public class DoublyList<E> {
	DNode head, tail;  // �� �ڷῡ�� <E>�� ����?
	int size;
	//����
	DoublyList() {
		//dummy node - head, tail
		head = new DNode(null, null, null);
		tail = new DNode(null, head, null);
		head.setNext(tail);
		size = 0;
	}
	//�� �������� �޼ҵ�
	int peek_index(E target) {
		DNode a = head;
		for (int i = 0; i < size; i++) {
			a = a.getNext();
			if (a.getItem().equals(target)) {
				return i;
			}
		} 
		return -1; //ã�� ���� ������ -1�� ��ȯ.
	}
	
	DNode peek_node(E target) {
		DNode a = head;
		for (int i = 0; i < size; i++) {
			a = a.getNext();
			if (a.getItem().equals(target)) {
				return a;
			}
		}
		return null; //ã�� ��尡 ������ null ��ȯ.
	}
	
	//����
	void insertAfter(E newItem, DNode prev) {
		// ���ڷ� �־����� prev ��� �տ� ����
		DNode newNode = new DNode(newItem, prev, prev.getNext());
		prev.setNext(newNode);
		if (newNode.getNext() != null) { //�� �� ������ �ƴ϶��
			newNode.getNext().setPrevious(newNode);
		}
		size++;
	}
	void insertBefore(E newItem, DNode fore) {
		//���ڷ� �־����� fore ��� �ڿ� ����
		DNode newNode = new DNode(newItem, fore.getPrevious(), fore);
		if (fore.getPrevious() != null) { //�� �� ������ �ƴ϶��
			fore.getPrevious().setNext(newNode);
		}
		fore.setPrevious(newNode);
		size++;
	}

	//����
	void delete(DNode target) {
		if (target == null) {
			throw new NoSuchElementException();
		}
		target.getPrevious().setNext(target.getNext()); 
		target.getNext().setPrevious(target.getPrevious());
		size--;
	}
	
	// ��� ���� ���
	void print() {
		System.out.println("������ ���:");
		DNode a = head;
		for (int i = 0; i < size; i++) {
			a = a.getNext();
			System.out.println(a.getItem());
		}
		System.out.println();
	}
}
