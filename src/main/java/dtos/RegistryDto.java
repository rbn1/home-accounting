package dtos;

import java.util.Date;

import entities.Registry;

public class RegistryDto {

	private Long id;
	
	private Date date;
	
	private String reason;
	
	private Double amount;
	
	public RegistryDto() {}
	
	public RegistryDto(Registry registry) {
		this.id = registry.getId();
		this.date = registry.getDate();
		this.reason = registry.getReason();
		this.amount = registry.getAmount();
	}
	
	public Registry toRegistry() {
		Registry registry = new Registry();
		
		registry.setAmount(amount);
		registry.setDate(date);
		registry.setId(id);
		registry.setReason(reason);
		
		return registry;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	
	
}
