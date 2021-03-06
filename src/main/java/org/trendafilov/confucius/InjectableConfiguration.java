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

import org.trendafilov.confucius.core.AbstractConfiguration;

/**
 * It is intended that this class will be used by Dependency Injection
 * frameworks to allow clients to control the scope of a <tt>Configurable</tt>
 * singleton.
 * 
 * <p>
 * This is required, as the scope of a singleton instance in a DI container may
 * differ from the scope of a self-managed singleton instance.
 * </p>
 * 
 * @author Ivan Trendafilov
 * @since  1.0
 * @see    Configurable
 * @see    Configuration
 */
public class InjectableConfiguration extends AbstractConfiguration {

	public InjectableConfiguration() {
		super.init();
	}

	public InjectableConfiguration(String filePath, String context) {
		setProperty(FILE_PARAM, filePath);
		setProperty(CONTEXT_PARAM, context);
		super.init();
	}
}
