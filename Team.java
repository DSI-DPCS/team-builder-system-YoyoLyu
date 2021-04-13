import java.util.Scanner;

public class Team {

	public static  void printAllName(Member arr[], int num) {
		for(int i=0;i<num;i++) {
			Member m=arr[i];
			System.out.println(m.Name+", "+m.Surname+", born in"+m.day+"/"+m.month+"/"+m.Year);
		}
	}


public static void main(String[] args) {
	System.out.println("Welcome to the Team Builder System\n"
			+ "==================================");
	Scanner in = new Scanner(System.in);
	System.out.println("Number of members:");
	int numOfMembers=Integer.parseInt(in.nextLine());
	Member members[]=new Member[numOfMembers];
	for (int index=0;index<numOfMembers;index++) {
		String line=in.nextLine();
		String[] lineChar=line.split(":");
		Member mem = new Member();
		mem.Name=lineChar[0];
		mem.Surname=lineChar[1];
		mem.Sex=lineChar[2];
		String[] Birth=lineChar[3].split("/");
		mem.Year=Integer.parseInt(Birth[0]);
		mem.month=Integer.parseInt(Birth[1]);
		mem.day=Integer.parseInt(Birth[2]);
		mem.compare=mem.Year*365+mem.month*30+mem.day;
		members[index] = mem;
	}
	boolean pan=true;
	while(pan) {
	System.out.println("Team Builder Menu:\n"
			+ "==================================\n"
			+ "1.List the team members\n"
			+ "2.Find the oldest member\n"
			+ "3.Find the youngest member\n"
			+"4. Sort by Nme in ascending order\n"
			+"5. Sort by birthday in ascending order");
	String order=in.nextLine();
	System.out.println(order);
	////////////////////////////////////////////////              1                 ////////////////////////////////////////////////////////
	if(order.equals("1")) {
		printAllName(members,numOfMembers);
	}
	///////////////////////////////////////////////               2                 /////////////////////////////////////////////////////////
	else if(order.equals("2")) {
		Member outp2=members[0];
		for(int i=0;i<numOfMembers;i++) {
			if(members[i].compare<outp2.compare) {
				outp2=members[i];
			}
		}System.out.println(outp2.Name+", "+outp2.Surname+", born in"+outp2.day+"/"+outp2.month+"/"+outp2.Year);
	}
	///////////////////////////////////////////////               3                 /////////////////////////////////////////////////////////
	else if(order.equals("3")){
		Member outp3=members[0];
		for(int i=0;i<numOfMembers;i++) {
			if(members[i].compare>outp3.compare) {
				outp3=members[i];
			}
			
		}System.out.println(outp3.Name+", "+outp3.Surname+", born in"+outp3.day+"/"+outp3.month+"/"+outp3.Year);
	}
	///////////////////////////////////////////////               4                 /////////////////////////////////////////////////////////
	else if(order.equals("4")) {
		for(int a=0;a<numOfMembers;a++) {
			for(int b=a+1;b<numOfMembers;b++) {
				if(members[a].Name.compareTo(members[b].Name) > 0) {
					Member temp = members[a];

					members[a]= members[b];

					members[b] = temp;
				}
			}
		}printAllName(members,numOfMembers);
	}
///////////////////////////////////////////////               5                 /////////////////////////////////////////////////////////
	else if(order.equals("5")) {
		for(int a=0;a<numOfMembers;a++) {
			for(int b=a+1;b<numOfMembers;b++) {
				if(members[a].compare>members[b].compare) {
					Member temp = members[a];

					members[a]= members[b];

					members[b] = temp;
				}
			}
		}printAllName(members,numOfMembers);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	else {
		System.out.println("???");
	}
	System.out.println("Continue? (Yes/No)");
	String inn=in.nextLine();
	if(inn.equals("No")) {
		pan=false;
}
	
}}
}