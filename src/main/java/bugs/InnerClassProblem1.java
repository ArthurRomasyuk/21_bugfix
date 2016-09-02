package bugs;

public class InnerClassProblem1 {
    public class Outer {
        public class Middle {
            public class Inner {
                public int variable = 8;
            }
        }
    }

    public static void main(String[] args) {
        //what is incorrect?
        InnerClassProblem1 innerClassProblem1 = new InnerClassProblem1();
        InnerClassProblem1.Outer outerObject = innerClassProblem1.new Outer();
        Outer.Middle middleObject = outerObject.new Middle();
        Outer.Middle.Inner innerObject = middleObject.new Inner();
    }
}
