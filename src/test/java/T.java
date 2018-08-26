class Person{
    {
        System.out.println("1111");
    }
    private Integer i=1;
    static {
        System.out.println("1");
    }
    public Person(){
        System.out.println("Only Perosn");
    }
    public Person(int i){
        this.i = i;
        System.out.println("Person");
    }
}
class Children extends  Person{
    static {
        System.out.println("2");
    }
    {
        System.out.println("2222");
    }

    public Children(){
        System.out.println("children");
    }
}
/*
*1  2  1111  person  2222  children 1111 person 2222 children
* */
public class T {
    public static void main(String[] args) {
        Person p = new Children();
        p = new Children();
    }
}
