# Structural Pattern

## 컴포짓 (Composite) 패턴

> 그룹 전체와 개별 객체를 동일하게 처리할 수 있는 패턴

- 장점 : 클라이언트 입장에서 '전체'나 '부분' 모두 동일한 컴포넌트로 인식할 수 있는 계층 구조 생성 (Part-Whole Hierarchy)

![Composite Pattern UML](Composite_Pattern_UML.jpg)
- Leaf : 가장 기본적인 단위
- Composite : 그룹을 표현 할 수 있음

### 예시
- 게임에서 아이탬을 구매하는 프로그램
```java
public class Client {

    public static void main(String[] args) {
        Item doranBlade = new Item("도란검", 450);
        Item healPotion = new Item("체력 물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPotion);

        Client client = new Client();
        client.printPrice(doranBlade);
        client.printPrice(bag);
    }
    
    // 클라이언트가 너무 많은 로직을 알아야 함
    private void printPrice(Item item) {
        System.out.println(item.getPrice());
    }

    private void printPrice(Bag bag) {
        int sum = bag.getItems().stream().mapToInt(Item::getPrice).sum();
        System.out.println(sum);
    }

}
```
▼
```java
// 컴포넌트 인터페이스
public interface Component {

    int getPrice();

}

// Leaf. 컴포넌트 구현
public class Item implements Component {

    private String name;

    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

// Composite. 컴포넌트 구현 (Leaf가 아님) 
public class Bag implements Component {

    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public int getPrice() {
        return components.stream().mapToInt(Component::getPrice).sum();
    }
}

public class Client {

    public static void main(String[] args) {
        Item doranBlade = new Item("도란검", 450);
        Item healPotion = new Item("체력 물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPotion);

        Client client = new Client();
        client.printPrice(doranBlade);
        client.printPrice(bag);
    }

// 클라이언트는 컴포넌트만 보면 됨 (위임)
// Bag(Composite)이든 Item(Leaf)이든 상관 없음
    private void printPrice(Component component) {
        System.out.println(component.getPrice());
    }
}

```

#### 정리
> 그룹 전체와 개별 객체를 동일하게 처리할 수 있는 패턴

- 장점
    - 복잡한 트리 구조를 편리하게 사용 가능
    - 다형성과 재귀 활용 가능
    - 새로운 타입의 리프 / 컴포짓이 추가되어도 클라이언트는 바뀌지 않음 : 개방폐쇄 원칙(OCP)
- 단점
    - 공통된 인터페이스를 뽑아내기 위해 지나치거나 부자연스럽게 일반화를 해야 하는 경우가 있음
        - 런타임시 타입을 체크해야 하는 경우, 의심해봐야 함
    
#### 다른 곳에서는 어떻게 사용하나?
 
##### 자바
- Swing
```java
public class SwingExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JTextField textField = new JTextField();
        textField.setBounds(200, 200, 200, 40);
        frame.add(textField);

        JButton button = new JButton("click");
        button.setBounds(200, 100, 60, 40);
        button.addActionListener(e -> textField.setText("Hello Swing"));
        frame.add(button);

        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }


}
```