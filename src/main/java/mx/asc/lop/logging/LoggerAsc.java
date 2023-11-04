package mx.asc.lop.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringMapMessage;
import org.springframework.web.util.JavaScriptUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.asc.lop.log.bean.LogBean;
import com.mx.asc.lop.log.service.LoggerAscService;
import com.mx.asc.lop.log.service.LoggerAscServiceImpl;

import mx.asc.lop.logging.bean.LoggerBean;

/**
 * Clase LoggerAsc
 *
 * @author roberto.ascencio.7@gmail.com
 * @date
 */
public class LoggerAsc {
	
	//atributo Logger
	private Logger logger;
	//atributo LoggerAscService
	private LoggerAscService log = new LoggerAscServiceImpl();

	/**
	 * Constructor LoggerAsc
	 */
	public LoggerAsc() {
		logger = LogManager.getLogger(LoggerAsc.class);
	}

	/**
	 * metodo info
	 * @param loggerBean
	 */
	public void info(LoggerBean loggerBean) {
		log.info(LogBean.builder().message(loggerBean.getMessage()).build());
	}

	/**
	 * metodo error
	 * @param loggerBean
	 */
	public void error(LoggerBean loggerBean) {
		log.error(LogBean.builder().message(loggerBean.getMessage()).build());
	}

	/**
	 * metodo warn
	 * @param loggerBean
	 */
	public void warn(LoggerBean loggerBean) {
		log.info(LogBean.builder().message(loggerBean.getMessage()).build());
	}

	/**
	 * metodo debug
	 * @param loggerBean
	 */
	public void debug(LoggerBean loggerBean) {
		log.debug(LogBean.builder().message(loggerBean.getMessage()).build());
	}

	/**
	 * metodo getStringMapMessage
	 * @param loggerBean
	 * @return StringMapMessage
	 */
	private StringMapMessage getStringMapMessage(LoggerBean loggerBean) {
		try {
			StringMapMessage stringMapMessage = new StringMapMessage();
			stringMapMessage.put("mensaje", escape(loggerBean.getMessage()));
			stringMapMessage.put("servicios", new ObjectMapper().writeValueAsString(loggerBean.getListService()));
			stringMapMessage.put("tiempoTotal", String.valueOf(loggerBean.getTotalTime()));
			return stringMapMessage;
		}
		catch (JsonProcessingException exception) {
			logger.error("Error al construir stringMapMessage: " + exception);
			return new StringMapMessage();
		}
	}

	/**
	 * metodo escape
	 * @param text
	 * @return String
	 */
	private String escape(String text) {
		return JavaScriptUtils.javaScriptEscape(text);
	}
}
