# Objektdiagram StockListener

Etter denne main-koden:
```java
	public static void main(String[] args) {
		Stock AAA = new Stock("AAA", 9001);
		Stock BBB = new Stock("BBB", 42);
		StockIndex index = new StockIndex("alphabet", AAA, BBB);
		AAA.setPrice(8000);
		Stock CCC = new Stock("CCC", 300);
		index.addStock(CCC);
	}
```

Vil objektdiagrammet se sånn ut med løsningsforslaget:

![](stocklistener.png)

Mermaid-koden (Last ned "Markodwn Preview Mermaid Support" i VSCode for å se den):

```mermaid
classDiagram
    AAA -- index
    BBB -- index
    CCC -- index
    class AAA["AAA : Stock"] {
        ticker = "AAA"
        price = 8000
    }
    class BBB["BBB : Stock"] {
        ticker = "BBB"
        price = 42
    }
    class CCC["CCC : Stock"] {
        ticker = "CCC"
        price = 300
    }
    class index["index : StockIndex"] {
        name = "alphabet"
        index = 8342
    }

```