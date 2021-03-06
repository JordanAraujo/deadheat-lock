/**
 * @author Vrushabh Joshi
 *
 */
package com.vrush.deadheat.lock.retry;

import com.vrush.deadheat.lock.Lock;
import com.vrush.deadheat.lock.Locked;
import lombok.Data;

@Data
public class DefaultRetriableLockFactory implements RetriableLockFactory {
  private final RetryTemplateConverter retryTemplateConverter;

  @Override
  public RetriableLock generate(final Lock lock, final Locked locked) {
    return new RetriableLock(lock, retryTemplateConverter.construct(locked));
  }
}
