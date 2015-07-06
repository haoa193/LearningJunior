package com.haoa193.tij.chapter17.exercises;

import sun.misc.BASE64Decoder;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by chenyong on 2015/7/3.
 */
public class GZipUtilsTest {

    private String inputStr = "zlex@zlex.org,snowolf@zlex.org,zlex.snowolf@zlex.org";


    public static void main(String[] args) throws Exception{

//        GZipUtilsTest gt = new GZipUtilsTest();
//        gt.testDataCompress();

        String src = "H4sIAAAAAAAAA6WRubaiQABEc75icgKgu2kgmKBFNgWkAYFHxtYsPkRxAf3658x8\n" +
                "wtykTp2qqKouECvlCjcabBRUw5qpMlBkTWMFBhiBX4VYiKrIEGgwk2AJC1B/FDJR\n" +
                "gaIm1zX3+z/hhLjGqTkRQuJRmkOLtKQj4dfHb0SXTwdEzJDQpCYby9GvbNfs0iIL\n" +
                "xduwhJc6UgyOx84lVwajXc6Dn5mSw5NRhroRooffjzps0hlU7ulooiVSNLHrKnO3\n" +
                "DfpyCw38fJ2O3MKSKr+fVoa0tQN9c++ixXRWyMZzLND39A0r4L9t3x1FdbrgacAV\n" +
                "dl5jRqfYOrLhzlFvRFR9PXpLz0Dvkuvx1gqRed75pWQh+jikepJHdJn9sz3lZ3Lb\n" +
                "Ddm+XlMVrEnkyDYXA8uWNHum6aCMxHmCzrCU2Z4V91nJ+/meBD7iByunQflMPeR1\n" +
                "fDSswhK/ViohLxU4s42S/bafYZA5zIMCKoO2PWCDVnB/aP03/eYNuQnI5IiL3/F7\n" +
                "Y+qy61dyR20f+qMMuNfls/tfdDVuBttGnYUp2UzUjf4k/YN4smsbuXDT//XCPG0/\n" +
                "9/0ARoRNpEICAAA=\n";

        byte [] srcAfterDecode = new BASE64Decoder().decodeBuffer(src);

        byte[] srcAfterDecompressed = GZipUtils.decompress(srcAfterDecode);
        System.out.println(new String(srcAfterDecompressed));


        String src2 = "/Td6WFoAAATm1rRGAgAhARYAAAB0L+Wj4AFRAQVdABGICqfJeJWaXR0sjwRpdS7E\n" +
                "+6IpZ7jEgwnjNXF1I+Am53CER4uNimC3eWr2cLkUF4wS790hhcFJDPibD3E6vykU\n" +
                "wfVcZtkxf49xh2iethSwFIx3fmnT/Qzol3c2NzHNLm08op6oj6c6IymXQoTGUfjt\n" +
                "QMm4Q8yuiGCX2iLAqUsg/SFnJNb1G4QuOWCVZSQwrNnHoZnAsJjXKdxW82xVSI5H\n" +
                "T2GH19HrQWj7mAIv2hEG7rHr7Lvc5KrtVPN4+jGZQPbvWM4Mh+Sjx/wTyxQ14MW/\n" +
                "FgSVKDir3PXIfM3/4bPggO6EQc3KOgNzQl+E5ePAoI0wNh+KEohXqYVt4giRNm52\n" +
                "ypAgAAAAAAC8TejHH4hG6QABoQLSAgAAiuAM5LHEZ/sCAAAAAARZWg==";

//        System.out.println(new String(GZipUtils.decompress(new BASE64Decoder().decodeBuffer(src2))));
//
        System.out.println(ZipUtils.unXZ(src2));


//        GZipUtils.decompress("d:/qqNum.txt.gz", false);
    }



    public final void testDataCompress() throws Exception {

        System.err.println("原文:\t" + inputStr);

        byte[] input = inputStr.getBytes();
        System.err.println("长度:\t" + input.length);

        byte[] data = GZipUtils.compress(input);
        System.err.println("压缩后:\t");
        System.err.println("长度:\t" + data.length);

        byte[] output = GZipUtils.decompress(data);
        String outputStr = new String(output);
        System.err.println("解压缩后:\t" + outputStr);
        System.err.println("长度:\t" + output.length);

//        assertEquals(inputStr, outputStr);

    }

//    @Test
    public final void testFileCompress() throws Exception {

        FileOutputStream fos = new FileOutputStream("d:/f.txt");

        fos.write(inputStr.getBytes());
        fos.flush();
        fos.close();

        GZipUtils.compress("d:/f.txt", false);

        GZipUtils.decompress("d:/f.txt.gz", false);

        File file = new File("d:/f.txt");

        FileInputStream fis = new FileInputStream(file);

        DataInputStream dis = new DataInputStream(fis);

        byte[] data = new byte[(int) file.length()];
        dis.readFully(data);

        fis.close();

        String outputStr = new String(data);
//        assertEquals(inputStr, outputStr);
    }
}