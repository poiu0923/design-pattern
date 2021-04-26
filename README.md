# design-pattern
设计模式学习笔记

### 设计原则-SOLID 原则
#### 单一职责原则(SRP - Single Responsibility Principle)
- 英文描述: A class or module should have a single responsibility.
- 中文描述: 一个类或者模块只负责完成一个职责（或者功能）

#### 开闭原则(OCP - Open Closed Principle)
- 英文描述: software entities (modules, classes, functions, etc.) should be open for extension , but closed for modification.
- 中文描述: 软件实体（模块、类、方法等）应该“对扩展开放、对修改关闭”

#### 里氏替换原则(LSP - Liskov Substitution Principle)
- 英文描述: Functions that use pointers of references to base classes must be able to use objects of derived classes without knowing it.(Robert Martin,1996)
- 中文描述: 子类对象（object of subtype/derived class）能够替换程序（program）中父类对象（object of base/parent class）出现的任何地方，并且保证原来程序的逻辑行为（behavior）不变及正确性不被破坏

#### 接口隔离原则(ISP - Interface Segregation Principle)
- 英文描述: Clients should not be forced to depend upon interfaces that they do not use.
- 中文描述: 客户端不应该被强迫依赖它不需要的接口。其中的“客户端”，可以理解为接口的调用者或者使用者

#### 依赖倒置原则(DIP - Dependency Inversion Principle)
- 英文描述: High-level modules shouldn’t depend on low-level modules. Both modules should depend on abstractions. In addition, abstractions shouldn’t depend on details. Details depend on abstractions.
- 中文描述: 高层模块（high-level modules）不要依赖低层模块（low-level）。高层模块和低层模块应该通过抽象（abstractions）来互相依赖。除此之外，抽象（abstractions）不要依赖具体实现细节（details），具体实现细节（details）依赖抽象（abstractions）。