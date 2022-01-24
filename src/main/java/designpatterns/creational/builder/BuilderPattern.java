package designpatterns.creational.builder;
/*
* Builder pattern solves the issue with large number of optional parameters and inconsistent state by providing a way to
* build the object step-by-step and provide a method that will actually return the final Object.
* */
public class BuilderPattern {
    static class Coffee {
        private String type;
        private boolean sugar;
        private boolean milk;
        private String size;
        private Coffee(Builder builder) {
            this.type = builder.type;
            this.sugar = builder.sugar;
            this.milk = builder.milk;
            this.size = builder.size;
        }

        //Builder class for Coffee.
        public static class Builder {
            private String type;
            private boolean sugar;
            private boolean milk;
            private String size;
            public Builder(String type) {
                this.type = type;
            }
            public Builder sugar(boolean value) {
                this.sugar = value;
                return this;
            }
            public Builder milk(boolean value) {
                this.milk = value;
                return this;
            }
            public Builder size(String value) {
                this.size = value;
                return this;
            }
            public Coffee build() {
                return new Coffee(this);
            }
        }
        @Override
        public String toString() {
            return String.format("Coffee [type=%s, sugar=%s, milk=%s, size=%s]", this.type, sugar, milk, size);
        }
    }

    public static void main(String[] args) {
        Coffee coffee = new BuilderPattern.Coffee.Builder("Mocha").milk(true).sugar(false).size("Large").build();
        System.out.println(coffee);
    }
}
