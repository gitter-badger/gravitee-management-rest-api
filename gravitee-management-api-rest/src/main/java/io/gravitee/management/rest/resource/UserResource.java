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
package io.gravitee.management.rest.resource;

import io.gravitee.common.http.MediaType;
import io.gravitee.management.providers.core.authentication.GraviteeUserDetails;
import io.gravitee.management.security.JWTCookieGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * @author Azize Elamrani (azize at gravitee.io)
 * @author GraviteeSource Team
 */
@Path("/user")
public class UserResource extends AbstractResource {

    @Autowired
    private JWTCookieGenerator jwtCookieGenerator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response user() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof GraviteeUserDetails) {
            return Response.ok(principal, MediaType.APPLICATION_JSON).build();
        }
        return Response.ok().build();
    }

    @POST
    @Path("/login")
    public Response login() {
        return Response.ok().build();
    }

    @POST
    @Path("/logout")
    public Response logout(@Context HttpServletResponse response) {
        response.addCookie(jwtCookieGenerator.generate(null));
        return Response.ok().build();
    }
}
