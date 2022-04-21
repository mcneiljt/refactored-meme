package com.mcneilio.refactoredMeme.handlers;

import com.mcneilio.refactoredMeme.v1.handlers.CreditsHandler;
import io.undertow.server.handlers.PathHandler;

public class V1Handler extends PathHandler {
    public V1Handler() {
        super();
        this.addPrefixPath("/credits", new CreditsHandler());
    }
}
