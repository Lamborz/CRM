package com.transport.util.category;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by Maksim Zagorodskiy on 7/13/2016.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class CategoryUtilTest {

    private static final Long MONDAY_11_07_2016= 1468195200000L;
    private static final Long TUESDAY_11_07_2016= 1468281600000L;
    private static final Long WEDNESDAY_11_07_2016= 1468368000000L;
    private static final Long THURSDAY_11_07_2016= 1468454400000L;
    private static final Long FRIDAY_11_07_2016= 1468540800000L;
    private static final Long SATURDAY_11_07_2016= 1468627200000L;
    private static final Long SUNDAY_11_07_2016= 1468713600000L;

    private static final Long TUESDAY_26_07_2016= 1469491200000L;
    private static final Long FRIDAY_29_07_2016= 1469750400000L;
    private static final Long SUNDAY_31_07_2016= 1469923200000L;

    private static final int CATEGORY_ONE = 1;
    private static final int CATEGORY_TWO = 2;
    private static final int CATEGORY_THREE = 3;
    private static final int CATEGORY_FOUR = 4;

    @Test
    public void testGetRoyalMovingPriceCategoryBySimpleMonday(){
       int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(MONDAY_11_07_2016));
        Assert.assertEquals("Simple Monday has incorrect category", CATEGORY_ONE, category );
}
    @Test
    public void testGetRoyalMovingPriceCategoryBySimpleTuesday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(TUESDAY_11_07_2016));
        Assert.assertEquals("Simple Tuesday has incorrect category", CATEGORY_ONE, category );
    }
    @Test
    public void testGetRoyalMovingPriceCategoryBySimpleWednesday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(WEDNESDAY_11_07_2016));
        Assert.assertEquals("Simple Wednesday has incorrect category", CATEGORY_ONE, category );
    }
    @Test
    public void testGetRoyalMovingPriceCategoryBySimpleThursday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(THURSDAY_11_07_2016));
        Assert.assertEquals("Simple Thursday has incorrect category", CATEGORY_ONE, category );
    }
    @Test
    public void testGetRoyalMovingPriceCategoryBySimpleFriday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(FRIDAY_11_07_2016));
        Assert.assertEquals("Simple Friday has incorrect category", CATEGORY_TWO, category );
    }
    @Test
    public void testGetRoyalMovingPriceCategoryBySimpleSaturday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(SATURDAY_11_07_2016));
        Assert.assertEquals("Simple Saturday has incorrect category", CATEGORY_TWO, category );
    }
    @Test
    public void testGetRoyalMovingPriceCategoryBySimpleSunday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(SUNDAY_11_07_2016));
        Assert.assertEquals("Simple Sunday has incorrect category", CATEGORY_THREE, category );
    }


    @Test
    public void testGetRoyalMovingPriceCategoryByEndOfMonthTuesday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(TUESDAY_26_07_2016));
        Assert.assertEquals("End Of Month Tuesday has incorrect category", CATEGORY_FOUR, category );
    }
    @Test
    public void testGetRoyalMovingPriceCategoryByEndOfMonthFriday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(FRIDAY_29_07_2016));
        Assert.assertEquals("End Of Month Friday has incorrect category", CATEGORY_FOUR, category );
    }
    @Test
    public void testGetRoyalMovingPriceCategoryByEndOfMonthSunday(){
        int category = CategoryUtil.getRoyalMovingPriceCategoryByDay(new DateTime(SUNDAY_31_07_2016));
        Assert.assertEquals("End Of Month Sunday has incorrect category", CATEGORY_FOUR, category );
    }
}
