package org.quarkus.sample.controller;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeBookControllerIT extends BookControllerTest {

    // Execute the same tests but in native mode.
}