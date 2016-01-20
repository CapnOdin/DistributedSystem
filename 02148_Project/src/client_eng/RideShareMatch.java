
package client_eng;

import org.cmg.resp.behaviour.Agent;
import org.cmg.resp.comp.Node;
import org.cmg.resp.knowledge.ActualTemplateField;
import org.cmg.resp.knowledge.FormalTemplateField;
import org.cmg.resp.knowledge.Template;
import org.cmg.resp.knowledge.Tuple;
import org.cmg.resp.knowledge.ts.TupleSpace;
import org.cmg.resp.topology.Self;
import java.util.Scanner;

public class RideShareMatch {
	
	public static void main(String[] argv) {
		
		Node node = new Node("rideshare", new TupleSpace());
		Agent traveler = new ClientAgent();
		Agent match = new MatchAgent();
		node.addAgent(traveler);		
		node.addAgent(match);
		node.start();
	}
	
	
	public static class ClientAgent extends Agent {

		public ClientAgent() {
			super("travel");
		}

		@Override
		protected void doRun() {
			try {
				while (true) {
					
					Thread.sleep(300);
					
					Scanner scanner = new Scanner(System.in);
					
	//Find ride share.
					
					
                    String usrname = "Ole";
    
    //travel tuple definition: (mode = "travel")           
	//mode, name of user, destination and date
					put(new Tuple( "travel" , usrname, "DTU","today"  ) , Self.SELF);
					
					
					Template t1 = new Template(new ActualTemplateField("travel") ,
							                   new FormalTemplateField( String.class ) ,
							                   new ActualTemplateField("DTU") ,
							                   new ActualTemplateField("today"));
					
	//Request a match with the same destination and date
					System.out.println("Find match! \n  (A rideshare request is sent by Ole (Main user) \n  to the server, with the destination: \"DTU\" and \n  the date: \"today\") \n \n");
					
					Tuple nameTup = new Tuple();
					
					nameTup = query( t1 , Self.SELF);
					String matchName = nameTup.getElementAt(String.class,1);
					
					//Get found match
					System.out.println("\n  (Ole's perspective (Main user))");
					System.out.println("Match found: " + matchName + " is looking for a ride! \n");
					get(t1, Self.SELF);	
                    	
	//Send message to matched user
					
					String sndr, rcvr, msg;
			//ID on sender and receiver, change to OP and reply
					sndr = "Ole";
					rcvr = "Matt";
                    
					System.out.println("Write a message to " + matchName + ":");
                    msg = (scanner.next());
                    msg = msg + (scanner.nextLine());
                    
					put(new Tuple( "message", sndr,rcvr, msg ), Self.SELF);
					
					
					Template t2 = new Template(	new ActualTemplateField("message")	,
												new FormalTemplateField(String.class)		,
												new ActualTemplateField("Ole")		,
												new FormalTemplateField( String.class));
					
					//Request a message
					query( t2 , Self.SELF);
					
					//Get found match
					Tuple msgT = new Tuple();
					msgT = get( t2 , Self.SELF);
					String senderName = "";
					senderName = msgT.getElementAt(String.class,1);
					System.out.println("\n  (Ole's perspective (Main user))");
					System.out.println("New message from " + senderName + ": \n ");					
					System.out.println(msgT.getElementAt(String.class,3) + "\n");
                 
				Thread.sleep(300);	
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}


	public static class MatchAgent extends Agent {
	
		public MatchAgent() {
			super("match");
		}
	
		@Override
		protected void doRun() {
			try {
				while (true) {
				
					Thread.sleep(300);
					
					Template t3 = new Template(new ActualTemplateField("travel") ,
			                   new FormalTemplateField( String.class ) ,
			                   new ActualTemplateField("DTU") ,
			                   new ActualTemplateField("today"));
					
					//Get travel ride hare request
					get(	t3 , Self.SELF);
					
					//Traveler 2 enter travel details to find match
					Scanner scanner = new Scanner(System.in);
					String mode, name, dest, date;
					System.out.println("  (Matt's perspective(Secondary user)) \n  Find rideshare matches by entering the mode: \"travel\" \n  and enter the details from Oles' request)");
					System.out.println("Enter mode:");
                    	mode = (scanner.next());
                    System.out.println("Enter your name:");
                    	name = (scanner.next());
                    System.out.println("Enter destination:");
                    	dest = (scanner.next());
                    System.out.println("Enter date:");
                    	date = (scanner.next());
					put(new Tuple( mode, name, dest, date) , Self.SELF);
				
			//Get message
					
					Template t4 = new Template(	new ActualTemplateField("message") ,
												new FormalTemplateField( String.class ),
			                   					new ActualTemplateField( "Matt" ) ,
			                   					new FormalTemplateField( String.class ));
					
					Tuple msgT = new Tuple();
					msgT = get( t4 , Self.SELF);
					String senderName = "";
					senderName = msgT.getElementAt(String.class,1);
					
					System.out.println("\n  (Matt's perspective (Secondary user))");
					System.out.println("New message from " + senderName + ": \n ");					
					System.out.println(msgT.getElementAt(String.class,3) + "\n");
				//Traveler 2 replies
                
				//This should of course be automated in the real program
					String rcvr, sndr, msg;
					
					sndr = "Matt";
					System.out.println("  (Enter the mode: \"message\" , to send reply to Ole!)");
					System.out.println("Enter mode: ");
                 	mode = (scanner.next());
                 	
                 		System.out.println("Enter receiver: ");
                 	rcvr = (scanner.next());
                //
                 		System.out.println("Enter message: ");
                 	msg = scanner.next();
                 	msg = msg + scanner.nextLine();
                 	
					put(new Tuple( mode, sndr, rcvr, msg) , Self.SELF);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
