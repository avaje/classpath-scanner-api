package io.avaje.classpath.scanner;

/**
 * Factory for the ClassPathScanner service.
 */
public interface ClassPathScannerFactory {

  /**
   * Create a ClassPathScanner given the classLoader.
   */
  ClassPathScanner createScanner(ClassLoader classLoader);
}
