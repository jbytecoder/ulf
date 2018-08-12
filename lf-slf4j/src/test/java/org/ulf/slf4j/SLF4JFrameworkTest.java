/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulf.slf4j;

import org.junit.Test;
import org.ulf.api.direct.L;

/**
 *
 * @author jbc
 */
public class SLF4JFrameworkTest {
    @Test
    public void test() {
        L.e(getClass(), "test", "Example message {}", 2);
    }
}
