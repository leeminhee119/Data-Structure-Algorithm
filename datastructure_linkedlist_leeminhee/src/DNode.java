//이중연결리스트의 노드 클래스

public class DNode<E> {
	private E item;
	private DNode<E> next;
	private DNode<E> previous; //이전 노드의 레퍼런스 저장
	//생성자 - 해당 노드의 항목 저장, 다음&이전 노드의 레퍼런스 저장
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
