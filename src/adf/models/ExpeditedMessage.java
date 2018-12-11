package adf.models;

public class ExpeditedMessage extends InMessage {
	private int associatedWith; //The id of the original message

	public int getAssociatedWith() {
		return associatedWith;
	}

	public void setAssociatedWith(int associatedWith) {
		this.associatedWith = associatedWith;
	}
}
