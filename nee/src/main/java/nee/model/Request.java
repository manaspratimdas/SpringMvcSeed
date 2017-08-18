package nee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Manas.Das
 * 
 *         CREATE TABLE REQUEST ( ID int NOT NULL auto_increment, USERNAME
 *         varchar(255), DESTINATION varchar(255), PRIMARY KEY (ID) 
 *         );
 *
 * 
 */
@Entity
@Table(name = "REQUEST")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Long id;

	@Column(name = "USERNAME")
	String username;

	@Column(name = "DESTINATION")
	String destination;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", username=" + username + ", destination=" + destination + "]";
	}

}
