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
package io.gravitee.management.standalone.spring;

import io.gravitee.common.node.Node;
import io.gravitee.management.api.spring.RestConfiguration;
import io.gravitee.management.standalone.jetty.JettyEmbeddedContainer;
import io.gravitee.management.standalone.jetty.JettyServerFactory;
import io.gravitee.management.standalone.node.ManagementNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author David BRASSELY (brasseld at gmail.com)
 */
@Configuration
@Import({RestConfiguration.class})
public class StandaloneConfiguration {

    @Bean
    public Node node() {
        return new ManagementNode();
    }

    @Bean
    public JettyServerFactory server() {
        return new JettyServerFactory();
    }

    @Bean
    public JettyEmbeddedContainer container() {
        return new JettyEmbeddedContainer();
    }
}