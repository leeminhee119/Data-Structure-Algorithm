//2018110988 �̹��� ��������а�
//�ڷᱸ���׾˰��� ���� - ����
//�ǽ����� 1�� - ���� ���� @ Stack.java (Main.java ���� ����)
//�ǽ����� 2�� - ����ǥ��� => ����ǥ��� ��ȯ @ OperatorStack.java (Main.java ���� ����)
//�ǽ����� 3�� - ����ǥ��� �� �Է�, ��� ��� @ CalculatePostfix.java (Main.java ���� ����)
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	//�ǽ����� 1 ���� ��� ����
		System.out.println("*** �ǽ����� 1 ���� ��� ���� ***");
		Stack stack = new Stack();
		stack.push("red");
		stack.push("orange");
		stack.push("yellow");
		stack.print();
		
		stack.pop();
		stack.print();
		
		stack.push("green");
		stack.print();
		System.out.println("���� ������ top����: " + stack.peek());
		System.out.println();
		
	//�ǽ�����2 ����->����
		System.out.println("*** �ǽ�����2 ����->���� ***");
		OperatorStack ops = new OperatorStack();
		System.out.print("A+B*(C+D-E)/(F+G)  =  ");
		ops.change("A+B*(C+D-E)/(F+G)");  // ����ǥ��� ���� ���ڷ� �޼ҵ� ����
		System.out.println();
		
	//�ǽ�����3 ����ǥ��� �� �Է¹ް� �ش� ����� ��� ���
		
		// �Է� ���� : ������, �ǿ����� �ϳ� �Է��� ������ "��������" ���� !!
		// (�� �ڸ� �̻��� �ǿ����ڸ� �ϳ��� ���ڷ� �ν��ϱ� ���� �������� ����)
		// �Է� ��) 10 9 31 + 5 / -   [ �� 10-((9+31)/5) ]
		
		// ��, ������ ����� ������ �������� ��츸 ����Ͽ� �Է��Ѵ�
		
		System.out.println("*** �ǽ�����3 ����ǥ��� �� ��� ***");
		Scanner sc = new Scanner(System.in);
		CalculatePostfix cal = new CalculatePostfix();
		System.out.print("����ǥ������� ǥ���� �� �Է�: ");
		String eq = sc.nextLine();
		cal.calculate(eq);
	}

}
