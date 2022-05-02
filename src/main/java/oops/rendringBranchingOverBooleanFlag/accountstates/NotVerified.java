package oops.rendringBranchingOverBooleanFlag.accountstates;

import java.math.BigDecimal;
import java.util.function.Consumer;
import oops.rendringBranchingOverBooleanFlag.AccountState;
import oops.rendringBranchingOverBooleanFlag.AccountUnfrozen;

public class NotVerified implements AccountState {

  private AccountUnfrozen onUnfrozen;

  public NotVerified(AccountUnfrozen accountUnfrozen) {
    this.onUnfrozen = accountUnfrozen;
  }

  @Override
  public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
    addToBalance.accept(amount);
    return this;
  }

  @Override
  public AccountState withDraw(BigDecimal balance, BigDecimal amount,
      Consumer<BigDecimal> subtractFromBalance) {
    return this;
  }

  @Override
  public AccountState freezeAccount() {
    return this;
  }

  @Override
  public AccountState holderVerified() {
    return new Active(this.onUnfrozen);
  }

  @Override
  public AccountState closeAccount() {
    return new Closed();
  }
}
