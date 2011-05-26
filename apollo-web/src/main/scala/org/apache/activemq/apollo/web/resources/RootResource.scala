package org.apache.activemq.apollo.web.resources

import javax.ws.rs._
import core.Response.Status._
import com.sun.jersey.api.view.ImplicitProduces

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a>
 */
@Path("/")
case class RootResource() extends Resource() {

  @GET
  @Path("/")
  @Produces(Array("application/json", "application/xml","text/xml","text/html"))
  def post_connection_shutdown_and_redirect():Unit = {
    result(strip_resolve("broker"))
  }

  @Path("{name}")
  def path(@PathParam("name") name:String):AnyRef = {
    name match {
      case "broker" => new BrokerResource(this)
      case _ =>
        result(NOT_FOUND)
    }

  }

}
