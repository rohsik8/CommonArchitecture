package com.view9.couriercustomer.ext.bus;


import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import io.reactivex.Observable;


public class RxBus {


        private static RxBus instance = null;

    private final Relay<Object> eventBus = PublishRelay.create().toSerialized();

        private RxBus() {

        }

        public static RxBus getInstance() {
            if (instance == null)
                instance = new RxBus();

            return instance;
        }


        public void send(Object object) {
            eventBus.accept(object);
        }

        public Observable<Object> toObservable() {
            return eventBus;
        }




}
