package hello;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.Handler;
import io.vertx.core.Future;

public class MyVerticle extends AbstractVerticle {

    private HttpServer httpServer = null;
    
    @Override
    public void start(Future<Void> startFuture) {
        httpServer = vertx.createHttpServer();

        httpServer.requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest request) {
                System.out.println("Request");
                HttpServerResponse response = request.response();
                response.end("Hello World!");
            }
        });
        
        httpServer.listen(8080);
    }

    @Override
    public void stop(Future stopFuture) throws Exception {
        System.out.println("MyVerticle stopped");
        httpServer.close();
    }

}
