public class Person {
    String first;
    String last;

    String fullName(){
        String fn = this.first+' '+this.last;
        return fn;
    }
    Person(String f, String l){
        this.first = f;
        this.last = l;
    }

    public static void main(String[] args) {
        Person luiz = new Person("Luiz", "Barboza");
        String lb = luiz.fullName();
        System.out.println(lb);
    }
}
