import Services.Pagination;

import java.util.List;

public class Testing {

    public static void main(String[] args) throws Throwable {
        Pagination pagination = new Pagination();
        List<String> list = pagination.listOfThemes(1);
        list.forEach(System.out::println);
        Something aaa = new Something();
        System.out.println(aaa.getName() == null);
    }

    public static class Something {
        private String name;
        public void setName(String n){
            name = n;
        }
        public String getName(){
            return name;
        }
    }
}
