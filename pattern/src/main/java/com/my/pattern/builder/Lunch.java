package com.my.pattern.builder;

/**
 * 建造者模式: AbstractBuilder Pattern
 * 主要解决：构建一个复杂对象时， 这个对象一些属性是固定不变的， 其它更多的属性是可选择的。
 * 解决方法：把固定属性和可选择属性分开构建， 可选属性类似零件一样，可以自由装配
 * 案例: 点餐时， 米饭和汤是固定选择， 鱼， 鸡腿， 蔬菜, 水果,  是否打包 是可选择的
 *
 * 注：
 *    使用JavaBean 的 getter/setter 也可以替代重载多个构造函数，
 *
 *    Meal meal = new Meal();
 *    meal.setRice("XxxRice");
 *    meal.setSoup("XxxSoup");
 *
 *    缺点：实例化的过程被分为了多个步骤， 破化了一致性， 在多线程的情况下， 需要开发人员花费额外的精力去维护其多线程下的安全
 *
 * @author YMa69
 * @date 2019/12/24.
 */
public class Lunch {

    /** 将成员变量声明为final, 及初始化后不可变，这样可保证线程安全; 很多业务场景中，成员变量是需要经常变化的，这样场景下不必声明为final;*/
    /** 米饭 */
    private final int rice;
    /** 汤 */
    private final int soup;
    /** 鸡腿 */
    private int drumstick;
    /** 鱼 */
    private int fish;
    /** 番茄 */
    private int tomato;
    /** 豆腐 */
    private int tofu;
    /** 是否打包 */
    private boolean takeout;

    public Lunch(LunchBuilder lunchBuilder){
        this.rice = lunchBuilder.rice;
        this.soup = lunchBuilder.soup;
        this.fish = lunchBuilder.fish;
        this.drumstick = lunchBuilder.drumstick;
        this.tomato = lunchBuilder.tomato;
        this.tofu = lunchBuilder.tofu;
        this.takeout = lunchBuilder.takeout;
    }

    public static class LunchBuilder {
        /**
         * 固定属性
         */
        public final int rice;
        /**
         * 固定属性
         */
        public int soup;
        /** 鸡腿 */
        public int drumstick;
        /** 鱼 */
        public int fish;
        /** 番茄 */
        public int tomato;
        /** 豆腐 */
        public int tofu;
        /** 是否打包 */
        public boolean takeout;

        public LunchBuilder(int rice, int soup) {
            this.rice = rice;
            this.soup = soup;
        }

        public LunchBuilder soup(int soup) {
            this.soup = soup;
            return this;
        }

        public LunchBuilder fish(int fish) {
            this.fish = fish;
            return this;
        }

        public LunchBuilder drumstick(int drumstick) {
            this.drumstick = drumstick;
            return this;
        }

        public LunchBuilder tomato(int tomato){
            this.tomato = tomato;
            return this;
        }

        public LunchBuilder tofu(int tofu){
            this.tofu = tofu;
            return this;
        }

        public LunchBuilder takeout(boolean takeout) {
            this.takeout = takeout;
            return this;
        }

        /**
         * 在调用build方法之前，都不会实例化对象
         */
        public Lunch build() {
            return new Lunch(this);
        }
    }

    @Override
    public String toString() {
        return "Meal{" +
                "rice='" + rice + '\'' +
                ", soup='" + soup + '\'' +
                ", fish='" + fish + '\'' +
                ", drumstick='" + drumstick + '\'' +
                ", tomato='" + tomato + '\'' +
                ", tofu='" + tofu + '\'' +
                ", takeout=" + takeout +
                '}';
    }

    public static void main(String[] args){
        // 按需构建复杂的对象
        Lunch lunch1 = new Lunch.LunchBuilder(1, 1)
                .soup(2)
                .drumstick(2)
                .tofu(2)
                .takeout(Boolean.FALSE)
                .build();

        Lunch lunch2 = new Lunch.LunchBuilder(1, 1)
                .fish(1)
                .tomato(1)
                .takeout(Boolean.FALSE)
                .build();

        System.out.println(lunch1);

        System.out.println(lunch2);
    }

}
