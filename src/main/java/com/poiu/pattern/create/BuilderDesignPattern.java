package com.poiu.pattern.create;

/**
 * 建造者模式
 *
 * @author: haibo.liang
 * @create: 2021-06-17 20:06
 **/
public class BuilderDesignPattern {
    public static void main(String[] args) {
        ConstructorArg constructorArg = new ConstructorArg.Builder()
                .setArgOne("argOne")
                .setArgTwo("argTwo")
                .build();
    }
}

class ConstructorArg {
    private String argOne;
    private String argTwo;

    private ConstructorArg() {
    }

    /**
     * 内部建造类
     */
    static class Builder {
        private String argOne;
        private String argTwo;

        public Builder setArgOne(String argOne) {
            this.argOne = argOne;
            return this;
        }

        public Builder setArgTwo(String argTwo) {
            this.argTwo = argTwo;
            return this;
        }

        public ConstructorArg build() {
            // 可实现参数校验功能
            ConstructorArg constructorArg = new ConstructorArg();
            constructorArg.argOne = this.argOne;
            constructorArg.argTwo = this.argTwo;
            return constructorArg;
        }
    }
}