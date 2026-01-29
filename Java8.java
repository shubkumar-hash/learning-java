import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Student
{
    int id;

    String name;

    double percentage;

    String specialization;

    public Student(int id, String name, double percentage, String specialization)
    {
        this.id = id;

        this.name = name;

        this.percentage = percentage;

        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString()
    {
        return id+"-"+name+"-"+percentage+"-"+specialization;
    }
}


class Main {
    public static void Java8(String[] args) {

        List<Student> listOfStudents = new ArrayList<>();

        listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));
        listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));
        listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));
        listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));
        listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));
        listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));
        listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));
        listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));
        listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));

        Map<Boolean, List<Student>> partitionStudents =
                listOfStudents.stream()
                        .collect(Collectors.partitioningBy(s -> s.getPercentage() > 60));
        System.out.println(partitionStudents);

        List<Student> topThreeStudents =
                listOfStudents.stream()
                        .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println(topThreeStudents);

        Map<String, Double> nameWithPercentage =
                listOfStudents.stream()
                        .collect(Collectors.toMap(Student::getName, Student::getPercentage));
        System.out.println(nameWithPercentage);

        Map<String, List<Student>> subjectwiseStudents =
                listOfStudents.stream()
                        .collect(Collectors.groupingBy(Student::getSpecialization));
        System.out.println(subjectwiseStudents);

        // filter
        List<Student> computerStudents =
                listOfStudents.stream()
                        .filter(s -> s.getSpecialization().equals("Computers"))
                        .collect(Collectors.toList());
        System.out.println(computerStudents);

        // count
        long countAbove80 =
                listOfStudents.stream()
                        .filter(s -> s.getPercentage() > 80)
                        .count();
        System.out.println(countAbove80);

        // max
        Optional<Student> topper =
                listOfStudents.stream()
                        .max(Comparator.comparingDouble(Student::getPercentage));
        topper.ifPresent(System.out::println);

        // min
        Optional<Student> lowest =
                listOfStudents.stream()
                        .min(Comparator.comparingDouble(Student::getPercentage));
        lowest.ifPresent(System.out::println);

        // average
        double averagePercentage =
                listOfStudents.stream()
                        .collect(Collectors.averagingDouble(Student::getPercentage));
        System.out.println(averagePercentage);

        // statistics
        DoubleSummaryStatistics stats =
                listOfStudents.stream()
                        .collect(Collectors.summarizingDouble(Student::getPercentage));
        System.out.println(stats);

        // match operations
        boolean anyFail =
                listOfStudents.stream()
                        .anyMatch(s -> s.getPercentage() < 60);
        System.out.println(anyFail);

        boolean allAbove50 =
                listOfStudents.stream()
                        .allMatch(s -> s.getPercentage() > 50);
        System.out.println(allAbove50);

        boolean noneBelow40 =
                listOfStudents.stream()
                        .noneMatch(s -> s.getPercentage() < 40);
        System.out.println(noneBelow40);

        // distinct specializations
        listOfStudents.stream()
                .map(Student::getSpecialization)
                .distinct()
                .forEach(System.out::println);

        // forEach
        listOfStudents.forEach(System.out::println);

        // IntStream
        int sumOfIds =
                listOfStudents.stream()
                        .mapToInt(Student::getId)
                        .sum();
        System.out.println(sumOfIds);
    }
}
