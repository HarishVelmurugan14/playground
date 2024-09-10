package SelfLearn.Java.Defaultpackage.Concepts.Fundamental;

public class OOPSConcepts {
    class Encapsulation{

        public void definitions(){
//            Bundling data and method behaviours and hiding from external methods and showing only what is needed is
//            called as Encapsulation
            setBalance(500);
            System.out.println(getBalance());
            retrieveBalanceAfterTransaction();
        }

        private int balance;
//             the balance cannot be accessed directly and showing only the getter setter - > Data Bundling

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public void retrieveBalanceAfterTransaction(){
//            Some Business Logic
//            Hiding the behaviour inside method and showing only method name -> Method (reference) bundling
        }

    }
}
