package javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics3;


import javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics2.Paper;

public class MyNonGenericPaperHandle implements GarbageHandler<Paper, MyPaperHandleMethod>{
    @Override
    public void handle(Paper what, MyPaperHandleMethod how) {

        // здесь что-то делается с бумажным мусором способом MyPaperHandleMethod
    }

    @Override
    public <E> void transfer(E dangerousWaste) {

    }
}
