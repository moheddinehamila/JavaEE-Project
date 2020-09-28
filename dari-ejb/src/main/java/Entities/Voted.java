package Entities;

public class Voted {

    public int VotedId ;
    public String UserId ;
    public int FurnitureId ;
    public int note;
	public int getVotedId() {
		return VotedId;
	}
	public void setVotedId(int votedId) {
		VotedId = votedId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public int getFurnitureId() {
		return FurnitureId;
	}
	public void setFurnitureId(int furnitureId) {
		FurnitureId = furnitureId;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Voted [VotedId=" + VotedId + ", UserId=" + UserId + ", FurnitureId=" + FurnitureId + ", note=" + note
				+ "]\n";
	}
		         
}
