package LowLoevelSystemDesign.lrucache.exceptions;

public class InvalidNodeException extends RuntimeException {

  public InvalidNodeException(final String msg) {
    super(msg);
  }

}
