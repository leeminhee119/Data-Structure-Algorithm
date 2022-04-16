import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ť�� ���� @ ListQueue.java Ŭ����
		
		// ���� 1: ���ڿ� ������
		System.out.println("1. ���ڿ� ������ - ������ũȰ��");
		
		CircularDeque<Character> dq = new CircularDeque<Character>();
		System.out.print("��� �Է�: ");
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		
		// �Է¹��� ���� �� �ڸ����� ��ȯ�ϸ鼭 ���� ��ũ�� ����
		for (int i = 0; i < number.length(); i++) {
			dq.add_rear(number.charAt(i));
		}
		
		// �����س��� ������ũ�� �ڿ������� �����ذ��鼭 ���
		System.out.print("������ ���: ");
		for (int i = 0; i < number.length(); i++) {
			System.out.print(dq.delete_rear());
		}
		System.out.println();
		
		
		// ���� 2: �似Ǫ�� ����
		// �Է� ��: 10 7
		System.out.println("2. �似Ǫ�� ����");
		System.out.print("N, K �������� �����Ͽ� �Է�: ");
		int N = sc.nextInt(); // N(����� ��)
		int K = sc.nextInt(); // K(������ ����)
		
		int[] order = new int[N]; // �似Ǫ�� ������ ������ �迭
		CircularDeque<Integer> ys = new CircularDeque<Integer>();
		
		// ���� ��ũ�� 1���� N���� ����
		for (int i = 1; i < N+1; i++) {
			ys.add_rear(i);
		}
		
		int size = 0; //order�迭(�似Ǫ�� ����) ���� ���� �ľ� ���� 
		while (!ys.isEmpty()) { //������ũ�� �� ������
			//front�� rear ��� Kĭ�� ������ �ű��. 
			for (int i = 0; i < K; i++) { 
				ys.front = ys.front.getNext();  //front�� K��° ���� ���� ���Ҹ� ����Ű����
				ys.rear = ys.rear.getNext(); //rear �� ��������. rear�� K��° ���Ҹ� ����Ű�� �ȴ�.			
			}
			order[size++] = ys.delete_rear(); //K��° ���� ����, rear�� �� �� ���� ����Ű�� ��.
		}
		
		// �似Ǫ�� ���� ���
		System.out.print("�似Ǫ�� ����: <");
		for (int i = 0; i < order.length; i++) {
			if (i==order.length-1) {
				System.out.print(order[i]+">");
			}
			else { System.out.print(order[i]+", "); }
		}


		

	sc.close();
	}
}
