package SelfLearn.Java.defaultpackage;

public class DriverClass {
    public static void main(String[] args) {

        //Inner Class Fetch
        BasicConcepts concepts = new BasicConcepts();
        BasicConcepts.AccessModifier accessModifier = concepts.new AccessModifier();
        accessModifier.definitions();

        // Static Inner Class Fetch
        BasicConcepts.FinalKeywordUsage finalKeywordUsage = new BasicConcepts.FinalKeywordUsage();
        finalKeywordUsage.definitions();

    }
}
