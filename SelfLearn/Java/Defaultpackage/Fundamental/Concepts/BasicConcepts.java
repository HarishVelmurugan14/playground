package SelfLearn.Java.Defaultpackage.Fundamental.Concepts;

@SuppressWarnings("unused")
public class BasicConcepts {

    class AccessModifier {
        public String publicVariable = "Hello";
        String defaultVariable = "Hello";
        protected String protectedVariable = "Hello";

        private String privateVariable = "Hello";

        void DefaultMethod() {}// Also called Package-Private

        public void PublicMethod() {}

        private void PrivateMethod(String variable) {}

        protected void ProtectedMethod() {}

        public final void definitions(){
            PrivateMethod(privateVariable);
//            Method, Variable and Class is accessible only inside the same package
//            Method, Variable and Class is accessible everywhere
//            Private method and Private variable is accessible only inside the class ; No class definition for private
//            Protected method and Protected variable is accessible only inside the package and allowed for
//                subclasses in other packages ; No class definition for private
        }
    }

    static class FinalKeywordUsage {

        public final void definitions(){
//            Class : final class ClassName : ClassName cannot be extended
//            Method  : public final void MethodName() : MethodName cannot be overriden
//            Variable : public final int A = 1; cannot be reassigned
//            Object : final Object obj = new Object();
//                obj = new NewObject(); Cannot be re initialized
        }
    }


    void DriverMethod() {
        AccessModifier accessModifiers = new AccessModifier();
        System.out.println(accessModifiers.protectedVariable);
        System.out.println(accessModifiers.publicVariable);
        System.out.println(accessModifiers.defaultVariable);
    }
}
