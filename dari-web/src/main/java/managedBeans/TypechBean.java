package managedBeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Enumerates.*;

@ManagedBean(name= "enumbean")
@ApplicationScoped
public class TypechBean implements Serializable {
	private static final long serialVersionUID= 1L;
	public Typech[] getTypech() {
		return Typech.values();
	}
	public Type[] getType() {
		return Type.values();
	}
	public Governorateenum[] getGovernorateenum() {
			
			return Governorateenum.values();
			
	}
	

}
