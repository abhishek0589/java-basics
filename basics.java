// Strings are maintained in String pool and are immutable to avoid password and connection related pointer refernce of char in the string, or -1

// int indexOf(String s) -
// boolean equals(Object) --test if two strings have the same characters
// boolean equalsIgnoreCase(Object) --as above, but ignoring case 
// String toLowerCase() --return a new String, lowercase -
// String substring(int begin, int end) --return a new String made of the begin..end - 1 substring from the original

String.a = "abc";
a.length();

// Array 

int[] ints = new int[] {1,2,3};
String[] strings = new Strings[] {'a','b','c'};
String[] arr = {“a”, “b”,“c”};
int[] arr = {1,2,3,4,5};
char[] arr = {‘a’,’b’,‘c’};

// get array length
// a.length.not a.length() or a.size()

// Collections

List < Integer > list = Arrays.asList(1, 2, 3);
List < Integer > list = new ArrayList < > ();

Map < Integer, Integer > map = new HashMap < > (); // no need to declare anything in diamond operator


// a hashmap is array of linkedlist. Index of array is obtained using hashcode of each object. Value of each array is a linkedlist. 
Class HashMap {
    LinkedList[] linked;
}

You can also call a hashmap as List of entries
List < Map.Entry < K, V >> list = new ArrayList < > (map.entrySet())


// sort a collection- uses trim sort
GOLDEN RULE FOR ASC or DESC SORT - If the result of comparison is positive then first element is placed before the 2 nd element
Collections.sort(list, comparator)
Collections.sort(list, (o1, o2) - > (o1 - o2)) // ascending sort
Collections.sort(list, (o1, o2) - > (o2 - o1)) // decending sort

// compare players by their scores and if scores are same then fallback on first name sort
// very good and simple example- https://www.youtube.com/watch?v=SzzSwvQfKyk


// Conversion

String to int = Integer.parseint("1234")
Character to int = Character.getNumericValue('a')



// Subtle differences
// These two are totally different from each other. 
// The first CONTINUES executing if a!=b and the second one returns the results irrespective of result of the condition
// Snippet A
if (a == b)
    return true

// Snippet B
return a == b



// Priority queue- ascending order (items with lower value will be on left most side and would be polled first)
PriorityQueue < Integer > pq = new PriorityQueue < Integer > ();
pq.add(3), pq.add(5), pq.add(15), pq.add(7), pq.add(8), pq.add(1)
While(pq.size != 0) {
    pq.poll()
}

// op- 1,3,5,7,8,15

// ii.	Priority queue- descending order
PriorityQueue < Integer > pq = new PriorityQueue < Integer > (initialCapacity, comparator);

PriorityQueue < Integer > pq = new PriorityQueue < Integer > (10, Collections.reverseOrder());

/*
Returns a comparator that imposes the reverse of the natural ordering on a collection of objects that implement the Comparable interface. (The natural ordering is the ordering imposed by the objects' own compareTomethod.) 
This enables a simple idiom for sorting (or maintaining) collections (or arrays) of objects that implement the Comparable interface in reverse-natural-order. For example, suppose a is an array of strings.
iii.	Priority queue with custom comparactor
*/

PriorityQueue < Customobject > pq = new PriorityQueue < Customobject > (10, new Comparator < CustomObject > () {
    Public int compara(Customobject a, Customobject b) {
        Return a.field - b.field;
        // first object – second object- ASCENDING
        // second object- first object- DESCENDING
    }
});





// Date and time  

// notice common methods across classes- now, of, parse
// https://www.baeldung.com/java-8-date-time-intro

// date
LocalDate localDate = LocalDate.now();
LocalDate.of(2015, 02, 20);
LocalDate.parse("2015-02-20");
LocalDate tomorrow = LocalDate.now().plusDays(1);
boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));

// time
LocalTime now = LocalTime.now();
LocalTime sixThirty = LocalTime.of(6, 30);
LocalTime sixThirty = LocalTime.parse("06:30");
LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
int six = LocalTime.parse("06:30").getHour();
boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));

// date time
LocalDateTime.now();
LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
LocalDateTime.parse("2015-02-20T06:30:00");
localDateTime.plusDays(1);
localDateTime.minusHours(2);

// duration- count seconds between two intervals
LocalTime start = LocalTime.now();
Thread.sleep(5000);
long seconds = Duration.between(start, LocalTime.now()).getSeconds();
System.out.println(seconds);

// period- The Period class is widely used to modify values of given a date or to obtain the difference between two dates:

LocalDate initialDate = LocalDate.parse("2007-05-10");
LocalDate finalDate = initialDate.plus(Period.ofDays(5));
int five = Period.between(initialDate, finalDate).getDays();
long five = ChronoUnit.DAYS.between(initialDate, finalDate);


// Date and Time Formatting- Java 8 provides APIs for the easy formatting of Date and Time:

LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
//This code passes an ISO date format to format the local date, with a result of 2015-01-25:

String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);
//The DateTimeFormatter provides various standard formatting options.

//Custom patterns can be provided to the format method as well, which here returns a LocalDate as 2015/01/25:

localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//We can pass in formatting style either as SHORT, LONG or MEDIUM as part of the formatting option.

//For example, this would give an output representing LocalDateTime in 25-Jan-2015, 06:30:00:

localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK));
