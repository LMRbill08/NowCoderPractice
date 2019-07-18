package other;
/*
 * input: the number of steps that a man is going up, 
 * output: the number of different jumps that the person completed 
 */
public class JumpFloor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 5;
		int result = jump(target);
		System.out.println("" + result);
		int result2 = jumpN(target);
		System.out.println("" + result2);
	}

	/*
	 * the man can only jump 1 or 2 steps per time 
	 * using recursion, the number of methods in n steps equals to the sum of (n - 1) and (n - 2) 
	 * because the last jump could be 1 step or 2 step :)
	 */
	public static int jump(int target) {
		if (target <= 0) {
			return -1;
		} else if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		} else {
			int a = 1;
			int b = 2;
			for (int i = 0; i < target - 2; i++) {
				int temp = b;
				b += a;
				a = temp;
			}
			return b;
		}
	}

	/*
	 * the man can jump as many steps as he wants per time 
	 * the number of jump methods in n steps equals to f(1) + f(2) + ... + f(n), where f(n) = 1, and 
	 * f(n) represents the number of jump methods when the last jump is n steps 
	 * it turns out jump(n) = 2 * jump(n - 1)   
	 */
	public static int jumpN(int target) {
		if (target <= 0) {
			return -1;
		} else if (target == 1) {
			return 1;
		} else {
			int x = 2;
			for (int i = 0; i < target - 2; i++) {
				x *= 2;
			}
			return x;
		}
	}
}
