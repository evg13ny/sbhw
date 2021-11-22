public class Main {
    public static void main(String[] args) {
        IndividualBusinessman individualBusinessman = new IndividualBusinessman();
        LegalPerson legalPerson = new LegalPerson();
        PhysicalPerson physicalPerson = new PhysicalPerson();

        individualBusinessman.put(10000);
        legalPerson.put(10000);
        physicalPerson.put(10000);

        individualBusinessman.take(20000);
        legalPerson.take(5000);
        physicalPerson.take(10000);

        individualBusinessman.put(500);

        individualBusinessman.info();
        legalPerson.info();
        physicalPerson.info();
    }
}
