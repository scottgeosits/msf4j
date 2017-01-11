/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.msf4j.restinterceptor.common.filter;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.Response;
import org.wso2.msf4j.filter.MSF4JResponseFilter;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;

/**
 * HTTP response logging class.
 * Please note that the @Component annotation is only required in OSGI mode
 */
@Component(
        name = "org.wso2.msf4j.restinterceptor.common.filter.HTTPResponseLogger",
        service = MSF4JResponseFilter.class,
        immediate = true
)
@Priority(Priorities.AUTHENTICATION)
public class HTTPResponseLogger implements MSF4JResponseFilter {

    private static final Logger log = LoggerFactory.getLogger(HTTPResponseLogger.class);

    @Override
    public void filter(Request request, Response response) throws IOException {
        log.info(String.format("Logging HTTP response { Status code: %s }",
                response.getStatusCode()));
    }
}
