# Objektdiagram Office

Etter denne main-koden:
```java
	public static void main(String[] args) {
		Printer printer = new Printer();
		Clerk c1 = new Clerk(printer);
		Clerk c2 = new Clerk(printer);
		ArrayList<Employee> eList1 = new ArrayList<>();
		eList1.add(c1);
		eList1.add(c2);
		Manager manager = new Manager(eList1);
		ArrayList<Employee> eList2 = new ArrayList<>();
		eList2.add(manager);
		Manager topDog = new Manager(eList2);
		topDog.printDocument("Hello World");
		topDog.doCalculations((a, b) -> a + b, 1, 2);
	}
```

Vil objektdiagrammet se sånn ut med løsningsforslaget:

![](office.png)

Mermaid-koden (Last ned "Markodwn Preview Mermaid Support" i VSCode for å se den):

```mermaid
classDiagram
    printer -- c1
    printer -- c2
    manager -- c1
    manager -- c2
    topDog -- manager
    class printer["printer : Printer"]
    class c1["c1 : Clerk"] {
        calculationCount = 1
    }
    class c2["c2 : Clerk"] {
        calculationCount = 0
    }
    class manager["manager : Manager"] {
        nextDelegate = 2
    }
    class topDog["topDog : topDog"] {
        nextDelegate = 2
    }
```