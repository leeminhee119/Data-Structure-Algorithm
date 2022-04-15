/*
mac OS 를 사용하여 콘솔창에 바로 출력되도록 했습니다.
2번 과제 입력방식은 별도 주석을 달아놓았습니다.

DNode -> 이중연결리스트의 노드 클래스
Node -> 단순연결리스트의 노드 클래스
DoublyList -> 이중연결리스트 클래스
SingleList -> 단순연결리스트 클래스
 */

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	//1. 이중연결리스트 구현
		
		DoublyList mydll = new DoublyList();
		mydll.insertAfter("orange", mydll.head); // 맨 앞 삽입
		mydll.insertAfter("red", mydll.head); // 맨 앞 삽입
		mydll.print();
		
		mydll.insertAfter("yellow", mydll.peek_node("orange")); // orange 다음 삽입
		mydll.insertAfter("pink", mydll.head.getNext()); // 맨 앞 노드 다음 삽입
		mydll.insertBefore("purple", mydll.tail); // 맨 끝 삽입
		mydll.print();

		mydll.insertBefore("navy", mydll.peek_node("purple")); //purple 전에 삽입
		mydll.print();

		mydll.delete(mydll.peek_node("pink")); // pink 삭제
		mydll.delete(mydll.peek_node("red"));  // red 삭제
		mydll.print();
		
		System.out.println("orange 의 인덱스: "+ mydll.peek_index("orange"));
		System.out.println("navy 의 인덱스: "+ mydll.peek_index("navy"));
		System.out.println();

		
	
		
	//2. 학생부 입력 및 출력
		// 전제: 입력받는 학생 이름의 가나다 순서는 학번의 순서와 동일하게 입력한다
		//     ex) 강호동 123 이승기 124 허준 129 => (O)
		//         강호동 123 이승기 129 허준 124 => (X)
		//     만약 학번의 순서와 가나다 순서가 다르게 입력되는 경우 (위 예의 둘째 줄), 학번의 순서를 우선으로 정렬한다.
		
		SingleList students = new SingleList();
		
		System.out.println("**************** 학생부 ******************");
		System.out.println("이름과 학번(3자리)을 << 공백으로 구분하여 >> 입력:");
		
		while (true) {
			String st = scanner.nextLine();
			if (st.equals("print")) {
				students.print();
				System.out.println();
			}
			else if (students.size == 0) { // 빈 리스트에 저장시.
				students.setFirst(new Node(st, null));
			}
			else { 
				//이미 존재하는 학생을 또 입력했다면 해당 학생 노드 삭제.
				if (students.search(st) == 0) { // 맨 앞 학생 삭제시
					students.deleteFront();
				}
				else if (students.search(st) != -1) { // 중간 or 끝 학생 삭제시
					students.deleteMid(st);
				}
				// 이미 존재하는 학생이 아니라 새로운 학생 입력시 삽입.
				else {
					Node newNode = new Node(st, null);
					students.insert(newNode, newNode.getID());
				}
			}
		}
		
		
		
	}

}
