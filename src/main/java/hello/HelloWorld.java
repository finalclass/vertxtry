package hello;

import io.vertx.core.Vertx;
import hello.MyVerticle;

public class HelloWorld {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyVerticle());
    }

}
