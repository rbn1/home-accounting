package dtos;

import java.util.List;

public class RegistryResponse {

	private ErrorDto error;
	
	private List<RegistryDto> data;

	public ErrorDto getError() {
		return error;
	}

	public void setError(ErrorDto error) {
		this.error = error;
	}

	public List<RegistryDto> getData() {
		return data;
	}

	public void setData(List<RegistryDto> data) {
		this.data = data;
	}
	
}
