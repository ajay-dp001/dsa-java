package oops.rendringBranchingOverBooleanFlag.accountstates;

import java.math.BigDecimal;
import java.util.function.Consumer;
import oops.rendringBranchingOverBooleanFlag.AccountState;
import oops.rendringBranchingOverBooleanFlag.AccountUnfrozen;

public class Active implements AccountState {

  private AccountUnfrozen onUnfrozen;

  public Active(AccountUnfrozen accountUnfrozen) {
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
    if (balance.compareTo(amount) >= 0) {
      subtractFromBalance.accept(amount);
    }
    return this;
  }

  @Override
  public AccountState freezeAccount() {
    return new Frozen(this.onUnfrozen);
  }

  @Override
  public AccountState holderVerified() {
    return this;
  }

  @Override
  public AccountState closeAccount() {
    return new Closed();
  }
}
