package io.avaje.classpath.scanner;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterResourceTest {

  @Test
  public void byPrefixSuffix_when_match() {

    Predicate<String> match = FilterResource.byPrefixSuffix("oe_", ".txt");

    assertTrue(match.test("oe_.txt"));
    assertTrue(match.test("oe_123.txt"));
    assertTrue(match.test("oe_a.txt"));
    assertTrue(match.test("oe_a.foo.txt"));
  }

  @Test
  public void byPrefixSuffix_when_notMatch() {

    Predicate<String> match = FilterResource.byPrefixSuffix("oe_", ".txt");

    assertFalse(match.test("e_.txt"));
    assertFalse(match.test("o_.txt"));
    assertFalse(match.test("oe.txt"));
    assertFalse(match.test("oe_txt"));
    assertFalse(match.test("oe_.xt"));
    assertFalse(match.test("oe_.tt"));
    assertFalse(match.test("oe_.tx"));
  }

  @Test
  public void bySuffix_when_match() {

    Predicate<String> match = FilterResource.bySuffix(".txt");

    assertTrue(match.test(".txt"));
    assertTrue(match.test("a.txt"));
    assertTrue(match.test("_.txt"));
    assertTrue(match.test("1.txt"));
    assertTrue(match.test("1..foo.txt"));
  }

  @Test
  public void bySuffix_when_notMatch() {

    Predicate<String> match = FilterResource.bySuffix(".txt");

    assertFalse(match.test("txt"));
    assertFalse(match.test(".xt"));
    assertFalse(match.test(".tt"));
    assertFalse(match.test(".tx"));
    assertFalse(match.test(".sql"));
  }

  @Test
  public void byPrefix() {

    Predicate<String> match = FilterResource.byPrefix("a.b");

    assertTrue(match.test("a.b"));
    assertTrue(match.test("a.b."));
    assertTrue(match.test("a.ba"));
    assertTrue(match.test("a.b_"));
    assertTrue(match.test("a.b1"));
    assertTrue(match.test("a.b.txt"));
  }

  @Test
  public void byPrefix_notMatch() {

    Predicate<String> match = FilterResource.byPrefix("a.b");

    assertFalse(match.test(".b"));
    assertFalse(match.test("ab"));
    assertFalse(match.test("a."));
    assertFalse(match.test(""));
    assertFalse(match.test(".a.b"));
    assertFalse(match.test("/a.b"));
    assertFalse(match.test("aa.b"));
    assertFalse(match.test("1a.b"));
  }
}
