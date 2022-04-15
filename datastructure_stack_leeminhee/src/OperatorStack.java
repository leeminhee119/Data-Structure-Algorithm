//�ǽ�����1 - ����ǥ��� => ����ǥ���
public class OperatorStack extends Stack { //����Ŭ������ �ִ� �޼ҵ� ���


	
	//������ �켱����
	int order(char op) {
		// ������, ��ȣ �켱���� : *,/  >  +,-  >  (,)
		switch(op) {
		case '(':
		case ')':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1; // op�� �����ڳ� ��ȣ�� �ƴ� �� �´ٸ� (�ǿ�����) -1 ��ȯ.
	}
	
	//����->���� ��ȯ (������ ��ȯ�� ���� �� ������ ��� char�� ������ �迭 ��ȯ)
	void change(String eq) {
		char ch; // ���� �ϳ� �ϳ� ĳ���ͷ� �޾ƿ��� ���� ����
		
		for (int i = 0; i < eq.length(); i++) { //���� �տ������� ���ڸ��� ��ȯ
			ch = eq.charAt(i);
			
			switch(ch) {
			case '(':   //���� ��ȣ��� �ٷ� push
				push(ch);
				break;
			case ')':   //������ ��ȣ��� ���� ��ȣ�� ���� ������ pop,���
				while ((char)peek() != '(') {
					System.out.print(pop());
				}
				pop();  //�ݺ��� ��ġ�� top�� ���ʰ�ȣ -> pop
				break;
			case '+':   //��� �����ڿ� ���ؼ��� �ڱ⺸�� ���� �����ڰ� top���� �� ������ pop, ���
			case '-':
			case '*':
			case '/':
				while (!isEmpty() && order((char)peek()) >= order(ch)) {
					System.out.print(pop());
				}
				push(ch); //�ݺ��� ��ġ�� top�� �ڱ⺸�� ���� �켱������ ������ -> �� �� push
				break;
			default:    // �ǿ������� ��� �ٷ� ���
				System.out.print(ch);
				break;
			}
		}
		//���ÿ� �����ִ� ������ �����ڸ� ��� pop, ���
		while (!isEmpty()) {
			System.out.print(pop());
		}
		System.out.println();
	}
}
