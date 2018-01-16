package org.rendra.driver.extension

import io.netty.handler.codec.http.HttpResponseStatus
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj


fun RoutingContext.badRequest(vararg messages: String) {
    this.response().let {
        it.statusCode = HttpResponseStatus.BAD_REQUEST.code()
        val message = json {
            obj(
                    "errors" to messages
            )
        }
        it.end(message.encode())
    }
}
 fun RoutingContext.unprocessableEntity(vararg messages: String) {
    this.response().let {
        it.statusCode = HttpResponseStatus.UNPROCESSABLE_ENTITY.code()
        val message = io.vertx.kotlin.core.json.json {
            obj(
                    "errors" to messages
            )
        }
        it.end(message.encode())
    }
}

 fun RoutingContext.notFound(headers: Map<String, String> = emptyMap()) {
    this.response().let {
        it.statusCode = HttpResponseStatus.NOT_FOUND.code()
        headers.entries.fold(it) { response, entries ->
            response.putHeader(entries.key, entries.value)
        }
        it.end("{}")
    }
}

