/* 
 * Copyright 2013 Ivan Trendafilov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.trendafilov.confucius;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.trendafilov.confucius.Configuration;
import org.trendafilov.confucius.core.ConfigurationException;

public class ConfigurationTest {
	private Configuration config;
	private final static String TEST_KEY = "testkey1231";

	@Before
	public void setUp() {
		config = Configuration.getInstance();
	}

	@Test
	public void sanityCheck() {
		assertFalse(Configuration.getInstance().keySet().isEmpty());
	}

	@Test
	public void testBooleanDefaultReturn() {
		assertFalse(config.getBooleanValue(TEST_KEY, false));
		assertTrue(config.getBooleanValue(TEST_KEY, true));
	}

	@Test
	public void testByteDefaultReturn() {
		assertEquals((byte) 10, config.getByteValue(TEST_KEY, (byte) 10));
	}

	@Test
	public void testCharDefaultReturn() {
		assertEquals('Z', config.getCharValue(TEST_KEY, 'Z'));
	}

	@Test
	public void testDoubleDefaultReturn() {
		assertEquals(20.0, config.getDoubleValue(TEST_KEY, 20.0), 0.1);
	}

	@Test
	public void testFloatDefaultReturn() {
		assertEquals(123.0f, config.getFloatValue(TEST_KEY, 123.0f), 0.1);
	}

	@Test
	public void testIntDefaultReturn() {
		assertEquals(123, config.getIntValue(TEST_KEY, 123));
	}

	@Test
	public void testLongDefaultReturn() {
		assertEquals(823954957346L, config.getLongValue(TEST_KEY, 823954957346L));
	}

	@Test
	public void testShortDefaultReturn() {
		assertEquals((short) 123, config.getShortValue(TEST_KEY, (short) 123));
	}

	@Test
	public void testStringDefaultReturn() {
		assertEquals("some string", config.getStringValue(TEST_KEY, "some string"));
	}

	@Test
	public void testPropertySetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, "value");
		assertEquals("value", System.getProperty(TEST_KEY));
	}

	@Test
	public void testBooleanSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, true);
		assertTrue(config.getBooleanValue(TEST_KEY, false));
		assertTrue(config.getBooleanValue(TEST_KEY));
	}

	@Test
	public void testByteSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, 5);
		assertEquals((byte) 5, config.getByteValue(TEST_KEY, (byte) 10));
		assertEquals((byte) 5, config.getByteValue(TEST_KEY));

	}

	@Test
	public void testCharSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, 'A');
		assertEquals('A', config.getCharValue(TEST_KEY, 'Z'));
		assertEquals('A', config.getCharValue(TEST_KEY));
	}

	@Test
	public void testDoubleSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, 10.0);
		assertEquals(10.0, config.getDoubleValue(TEST_KEY, 20.0), 0.1);
		assertEquals(10.0, config.getDoubleValue(TEST_KEY), 0.1);
	}

	@Test
	public void testFloatSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, 321.0f);
		assertEquals(321.0f, config.getFloatValue(TEST_KEY, 123.0f), 0.1);
		assertEquals(321.0f, config.getFloatValue(TEST_KEY), 0.1);
	}

	@Test
	public void testIntSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, 321);
		assertEquals(321, config.getIntValue(TEST_KEY, 123));
		assertEquals(321, config.getIntValue(TEST_KEY));
	}

	@Test
	public void testLongSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, 923954957346L);
		assertEquals(923954957346L, config.getLongValue(TEST_KEY, 823954957346L));
		assertEquals(923954957346L, config.getLongValue(TEST_KEY));
	}

	@Test
	public void testShortSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, (short) 312);
		assertEquals((short) 312, config.getShortValue(TEST_KEY, (short) 123));
		assertEquals((short) 312, config.getShortValue(TEST_KEY));
	}

	@Test
	public void testStringSetAndGet() throws ConfigurationException {
		config.setProperty(TEST_KEY, "new string");
		assertEquals("new string", config.getStringValue(TEST_KEY, "some string"));
		assertEquals("new string", config.getStringValue(TEST_KEY));
	}

	@Test
	public void testBooleanList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "true, true,true");
		for (boolean value : config.getBooleanList(TEST_KEY))
			assertTrue(value);
		config.setProperty(TEST_KEY, "true, false");
		assertTrue(config.getBooleanList(TEST_KEY).get(0));
		assertFalse(config.getBooleanList(TEST_KEY).get(1));
	}

	@Test
	public void testByteList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "5, 10");
		assertEquals((byte) 5, (byte) config.getByteList(TEST_KEY).get(0));
		assertEquals((byte) 10, (byte) config.getByteList(TEST_KEY).get(1));
	}

	@Test
	public void testCharList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "A,B");
		assertEquals('A', (char) config.getCharList(TEST_KEY).get(0));
		assertEquals('B', (char) config.getCharList(TEST_KEY).get(1));
	}

	@Test
	public void testDoubleList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "10.0,20.0");
		assertEquals(10.0, config.getDoubleList(TEST_KEY).get(0), 0.1);
		assertEquals(20.0, config.getDoubleList(TEST_KEY).get(1), 0.1);
	}

	@Test
	public void testFloatList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "321.00, 333.1");
		assertEquals(321.00f, config.getFloatList(TEST_KEY).get(0), 0.1);
		assertEquals(333.1f, config.getFloatList(TEST_KEY).get(1), 0.1);
	}

	@Test
	public void testIntList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "123,321, 999");
		assertEquals(123, (int) config.getIntList(TEST_KEY).get(0));
		assertEquals(321, (int) config.getIntList(TEST_KEY).get(1));
		assertEquals(999, (int) config.getIntList(TEST_KEY).get(2));
	}

	@Test
	public void testLongList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "923954957346,823954957346");
		assertEquals(923954957346L, (long) config.getLongList(TEST_KEY).get(0));
		assertEquals(823954957346L, (long) config.getLongList(TEST_KEY).get(1));
	}

	@Test
	public void testShortList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "123, 321");
		assertEquals(123, (short) config.getShortList(TEST_KEY).get(0));
		assertEquals(321, (short) config.getShortList(TEST_KEY).get(1));
	}

	@Test
	public void testStringList() throws ConfigurationException {
		config.setProperty(TEST_KEY, "first,second, third");
		assertEquals("first", config.getStringList(TEST_KEY).get(0));
		assertEquals("second", config.getStringList(TEST_KEY).get(1));
		assertEquals("third", config.getStringList(TEST_KEY).get(2));
	}

	@Test
	public void testGetProperties() {
		Properties props = config.getProperties();
		assertTrue(props.keySet().size() > 0);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingBooleanValueKey() throws ConfigurationException {
		config.getBooleanValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingBooleanListKey() throws ConfigurationException {
		config.getBooleanList(TEST_KEY, "!");
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingByteValueKey() throws ConfigurationException {
		config.getByteValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingByteListKey() throws ConfigurationException {
		config.getByteList(TEST_KEY, "!");
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingCharValueKey() throws ConfigurationException {
		config.getCharValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingCharListKey() throws ConfigurationException {
		config.getCharList(TEST_KEY, "!");
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingDoubleValueKey() throws ConfigurationException {
		config.getDoubleValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingDoubleListKey() throws ConfigurationException {
		config.getDoubleList(TEST_KEY, "!");
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingFloatValueKey() throws ConfigurationException {
		config.getFloatValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingFloatListKey() throws ConfigurationException {
		config.getFloatList(TEST_KEY, "!");
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingIntValueKey() throws ConfigurationException {
		config.getIntValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingIntListKey() throws ConfigurationException {
		config.getBooleanList(TEST_KEY, "!");
	}

	@Test(expected = ConfigurationException.class)
	public void testLongShortValueKey() throws ConfigurationException {
		config.getShortValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingShortListKey() throws ConfigurationException {
		config.getShortList(TEST_KEY, "!");
	}

	@Test(expected = ConfigurationException.class)
	public void testLongStringValueKey() throws ConfigurationException {
		config.getStringValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingStringListKey() throws ConfigurationException {
		config.getStringList(TEST_KEY, "!");
	}

	@Test(expected = ConfigurationException.class)
	public void testLongBooleanValueKey() throws ConfigurationException {
		config.getLongValue(TEST_KEY);
	}

	@Test(expected = ConfigurationException.class)
	public void testMissingLongListKey() throws ConfigurationException {
		config.getLongList(TEST_KEY, "!");
	}

	@Test
	public void testSetProperties() throws ConfigurationException {
		Properties props = new Properties();
		props.setProperty(TEST_KEY, "value123");
		props.setProperty("Other", "value");
		config.setProperties(props);
		assertEquals("value123", config.getStringValue(TEST_KEY));
		assertEquals("value", config.getStringValue("Other"));
	}

	@Test
	public void testClearProperty() throws ConfigurationException {
		config.setProperty(TEST_KEY, "!");
		assertEquals("!", config.getStringValue(TEST_KEY));
		config.clearProperty(TEST_KEY);
		assertEquals("!!!", config.getStringValue(TEST_KEY, "!!!"));
	}

	@Test
	public void testClearMissingProperty() {
		config.clearProperty(TEST_KEY);
		assertEquals("!!", config.getStringValue(TEST_KEY, "!!"));
	}

	@After
	public void tearDown() {
		config.reset();
	}
}
