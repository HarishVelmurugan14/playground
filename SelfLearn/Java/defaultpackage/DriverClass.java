package SelfLearn.Java.defaultpackage;

public class DriverClass {
    public static void main(String[] args) {

//        Inner Class Fetch
//        @AccessModifiers
        BasicConcepts basicConcepts = new BasicConcepts();
        BasicConcepts.AccessModifier accessModifier = basicConcepts.new AccessModifier();
        accessModifier.definitions();

//        Static Inner Class Fetch
//        @FinalKeywordUsage
        BasicConcepts.FinalKeywordUsage finalKeywordUsage = new BasicConcepts.FinalKeywordUsage();
        finalKeywordUsage.definitions();

        OOPSConcepts oopsConcepts = new OOPSConcepts();
//        @Encapsulation
        OOPSConcepts.Encapsulation encapsulation = oopsConcepts.new Encapsulation();
        encapsulation.definitions();


//        @ModernJava
        ModernJava modernJava = new ModernJava();
        modernJava.definitions();
    }
}
