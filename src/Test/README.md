### AssertTest
使用Assert来调试程序。例如：
```java
public static void main(String[] args) {
    System.out.println("start");
    int i = 0;
    assert i > 0;
    System.out.println("end");
}
```
使用java Main会正常输出，但是如果使用java -ea Main，则会报错：
```java
start
Exception in thread "main" java.lang.AssertionError
        at Test.AssertTest.main(AssertTest.java:7)
```
### ScannerTest
next() 方法遇见第一个有效字符（非空格，非换行符）时，开始扫描，当遇见第一个分隔符或结束符(空格或换行符)时，结束扫描，获取扫描到的内容，即获得第一个扫描到的不含空格、换行符的单个字符串。  

nextLine()方法则可以扫描到一行内容并作为一个字符串而被获取到。  

[Java基础之Scanner类中next()与nextLine()方法的区别](https://www.cnblogs.com/ihaveastory/p/5931278.html)  
