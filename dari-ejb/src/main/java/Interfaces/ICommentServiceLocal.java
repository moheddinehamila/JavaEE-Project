package Interfaces;

import java.util.List;

import javax.ejb.Local; 

import Entities.Comment;

 
@Local
public interface ICommentServiceLocal {
	
	List<Comment> Getbyid(int fid); 
	void delcomment(int cid) ;
	void addcomment(int fid ,String msg) ;

}
