package entities.enums;

import java.util.Scanner;

public enum WorkerLevel {
	JUNIOR,
	MID_LEVEL,
	SENIOR;
	

	public static WorkerLevel converterWorkerLevel(){
		Scanner sc = new Scanner(System.in);
		
		String workerLevelInput = sc.nextLine();
		try {
			WorkerLevel workerLevel = WorkerLevel.valueOf(workerLevelInput);
			return workerLevel;
		}catch(Error error){
			System.out.println("Digite um level válido");
			return WorkerLevel.converterWorkerLevel();
		}
	}
}

