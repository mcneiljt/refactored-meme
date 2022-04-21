package com.mcneilio.refactoredMeme;

import com.mcneilio.refactoredMeme.handlers.V1Handler;
import io.undertow.Handlers;
import io.undertow.Undertow;

public class Application {
    static public void main(String[] args) {
        System.out.println("Refactoring those memes.");

        Undertow server = Undertow.builder()
                .addHttpListener(9090, "localhost")
                .setHandler(Handlers.path()
                        .addPrefixPath("/v1", new V1Handler())
                )
                .build();
        server.start();
    }
}
