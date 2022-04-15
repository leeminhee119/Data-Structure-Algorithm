//���߿��Ḯ��Ʈ�� ��� Ŭ����

public class DNode<E> {
	private E item;
	private DNode<E> next;
	private DNode<E> previous; //���� ����� ���۷��� ����
	//������ - �ش� ����� �׸� ����, ����&���� ����� ���۷��� ����
	DNode(E data, DNode<E> previousNode, DNode<E> nextNode) {
		item = data;
		next = nextNode;
		previous = previousNode;
	}
	//getter, setter
	public E getItem() {
		return item;
	}
	public DNode<E> getNext() {
		return next;
		}
	public DNode<E> getPrevious() {
		return previous;
		}
	public void setItem(E item) {
		this.item = item;
		}
	public void setNext(DNode<E> next) {
		this.next = next;
	}
	public void setPrevious(DNode<E> previous) {
		this.previous = previous;
	}
}
