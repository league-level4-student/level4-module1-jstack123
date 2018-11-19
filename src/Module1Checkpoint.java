import java.util.Random;

public class Module1Checkpoint {
	public static void main(String[] args) {
		Random r = new Random();
		int rNum = r.nextInt(5);

		switch (rNum) {
		case 0:
			System.out.println("Number 0");
			break;
		case 1:
			System.out.println("Number 1");
			break;
		case 2:
			System.out.println("Number 2");
			break;
		case 3:
			System.out.println("Number 3");
			break;
		case 4:
			System.out.println("Number 4");
			break;
		}
	}
}
