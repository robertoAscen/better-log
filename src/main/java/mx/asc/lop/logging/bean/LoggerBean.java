package mx.asc.lop.logging.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * clase LoggerBean
 *
 * @author roberto.ascencio.7@gmail.com
 * @date
 */
@Data
@AllArgsConstructor
@Builder
public class LoggerBean {
	//atributo message
	private String message;
	//atributo listService
	private List<LogServiceBean> listService;
	//atributo startTime
	private long startTime;
	//atributo totalTime
	private long totalTime;

	/**
	 * Constructor LoggerBean
	 */
	public LoggerBean() {
		this.message = "Not Message";
		this.listService = new ArrayList<>();
		this.totalTime = 0l;
	}

	/**
	 * metodo getTotalTime
	 * @return long
	 */
	public long getTotalTime() {
		if (startTime > 0) {
			startTime = 0;
			return totalTime;
		}
		return 0;
	}

	/**
	 * metodo getListService
	 * @return List<LogServiceBean>
	 */
	public List<LogServiceBean> getListService() {
		List<LogServiceBean> listServiceCopy;
		listServiceCopy = new ArrayList<>(listService);
		return listServiceCopy;
	}

	/**
	 * metodo setListService
	 * @param listService
	 */
	public void setListService(List<LogServiceBean> listService) {
		List<LogServiceBean> listServiceCopy;
		listServiceCopy = new ArrayList<>(listService);
		this.listService = listServiceCopy;
	}

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
		totalTime = System.currentTimeMillis() - startTime;
	}

}
