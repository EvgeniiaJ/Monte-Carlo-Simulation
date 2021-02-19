import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
public static void main(String[] args) {
		
		int startingAmount[] = {10, 100, 1000}; // starting amount of money to run a simulation
		double winningProb[] = {0.40, 0.49, 0.50}; // probability of winning
		int finalRound = 50; // total number of rounds of simulation
		int combination = 1;
		
		String outputFileName = "output1.txt";
		
		try {

			FileWriter output = new FileWriter(new File(outputFileName));
			output.write("\t\t\tMONTE CARLO SIMULATION\n\n\n");

			for (int i = 0; i < startingAmount.length; i++) {
				for (int j = 0; j < winningProb.length; j++) {
					MonteCarloSimulation simulation = new MonteCarloSimulation(combination++, startingAmount[i], winningProb[j], finalRound,
							output);
				}
			}
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
