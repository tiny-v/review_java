package com.my.basic.io.bio;

import java.io.*;

/**
 * 测试: 复制文件，使用和不使用缓冲区对效率的影响
 * @author YMa69
 * @date 2019/12/9
 */
public class CopyFile {

    private static final String basicPath = new File("").getAbsolutePath();

    private static final String fromPath = basicPath+"/basic/io/童话镇Plus.mp3";

    private static final String toPath = basicPath+"/basic/io/童话镇Plus-暗杠.mp3";

    /** 输入和输出都使用缓冲 */
    static void case01() throws IOException{
        FileInputStream in = new FileInputStream(fromPath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream(toPath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
        byte[] b = new byte[1024];
        int i;
        long startTime = System.currentTimeMillis();
        while((i=bufferedInputStream.read(b))!=-1){
            bufferedOutputStream.write(b, 0, i);
        }
        bufferedOutputStream.flush();
        long endTime = System.currentTimeMillis();
        bufferedInputStream.close();
        in.close();
        bufferedOutputStream.close();
        out.close();
        // 115ms, 125ms, 137ms, 119ms, 119ms
        System.out.println("total cost:"+ (endTime-startTime));
    }

    /** 输入和输出都不使用缓冲 */
    static void case02() throws IOException{
        FileInputStream in = new FileInputStream(fromPath);
        FileOutputStream out = new FileOutputStream(toPath);
        byte[] b = new byte[1024];
        int i;
        long startTime = System.currentTimeMillis();
        while((i=in.read(b))!=-1){
            out.write(b, 0, i);
        }
        out.flush();
        long endTime = System.currentTimeMillis();
        in.close();
        out.close();
        // 458ms, 447ms, 621ms, 422ms, 471ms
        System.out.println("total cost:"+ (endTime-startTime));
    }

    /** 输入使用缓冲, 输出不使用 */
    static void case03() throws IOException{
        FileInputStream in = new FileInputStream(fromPath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        FileOutputStream out = new FileOutputStream(toPath);
        byte[] b = new byte[1024];
        int i;
        long startTime = System.currentTimeMillis();
        while((i=bufferedInputStream.read(b))!=-1){
            out.write(b, 0, i);
        }
        out.flush();
        long endTime = System.currentTimeMillis();
        bufferedInputStream.close();
        in.close();
        out.close();
        // 286ms, 271ms, 347ms, 321ms, 269ms
        System.out.println("total cost:"+ (endTime-startTime));
    }

    /** 输出使用缓冲, 输入不使用 */
    static void case04() throws IOException{
        FileInputStream in = new FileInputStream(fromPath);
        FileOutputStream out = new FileOutputStream(toPath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
        byte[] b = new byte[1024];
        int i;
        long startTime = System.currentTimeMillis();
        while((i=in.read(b))!=-1){
            bufferedOutputStream.write(b, 0, i);
        }
        bufferedOutputStream.flush();
        long endTime = System.currentTimeMillis();
        in.close();
        bufferedOutputStream.close();
        out.close();
        // 313ms, 276ms, 383ms, 453ms, 301ms
        System.out.println("total cost:"+ (endTime-startTime));
    }

    public static void main(String[] args) throws IOException{
        CopyFile.case04();
    }



}
