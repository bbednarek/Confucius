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

import org.junit.Test;
import org.trendafilov.confucius.InjectableConfiguration;
import org.trendafilov.confucius.core.ConfigurationException;

public class InjectableConfigurationTest {
	private final static String TEST_CONTEXT = "Test2";

	@Test
	public void sanityCheck() {
		InjectableConfiguration config = new InjectableConfiguration();
		assertFalse(config.keySet().isEmpty());
	}

	@Test
	public void testTwoArgsConstructor() throws ConfigurationException {
		InjectableConfiguration config = new InjectableConfiguration("some-file.cfg", TEST_CONTEXT);
		assertFalse(config.keySet().isEmpty());
		assertEquals(TEST_CONTEXT, config.getStringValue("conf.context"));
	}
}
