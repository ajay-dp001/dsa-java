package LowLoevelSystemDesign.lrucache.cache.exception;

public class NotFoundException extends RuntimeException {

  public NotFoundException(final String msg) {
    super(msg);
  }

}
