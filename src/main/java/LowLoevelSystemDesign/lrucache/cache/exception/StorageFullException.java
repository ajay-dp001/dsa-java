package LowLoevelSystemDesign.lrucache.cache.exception;

public class StorageFullException extends RuntimeException {

  public StorageFullException(final String msg) {
    super(msg);
  }
}
