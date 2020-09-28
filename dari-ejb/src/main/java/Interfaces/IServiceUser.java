package Interfaces;

import javax.ejb.Remote;

import Entities.User;
@Remote
public interface IServiceUser {
	public User Dologin(String email, String Password);
}
