/**
 * 
 */
package com.baidu.unbiz.common.convert.array;

import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrb;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrd;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrf;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arri;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrl;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrs;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.unbiz.common.convert.ConverterManager;

/**
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年9月22日 下午2:05:28
 */
public class ByteArrayConverterTest {

    ByteArrayConverter byteArrayConverter = (ByteArrayConverter) ConverterManager.lookup(byte[].class);

    @Test
    public void testArrayConvert() {
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(arrb(1, 7, 3)));
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(arrs(1, 7, 3)));
        Assert.assertArrayEquals(arrb(1, 0, 1), byteArrayConverter.toConvert(arrl(true, false, true)));
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(arri(1, 7, 3)));
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(arrl(1, 7, 3)));
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(arrf(1.99f, 7.99f, 3.22f)));
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(arrd(1.99, 7.99, 3.22)));
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(arrs("1", "7", "3")));
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(arrs(" 1 ", " 7 ", " 3 ")));
        Assert.assertArrayEquals(arrb(1, 7, 3), byteArrayConverter.toConvert(" 1 ;  7 ;  3 "));
    }

    @Test
    public void testNonArrayConversion() {
        Assert.assertArrayEquals(arrb(7), byteArrayConverter.toConvert(Byte.valueOf((byte) 7)));
        Assert.assertArrayEquals(arrb(7), byteArrayConverter.toConvert(Integer.valueOf(7)));
        Assert.assertArrayEquals(arrb(7), byteArrayConverter.toConvert("7"));
    }

}
