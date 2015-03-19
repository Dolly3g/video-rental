package com.twu.refactor;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by dollyg on 3/18/2015.
 */
public class MoviePricingCategoryTest extends TestCase {
    @Test
    public void testKIDSCategoryGivesCorrectCostFor4days(){
        double actual = MoviePricingCategory.KIDS.getCostFor(4);
        assertEquals(3.0,actual);
    }

    @Test
    public void testKIDSCategoryGivesCorrectForLessThan3Days(){
        double actualFor1Day = MoviePricingCategory.KIDS.getCostFor(1);
        double actualFor2Days = MoviePricingCategory.KIDS.getCostFor(2);
        assertEquals(1.5,actualFor1Day,0.0);
        assertEquals(actualFor1Day,actualFor2Days);
    }
}
