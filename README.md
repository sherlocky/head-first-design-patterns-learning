# Sherlocky learning in Head First 设计模式
[![stable](http://badges.github.io/stability-badges/dist/stable.svg)](http://github.com/badges/stability-badges)
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)

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

## [01 Strategy Pattern 策略模式](src/main/java/com/sherlocky/headfirst/pattern/_01_strategy)

**策略模式**定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。

 
## [02 Observer Pattern 观察者模式](src/main/java/com/sherlocky/headfirst/pattern/_02_observer)

**观察者模式**定义了对象之间一对多依赖（关系），这样一来，当一个对象改变状态时，它的所有依赖者都会受到通知并自动更新。

> 实现观察者模式的方法不只一种，但是以包含``Subject``与``Observer``接口的类设计的做法最常见。

当两个对象之间松耦合，他们依然可以交互，但是不太清楚彼此的细节。观察者模式提供了一种对象设计，让主题和观察者之间松耦合。主题（可观察者）用一个共同接口来更新观察者。观察者和可观察者之间用松耦合的方式结合(loosecoupling)，可观察者不知道观察者的细节，只知道观察者实现了观察者接口。

使用此模式时，可以从被观察者处推（push）或拉（pull）数据（然而，推的方式被认为更”正确“）。
> MVC 是观察者模式的代表人物，Swing也大量使用观察者模式(许多GUI框架也是如此)。此模式也被应用在如：JavaBeans、RMI 等地方。

