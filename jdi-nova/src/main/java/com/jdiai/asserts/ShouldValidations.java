package com.jdiai.asserts;

import com.jdiai.interfaces.HasCore;

import static com.jdiai.asserts.ShouldUtils.handleShouldBe;

public interface ShouldValidations<T extends HasCore> {
    default T shouldBe(Condition... conditions) {
        return handleShouldBe((T) this, conditions);
    }

    default T should(Condition... conditions) {
        return shouldBe(conditions);
    }

    default T waitFor(Condition... conditions) {
        return shouldBe(conditions);
    }

    default T shouldHave(Condition... conditions) {
        return shouldBe(conditions);
    }
}
