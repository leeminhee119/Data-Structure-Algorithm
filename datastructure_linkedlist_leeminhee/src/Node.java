//�ܼ����Ḯ��Ʈ�� ��� Ŭ����

public class Node {
	private String item;  //������ (�׸�)�� ����
	private Node next; //���� ����� ���۷��� ����
	//������ - �ش� ����� �׸� ����, ���� ����� ���۷��� ����
	Node(String item, Node next) {
		this.item = item;
		this.next = next;
	}
	//getter, setter
	public String getItem() {
		return item;
	}
	public Node getNext() {
		return next;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	// �л��ο� �Էµ� �л��� �й��� ��ȯ�ϴ� �޼ҵ�
	int getID() {
		int space = item.indexOf(" ");
		int ID = Integer.parseInt(item.substring(space+1));
		return ID;
	}
	
}
