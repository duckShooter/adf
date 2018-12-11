package adf.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class OutMessage implements Serializable {
	private int id; //ID in database
	private int archiveSN; //Serial number from archive
	private int recordNumber; //The number sent with the message
	private String receiver;
	private Date dateSent;
	private Timestamp dateAdded;
	private String brief;
	private int state;
	private Folder folder;
	private String documentPath;
	//Private ArrayList<Integer> urges;
	//private ArrayList<> replies;
	
}
 