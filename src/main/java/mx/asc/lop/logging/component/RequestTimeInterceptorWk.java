package mx.asc.lop.logging.component;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mx.asc.lop.log.config.EnumThreadContext;
import com.mx.asc.lop.log.service.LoggerAscService;

/**
 * clase RequestTimeInterceptorWk
 *
 * @author roberto.ascencio.7@gmail.com
 * @date
 */
@Component
public class RequestTimeInterceptorWk implements HandlerInterceptor {
	// atributo LoggerAscService
	@Autowired
	private LoggerAscService log;

	/**
	 * Metodos preHandle
	 * @param request
	 * @param response
	 * @param handler
	 * @return boolean
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		limpiarVariablesTransac();
		return true;
	}

	/**
	 * metodo afterCompletion
	 * se ejecuta despues de la peticion http
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		limpiarVariablesTransac();
	}

	/**
	 * metodo limpiarVariablesTransac
	 */
	public void limpiarVariablesTransac() {
		EnumThreadContext.obtenThreadContext().stream().forEach(ThreadContext::remove);
	}
}
