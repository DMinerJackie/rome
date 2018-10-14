package com.jackie.wowjava.best.practice.java.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Jackie implements Student {
    private static final Logger LOG = LoggerFactory.getLogger(Jackie.class);

    @Override
    public void resolveQuesion(Callback callback) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            LOG.info("some error occur when thinking", e);
        }

        callback.tellAnswer(666);
    }
}
