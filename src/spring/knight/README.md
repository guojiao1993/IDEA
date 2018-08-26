## 依赖注入
xml配置Bean
```xml
<bean id="knight" class="spring.knight.BraveKnight">
    <constructor-arg ref="quest" />
</bean>

<bean id="quest" class="spring.knight.SlayDragonQuest">
    <constructor-arg ref="fakePrintStream" />
</bean>

<bean id="minstrel" class="spring.knight.Minstrel">
    <constructor-arg ref="fakePrintStream" />
</bean>

<bean id="fakePrintStream" class="spring.knight.FakePrintStream">
    <constructor-arg value="#{T(System).out}" />
</bean>
```
注解配置Bean
```xml
@Configuration
public class KnightConfig {
    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
```
如何使用
```xml
public static void main(String[] args) throws Exception {
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                    "spring/knight/knight.xml");
    Knight knight = context.getBean(Knight.class);
    knight.embarkOnQuest();
    context.close();
}
```
## AOP切面
```xml
<bean id="minstrel" class="spring.knight.Minstrel">
    <constructor-arg ref="fakePrintStream" />
</bean>

<aop:config>
    <aop:aspect ref="minstrel">
        <aop:pointcut id="embark" 
            expression="execution(* *.embarkOnQuest(..))"/>

        <aop:before pointcut-ref="embark"
                    method="singBeforeQuest"/>

        <aop:after pointcut-ref="embark"
                   method="singAfterQuest"/>
    </aop:aspect>
</aop:config>
```
这里使用了Spring的aop配置命名空间把Minstrel bean声明为一个切面。
   
首先， 需要把Minstrel声明为一个bean， 然后在元素中引用该bean。 
 
为了进一步定义切面， 声明（使用） 在embarkOnQuest()方法执行前调用Minstrel的singBeforeQuest()方法。 这种方式被称为前置通知（before advice） 。  

同时声明（使用）在embarkOnQuest()方法执行后调用singAfter Quest()方法。 这种方式被称为后置通知（after advice） 。  

参考  
[深入理解Spring框架的作用](https://blog.csdn.net/huanghanqian/article/details/79340762)