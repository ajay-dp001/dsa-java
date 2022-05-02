package LowLoevelSystemDesign.lrucache.exceptions;

public class InvalidElementException extends RuntimeException {

  public InvalidElementException(final String msg) {
    super(msg);
  }

}
