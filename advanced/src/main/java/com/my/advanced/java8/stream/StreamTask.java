package com.my.advanced.java8.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mayue
 * @date 2020/11/14.
 */
public class StreamTask {

    public List<StreamBean> initList1(){
        StreamBean bean1 = new StreamBean("bean1", 10);
        StreamBean bean2 = new StreamBean("bean2", 20);
        return Arrays.asList(bean1, bean2);
    }

    public List<StreamBean> initList2(){
        StreamBean bean3 = new StreamBean("bean3", 10);
        StreamBean bean4 = new StreamBean("bean4", 20);
        List list = new ArrayList();
        list.add(bean3);
        list.add(bean4);
        return list;
    }

    /**
     * Optional不存在元素，调用get时会抛出 NoSuchElementException
     */
    public void test1(){
        initList1().stream().filter(bean->bean.getAge()<10).findFirst().get();
    }

    /**
     * 如果没有满足过滤的元素， findFirst||findAny 会抛出 NullPointerException
     */
    public void test2(){
        Optional<StreamBean> optional = initList1().stream().filter(bean->bean.getAge()<15).findFirst();
        optional.ifPresent(bean->{
            System.out.println(bean.getName());
        });
        System.out.println(optional); // Optional.empty
    }

    public void test3(){
        List<StreamBean> beans = initList1().stream().filter(bean->bean.getAge()<15).collect(Collectors.toList());
        if(beans!=null && beans.size()>0){
            StreamBean bean = beans.get(0);
            System.out.println(bean.getName());
            bean.setName("GOGO");
            System.out.println(bean.getName());
        }
    }

    public void test4(){
        List<StreamBean> beans = initList1().stream().filter(bean->bean.getAge()<25).collect(Collectors.toList());
        System.out.println(beans.size());
        beans = beans.stream().filter(bean->bean.getAge()>10).collect(Collectors.toList());
        System.out.println(beans.size());
    }

    public void test5(){
        Set<String> set = new HashSet<>();
        set.add("value1");
        set.add("value2");
        set.add("value3");
        List list = Stream.of(set.toArray(new String[0])).collect(Collectors.toList());
        System.out.println(list.toString());
    }

    private void printHello(String msg){
        System.out.println("Say Hello to:"+msg);
    }

    private String getAbc(){
        return "4545";
    }

    public static void main(String[] args) {
        new StreamTask().test5();
    }


    class StreamBean{

        private String name;

        private int age;

        public StreamBean(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }



}
