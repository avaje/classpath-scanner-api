package io.avaje.classpath.scanner;

/**
 * Filter predicate to determine which scanned resources should be returned.
 */
@FunctionalInterface
public interface ResourceFilter {

  /**
   * Return true if this resource should be included in the scan result.
   */
  boolean isMatch(String resourceName);
}
