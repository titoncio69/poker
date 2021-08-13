package com.poker.backend.rest.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ExceptionResponse {
	private LocalDateTime timestamp;
	private String mensaje;
	private List<String> detalles;

	public ExceptionResponse(LocalDateTime timestamp, String mensaje, List<String> detalles) {
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<String> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<String> detalles) {
		this.detalles = detalles;
	}
}
