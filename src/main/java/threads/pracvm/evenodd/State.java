package threads.pracvm.evenodd;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class State {

  private PrintType nextToPrint;

  public State(@NonNull final PrintType printerType) {
    this.nextToPrint = printerType;
  }

  public PrintType nextPrintType(final PrintType printType) {
    return printType.equals(PrintType.ODD) ? PrintType.EVEN : PrintType.ODD;
  }

}
