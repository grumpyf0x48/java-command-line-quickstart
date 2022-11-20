package org.grumpyf0x48.myapplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplicationTest {

    @Test
    void appHasAGreeting() {
        Application application = new Application();
        assertNotNull(application.getGreeting(), "application should have a greeting");
    }
}
