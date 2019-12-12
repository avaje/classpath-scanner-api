package io.avaje.classpath.scanner;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilterResourceTest {

  @Test
  public void byPrefixSuffix_when_match() {

    ResourceFilter match = FilterResource.byPrefixSuffix("oe_", ".txt");

    assertTrue(match.isMatch("oe_.txt"));
    assertTrue(match.isMatch("oe_123.txt"));
    assertTrue(match.isMatch("oe_a.txt"));
    assertTrue(match.isMatch("oe_a.foo.txt"));
  }

  @Test
  public void byPrefixSuffix_when_notMatch() {

    ResourceFilter match = FilterResource.byPrefixSuffix("oe_", ".txt");

    assertFalse(match.isMatch("e_.txt"));
    assertFalse(match.isMatch("o_.txt"));
    assertFalse(match.isMatch("oe.txt"));
    assertFalse(match.isMatch("oe_txt"));
    assertFalse(match.isMatch("oe_.xt"));
    assertFalse(match.isMatch("oe_.tt"));
    assertFalse(match.isMatch("oe_.tx"));
  }

  @Test
  public void bySuffix_when_match() {

    ResourceFilter match = FilterResource.bySuffix(".txt");

    assertTrue(match.isMatch(".txt"));
    assertTrue(match.isMatch("a.txt"));
    assertTrue(match.isMatch("_.txt"));
    assertTrue(match.isMatch("1.txt"));
    assertTrue(match.isMatch("1..foo.txt"));
  }

  @Test
  public void bySuffix_when_notMatch() {

    ResourceFilter match = FilterResource.bySuffix(".txt");

    assertFalse(match.isMatch("txt"));
    assertFalse(match.isMatch(".xt"));
    assertFalse(match.isMatch(".tt"));
    assertFalse(match.isMatch(".tx"));
    assertFalse(match.isMatch(".sql"));
  }

  @Test
  public void byPrefix() {

    ResourceFilter match = FilterResource.byPrefix("a.b");

    assertTrue(match.isMatch("a.b"));
    assertTrue(match.isMatch("a.b."));
    assertTrue(match.isMatch("a.ba"));
    assertTrue(match.isMatch("a.b_"));
    assertTrue(match.isMatch("a.b1"));
    assertTrue(match.isMatch("a.b.txt"));
  }

  @Test
  public void byPrefix_notMatch() {

    ResourceFilter match = FilterResource.byPrefix("a.b");

    assertFalse(match.isMatch(".b"));
    assertFalse(match.isMatch("ab"));
    assertFalse(match.isMatch("a."));
    assertFalse(match.isMatch(""));
    assertFalse(match.isMatch(".a.b"));
    assertFalse(match.isMatch("/a.b"));
    assertFalse(match.isMatch("aa.b"));
    assertFalse(match.isMatch("1a.b"));
  }
}
