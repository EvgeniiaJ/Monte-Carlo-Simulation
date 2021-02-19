import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

class MonteCarloSimulation{
	
	private int combination;;
	private int startingAmount;
	private int currentAmount;
	private double winningProbability;
	private int numSuccess;
	private int numFailure;
	private int counter;
	private int finalRound;
	
public int getCombination() {
		return combination;
	}

	public void setCombination(int combination) {
		this.combination = combination;
	}

	public int getStartingAmount() {
		return startingAmount;
	}

	public void setStartingAmount(int startingAmount) {
		this.startingAmount = startingAmount;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	public double getWinningProbability() {
		return winningProbability;
	}

	public void setWinningProbability(double winningProbability) {
		this.winningProbability = winningProbability;
	}

	public int getNumSuccess() {
		return numSuccess;
	}

	public void setNumSuccess(int numSuccess) {
		this.numSuccess = numSuccess;
	}

	public int getNumFailure() {
		return numFailure;
	}

	public void setNumFailure(int numFailure) {
		this.numFailure = numFailure;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getFinalRound() {
		return finalRound;
	}

	public void setFinalRound(int finalRound) {
		this.finalRound = finalRound;
	}

MonteCarloSimulation(int combination, int startingAmount, double winningProbability, int finalRound, FileWriter output){
		
		this.combination = combination;
		this.startingAmount = startingAmount;
		this.currentAmount = startingAmount;
		this.winningProbability = winningProbability;
		this.numSuccess = 0;
		this.numFailure = 0;
		this.counter = 0;
		this.finalRound = finalRound;

		runTest();
		printResults(output);
	}
	
	void runTest(){
		
		while(this.getCounter() < this.getFinalRound() && (this.getStartingAmount() + 100) > this.getCurrentAmount()) {
			
			if(this.getCurrentAmount() > 0) {
				int generatedNumber = ThreadLocalRandom.current().nextInt(1, 38);
				
				double fraction = (double)(generatedNumber / 37.0);
				
				if(fraction < this.getWinningProbability()) {
					this.setCurrentAmount(this.getCurrentAmount() + 1);
					this.setNumSuccess(this.getNumSuccess() + 1);
				}
				else {
					this.setCurrentAmount(this.getCurrentAmount() - 1);
					this.setNumFailure(this.getNumFailure() + 1);
				}
				this.setCounter(this.getCounter()+1);
			}
			else {
				break;
			}
			
		}
	}
	
	void printResults(FileWriter output) {
		
		try {
			output.write("\t\t  ==========================\n");
			output.write("\t\t  = Running Combination #" + this.getCombination() + " =\n");
			output.write("\t\t  ==========================\n\n");
			output.write("\tSimulation Results:\n\n");
			output.write("Starting Amount: $" + this.getStartingAmount() + " \tChance of Winning: " + this.getWinningProbability() + "\n");
			output.write("Processed Rounds: " + this.getCounter() + " out of " + this.getFinalRound() + "\n");
			output.write("Successful Rounds: " + this.getNumSuccess() + "\t\tFailed Rounds: " + this.getNumFailure() + "\n");
			output.write("\nFinal Amount of money: " + this.getCurrentAmount() + "\t --------------->\t");
			if(this.getCurrentAmount() > this.getStartingAmount()) {
				output.write("Money Surplus: " + (this.getCurrentAmount() - this.getStartingAmount()) +"\n");
			}
			else if(this.getCurrentAmount() != 0 && this.getCounter() == this.getFinalRound()){
				output.write("Not Bunkrupt but lost $" + (this.getStartingAmount() - this.getCurrentAmount()) + "\n");
			}
			else {
				output.write("Bunkrupt \n");
			}
			output.write("\n==============================================================================\n\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}