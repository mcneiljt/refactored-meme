package com.mcneilio.refactoredMeme.handlers;

import com.google.gson.Gson;
import com.mcneilio.refactoredMeme.models.Credit;
import io.undertow.server.RoutingHandler;
import io.undertow.util.Headers;

public class CreditHandler extends RoutingHandler {
    public CreditHandler() {
        super();
        Gson gson = new Gson();
        this.get("/", exchange -> {
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
            exchange.getResponseSender().send(gson.toJson(Credit.getCredits()));
            exchange.getResponseSender().close();
        });
        this.post("/", exchange -> {
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
            exchange.getRequestReceiver().receiveFullBytes((e,m) -> {
                gson.fromJson(new String(m), Credit.class).save();
            });
            exchange.getResponseSender().send("Probably accepted it");
            exchange.getResponseSender().close();
        });
    }
}
