
public class ViterBiNode {

	String[] observation;
	double[][][] stateTransitionProbability;
	double[] initProbs;
	String[] state;
	String[] output;
	String[] paths;
	String name;

	ViterBiNode(String[] state,String[] output,double[][][] stateTrans,double initProbs[],String paths[]){
		this.state = state;
		this.output = output;
		this.stateTransitionProbability = stateTrans;
		this.initProbs = initProbs;
	}
	
	int getOutputIndex(String op){
		for(int i=0;i<output.length;i++){
			if(output[i].equals(op))return i;
		}
		return -1;
	}
	String explore(int level){
		if(level>=observation.length)return "";
		double nextProbs[][] = new double[state.length][state.length];
		String newPaths[] = new String[state.length];
		int op = getOutputIndex(observation[level]);
		for(int i=0;i<state.length;i++)
			for(int j=0;j<state.length;j++)
				nextProbs[i][j]=initProbs[i]*stateTransitionProbability[i][j][op];
		double nextInit[]= new double[initProbs.length];
		for(int i=0;i<state.length;i++){
			int max = 0;
			for(int j = 1;j<state.length;j++){
				if(nextProbs[j][i]>nextProbs[j][max]){
					max = j;					
				}
			}
			nextInit[i] = nextProbs[max][i];
			newPaths[i] = paths[max] + state[i];
		}
		ViterBiNode next= new ViterBiNode(state,output,stateTransitionProbability,nextInit,paths);
		String nextState = next.explore(level+1);
		
		return ;
	}
	void setSequence(String opseq[]){
		this.observation = opseq;
	}
	
	

}
