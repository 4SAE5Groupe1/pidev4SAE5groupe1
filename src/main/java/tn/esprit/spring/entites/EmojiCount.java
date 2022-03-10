package tn.esprit.spring.entites;

public class EmojiCount {
	
	
	private Publication publication;
    private int totalEmoji;

    public EmojiCount(Publication publication, int totalEmoji) {
        this.publication = publication;
        this.totalEmoji = totalEmoji;
    }

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public int getTotalEmoji() {
		return totalEmoji;
	}

	public void setTotalEmoji(int totalEmoji) {
		this.totalEmoji = totalEmoji;
	}

	@Override
	public String toString() {
		return "EmojiCount [publication=" + publication + ", totalEmoji=" + totalEmoji + "]";
	}
    
    

}
