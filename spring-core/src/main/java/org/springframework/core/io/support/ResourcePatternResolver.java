/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io.support;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * ResourceLoader 的 Resource getResource(String location) 方法，每次只能根据 location 返回一个 Resource 。
 * 当需要加载多个资源时，我们除了多次调用 #getResource(String location) 方法外，别无他法。
 *
 * org.springframework.core.io.support.ResourcePatternResolver 是 ResourceLoader 的扩展，
 * 它支持根据指定的资源路径匹配模式每次返回多个 Resource 实例
 *
 */
public interface ResourcePatternResolver extends ResourceLoader {

	/**
	 * 新增了一种新的协议前缀 "classpath*:"，该协议前缀由其子类负责实现。
	 */
	String CLASSPATH_ALL_URL_PREFIX = "classpath*:";

	/**
	 * Resolve the given location pattern into Resource objects.
	 * <p>Overlapping resource entries that point to the same physical
	 * resource should be avoided, as far as possible. The result should
	 * have set semantics.
	 * @param locationPattern the location pattern to resolve
	 * @return the corresponding Resource objects
	 * @throws IOException in case of I/O errors
	 */
	Resource[] getResources(String locationPattern) throws IOException;

}
