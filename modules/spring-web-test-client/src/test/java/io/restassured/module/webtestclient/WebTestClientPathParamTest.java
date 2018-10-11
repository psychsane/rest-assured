/*
 * Copyright 2016-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.restassured.module.webtestclient;

import io.restassured.module.webtestclient.setup.GreetingController;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class WebTestClientPathParamTest {

	@Test
	public void unnamed_path_param_works() {
		RestAssuredWebTestClient.given()
				.standaloneSetup(new GreetingController())
				.queryParam("name", "John")
				.when()
				.get("/{x}", "greeting")
				.then()
				.body("id", equalTo(1))
				.body("content", equalTo("Hello, John!"));
	}
}
