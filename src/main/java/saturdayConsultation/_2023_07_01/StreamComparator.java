package saturdayConsultation._2023_07_01;

import javaProfessionalCourse2.lesson33_Hibernate.jpaExample.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamComparator {
    /*
    метды
    разные методы и исользуются в разных вариантах

    comparable = свойсвтво класса, как мы будем сравнивать
    comparaTo
    есть comparato у кот есть compare
    компаратоор -= отдельным классом, и служит для сортировки по-другому

    если провалится внутрь метода сортев

     */
//    Comparable
//    List<Person> list = persons.stream() // sorted()дез параметров в натурал ордер sorted(Comparator<> exctends....)
//            .sorted(Comparator.comparing(Person::getName))
//            .collect(Collectors.toList());
//
//    Optional<Integer> min = numbers.stream()
//            .min(Comparator.naturalOrder());

    // sorted()
    // sorted(Comparator<? super T> comparator)

//     Map<Category, List<Product>> map = product.stream()
//             .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectrors.toList())));
//
//     List<String> list = str.stream()
//             .sorted(Comparator.reverseOrder())
//             .collect(Collectors.toList());
//
//     list.stream.filter(el -> el %2 == 0).forEach(System.out::print);

}

