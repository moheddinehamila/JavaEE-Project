
package Entities;

import java.util.Date;

public class Comment {

	public int CommentId;

	public int FurnitureId;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date date;
	public String Message;

	public String UserId;
 

	@Override
	public String toString() {
		return "Comment [CommentId=" + CommentId + ", FurnitureId=" + FurnitureId + ", date=" + date + ", Message="
				+ Message + ", UserId=" + UserId + "]";
	}

	public int getCommentId() {
		return CommentId;
	}

	public void setCommentId(int commentId) {
		CommentId = commentId;
	}

	public int getFurnitureId() {
		return FurnitureId;
	}

	public void setFurnitureId(int furnitureId) {
		FurnitureId = furnitureId;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

}
