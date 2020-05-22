package ru.altarix.dealerapp;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * Supporting interface to accept batch items
 */
public interface CollectionConsumer<E> extends Consumer<E> {

    default void accept(Collection<? extends E> elements) {
        elements.forEach(this);
    }
}
