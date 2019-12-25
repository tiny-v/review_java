package com.my.pattern.builder;

/**
 * 建造者模式: LocalBuilder Pattern
 * 主要解决：构建一个复杂对象时， 这个对象一些属性是固定不变的， 其它更多的属性是可选择的。
 * 解决方法：把固定属性和可选择属性分开构建， 可选属性类似零件一样，可以自由装配
 * 案例: 点餐时， 米饭和汤是固定选择， 鱼， 鸡腿， 蔬菜, 水果,  是否打包 是可选择的
 *
 * @author YMa69
 * @date 2019/12/24.
 */
public class Meal {

    /** 将成员变量声明为final, 及初始化后不可变。 这样可保证线程安全 (也有很多成员变量是需要经常变化的， 这样就不可以声明为) */
    private final String rice;

    private final String soup;

    private final String fish;

    private final String drumstick;

    private final String vegetable;

    private final String fruit;

    private final Boolean pack;

    public static class MealBuilder extends LocalBuilder {
        /**
         * 固定属性
         */
        public final String rice;
        /**
         * 固定属性
         */
        public final String soup;

        public String fish;

        public String drumstick;

        public String vegetable;

        public String fruit;
        /**
         * 给定默认值， 不打包
         */
        public Boolean pack = Boolean.FALSE;

        public MealBuilder(String rice, String soup) {
            this.rice = rice;
            this.soup = soup;
        }

        public MealBuilder fish(String fish) {
            this.fish = fish;
            return this;
        }

        public MealBuilder drumstick(String drumstick) {
            this.drumstick = drumstick;
            return this;
        }

        public MealBuilder vegetable(String vegetable) {
            this.vegetable = vegetable;
            return this;
        }

        public MealBuilder fruit(String fruit) {
            this.fruit = fruit;
            return this;
        }

        public MealBuilder pack(Boolean pack) {
            this.pack = pack;
            return this;
        }

        /**
         * 在调用build方法之前， 都不会实例化对象
         * @return
         */
        @Override
        public Meal build() {
            return new Meal(this);
        }
    }

    public Meal(MealBuilder mealBuilder){
        this.rice = mealBuilder.rice;
        this.soup = mealBuilder.soup;
        this.fish = mealBuilder.fish;
        this.drumstick = mealBuilder.drumstick;
        this.vegetable = mealBuilder.vegetable;
        this.fruit = mealBuilder.fruit;
        this.pack = mealBuilder.pack;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "rice='" + rice + '\'' +
                ", soup='" + soup + '\'' +
                ", fish='" + fish + '\'' +
                ", drumstick='" + drumstick + '\'' +
                ", vegetable='" + vegetable + '\'' +
                ", fruit='" + fruit + '\'' +
                ", pack=" + pack +
                '}';
    }

    public static void main(String[] args){
        // 按需构建复杂的对象， 比如这顿饭就不吃鸡腿啦
        Meal launch = new Meal.MealBuilder("五常大米", "紫菜蛋花汤")
                .fish("清蒸鲈鱼")
                .vegetable("小青菜")
                .fruit("橘子")
                .pack(Boolean.FALSE)
                .build();
        // 橘子
        System.out.print(launch.fruit);
    }

}
