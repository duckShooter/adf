package adf.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class InMessage implements Serializable {
	private int id; //ID in database
	private int archiveSN; //Serial number from archive
	private int registerNumber; //The number sent with the message
	private String sender;
	private Date dateReceived;
	private Timestamp dateAdded;
	private ArrayList<User> assignedOfficers;
	private String brief;
	private int state;
	private Folder folder;
	private String documentPath;
	//Private ArrayList<Integer> urges;
	//private ArrayList<> replies;
	
	
}
