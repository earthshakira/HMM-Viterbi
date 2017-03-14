import java.io.*;
import java.util.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File transFile = new File("transition.data"),
				outFile = new File("outputs.data");
		Scanner transScr = new Scanner(transFile),outScr = new Scanner(outFile);
		String initStr[] = transScr.nextLine().split("\\s+");
		String state[] = transScr.nextLine().split("\\s+");
		String output[] = outScr.nextLine().split("\\s+");
		double stateTransition[][] = new double[state.length][state.length];
		double stateOutput[][] = new double[state.length][output.length];
		double transitionProbs[][][]=new double[state.length][state.length][output.length];
		double initProbs[] = new double[initStr.length];
		System.out.print("Intial Probabilities");
		
		for(int i=0;i<initStr.length;i++){
			initProbs[i]=Double.parseDouble(initStr[i]);
			System.out.print(" "+initProbs[i]);
		}
		
		for(int i=0;i<state.length;i++){
			String stateLine[] = transScr.nextLine().split("\\s+");
			for(int j=0;j<state.length;j++){
				stateTransition[i][j] = Double.parseDouble(stateLine[j]);
			}
		}
		for(int i=0;i<state.length;i++){
			String opLine[] = outScr.nextLine().split("\\s+");
			for(int j=0;j<output.length;j++){
				stateOutput[i][j] = Double.parseDouble(opLine[j]);
			}
		}
		
		for(int i = 0;i < state.length ; i++){
			for(int j = 0 ;j<state.length;j++ ){
				for(int k = 0 ;k<output.length;k++)
					transitionProbs[i][j][k] = stateTransition[i][j]* stateOutput[i][k];
			}
		}
		
		
		System.out.println();
		
	}

}
