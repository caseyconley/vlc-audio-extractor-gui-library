/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author CASEY
 */
public class ConverterTest {
    
    public ConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setAudioFormat method, of class Converter.
     */
    @Test
    public void testSetAudioFormat() {
        System.out.println("setAudioFormat");
        String f = "wav";
        Converter instance = new Converter();
        instance.setAudioFormat(f);
        String expResult = "wav";
        String result = instance.getAudioFormat();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAudioLocation method, of class Converter.
     */
    @Test
    public void testSetAudioLocation() {
        System.out.println("setAudioLocation");
        Converter instance = new Converter();
        String f = "C:\\";
        instance.setAudioLocation(f);
        String expResult = "C:\\";
        String result = instance.getAudioLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of startConvert method, of class Converter.
     */
    @Test
    public void testStartConvert() {
        System.out.println("startConvert");
        File f = new File("test.wav");
        
        if (f.exists()){
            System.out.println("exists");
            System.out.println("path: " + f.getAbsolutePath());
            if (f.delete()){
                System.out.println("deleted");
            }
            else {
            System.out.println("not deleted");
            }
        }
        Converter instance = new Converter();
        instance.setAudioFormat("wav");
        instance.setAudioLocation("");
        instance.setVideoLocation("metalocalypse.avi");
        instance.startConvert("test");
        
        //wait 10 seconds for file to be created
        long t0, t1;
        t0 =  System.currentTimeMillis();
        do {
            t1 = System.currentTimeMillis();
        } while ((t1 - t0) < (10 * 1000));
        
        System.out.println("completed convert");
        //check if the test file exists
        File aud = new File("test.wav");
        if(!aud.isFile()){
            fail("Created audio file not found");
        } else{
            System.out.println("it lives (test.wav exists)");
        }
    }
}
