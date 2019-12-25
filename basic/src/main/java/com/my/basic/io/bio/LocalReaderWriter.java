package com.my.basic.io.bio;

import java.io.*;

/**
 *
 * @author YMa69
 * @date 2019/12/8
 */
public class LocalReaderWriter {

    static String testFile = "/MyJavaBasic/src/main/resources/io/test.txt";

    /** 读取控制台输入 - case01 */
    static void case01() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符:");
        char c;
        c = (char)bufferedReader.read();
        System.out.println("你输入的字符为:"+c);
        bufferedReader.close();
    }

    /** 读取控制台输入 - case02 */
    static void case02() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符，按 q 键结束");
        char c;
        do {
            c = (char) bufferedReader.read();
            System.out.println("你输入的字符为:"+c);
        } while (c != 'q');
        bufferedReader.close();
    }

    /** 读取控制台输入 - case03 */
    static void case03() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一行字符");
        String str = bufferedReader.readLine();
        System.out.println("你输入的字符为" + str);
        bufferedReader.close();
    }

    /** 文本文件的写入 */
    static void case04() throws IOException{
        // append 默认为false, 会覆盖之前的文件内容
        FileWriter fileWriter = new FileWriter(new File("").getAbsoluteFile()+testFile);
        /** append 为true, 会在文件末尾追加数据 */
        /// FileWriter fileWriter = new FileWriter(new File("").getAbsoluteFile()+testFile, true);
        fileWriter.write("hello world,  this is FileWriter \n");
        /** 不允许写入null */
        /// fileWriter.write(null);
        fileWriter.append("==== 这个方法内部也是调用 write() 方法 ====\n");
        // 这个append(null), 会在结尾加入 “null” 字符串
        fileWriter.append(null);
        fileWriter.flush();
        fileWriter.close();
    }

    /** 文本文件的读取 case1 */
    static void case05() throws IOException{
        FileReader fileReader = new FileReader(new File("").getAbsoluteFile()+testFile);
        int c;
        while((c=fileReader.read())!=-1){
            System.out.print((char)c);
        }
        fileReader.close();
    }

    /** 文本文件的读取 case2 */
    static void case06() throws IOException{
        FileReader fileReader = new FileReader(new File("").getAbsoluteFile()+testFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while((str=bufferedReader.readLine())!=null){
            System.out.println(str);
        }
        bufferedReader.close();
        fileReader.close();
    }

    /** 将文件输出流FileOutputStream转化为字符流OutputStreamWriter 来写入文件*/
    static void case07() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsoluteFile()+testFile);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        outputStreamWriter.write("== this is OutputStreamWriter case ==\n");
        outputStreamWriter.append(" 这是另外一行内容");
        outputStreamWriter.flush();
        System.out.println("文件的编码为" + outputStreamWriter.getEncoding());
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    /** 将文件输入流FileInputStream 转化为字符流 InputStreamReader, 再进一步转化为BufferedReader 来读取文件*/
    static void case08() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+testFile);
        //使用utf-8来解码
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
    }

    public static void main(String[] args) throws IOException{
        LocalReaderWriter.case08();
    }

}
