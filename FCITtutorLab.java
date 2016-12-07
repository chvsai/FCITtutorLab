import java.io.*;
import java.util.Scanner;

public class FCITtutorLab {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("src/input.txt"));
		int noOfLaptops = in.nextInt();
		PrintWriter out = new PrintWriter("src/output.txt","UTF-8");
		FCITlaptopStack laptopStack = new FCITlaptopStack(noOfLaptops);
		addLaptops(noOfLaptops, in,laptopStack);
		int noOfMueed = in.nextInt();
		FCITmueed[] mueedArray = new FCITmueed[noOfMueed];
		addMueed(noOfMueed,in,mueedArray);
		int noOfPrograms = in.nextInt();
		
		conductPrograms(noOfPrograms,in,laptopStack,mueedArray,out);
		in.close();
		out.close();
	}

	public static void addLaptops(int noOfLaptops, Scanner in, FCITlaptopStack laptopStack) {
		for (int i = 0; i < noOfLaptops; i++) {
			laptopStack.addLaptop(in.nextInt());
		}
	}
	public static void addMueed(int noOfMueed,Scanner in,FCITmueed[] mueedArray){
		for (int i = 0; i < noOfMueed; i++) {
			String name = in.next();
			int[] startTimes = new int[3];
			int[] endTimes = new int[3];
			for(int j=0;j<3;j++){
				startTimes[j]= Integer.parseInt(in.next());
				endTimes[j]=Integer.parseInt(in.next());
			}
			FCITmueed mueed = new FCITmueed(name,startTimes,endTimes);
			mueedArray[i] = mueed;
			
		}
	}
	public static void conductPrograms(int noOfPrograms,Scanner in,FCITlaptopStack laptopStack,FCITmueed[] mueedArray, PrintWriter out){
		for(int i=0;i<noOfPrograms;i++){
			performThreeDayRoutine(in,laptopStack,mueedArray,out);
		}
	}
	public static void performThreeDayRoutine(Scanner in,FCITlaptopStack laptopStack,FCITmueed[] mueedArray, PrintWriter out){
		for(int i=0;i<3;i++){
			performDayRoutine(in,laptopStack,mueedArray,i,out);
		}
	}

	public static void performDayRoutine(Scanner in,
			FCITlaptopStack laptopStack, FCITmueed[] mueedArray,int i, PrintWriter out) {
		int studentsCount = in.nextInt();
		FCITqueue outsideQueue = addStudentsToOutsideLine(in,studentsCount);
		int startTime = getStartTime(i,mueedArray,out);
		int endTime = getEndTime(i,mueedArray);
		FCITqueue laptopQueue = new FCITqueue();
		FCITqueue mueedQueue = new FCITqueue();
		int laptopIssueTime=0;
		for(;startTime<=endTime;startTime++){
			
			if(!(outsideQueue.isEmpty())){
			while(!(outsideQueue.isEmpty()) && outsideQueue.getFirst().getEnterTime()<=startTime){
				printTimeStamp(startTime,out);
				out.println(outsideQueue.getFirst().getFirstName()+
						" "+outsideQueue.getFirst().getLastName()+" has arrived in the FCIT Tutor Lab.");
				laptopQueue.enqueue(outsideQueue.dequeue());
			}
//			}
		}
			if(laptopIssueTime !=0){
				
				if(laptopIssueTime == 2){
					if(laptopQueue.getFirst().getLaptopSerialNumber()==0){
//					laptopQueue.getFirst().setLaptopSerialNumber(laptopStack.removeLaptop());
					mueedQueue.enqueue(laptopQueue.dequeue());
					printTimeStamp(startTime,out);
					out.println(mueedQueue.getFirst().getFirstName()+" "+mueedQueue.getFirst().getLastName()+
							" has borrowed laptop "+mueedQueue.getFirst().getLaptopSerialNumber()+" and moved to the TA line.");
					laptopIssueTime=0;
					
//					
					}else{
						printReportMessage(startTime,laptopQueue.getFirst(),out);
						laptopStack.addLaptop(laptopQueue.getFirst().getLaptopSerialNumber());
						laptopQueue.getFirst().setLaptopSerialNumber(0);
						laptopQueue.dequeue();
					}
				}else laptopIssueTime++;
			}else if(!(laptopQueue.isEmpty())){
				laptopIssueTime++;
			}
//			if(!mueedQueue.isEmpty()){
			clarifyDoubts(startTime,mueedQueue,mueedArray,out);
//			}
		}
//		}
	}

	private static void clarifyDoubts(int startTime,FCITqueue mueedQueue,
			FCITmueed[] mueedArray, PrintWriter out) {
		// TODO Auto-generated method stub
		for(FCITmueed mueed : mueedArray){
			if(mueed.getStudentWithMueed()!=null)mueed.setMinute(mueed.getMinute()+1);
			if(!(mueedQueue.isEmpty()) && mueed.getStudentWithMueed() == null && mueed.getEndTimes()[0]>startTime){
				mueed.setStudentWithMueed(mueedQueue.dequeue());
				printTimeStamp(startTime,out);
				out.println(mueed.getStudentWithMueed().getFirstName()+" "
				+mueed.getStudentWithMueed().getLastName()+
						" is getting help from "+mueed.getName()+".");
			}else if(mueed.getMinute() >= 5){
				mueed.setMinute(0);
				if(mueed.getStudentWithMueed().getNumQuestions()>0){
					printTimeStamp(startTime,out);
					out.println(mueed.getStudentWithMueed().getFirstName()+" "+mueed.getStudentWithMueed().getLastName()+
					" has had one question answered and gotten back in line.");
					mueedQueue.enqueue(mueed.getStudentWithMueed());
					mueed.setStudentWithMueed(null);
					
				}else{
					printTimeStamp(startTime,out);
					out.println(mueed.getStudentWithMueed().getFirstName()+" "+mueed.getStudentWithMueed().getLastName()+
							" has no more questions and will now return the laptop.");
				}
				clarifyDoubts(startTime, mueedQueue, mueedArray,out);
			}
		}
	}

	private static void printReportMessage(int startTime,FCITstudent first, PrintWriter out) {
		// TODO Auto-generated method stub
		printTimeStamp(startTime,out);
		out.println(first.getFirstName()+" "+first.getLastName()+" has returned laptop "
							+first.getLaptopSerialNumber()+" and went home "
							+((first.getNumQuestions()>0)?"FRUSTRATED":"HAPPY"));
	}

	private static void printTimeStamp(int startTime, PrintWriter out) {
		// TODO Auto-generated method stub
		out.printf("%d:%02d PM:   ",(startTime/60==0?12:startTime/60),(startTime%60));
	}

	private static int getEndTime(int i, FCITmueed[] mueedArray) {
		int max=mueedArray[0].getEndTimes()[i];
		for(int j=0;j<mueedArray.length;j++){
			max = (max>=mueedArray[j].getEndTimes()[i])?max:mueedArray[j].getEndTimes()[i];
		}
		return max;
	}

	private static int getStartTime(int i, FCITmueed[] mueedArray, PrintWriter out) {
		int min=mueedArray[0].getStartTimes()[i];
		String classBeginner=mueedArray[0].getName();
		for(int j=0;j<mueedArray.length;j++){
			if(min>mueedArray[j].getStartTimes()[i]){
			min= mueedArray[j].getStartTimes()[i];
			classBeginner = mueedArray[j].getName();
			}
		}
		printTimeStamp(min,out);
		out.println(classBeginner+" has begun lab hours");
		return min;
	}

	public static FCITqueue addStudentsToOutsideLine(Scanner in, int studentsCount) {
		FCITqueue outsideQueue = new FCITqueue();
		for(int i=0;i<studentsCount;i++){
			int enterTime = in.nextInt();
			String firstName = in.next();
			String lastName = in.next();
			int numQuestions = in.nextInt();
			FCITstudent student = new FCITstudent(enterTime,firstName,lastName,numQuestions);
			outsideQueue.enqueue(student);
		}
		return outsideQueue;
	}
}
