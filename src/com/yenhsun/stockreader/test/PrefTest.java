/**
 * 
 */

package com.yenhsun.stockreader.test;

import java.util.ArrayList;

import com.yenhsun.stockreader.MainActivity;
import com.yenhsun.stockreader.storage.StockDataPreference;
import com.yenhsun.stockreader.util.StockId;

import android.test.ActivityInstrumentationTestCase2;

/**
 * @author Yen-Hsun_Huang
 */
public class PrefTest extends ActivityInstrumentationTestCase2 {

    private StockDataPreference msdp;

    public PrefTest() {
        super("com.yenhsun.stockreader", MainActivity.class);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        msdp = new StockDataPreference(this.getActivity());
    }

    /*
     * (non-Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test method for
     * {@link com.yenhsun.stockreader.storage.StockDataPreference#retriveData()}
     * .
     */
    public void testRetriveData() {
        ArrayList<StockId> data = new ArrayList<StockId>();
        StockId s1 = new StockId("a", "1");
        StockId s2 = new StockId("b", "2");
        StockId s3 = new StockId("c", "3");
        StockId s4 = new StockId("d", "4");
        data.add(s1);
        data.add(s2);
        data.add(s3);
        data.add(s4);
        msdp.saveData(data);
        ArrayList<StockId> retrive = msdp.retriveData();
        StockId r1 = retrive.get(0);
        StockId r2 = retrive.get(1);
        StockId r3 = retrive.get(2);
        StockId r4 = retrive.get(3);
        if ("a:1".equals(r1.toString()) == false) {
            fail("1");
        }
        if ("b:2".equals(r2.toString()) == false) {
            fail("2");
        }
        if ("c:3".equals(r3.toString()) == false) {
            fail("3");
        }
        if ("d:4".equals(r4.toString()) == false) {
            fail("4");
        }
    }

}
