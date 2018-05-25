package perceptron01;

import java.util.Arrays;

public class Perceptron01_lib {
	private int n;//次元
	private double eta;//更新率
	private double input[][], output[], w[]; //input:データx, output:教師データ-1 or 1
	
	public Perceptron01_lib(int n, double eta, double[][] input, double[] output) {
		//super();
		this.n = n;
		this.eta = eta;
		this.input = input;
		this.output = output;
		this.w = new double[n];
		for(int i = 0;i < n; i++)w[i] = 1; //wを1に初期化
	}
	
	//内積の計算
	public double getInnerProduct(double a[], double b[]) {
		double answer = 0;
		for(int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
		return answer;
	}
	
	//学習関数
	public void getLearning() {
		for(int i = 0; i < input.length; i++) {
			double u = this.getInnerProduct(w, input[i]); //wx内積計算
			if( Math.signum(u) == output[i]) continue; //signum 正数 1.0 負数 -1.0 ゼロ 0.0を返す
			else {
				for(int j = 0; j < w.length; j ++) {
					w[j] += this.eta * output[i] * input[i][j];  //最急降下法
				}
				i = -1; //更新があったのでループの最初から(i++があるので-1にしておく)
			}
			System.out.println("w = " + Arrays.toString(this.w));
		}
	}

	public double getPredict(double data[]) {
		double u = this.getInnerProduct(w, data); //wx内積計算
		return Math.signum(u);	
	}

	

}
