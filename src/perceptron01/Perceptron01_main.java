package perceptron01;

public class Perceptron01_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double input[][] = { {1,0,0}, {1,0,1}, {1,1,0}, {1,1,1}};
		double output[] = {-1, 1, 1, 1};
		
		Perceptron01_lib mlib = new Perceptron01_lib(input[0].length,0.2,input,output);
		mlib.getLearning();
		//double [][] transition = mlib.getTransition(n, initial);
	}

}
