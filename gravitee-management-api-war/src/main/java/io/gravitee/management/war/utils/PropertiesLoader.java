/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.management.war.utils;

import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class PropertiesLoader {

	public final static String GRAVITEE_CONFIGURATION = "gravitee.conf";

	public Properties load() {
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();

		String yamlConfiguration = System.getProperty(GRAVITEE_CONFIGURATION);
		Resource yamlResource = new FileSystemResource(yamlConfiguration);

		yaml.setResources(yamlResource);
		Properties properties = yaml.getObject();

		return properties;
	}
}
