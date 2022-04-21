package com.mcneilio.refactoredMeme.v1.handlers;

import com.google.gson.Gson;
import com.mcneilio.refactoredMeme.v1.models.Credit;
import io.undertow.server.RoutingHandler;
import io.undertow.util.Headers;

public class CreditsHandler extends RoutingHandler {
    public CreditsHandler() {
        super();
        Gson gson = new Gson();
        this.get("/", exchange -> {
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
            exchange.getResponseSender().send(gson.toJson(Credit.getCredits())+"\n");
            exchange.getResponseSender().close();
        });
        this.post("/", exchange -> {
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
            exchange.getRequestReceiver().receiveFullBytes((e,m) -> {
                gson.fromJson(new String(m), Credit.class).save();
            });
            exchange.getResponseSender().send("Probably accepted it\n");
            exchange.getResponseSender().close();
        });
    }
}
