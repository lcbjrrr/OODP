public class Main {
    public static void main(String[] args) {
        String f = "Luiz";
        String l = "Barboza";
        String lb = fullName(f,l);
        System.out.println(lb);

    }

    static String fullName(String first, String last){
        String fn = first+' '+last;
        return fn;
    }
}
