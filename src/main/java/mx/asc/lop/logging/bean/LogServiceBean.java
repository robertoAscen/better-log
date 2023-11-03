package mx.asc.lop.logging.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogServiceBean {
	//atributo servicio
	private String servicio;
	//atributo sistema
	private String sistema;
	//atributo subProceso
	private String subProceso;
	//atributo cliente
	private String cliente;
	//atributo producto
	private String producto;
	//atributo request
	private String request;
	//atributo response
	private String response;
	//atributo url
	private String url;
	//atributo tiempo
	private long tiempo;
	//atributo startTime
	private long startTime;

	/**
	 * metodo start
	 */
	public void start() {
		startTime = System.currentTimeMillis();
	}

	/**
	 * metodo stop
	 */
	public void stop() {
		tiempo = System.currentTimeMillis() - startTime;
	}
}
