# Abstract Class va Interface

## 1. Interface

- Interface trong Java là một bản thiết kế của một lớp. Nó chỉ có các phương thức trừu tượng. 
- Interface là một kỹ thuật để thu được tính trừu tượng hoàn toàn và đa kế thừa trong Java.
- Interface trong Java cũng biểu diễn  mối quan hệ IS-A. NÓ không thể được khởi tạo giống như lớp trừu tượng.

Khai báo:

```java
public interface Printable {
    abstract void print();
}
```

- Các trường của Interface là public, static và final theo mặc định và các phương thức là public và abstract.
- Một interface trong Java là một tập  hợp các phương thức trừu tượng (abstract). Một class triển khai một interface, do đó kể thừa các phương thức abstracr của interface.
- Một interface không phải là một lớp. Viết một interface giống như viết một  lớp nhưng chúng có 2 định nghĩa khác nhau. Một lớp mô tả các thuộc tính và hành vi của một đối tượng. Một interface chứa các hành vi mà một class triển khai.
- Trừ khi một lớp triển khai interface là một lớp trừu tượng, còn lại tất cả các phương thức của interface cần được định nghĩa trong class.
- Điểm giống nhau giữa class và Interface:
  - được viết trong 1 file với định dạng .java, với tên của interface giống với tên của file.
  - bytecode của interface được lưu trong file có định dạng .class.
  - khai báo interface trong một package, những file bytecode tương ứng cũng có cấu trúc thư mục có cùng tên package.
- Điểm khác nhau giữa class và interface:
  - Không thể khởi tạo một interface
  - 1 interface không chứa bất kỳ hàm khởi tạo nào.
  - tất cả các phương thức interface đều là abstract
  - 1 interface không thể chứa một trường nào trừ các trường vừa `static` vừa `final`.
  - một interface không thể kế thừa từ lớp, nó được triển khai bởi một lớp.
  - một interface có thể kế thừa từ nhiều interface khác.
### Ví dụ về Interface trong Java
```java
public interface Printable {
    void print();
} 

public class Test implements Printable {
    public void print() {
        System.out.println("Hehe");
    }
    public stactic void main(Strings args[]) {
        Test a = new Test ();
        a.print();
    }
}
```
```
Output:
Hehe
```

Khi triển khai interface, có một vài nguyên tắc sau:
- Một lớp chỉ có thể triển khai 1 hoặc nhiều interface tại một thời điểm.
- Một lớp chỉ có thể kế thừa một lớp khác nhưng có thể triển khai nhiều interface.
- Một interface có thể kế thưa từ một interface khác, tương tự một lớp có thể kế thừa từ lớp khác.

Đa kế thừa trong Java bởi Interface:

Ví dụ về đa kế thừa interface:

```java
interface Printabble {
    void print();
}
interface Showable {
    void print();
}
public class Test implements Printale, Showable {
    public void print() {
        System.out.println("Hehe");
    }
    public static void main (Strings args[]) {
        Test a = new Test();
        a.print();
    }
}
```
```
Output:
Hehe
```
Trong ví dụ trên, Printable và Showable interface có cùng phương thức print nhưng trình triển khai của nó được cung cấp bởi lớp Test ==> không có tính lưỡng nghĩa.


Interface lồng nhau:
Một interface có thể có interface khác, gọi là lồng interface.

```java
interface Printable {
    void print();
    interface MessagePrintable {
        void msg();
    }
}
```

# 2. Abstract Class
- Là một lớp đợc khai báo với từ khóa `abstract` trong Java.
- Lớp abstrat có định nghĩa là lớp trừu tượng, nó có thể có các phương thức abstract hoặc non-abstract.

### Phương thức trừu tượng trong Java
- Một phương thức được khai báo là abstract và không có trình triển khai thì đó là phương thức trừu tượng.
- Nếu muốn sử dụng một lớp chứa một phương thức cụ thể nhưng bạn muốn phương thức đó được quyết định bởi các lớp con, thì có thể khai báo phương thức đó ở lớp cha với từ khóa `abstract`.
- Một phương thức abstract sẽ không có thân phương thức.

### Ví dụ về lớp trừu tượng và phương thức trừu tượng:

```java
abstract class Animal {
    abstract void makesound();
    void slepp() {
        System.out.println("Zzzzz");
    }
}
class Dog {
    void makeSound() {
        System.out.println("Gow Gow");
    }
}
class Cat {
    void makeSound() {
        System.out.peintln("Meow Meow");
    }
}
class Test {
    public static void main(Strings args[]) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.makeSOund();
        dog.sleep();
        cat.makeSound();
    }
}
```
```
Output
Gow Gow
Zzzzz
Meow Meow
```

# 3. Tính trừu tượng


### Khái niệm
- Là tính chất không thể hiện cụ thể mà chỉ nêu tên vấn đề. Đó là quá trình che giấu các hoạt động bên trong và chỉ hiển thị nhưng tính năng thiết yếu của đối tượng tới người dùng.
Ví dụ: Một người rút tiền tại cây ATM, người đó chỉ cần bấm nút rút tiền rồi tiền sẽ được cây ATM nhả ra chứ không cần quan tâm cây ATM đã thực hiện những thao tác như kiểm tra số dư, trừ tiền trong số dư, ...

### Ưu điểm khi sử dụng tính trừu tượng
- Tính trừu tượng cho phép các lập trình viên loại bỏ tính chất phức tạp của đối tượng bằng cách chỉ đưa ra các thuộc tính và phương thức cần thiết của đối tượng trong lập trình, cải thiện khả năng bảo trì của hệ thống.
- Tính trừu tượng giúp chúng ta tập trung vào những cốt lõi cần thiết của đối tượng thay vì quan tâm đến cách nó thực hiện.
- Tính trừu tượng cung cấp nhiều tính năng mở rộng khi sử dụng kết hợp với tính đa hình và kế thừa trong lập trình hướng đối tượng.
