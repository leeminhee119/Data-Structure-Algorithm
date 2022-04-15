//단순연결리스트의 노드 클래스

public class Node {
	private String item;  //데이터 (항목)을 저장
	private Node next; //다음 노드의 레퍼런스 저장
	//생성자 - 해당 노드의 항목 저장, 다음 노드의 레퍼런스 저장
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
	
	// 학생부에 입력된 학생의 학번을 반환하는 메소드
	int getID() {
		int space = item.indexOf(" ");
		int ID = Integer.parseInt(item.substring(space+1));
		return ID;
	}
	
}
