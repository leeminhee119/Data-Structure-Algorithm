import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 큐의 구현 @ ListQueue.java 클래스
		
		// 과제 1: 문자열 뒤집기
		System.out.println("1. 문자열 뒤집기 - 원형데크활용");
		
		CircularDeque<Character> dq = new CircularDeque<Character>();
		System.out.print("양수 입력: ");
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		
		// 입력받은 숫자 한 자릿수씩 순환하면서 원형 데크에 저장
		for (int i = 0; i < number.length(); i++) {
			dq.add_rear(number.charAt(i));
		}
		
		// 저장해놓은 원형데크의 뒤에서부터 삭제해가면서 출력
		System.out.print("뒤집은 결과: ");
		for (int i = 0; i < number.length(); i++) {
			System.out.print(dq.delete_rear());
		}
		System.out.println();
		
		
		// 과제 2: 요세푸스 문제
		// 입력 예: 10 7
		System.out.println("2. 요세푸스 문제");
		System.out.print("N, K 공백으로 구분하여 입력: ");
		int N = sc.nextInt(); // N(사람의 수)
		int K = sc.nextInt(); // K(제거할 순서)
		
		int[] order = new int[N]; // 요세푸스 순열을 저장할 배열
		CircularDeque<Integer> ys = new CircularDeque<Integer>();
		
		// 원형 데크에 1부터 N까지 저장
		for (int i = 1; i < N+1; i++) {
			ys.add_rear(i);
		}
		
		int size = 0; //order배열(요세푸스 순열) 원소 개수 파악 위함 
		while (!ys.isEmpty()) { //원형데크가 빌 때까지
			//front와 rear 모두 K칸씩 앞으로 옮긴다. 
			for (int i = 0; i < K; i++) { 
				ys.front = ys.front.getNext();  //front를 K번째 원소 다음 원소를 가리키도록
				ys.rear = ys.rear.getNext(); //rear 도 마찬가지. rear는 K번째 원소를 가리키게 된다.			
			}
			order[size++] = ys.delete_rear(); //K번째 원소 제거, rear는 그 전 원소 가리키게 됨.
		}
		
		// 요세푸스 순열 출력
		System.out.print("요세푸스 순열: <");
		for (int i = 0; i < order.length; i++) {
			if (i==order.length-1) {
				System.out.print(order[i]+">");
			}
			else { System.out.print(order[i]+", "); }
		}


		

	sc.close();
	}
}
