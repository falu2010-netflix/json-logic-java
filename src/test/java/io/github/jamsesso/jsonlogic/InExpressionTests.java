package io.github.jamsesso.jsonlogic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InExpressionTests {
  private static final JsonLogic jsonLogic = new JsonLogic();

  @Test
  public void testStringIn() throws JsonLogicException {
    assertEquals(true, jsonLogic.apply("{\"in\": [\"race\", \"racecar\"]}", null));
  }

  @Test
  public void testStringNotIn() throws JsonLogicException {
    assertEquals(false, jsonLogic.apply("{\"in\": [\"race\", \"clouds\"]}", null));
  }

  @Test
  public void testArrayIn() throws JsonLogicException {
    assertEquals(true, jsonLogic.apply("{\"in\": [1, [1, 2, 3]]}", null));
    assertEquals(true, jsonLogic.apply("{\"in\": [4.56, [1, 2, 3, 4.56]]}", null));
  }

  @Test
  public void testArrayNotIn() throws JsonLogicException {
    assertEquals(false, jsonLogic.apply("{\"in\": [5, [1, 2, 3]]}", null));
  }
}
