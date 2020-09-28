package Interfaces;

import java.util.List;


import javax.ejb.Remote;

import Entities.Comment;

 
@Remote
public interface ICommentServiceRemote {

	List<Comment> Getbyid(int fid); 
	void addcomment(int fid,String msg) ;
	void delcomment(int cid) ;

}
