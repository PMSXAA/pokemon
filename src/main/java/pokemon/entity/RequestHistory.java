package pokemon.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REQUEST_HISTORY")
public class RequestHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "IP_ORIGIN")
	private String ipOrigin;
	@Column(name = "DATE_REQUEST")
	private Date dateRequest;
	@Column(name = "METHOD")
	private String method;
	@Column(name = "TIME_REQUEST")
	private Long timeRequest;
	@Column(name = "REQUEST")
	private String request;
	@Column(name = "RESPONSE")
	private String response;
	
	public RequestHistory(String ipOrigin, Date dateRequest, String method, Long timeRequest, String request,
			String response) {
		this.ipOrigin = ipOrigin;
		this.dateRequest = dateRequest;
		this.method = method;
		this.timeRequest = timeRequest;
		this.request = request;
		this.response = response;
	}
	
	public String getIpOrigin() {
		return ipOrigin;
	}
	public void setIpOrigin(String ipOrigin) {
		this.ipOrigin = ipOrigin;
	}
	public Date getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Long getTimeRequest() {
		return timeRequest;
	}
	public void setTimeRequest(Long timeRequest) {
		this.timeRequest = timeRequest;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
