package first.sprintbootProject.ApplicationdemoProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cloudvenderinfo")
public class CloudVender {
	@Id
	private String venderId;
	private String venderName;
	private String venderAddrss;
	private int venderPhoneNumber;
	
	
	public CloudVender(String venderId,String venderName,String venderAddrss,int venderPhoneNumber) {
		this.venderId=venderId;
		this.venderName=venderName;
		this.venderAddrss = venderAddrss;
		this.venderPhoneNumber=venderPhoneNumber;
				
	}
	
	public CloudVender() {
		
	}

	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	public String getVenderName() {
		return venderName;
	}
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
	public String getVenderAddrss() {
		return venderAddrss;
	}
	public void setVenderAddrss(String venderAddrss) {
		this.venderAddrss = venderAddrss;
	}
	public int getVenderPhoneNumber() {
		return venderPhoneNumber;
	}
	public void setVenderPhoneNumber(int venderPhoneNumber) {
		this.venderPhoneNumber = venderPhoneNumber;
	}
	

}
