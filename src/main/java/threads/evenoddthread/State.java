package threads.evenoddthread;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class State {

  private PrinterType nextToPrint;

  public State(@NonNull final PrinterType printType) {
    this.nextToPrint = printType;
  }
}
