package mx.asc.lop.logging;

import mx.asc.lop.logging.bean.LoggerBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerAscTest {
  private LoggerAsc loggerAsc;
  private LoggerBean loggerBean;

  public LoggerAscTest(){
    loggerAsc = new LoggerAsc();
    loggerBean = new LoggerBean();
    loggerBean.setMessage("Test");
  }

  @Test
  void controladorTest(){
    boolean valorEsperado = true;
    boolean valorActual;

    loggerAsc.info(loggerBean);
    loggerAsc.error(loggerBean);
    loggerAsc.warn(loggerBean);
    loggerAsc.debug(loggerBean);
    valorActual = loggerAsc instanceof LoggerAsc;
    assertEquals(valorEsperado, valorActual, "Debe ser true");
  }
}
