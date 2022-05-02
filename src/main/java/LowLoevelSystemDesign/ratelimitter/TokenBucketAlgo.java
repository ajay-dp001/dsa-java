package LowLoevelSystemDesign.ratelimitter;

public class TokenBucketAlgo {

  private final long maxBucketSize;
  private final long refillRate;

  private double currentBucketSize;
  private long lastRefillTimeStamp;

  public TokenBucketAlgo(final long maxBucketSize, final long refillRate) {
    this.maxBucketSize = maxBucketSize;
    this.refillRate = refillRate;

    currentBucketSize = maxBucketSize;
    lastRefillTimeStamp = System.nanoTime();
  }

  public synchronized boolean allowRequest(int tokens) {
    refill();
    if (currentBucketSize > tokens) {
      currentBucketSize -= tokens;
      return true;
    }
    return false;
  }

  private void refill() {
    long now = System.nanoTime();
    double tokensToAdd = (now - lastRefillTimeStamp) * refillRate / 1e9;
    currentBucketSize = Math.min((currentBucketSize +tokensToAdd), maxBucketSize);
    lastRefillTimeStamp = now;
  }
}
