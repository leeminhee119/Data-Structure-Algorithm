/*
2018110988 ��������а� �̹���
mac OS �� ����Ͽ� �ܼ�â�� �ٷ� ��µǵ��� �߽��ϴ�.
2�� ���� �Է¹���� ���� �ּ��� �޾Ƴ��ҽ��ϴ�.

DNode -> ���߿��Ḯ��Ʈ�� ��� Ŭ����
Node -> �ܼ����Ḯ��Ʈ�� ��� Ŭ����
DoublyList -> ���߿��Ḯ��Ʈ Ŭ����
SingleList -> �ܼ����Ḯ��Ʈ Ŭ����
 */

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	//1. ���߿��Ḯ��Ʈ ����
		
		DoublyList mydll = new DoublyList();
		mydll.insertAfter("orange", mydll.head); // �� �� ����
		mydll.insertAfter("red", mydll.head); // �� �� ����
		mydll.print();
		
		mydll.insertAfter("yellow", mydll.peek_node("orange")); // orange ���� ����
		mydll.insertAfter("pink", mydll.head.getNext()); // �� �� ��� ���� ����
		mydll.insertBefore("purple", mydll.tail); // �� �� ����
		mydll.print();

		mydll.insertBefore("navy", mydll.peek_node("purple")); //purple ���� ����
		mydll.print();

		mydll.delete(mydll.peek_node("pink")); // pink ����
		mydll.delete(mydll.peek_node("red"));  // red ����
		mydll.print();
		
		System.out.println("orange �� �ε���: "+ mydll.peek_index("orange"));
		System.out.println("navy �� �ε���: "+ mydll.peek_index("navy"));
		System.out.println();

		
	
		
	//2. �л��� �Է� �� ���
		// ����: �Է¹޴� �л� �̸��� ������ ������ �й��� ������ �����ϰ� �Է��Ѵ�
		//     ex) ��ȣ�� 123 �̽±� 124 ���� 129 => (O)
		//         ��ȣ�� 123 �̽±� 129 ���� 124 => (X)
		//     ���� �й��� ������ ������ ������ �ٸ��� �ԷµǴ� ��� (�� ���� ��° ��), �й��� ������ �켱���� �����Ѵ�.
		
		SingleList students = new SingleList();
		
		System.out.println("**************** �л��� ******************");
		System.out.println("�̸��� �й�(3�ڸ�)�� << �������� �����Ͽ� >> �Է�:");
		
		while (true) {
			String st = scanner.nextLine();
			if (st.equals("print")) {
				students.print();
				System.out.println();
			}
			else if (students.size == 0) { // �� ����Ʈ�� �����.
				students.setFirst(new Node(st, null));
			}
			else { 
				//�̹� �����ϴ� �л��� �� �Է��ߴٸ� �ش� �л� ��� ����.
				if (students.search(st) == 0) { // �� �� �л� ������
					students.deleteFront();
				}
				else if (students.search(st) != -1) { // �߰� or �� �л� ������
					students.deleteMid(st);
				}
				// �̹� �����ϴ� �л��� �ƴ϶� ���ο� �л� �Է½� ����.
				else {
					Node newNode = new Node(st, null);
					students.insert(newNode, newNode.getID());
				}
			}
		}
		
		
		
	}

}
