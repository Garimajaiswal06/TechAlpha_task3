package voting;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class  Candidate{
    private String name;
    private int votes;

    public Candidate(String name){
        this.name = name;
        this.votes = 0;
    }
    public String getName(){
        return name;
    }
    public int getVotes(){
        return votes;
    }
    public void addVote(){
        votes++;
    }
}
public class OnlineVotingSystem {

    private List<Candidate> candidates =new ArrayList<>();

    public void addCandidate(String name){
        candidates.add(new Candidate(name));
        System.out.println("Candidate added successfully");
    }
    public void castVotes(String name){
        for(Candidate candidate : candidates){
            if(candidate.getName().equals(name)){
                candidate.addVote();
                System.out.println("Vote casted successfully");
                return ;
            }
        }
        System.out.println("Candidate not found");
    }
    public void displayResults(){
        if(candidates.isEmpty()){
            System.out.println("No candidates found");
        }else{
            System.out.println("voting results:");
            for(Candidate candidate : candidates){
                System.out.println("Candidate:" + candidate.getName() + "Votes" + candidate.getVotes());
            }
        }
    }
    public static void main(String[] args) {
        OnlineVotingSystem system =new OnlineVotingSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOnline Voting System");
            System.out.println("1. Add Candidate");
            System.out.println("2. Cast Vote");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.println("5. Enter Your choice: ");

            int Choice = scanner.nextInt();
            scanner.nextLine();

            switch (Choice) {
                case 1: System.out.println("Enter Candidate name: ");
                String name = scanner.nextLine();
                system.addCandidate(name);    
                    break;
                    case 2: System.out.println("Enter Candidate name to vote for: ");
                    String candidateName = scanner.nextLine();
                   system.castVotes(candidateName);   
                        break;
                        case 3: system.displayResults();
                            break;
                            case 4:System.out.println("Exiting....");
                            scanner.close();
                            return;
                default:
                System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
        }
    }

}