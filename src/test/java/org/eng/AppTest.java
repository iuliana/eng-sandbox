package org.eng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

    @Test
   void testApp() {
        LOG.info( "Halò a-rithist, a charaid !" );
        assertTrue( true );
    }
}
