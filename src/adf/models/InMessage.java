package adf.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class InMessage implements Serializable {
	private int id; //ID in database
	private int archiveSN; //Serial number from archive
	private int recordNumber; //The number sent with the message
	private String sender;
	private Date dateReceived;
	private Timestamp dateAdded;
	private ArrayList<User> assignedOfficers; //The officers whom the message is assigned to
	private Folder folder;
	private String brief; //Concise description of the message content
	private int state;
	private String documentPath; //Location on HD
}
