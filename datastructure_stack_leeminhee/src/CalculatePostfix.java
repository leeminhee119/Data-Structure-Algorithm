//�ǽ����� 3 - ����ǥ��� �� ���

public class CalculatePostfix extends Stack { // stack Ŭ������ �޼ҵ� ����ϱ� ����
	

	
	// ����ǥ��� �� ��� ��� ��� �޼ҵ�
	void calculate(String post) { // ����ǥ��� ���� ���ڿ��� �޾ƿ´�
		String[] pieces = post.split(" ");
		String piece;
		int result;
		
		for (int i = 0; i < pieces.length; i++) {
			piece = pieces[i];
			int temp; // '-'�� '/'�� �� ���� ���߱� ���� �뵵
			
			switch (piece) {
			case "+":
				result = (int)pop() + (int)pop();
				print();
				push(result); //����� ������� �ٽ� ���ÿ� push
				print();
				break;
			case "-":
				temp = (int)pop();  //���� ���� ���� ������ �ڷ� �����ϹǷ�
				result = (int)pop() - temp;
				print();
				push(result); //����� ������� �ٽ� ���ÿ� push
				print();
				break;
			case "*":
				result = (int)pop() * (int)pop();
				print();
				push(result); //����� ������� �ٽ� ���ÿ� push
				print();
				break;
			case "/":
				temp = (int)pop(); //���� ���� ���� ������ �ڷ� �����ϹǷ�
				result = (int)pop() / temp;
				print();
				push(result); //����� ������� �ٽ� ���ÿ� push
				print();
				break;
			default: //�ǿ������� ���
				push(Integer.parseInt(piece));
				print();
				break;
			}
		}
		// �ݺ��� ��ġ�� ����, ���ÿ��� ������� ���Ե�. (�� ���������� push�� ���)
		
		System.out.println("<<<  �� = " + pop() + "  >>>");
	}
	
}
