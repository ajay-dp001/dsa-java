package oops.rendringBranchingOverBooleanFlag;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AccountState {

  AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);

  AccountState withDraw(BigDecimal balance, BigDecimal amount, Consumer<BigDecimal> subtractFromBalance);

  AccountState freezeAccount();

  AccountState holderVerified();

  AccountState closeAccount();
}
