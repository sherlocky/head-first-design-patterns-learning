# Sherlocky learning in Head First 设计模式
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)
[![stable](http://badges.github.io/stability-badges/dist/stable.svg)](http://github.com/badges/stability-badges)

本例代码基于 Gradle 4.10、Java 8 构建。

> 记住，知道抽象、继承、多态这些概念，并不会马上让你变成好的面向对象设计者。设计大师关心的是建立弹性的设计，可以维护，可以应付变化。  
建立可维护的OO系统，要诀就在于随时想到系统以后可能需要的变化，以及应付变化的原则。  
良好的OO设计必须具备可复用、可扩充、可维护三个特性。

使用模式最好的方式是：“把模式装进脑子里，然后在你的设计和已有的应用中，寻找何处可以使用他们。“以往是代码复用，现在是经验复用。

## 设计原则：
- 封装变化(找出应用中可能需要变化之处，把他们独立出来，不要和那些不需要变化的代码混在一起)。
- 针对接口编程，而不是针对实现编程。
- 多用组合，少用继承。
- 为了交互对象之间的**``松耦合``**设计而努力。
  > 松耦合的设计之所以能让我们建立有弹性的OO系统，能够应对变化，是因为对象之间的相互依赖降到了最低。
- 类应该对扩展开放，对修改关闭。
  > 虽然似乎有点矛盾，但是的确有一些技术可以允许在不直接修改代码的情况下，对其进行扩展。  
   在选择需要被扩展的代码部分时要小心。每个地方都采用开闭原则是一种浪费，也没必要，还会导致代码变得复杂且难以理解。  
   遵循开闭原则通常会引入新的抽象层次，增加代码的复杂度。我们应该把注意力集中在设计中**最有可能改变**的地方，然后应用开闭原则。
- 要依赖抽象，不要依赖具体类（依赖倒置原则）。
  > 不能让高层组件依赖底层组件，而且，不管高层或低层组件，“两者”都应该依赖于抽象。  
  > 指导方针： 
  > - 变量不可以持有具体类的引用。
  > - 不要让类派生自具体类。
  > - 不要覆盖基类中已实现的方法。 
- 最少知识原则：只和你的密友谈话。
  > 不管是任何对象，你都要注意他所交互的类有哪些，并注意它和这些类是如何交互的。
  > 我们在设计中不要让太多的类耦合在一起，免得修改系统中一部分，会影响到其他部分。

  方针：就任何对象而言，在该对象的方法内，我们只应该调用属于以下范围的方法：
  - 该对象本身
  - 被当做方法的参数而传递进来的对象
  - 此方法所创建或实例化的任何对象
  - 对象的任何组件
- 好莱坞原则：别调用（打电话给）我们，我们会调用（打电话给）你。
> 我们允许低层组件将自己挂钩到系统上，但是高层组件会决定什么时候和怎样使用这些低层组件。  
> 换句话说，高层组件对待低层组件的方式是“别调用我们，我们会调用你”。
  
## [01 Strategy Pattern 策略模式](src/main/java/com/sherlocky/headfirst/pattern/_01_strategy)

**策略模式**定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户（使用组合，组合类实现了整个算法）。

 
## [02 Observer Pattern 观察者模式](src/main/java/com/sherlocky/headfirst/pattern/_02_observer)

**观察者模式**定义了对象之间一对多依赖（关系），这样一来，当一个对象改变状态时，它的所有依赖者都会受到通知并自动更新。

> 实现观察者模式的方法不只一种，但是以包含``Subject``与``Observer``接口的类设计的做法最常见。

当两个对象之间松耦合，他们依然可以交互，但是不太清楚彼此的细节。观察者模式提供了一种对象设计，让主题和观察者之间松耦合。主题（可观察者）用一个共同接口来更新观察者。观察者和可观察者之间用松耦合的方式结合(loosecoupling)，可观察者不知道观察者的细节，只知道观察者实现了观察者接口。

使用此模式时，可以从被观察者处推（push）或拉（pull）数据（然而，推的方式被认为更”正确“）。
> MVC 是观察者模式的代表人物，Swing也大量使用观察者模式(许多GUI框架也是如此)。此模式也被应用在如：JavaBeans、RMI 等地方。

## [03 Decorator Pattern 装饰者模式](src/main/java/com/sherlocky/headfirst/pattern/_03_decorator)

**装饰者模式**动态地将责任附加到对象上。若要扩展功能，装饰者提供了比集成更有弹性的替代方案。

- 集成属于扩展形式之一，但不见得是达到弹性设计的最佳方式。
- 组合和委托可用于在运行时动态的加上新的行为。
- 装饰者需要和被装饰者（亦即被包装的组件）拥有相同的“接口”，因为装饰者必须能够取代被装饰者。此处继承是为了有正确的类型（为了能够取代被装饰者），而不是继承他的行为。
- 将装饰者与组件组合时，就是在加入新的行为。所得到的新行为，并不是继承自超类，而是由组合对象得来的。

Java I/O 中很多类都使用了装饰者模式。例如：
> BufferedInputStream/LineNumberInputStream/PushbackInputStream/DataInputStream 等 都扩展自 FilterInputStream，而 FilterInputStream 是一个抽象的装饰类，对应的抽象组件是 InputStream。另外， Reader/Writer(基于字符数据的输入输出)和输入流/输出流的类相当类似(虽然有一些小的差异和不一致之处，但是相当雷同)。

Java I/O 也引出装饰者模式的一个“缺点”：利用装饰者模式，经常造成设计中有大量的小类，数量实在太多，可能会造成使用此API程序员的困扰。

## [04 Factory Pattern 工厂模式](src/main/java/com/sherlocky/headfirst/pattern/_04_factory)
所有的工厂都是用来封装对象的创建。

工厂模式可以分为三类：
- 1）简单工厂（Simple Factory）：又叫做静态工厂方法（Static Factory Method），其实并非一种模式，更多的是编程习惯。  
    > 【符合单一职责原则。不符合开放-封闭原则】
    用来生产同一等级结构中的任意产品。（对于增加新的产品，主要是新增产品，就要修改工厂类。
    
- 2）工厂方法模式（Factory Method）：用来生产同一等级结构中的固定产品。定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。（使用继承）
    > 【符合单一职责原则、符合开放-封闭原则。但是引入了复杂性】     
    工厂方法让类把实例化推迟到子类。工厂方法模式能够封装具体类型的实例化（封装对象的创建过程）。
    
    > 简单工厂把全部的事情在一个地方都处理完了，然而工厂方法确实创建一个框架，让子类决定要如何实现。  
    简单工厂的做法可以将对象的创建封装起来，但是简单工厂不具备工厂方法的弹性，因为简单工厂不能变更正在创建的产品。
    
- 3）抽象工厂模式（Abstract Factory）：（又称为Kit模式）用来生产不同产品族的全部产品。提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类。（使用对象组合）
    > 【符合单一职责原则，部分符合开放-封闭原则，降低了复杂性。】  
    抽象工厂允许客户使用抽象的接口来创建一组相关的产品，而不需要知道实际产出的具体产品是什么。  
    客户就从具体的产品中被解耦。  
    抽象工厂模式提供了一种方式，可以将同一产品族的单独的工厂封装起来。在正常使用中，客户端程序需要创建抽象工厂的具体实现，然后使用抽象工厂作为接口来创建这一主题的具体对象。  
    客户端程序不需要知道（或关心）它从这些内部的工厂方法中获得对象的具体类型，因为客户端程序仅使用这些对象的通用接口。  
    抽象工厂模式将一组对象的实现细节与他们的一般使用分离开来。  

## 05 Singleton Pattern 单例模式
确保一个类只有一个实例，并提供一个全局访问点。
> 参见：[sherlocky/interview/singleton](https://gitee.com/sherlocky/interview/tree/master/javase/src/main/java/com/sherlocky/interview/javase/singleton)

> 【问题】两个类加载器可能有机会各自创建自己的单例实例？
因为每个类加载器都定义了一个命名空间，如果有两个以上的类加载器，
不同的类加载器可能会加载同一个类，从整个程序来看，同一个类会被加载多次。   
所以，如果你的程序有多个类加载器又同时使用了单例模式，请小心。  
有一个解决办法：自行指定类加载器，并指定同一个类加载器。

## [06 Command Pattern 命令模式](src/main/java/com/sherlocky/headfirst/pattern/_06_command)
将“请求”封装成对象，以便使用不同的请求，队列或者日志请求来参数化其他对象。  
命令模式也支持可撤销的操作。

>
- 命令模式将发出请求的对象和执行请求的对象解耦。
- 在被解耦的两者之间是通过命令对象进行沟通的。命令对象封装了接收者和一个或一组动作。
- 调用者通过调用命令对象的execute()发出请求，这会使得接收者的动作被调用。
- 调用者可以接受命令当做参数，甚至在运行时动态地进行。
- 命令可以支持撤销，做法是实现一个undo()方法来回到execute()被执行前的状态。
- 宏命令是命令的一种简单的延伸，允许调用多个命令。宏方法也可以支持撤销。
- 命令也可以用来实现日志和事务系统。

## [07 Adapter Pattern 适配器模式](src/main/java/com/sherlocky/headfirst/pattern/_07_adapter)
将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间。

客户使用适配器（之间是解耦的）的过程：
- 1.客户通过目标接口调用适配器的方法对适配器发出请求。
- 2.适配器使用被适配者接口把请求转换成被适配者的一个或多个调用接口。
- 3.客户接收到调用的结果，但并未察觉这一切是适配器在起转换作用。

## [08 Facade Pattern 外观/门面模式](src/main/java/com/sherlocky/headfirst/pattern/_08_facade)
外观模式也称为门面模式，提供了一个统一（简化）的接口，用来访问子系统中的一群接口，本质是：**封装交互，简化调用**。外观定义了一个高层接口，让子系统更容易使用。同时依然将系统完整的功能暴露出来，以供需要的人使用。

外观不只是简化了接口，也将客户从组建的子系统中解耦。

> 外观和适配器可以包装许多类，但是外观的意图是简化接口，而适配器的意图是将接口转换成不同接口。

**装饰者模式 VS 适配器模式 VS 外观模式**：  
> **装饰者**将一个对象“包装”起来以增加新的行为和责任；  
> **适配器**将一个对象“包装”起来以改变其接口；  
> **而外观**将一群对象“包装”起来以简化其接口。


## [09 Templatemethod Pattern 模板方法模式](src/main/java/com/sherlocky/headfirst/pattern/_09_templatemethod)
模板方法模式在一个方法中定义了一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。

这个模式是用来创建一个算法的模板。其实模板就是一个方法，更具体地说，这个方法将算法定义成一组步骤，其中的任何步骤都可以是抽象的，由子类负责实现。这可以确保算法的结构保持不变，同时由子类提供部分实现。

> JDK 中的 Arrays.sort() 方法可以被看做是一个模板方法（尽管不是教科书式的实现，但是依然符合模板方法的精神）。  
> 数组所实现的排序算法并不完整，它需要一个类填补 compareTo() 方法的实现，因此我们认为这更像一个模板方法。  
> 类似的还有：java.io.InputStream#read() 方法，是由子类实现的，而这个方法又被被 read(byte b[], int off, int len) 模板方法使用。  

钩子方法(默认不做事)：  
> 是对于抽象方法或者接口中定义的方法的一个空的或者默认的实现，子类可以视情况决定要不要覆盖他们，如果不覆盖，就使用抽象类提供的默认实现（要不要挂钩由子类决定）。

**模板方法模式 VS 策略模式**
> **策略模式**（通过组合封装算法）：定义一个算法家族，并让这些算法可以互换（组合类实现了整个算法）。  
> **模板方法**（通过继承封装算法）：定义一个算法大纲，而由子类定义其中某些步骤的内容（个别步骤可以有不同的实现细节，但算法结构维持不变）。  
> 工厂方法是模板方法的一种特殊版本。