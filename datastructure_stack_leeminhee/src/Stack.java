

import java.util.EmptyStackException;
public class Stack<E> {
	E[] stack;
	int top;
	
	//������
	Stack() {
		stack = (E[]) new Object[1];
		top = -1;  // ���ÿ� �ƹ� �͵� ���� �� top�� -1
	}
	
	int size() { //������ ����
		return top+1; // �迭�� size�� ���� ������ �ε����� top
	}
	boolean isEmpty() { //������ ����ٸ� true ����
		if (top == -1) {
			return true;
		}
		return false;
	}
	
	//resize �޼ҵ�
	void resize(int new_size) {
		E[] temp = (E[]) new Object[new_size];   // �����͸� �ӽ÷� �������� new_size ũ���� �迭
		for (int i=0; i<size(); i++) {  
			temp[i] = stack[i];     // ������ �Ű��ֱ�
		}
		stack = temp;   
	}
	
	//push�޼ҵ�
	void push(E item) {
		//����ֱ� �� �迭(����)�� ����á�ٸ� �迭 Ȯ��
		if (size() == stack.length) { // ������ ���� á�� ��
			resize(2*stack.length);
		}
		stack[++top] = item;  // top�� ���� 1 ������Ű�� �� �ε����� item����
	}
	
	//pop �޼ҵ�
	E pop() {
		if (isEmpty()) throw new EmptyStackException(); //underflow �߻��� ���α׷� ����.
		E popped = stack[top];
		stack[top--] = null;
		//�̾Ƴ� �� �迭�� ����� ���� ũ�� ���϶�� �迭 ���
		if (size() == 0) {
			resize(1);
		}
		else if (size() <= stack.length * 1/4) { 
			//�迭 �� ������ 1/4���� ����ϰ� �ִ� ����� �� �۴ٸ� �迭 ���
			resize(stack.length * 1/2);
		}
		return popped;
	}
	
	//peek�޼ҵ�
	E peek() {
		if (isEmpty()) throw new EmptyStackException(); //underflow �߻��� ���α׷� ����.
		return stack[top];  //���� ���� �ִ� (top�� �ش��ϴ�) ���Ҹ� ����.
	}
	
	// ���� ��ü�� ����ϴ� �޼ҵ�
	void print() {
		System.out.print("���� ��ü (top���� ���ʴ��): ");
		for (int i = 0; i < stack.length; i++ ) {
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}
}
