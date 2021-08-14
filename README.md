# 第一章 编程入门

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-15-44-54-image.png" alt="" width="623">

* **学习流程**：语言基础—>JVM—>并发多线程

* **职业发展**：<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-15-49-50-image.png" alt="" width="480">

* **学习必备能力**：良好的编码风格—javadoc

* **语言架构认知**：JDK=JRE+开发工具集，JRE=JVM+JavaSE标准类库
  
  <img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-15-53-41-image.png" title="" alt="" width="474">

* **语言文件**：
  
  * java源文件可以声明多个class，但是最多一个public class
  
  * public类的类名必须和源文件名相同（大写开头）
  
  * 程序入口main（），格式固定。其中 []和 args 可以改变
  
  * 编译过程：生成一个或多个字节码文件,个数名称与源文件中的类名相同
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-15-54-45-image.png" alt="" width="405">

---

# 第二章 基础语法

## 2.1 关键字

关键字一律用小写字母标识，按其用途划分为如下几组。

* **用于数据类型**： boolean、byte、char、 double、 false、float、int、long、new、short、true、void、instanceof。

* **用于语句**：break、case、 catch、 continue、 default 、do、 else、 for、 if、return、switch、try、 while、 finally、 throw、this、 super。

* **用于修饰**：abstract、final、native、private、 protected、public、static、synchronized、transient、 volatile。

* **用于方法、类、接口、包和异常**： class、 extends、 implements、interface、 package、import、throws。

* **其他保留关键字**：cat、 future、 generic、innerr、 operator、 outer、rest、var、goto、const等——Java保留的没有意义的关键字。

* **特殊意义的3个保留字**:：true、false、null。(严格意义上不是关键字)

## 2.2 标识符

自己取名的都为标识符——类、方法、变量、接口、包名

### 2.2.1 编译时命名遵守规则

* 只能由字母（a-z，A-Z）数字（0-9）下划线（_）和美元符号（$）组成

* 不能以数字开头，不能包含空格

* 不能与关键字重名，可以包含

* 严格区分大小写，长度无限制

### 2.2.2 君子遵守规则

* 包名：全部小写xxxyyyzzz

* 类名、接口名：所有单词首字母大写XxxYyyZzz

* 变量名、方法名：第一个单词小写，往后每个单词首字母大写xxxYyyZzz

* 常量名：全部大写，单词间下划线连接XXX_YYY_ZZZ

## 2.3 变量

* 储存单元：类型、名、值

* java是强类型语言，变量类型**必须先声明后使用**（弱类型 var let 等）

* 作用域 同个作用域内不可以同名

**JAVA定义的数据类型**：变量类型 8种基本数据类型（不包含string）

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-16-15-53-image.png" alt="" width="483">

## 2.3 数据类型

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-16-38-18-image.png)

* **整型常量默认为int类型**。**long**：后面必须加L，否则会默认转换为int。

* **浮点类型常量默认为double型**。表示范围比整型大,部分空间表示10的次方
  
  **float**：尾数精确到7位，后面必须加f或者F。**double**：精度是float的两倍

### 2.3.1 基本数据类型之间的转换

* **自动类型提升**：小到大
* **强制类型转换**：大到小、可能导致精度损失

### 2.3.2 进制

Intege类实现进制的直接转换。八进制和十六进制最有用，都用在底层。

* 2进制  以0b开头，只有0和1组成 　

* 8进制  以0开头，0~7组成 　　 　　 

* 10进制 0~9组成    　　  

* 16进制 以0X开头，0~9或者a~f组成  

### 2.3.3 引用数据类型之String

### 2.3.4 引用数据类型之数组Array

相同类型的数据按顺序排列，连续内存空间结构(数组名,下标,元素,数组长度)

* **分类** ： 按维度：一维、二维…… 按类型：基本、引用

* **特点**：一旦定义长度就被确定，无法改变
  
  ```java
  int[] arr1 = new int[]{1,2,3};
  int[] arr2 = new int[3];
  ```

* **一维数组初始化值**：整数 0 ，浮点 0.0，字符 0 或'\u0000'(不是'0')，布尔false，引用数据类型null

* 多维数组的底层就是一维数组的嵌套

* **Arrays**—java数组操作类

* **ArrayException异常**—角标越界、空指针异常

### 2.3.5 包装类Wrapper—自动拆装箱

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-50-12-image.png" alt="" width="298">

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-50-40-image.png)

* Boolean型中：忽略大小写是true为true，其余为false
  
  * `Boolean b = new Boolean（"123"）//false`
  
  * boolean 初始值false。Boolean 初始值null

* **Integer额外知识**：内部定义了IntegerCache结构—Integer[]，保存了-128～127的整数。如果我们使用自动拆箱，给Integer赋值在-128～127内时，可以直接使用数组中的元素，不用再去new了——**提高效率**
1. **基本数据类型—>包装类**：调用包装类构造器
2. **包装类—>基本数据类型**：调用包装类中的xxxValue()
3. **基本数据类型/包装类—>String类型**：调用String 的重载方法valueOf(xxx)
4. **String—>基本数据类型/包装类** ：XXX.parseXxx()

## 2.4 运算符

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-16-51-25-image.png" alt="" width="465">

* ==和 != 用于引用数据类型之间时，比较两个类是否时同一个地址

* s = s+2 会改变数据类型 可能会报错。s+=2 不会改变数据类型

* & 和  &&的区别，|和||的区别

* 开发中优先使用短路与或，效率高  && 、||

* [常用位运算](https://zhuanlan.zhihu.com/p/100595139)

* 三元运算符可以嵌套使用,是if-else 的充分不必要条件,优先使用三元。

## 2.5 流程控制

* **顺序**

* **循环**：
  
  for、do-while、while。**for(;;)和while(true)一样,使用false和break终止**

* **分支**
  
  * if-else：**括号省略时else只匹配就近原则的if**，无论排版是否对齐
  
  * switch-case ：**执行效率略高**
    
    * 不添加break的话，如果有满足条件的case还会接下去执行，直到遇见break或者末尾。
    
    * 结构中表达式只能是byte、short、char、int、枚举、String
    
    * **case后只能跟常量**

**指定lable：结束或继续lable标签循环**

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-17-27-56-image.png" alt="" width="392">

---

# 第三章 面向对象

## 3.1 设计类的基本概念

* **四个特征**：封装性、继承性、多态性、抽象性

* **两个组成**：
  
  * 属性=成员变量=域和字段=field
  
  * 方法=成员=函数=method—方法不可嵌套定义

* **类及成员**：属性、方法、构造器、代码块、内部类

* **匿名对象**：new object().function(..)

* <img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-13-14-image.png" title="" alt="" width="414">
  
  * 通常说的**栈是虚拟机栈**，存放局部变量等，例如引用对象地址
  
  * **堆存放对象实例**
  
  * **方法区**存放JVM加载的类信息,常量,静态方法,即时编译后的代码等数据

### 3.1.2 方法

#### 1）重载—overload

可以定义一些名称相同的方法，通过定义不同的输入参数来区分这些方法，调用时，根据不同的参数样式，来选择合适的方法执行。

* 与返回值类型无关，只看参数列表，参数列表必须不用（个数、类型）

#### 2）可变个数形参方法

`public void show(String … str);`

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-28-00-image.png)

#### 3）传递机制

* **形参是基本数据类型**—值传递

* **形参是引用数据类型**—地址传递

#### 4）递归方法—recursion

在方法内调用自身

### 3.1.3 构造器

* 构造器的权限修饰符默认与类相等

* 构造器无返回值

* 类内构造器彼此之间构成重载

* 类中至少有一个构造器

* **定义过构造器后系统将不再提供默认构造器**

* **this调用构造器**：不能循环调用this构造器，可以单链条式调用
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-31-31-image.png)

### 3.1.4 代码块（初始化块）

初始化类、对象，修饰词只有static。使用情景不多，需要看懂。

由子及父，静态先行

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-07-15-image.png)

### 3.1.5 对象中的执行顺序

1. 默认初始化
2. 显示初始化/代码块中赋值 （看执行先后顺序）
3. 构造函数初始化
4. （类）对象.方法/对象.属性 赋值操作

### 3.1.6 final关键字

static final 修饰属性：全局常量

1. 修饰类、方法、变量
2. 修饰类时：不能被继承——例如：String、System、StringBuffer
3. 修饰方法时：不可被重写
4. 修饰变量时：变量则为常量——可显示初始化、代码块中初始化、构造器中初始化、不可在方法中初始化因为方法会导致重新赋值。
5. 修饰局部变量时：表明形参是个常量，使用final后，方法体内不可重新赋值
6. 修饰对象时：对象的地址不可变，但是对象内部的变量可以变换。

### 3.1.7 内部类

开发中不多，看源码的时候会出现。例如：人类是个类，人类的内部类：大脑；

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-21-03-image.png)

* **局部/成员内部类编译后都会生成字节码文件。格式为：**
  
  * 成员内部类：外部类$内部类名.class
  
  * 局部内部类：外部类$数字 内部类名.class

* **局部内部类方法调用局部内部类声明的方法中的局部变量，则要求此变量为final，jdk8后可以省略final的声明——开发中常用**
  
  <img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-24-08-image.png" title="" alt="" width="297">

* **内部类的三个问题**
  
  * 如何实例化成员内部类的对象
    
    <img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-24-46-image.png" title="" alt="" width="403">
  
  * 如何在内部类中区分调用外部类的对象
    
    <img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-25-08-image.png" title="" alt="" width="420">
  
  * 开发中局部内部类的使用（开发中很少见）
    
    <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-25-39-image.png" alt="" width="390">

## 3.2 封装与隐藏—面向对象特性一

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-17-31-image.png)

### 3.2.1 四种体现方法

1. 属性私有化，设置setter getter
2. 不对外暴露私有方法
3. 单例模式（将构造器私有化）
4. 不希望类在包外使用时，将其设置为缺省值

### 3.2.2 四种访问权限修饰符

用于修饰类以及类的内部结构：属性、方法、构造器、内部类。

**修饰类时，只能使用缺省、public**

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-18-28-image.png)

### 3.2.3 JavaBean

java语言写成的可重用语言,与数据库的表性质相同。

**JavaBean标准：**

* 类是公共的public

* 无参构造器:为了后期的反射机制创建运行时类对象,便于继承的super()调用

* 属性对应getter、setter方法

## 3.3 继承—面向对象特性二

* 减少代码冗余，提高复用性，便于功能扩展，为多态提供前提

* class A extends B：A获取B的所有属性和方法，私有的属性本质上也被继承了，但由于封装性的影响，不能直接调用私有属性 只能间接。

* 所有类都隐形继承object

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-33-41-image.png)

### 3.3.1 重写—（override/overwrite）

**⚠️区别方法的重写和重载**

子类和父类中同名同参数的方法要么都声明为非static的（考虑重写）；要么都声明为static 的（不是重写）重载overload

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-35-35-image.png)

### 3.3.2 Super

super可以用来调用属性、方法、构造器

* 在类的多个构造器中，至少有一个类的构造器调用了super构造器

* 因为n个构造器，最多有n-1个this构造器

* 尽管调用了父类构造函数，但是只造了一个对象

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-38-09-image.png)

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-38-24-image.png)

## 3.4 多态—面向对象特征之三

父类引用指向子类对象（子类对象赋给父类引用 ）

### 3.4.1 多态的使用—虚拟方法调用（Virtual）

**编译看父，运行看子** ：只可以调用父类所声明的方法，但是实际运行的时候执行的是子类重写的方法。**使用前提：类继承+方法重写**。

* 多态的使用只针对方法不针对属性，即对于属性编译和运行都看左父类

* **多态性是运行时行为（动态绑定）**——不是晚绑定就不是多态
  
  从编译运行角度来看：
  
  **重载是静态绑定（早绑定）**——即在编译时就确定了调用地址
  
  **重写是动态绑定（晚绑定）**——运行时才决定具体要调用的方法

### 3.4.2 instanceof

当 Parent p = new Son() 的时候，内存中加载了son的属性和方法，由于声明为父类对象，所以无重写时就无法调用子类中的其他方法。**想要调用子类中自己的方法，需要向下转型即强制转换为子类：Son s = （Son）p**

* 为了避免向下强制转换失败（ClassCastException）：使用intanceof
  
  * a instanceof A ：判断a对象是否是类A的实例（true/false）
  
  * 若B是A的父类， a instanceof A为true时， a instanceof B也为true

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-44-11-image.png" alt="" width="189">

## 3.5 抽象类Abstract—面向对象特性四

**是因为abstract需要被子类重写，而私有方法等无法重写。所以abstract不能用来修饰属性、构造器、私有有方法、静态方法、final方法和类**

* **修饰类**
  
  * 不可以被实例化
  
  * 抽象类中一定要有构造器，便于子类实例化过程中调用
  
  * 由抽象类的子类构建实例化对象，实现操作

* **修饰方法**
  
  * 只有声明，没有方法体——public abtract void method();
  
  * 包含抽象方法的一定是一个抽象类。反之抽象类中可以没有抽象方法。
  
  * 若子类重写了父类中的所有方法，则可以实例化。否则还是一个抽象类，需要注明abstract

* **抽象类的匿名子类**—开发常用

## 3.6 接口Interface

**接口和类为并列的结构，达到多继承的效果。驱动为接口的实现类**

1. 接口实现上体现多态性。
2. 接口事实上可以看作一种规范。
3. 接口的主要用途就是被实现类实现（面向接口编程）
4. 接口示例
   1. 非匿名对象和非匿名类
   2. 匿名对象和非匿名类
   3. 非匿名对象和匿名类
   4. 匿名对象和匿名类

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-17-40-image.png)

**抽象类和接口有哪些异同？**

## 3.7 Object类

**常用方法：** equals、getclass、notify、notifyAll、wait、clone、hashCode、toString 、finalize() ——尽可能不用，jvm垃圾回收的调用方法。通过system.gc()/Runtime.getRuntime().gc()/设置null来通知JVM进行垃圾回收

### 3.7.1 ==和equals

特别注意，String是引用数据类型，需要使用equals判断

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-48-53-image.png)

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-49-03-image.png)

## 3.8 静态Static

从生命周期去理解static—修饰属性、方法、代码块、内部类

**生命周期：类加载—对象出生—对象消亡—类消亡**

### 3.8.1 静态变量（类变量）

- 静态变量随着类的加载而加载**(早于对象创建)** 。由于类只加载一次，所以静态变量在内存中也只**存在一份存在方法区的静态域中**。

- 通过 类 . 静态变量 来调用； 例如Math.PI，System.out
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-22-59-44-image.png" alt="" width="401">

### 3.8.2 静态方法

静态方法使用同变量类似,由于STATIC的生命周期从类加载就开始存在，所以：

1. 静态方法中只能调用静态属性或方法
2. 非静态方法中既能调用非静态也能调用静态（方法和属性）
3. 静态方法内不可以使用this和super，因为还不存在当前对象。this和super的生命周期不够。
4. 静态属性方法前面省略了类名。

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-01-47-image.png)

### 3.8.3 单例设计模式（Singleton）

在整个系统中，针对某个类只存在一个实例对象，减少系统性能的开销，java.lang.Runtime 采用的就是恶汉式单例模式。

* **实现步骤**
  
  1. 构造器访问权限 private——无法在类外构造对象
  2. 内部产生该类对象
  3. 调用静态方法返回该对象，由于静态方法只能访问静态成员变量，所以类的成员变量

* **实现方式**
  
  |     | 含义         | 优点     | 缺点     |
  | --- |:----------:|:------:|:------:|
  | 恶汉式 | 类加载就生成单例对象 | 线程安全   | 加载时间过长 |
  | 懒汉式 | 使用类时生成单例对象 | 延迟对象创建 | 线程不安全  |

* **应用场景**
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-04-53-image.png" alt="" width="519">

---

# 第四章 异常处理

## 4.1 异常概念

1. **ERROR——无法处理**

2. **EXCEPTION——可以处理**
   
   解决方案：终止运行、错误提示

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-29-38-image.png)

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-29-49-image.png)

## 4.2 异常处理机制

**为了解决可读性，使用两种方式。关于异常对象的产生：**

1. 系统自动生成
2. 手动生成异常对象，并抛出（throw）

**开发中使用哪种抛异常的方式？**

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-33-24-image.png)

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-34-56-image.png)

### 4.2.1 抓抛模型

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-31-10-image.png)

### 4.2.2 try-catch-finally

* **将编译时可能出现的异常，延迟到运行时出现 。** 

* **运行时异常通常不处理，处理编译时异常。**

* 可以相互嵌套

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-31-51-image.png)

### 4.2.3 throws+异常类型

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-13-23-33-45-image.png)

### 4.2.4 自定义异常类

1. 继承现有异常结构：RuntimeException，Exception
2. **提供全局常量：serialVersionUID——唯一标识符**
3. 提供重载构造器

---

# 第五章 多线程

## 5.1 程序、线程、进程

- 程序program：为完成特定任务的一段静态代码

- 进程process：正在运行中的程序，程序的一次执行。动态的

- 线程thread：进程进一步细化为线程，是程序内部的一条执行路径
  
  - 多线程：一个进程并行执行多个线程
  
  - 每个线程拥有独立的运行栈和程序计数器（pc）
  
  - 一个进程的多个线程共享相同的内存单元/内存地址空间——可以从同一个堆中分配对象和访问（安全隐患）
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-09-36-06-image.png" alt="" width="501">
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-09-36-26-image.png" alt="" width="502">

### 5.1.1单核和多核CPU

- 单核：假多线程——通过极短的时间片分时执行多个线程
- 多核：多线程

**一个java.exe至少有3个线程:main()主线程,gc()垃圾回收线程,异常处理线程**

### 5.1.2并行和并发

- 并行：多个CPU执行多个任务
- 并发：一个CPU执行多个任务（时间片）

### 5.2 线程THREAD

### 5.2.1 线程的创建方式和常见方法

#### 1）创建一：继承Thread

**创建Thread子类并重写run方法，通过调用子类对象的start()启动线程**

* 可以创建Thread 的匿名子类

* 常见的线程问题
  
  * **直接使用run方法不调用start时，只时调用了方法体，不启动多线程**
  
  * 一个实例线程的start方法只能使用一次，否则报非法线程状态错误

#### 2）创建二：实现Runnable

**实现Runnable接口重写run方法—优于继承Thread方法的创建方式。** 原因：

* 实现的方式没有类的单继承的局限性

* 实现的方式更适合处理多个线程共享数据的情况

#### 3）创建三：实现Callable接口(JDK5增)

**实现Callable接口重写call()方法**—优于实现Runnable接口。更强大

* 相比run()方法，可以有返回值，并且支持泛型返回值

* 可以抛出异常

* **需要借助FutureTask类，比如获取返回结果**

#### 4）创建四：线程池—开发中最常用

为了避免频繁创建销毁线程

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-01-09-image.png)

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-01-29-image.png)

**常见方法**

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-02-04-image.png)

**线程通信：wait、notify、notifyAll，此三个方法定义在Object类中**

### 5.2.2 线程的分类、优先级、调度

**线程调度**

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-06-43-image.png)

**线程优先级**：默认5

* MAX_PRIORITY=10，MIN_PRIORITY=1，NORM_PRIORITY=5

* getPriority、setPriority 获取和设置优先级

**线程分类**：

* 守护线程——服务用户线程，
  
  * start方法前 **thread.setDaemon(true)** 可以把用户线程变成守护线程
  
  * java垃圾回收是典型的守护线程
  
  * JVM都是守护线程的话，当前JVM将退出

* 用户线程

### 5.2.3 线程的生命周期

1. **创建**：新生的线程对象处于创建状态

2. **就绪**：start方法启动后，进去线程队列等待CPU时间片，未分配到资源状态

3. **运行**：分配到CPU资源，进入运行状态，run()方法定义了执行内容和功能

4. **阻塞**：被人为挂起或执行输入输出操作时让出CPU中止自己的执行

5. **死亡**：完成全部工作，或者异常导致结束

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-14-32-image.png)

### 5.2.4 线程同步（线程安全问题）

局限性：操作代码时，一个线程操作，其余等待，效率低

* **方法一：同步代码块**
  
  * Runnable接口创建的线程，可以考虑使用this充当同步监视器
  
  * Thread继承创建的线程慎用this
  
  ```java
  synchronized(同步监视器){//同步监视器就是锁。任何对象都可以是锁
          //多个线程同步必须共同一把锁
          //需要被同步的代码（不能多不能少）
  }
  ```

* **方法二：同步方法**
  
  若方法内为需要同步的代码，可以将方法直接声明为同步。
  
  - 非静态：实现runnable 的同步方法 同步监视器为this（唯一）
  - 静态：继承thread 的同步方法需要声明为static ，此时同步监视器为 `ClassName`.Class

### 5.2.5 锁LOCK

显示定义同步锁对象实现同步

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-18-32-image.png)

RantrantLock（fair：true）//先进先出公平线程

### 5.2.6 线程通信

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-21-28-image.png)

**wait和sleep的异同**：    

* 相同：一旦执行都使当前线程进去阻塞

* 不同：
  
  * 声明位置：Thread类中声明sleep，Object类中声明wait
  
  * 调用要求：sleep任何场景，wait必须在同步代码块内
  
  * 同步监视器：都在同步代码块或方法内时，sleep不释放，wait释放

### 5.2.7 问题

* synchronized 与lock 的区别？
  
  * 相同：都可以解决线程安全问题
  
  * 不同：synchronized自动释放同步监视器，lock需要手动启动和释放
  
  **优先使用顺序：lock>同步代码块>同步方法**

* 如何解决线程安全问题，有几种方式？

---

# 第六章 Java常用类

## 6.1 String

### 6.1.1 概念、创建方式

**字符串常量池中不会储存两个相同的字符串**

1. final char value[]——不可变字符序列。**jdk9.0之后 char[] 都改为byte[]了**
2. final 类 ——不可被继承
3. 支持序列化。实现Serializable接口
4. 可比较的。实现Comparable接口

**创建方式**

```java
String str = "hello"; 
String s1 = new String();//本质上new char[0]
String s2 = new String (String original); //this.value=original.value
Stirng s3 = new String(char[] a);//this.value=Arrays.copyOf(value,value.length)
String s4 = new String(char[] a,int startIndex,int count);
```

### 6.1.2 内部运行机制（面试题）

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-40-16-image.png)

* intern方法将堆中的内容返回以常量池声明的方式

* 如果声明为final 的字符串为常量，在常量池中，jdk16字符串常量池在堆中
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-40-55-image.png)

### 6.1.4 StringBuffer&StringBuilder

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-41-34-image.png)

```java
StringBuffersbuffer=newStringBuffer();//value=newbyte[16];
StringBuildersbuider=newStringBuilder();//value=newbyte[16];
构造器创建时，初始长度都为16，但是length()方法返回的是元素的count值
开发中推荐使用StringBuffer（int capacity）避免StringBuffer经常性的扩容 或Builder
```

**效率对比：StringBuilder > StringBuffer > String**

Java中的+对字符串的拼接其实现原理是使用**StringBuilder.append**。

建议：循环体内，字符串的连接方式，使用 StringBuilder的append 方法进行扩展。

## 6.2 时间API

### 6.2.1 旧时间API—JDK8以前

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-44-02-image.png" alt="" width="504">

1. System.currentTimeMill1s（）返回当前时间与1970.1.1.00:00 以毫秒为单位的时
2. java.util.Date 不易于国际化，大部分被废弃了
3. |——java.sql.Date
4. java.text.SimpleDateFormat 日期格式化，是一个不与语言环境有关的方式来格式化和解析日期的具体类。允许进行格式化：日期à文本、解析：文本à日期
5. java.util.Calendar(日历)类 **注意月份从0开始计算**

**旧时间API存在的问题**

* 可变性：类应为不可变

* 偏移性：Date年份从1900开始，月份从0开始

* 格式化：格式化只对Date有用，Calendar不行

* 线程不安全，不饿能处理闰秒等

### 6.2.2 新时间API—JDK8以后

* **java.time** 相当于Calendar包含了所有关于LocalDate，不可变。
  LocalTime、LocalDateTime、ZonedDateTime、Duration
  
  * java.time.chrono 不同日历系统的访问
  
  * java.time.format 格式化解析时间和日期
  
  * java.time.temporal 底层框架和扩展特性
  
  * java.time.zone 时区支持
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-52-08-image.png" alt="" width="383">

* **Instant瞬时** 相当于Date，时间线上的一个瞬时点，用来记录事件时间戳—时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至现在的总秒数。
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-53-55-image.png" alt="" width="408">

* **java.time.format.DateTimeFormatter**格式化与解析,相当于SimpleTimeFormatter
  
  * 预定义的标准格式。ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIM
  
  * 本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG
  
  * 自定义的格式。如：ofPattern(“yyyy-MM-ddhh:mm:ss”)
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-55-34-image.png)

* **其他API**
  
  <img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-55-56-image.png" title="" alt="" width="517">

## 6.3 Comparable/Conparator—Java比较器

* **自然排序Comparable**
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-56-59-image.png)

* **定制排序Comparator**
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-10-57-08-image.png" alt="" width="401">

* **两者使用对比**
  
  * Comparable相当于家用筷子。其实现类对象可以在任何位置比较大小
  
  * Comparator相当于一次性筷子。临时性的比较

## 6.4 System

* 构造器是private的—无法创建该类的对象——无法实例化。

* 其内部的成员变量和成员方法都是static的——直接调用。

* System类内部包含in、out和err三个成员变量，分别代表标准输入流(键盘输入)，标准输出流(显示器)和标准错误输出流(显示器)。

## 6.5 Math

### 6.5.1 常用方法

- abs 绝对值
- acos,asin,atan,cos,sin,tan 三角函数
- sqrt 平方根
- pow(double a,doble b) a的b次幂
- log 自然对数
- exp e为底指数
- max(double a,double b)
- min(double a,double b)
- random() 返回0.0到1.0的随机数
- long round(double a) double型数据a转换为long型（四舍五入）
- toDegrees(double angrad) 弧度—>角度
- toRadians(double angdeg) 角度—>弧度
- ……

### 6.5.2 BigInteger&BigDecimal

* BigInteger
  
  * 表示不可变的任意精度的整数，提供所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。 
  
  * 提供以下运算：模算术、GCD 计算、质数测试、素数生成、
    位操作以及一些其他操作。

* BigDecimal
  
  * 对数字精度要求比较高的时候使用。例如float，double已经不够用了的时候
  
  * BigDecimal类支持不可变的、任意精度的有符号十进制定点数。

---

# 第七章 枚举类和注解

## 7.1 Enum枚举类

当需要定义一组常量，使用枚举类——类的对象有限个确定的

例如：星期（1-7），性别（男女），季节（四个），线程状态（5个）……

* 自定义枚举类的方式
  
  * 声明属性private final
  
  * 私有化构造器
  
  * 提供多个枚举对象public static final

* 使用enum
  
  默认继承与java.long.Enum，提供多个枚举对象,多个对象使用逗号隔开,末尾用分号

## 7.2 Annotation注解

框架 = 注解+反射+设计模式——注解是jdk5.0特性，代替繁冗代码和xml配置

* 生成文档注解

* 编译时格式校验检查：Override、Deprecated、SuppressWarning

* 跟踪代码依赖性，实现代替配置文件

* **自定义注解** @interface（和interface没有任何关系）
  
  * 自动继承了java.lang.annotation.Annotation接口
  
  * 其成员变量定义中以无参数方法的形式来声明。
  
  * 其方法名和返回值定义成员名字和类型—配置参数。类型只能是八种基本数据类型、String、Class、enum、Annotation、以上所有类型的数组。
  
  * 定义成员变量时为其指定初始值, 指定成员变量的初始值可使用 default 关键字。
  
  * 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。如果只有一个参数成员，建议使用参数名为value，并且可以省略“value=”。
  
  * 没有成员定义的注解称为标记; 包含成员变量的注解称为**元数据**

* **元注解** 修饰注解的注解
  
  1. 生命周期 source/class/runtime 默认class 只有声明为runtime的才能被反射获取
  
  2. Target 无指定则无要求 ，指定可以修饰的结构（如类、方法……）
  
  3. Documented 表示所修饰注解被javadoc解析时保留，如Deprecated
  
  4. Inherited 具有继承性
  
  **自定义直接通常指定retention 和target ，剩下两个出现频率较低**

* **JDK8注解新特性**
  
  * 可重复注解：在注解类上声明 @repeatable
  
  * 类型注解：
    
    * ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中
    
    * ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中

---

# 第八章 集合

## 8.1 集合概述

* **Java集合可分为两个体系Collection 和Map两种体系**
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-21-43-image.png)
  
  一个x不可以对应多个y，一个y可以对应多个x

* 数组和集合区别
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-21-11-image.png)

## 8.2 Collection接口

<img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-23-29-image.png" title="" alt="" width="398">

### 8.2.1 Iterator 迭代器

遍历Collection集合而生 ，迭代器模式，就是为容器而生。不包括遍历Map类型的集合

GOF给迭代器模式的定义为：提供一种方法访问一个容器(container)对象中各个元

素，而又不需暴露该对象的内部细节。

* Enumeration——Iterator 迭代器的 “古老版本”

### 8.2.2 List接口

元素**有序且可重复**，常用List代替数组

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-29-26-image.png)

ArrayList、LinkedList、Vector 的异同（面试题必问）

<img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-29-00-image.png" title="" alt="" width="474">

#### 1）ArrayList顺序表

jdk7相当于恶汉式，jdk8以后相当于懒汉式，延时数组创建，节省内存

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-30-05-image.png)

#### 2）LinkedList链表

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-30-33-image.png)

**LinkedList方法的区别**

1. 增加元素方法add和offer
   
   1. add在队列满的情况下将选择抛异常的方法来表示队列已经满了
   
   2. offer返回false表示队列已经满了，在有限队列使用offer方法优于add方法

2. 删除队列的头元素remove和poll
   
   1. remove方法在队列为空的情况下将抛异常
   
   2. poll方法将返回null；

3. 返回队列的头元素element和peek，但是不删除头元素。
   
   1. element方法在队列为空的情况下将抛异常
   
   2. peek方法将返回null

#### 3）Vector

**stack栈是vector子类**——通常用dequeue两端队列代替stack操作

jdk7、8的Vector创建对象时底层都创建了长度为10的数组，扩容时扩1倍

### 8.2.3 SET接口

**无序的不可重复的**，Set接口是Collection的子接口，set接口没有提供额外的方法

**Set的底层原理就是Map**

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-35-57-image.png)

#### 1）HashSet（数组+链表）

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-36-30-image.png" alt="" width="364">

* 无序性：根据哈希值排序

* 不可重复性：按照equals判断不能返回true—重复元素只能添加一个

* **HashSet的添加方式**
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-40-54-image.png)

* 要求：向Set中添加数据，其所在的类一定要重写equals和hashcode方法
  
  重写的方法尽可能保持一致性，即相等的对象必须要具有相等的散列码（哈希值）
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-39-01-image.png" alt="" width="477">

#### 2）LinkedHashSet

**继承了HashSet** 添加数据的同时**还维护了两个引用**，记录前一个数据和后一个数据

* LinkedHashSet插入性能略低于 HashSet、但是频繁的遍历操作效率更高

* 在HashSet基础上，按什么顺序输入的，按什么顺序输出。但底层还是无序的

#### 3）TreeSet

- TreeSet 是**SortedSet 接口的实现类** ，TreeSet 可以确保集合元素处于排序状态
- TreeSet底层使用**红黑树结构存储数据**
- TreeSet只允许存放属于同一类的对象 ，默认情况下对象要继承Comparable接口，重写compareTo方法。或者有定制排序
- TreeSet 两种排序方法**自然排序和定制排序**。默认情况下，TreeSet **采用自然排序**

## 8.3 Map接口

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-43-28-image.png" alt="" width="387">

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-45-05-image.png)

**Map的结构**

* key：无序不可重复，Set存储——key所在类需要重写equals和hashcode

* value：无序可重复，Collection存储——value所在类需要重写equals

* entry：无序不可重复，Set存储——key：value

#### 1）HashMap

* JDK7底层原理
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-47-57-image.png)

* JDK8原理
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-48-25-image.png)

#### 2）LinkedHashMap

LinkedHashMap 是 HashMap 的子类

* 在HashMap存储结构的基础上，使用了对双向链表来记录添加元素的顺序

* 与LinkedHashSet类似，LinkedHashMap可以维护 Map 的迭代 顺序：迭代顺序与Key-Value 对的插入顺序一致

#### 3）TreeMap

* TreeMap根据key-value 对进行排序，底层使用红黑树结构存储数据

* TreeMap 可以保证所有的 Key-Value 对处于有序状态。

* TreeMap 的 Key 的排序：
  
  * 自然排序：Key 必须实现 Comparable 接口且所有的 Key 是同一个类的对象，否则将会抛出 ClasssCastException
  
  * 定制排序：创建 TreeMap 时，传入一个Comparator 对象，该对象负责对 TreeMap 中的所有 key 进行排序。此时不需要 Map的Key 实现 Comparable 接

* TreeMap判断两个key相等：两个key**通过compareTo()或者compare()** 返回0。

#### 4）HashTable

古老的 Map 实现类，**线程安全。** 实现原理和HashMap相同功能相同。

* 底层都使用哈希表结构，查询速度快，很多情况下可以互用。

* 与HashMap不同的是不允许使用 null 作为 key 和 value

#### 5）Properties

Hashtable 的子类，用于处理属性文件。key 和 value 都是字符串类型

存取数据时建议使用setProperty(Stringkey,Stringvalue)和 getProperty(String key)方法

## 8.4 Collections工具类

操作collection和map的工具类

* 排序操作：（均为static方法）
  
  * reverse(List)：反转 List 中元素的顺序
  
  * shuffle(List)：对 List 集合元素进行随机排序
  
  * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
  
  * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
  
  * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

* 查找、替换
  
  * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
  
  * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
  
  * Object min(Collection)、Object min(Collection，Comparator)
  
  * lintfrequency(Collection，Object)：返回指定集合中指定元素的出现次数
  
  * void copy(List dest,List src)：将src中的内容复制到dest中
  
  * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换旧

* 同步控制
  
  ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-55-52-image.png)

---

# 第九章 泛型 <E>

把元素类型设置成一个参数 这个类型参数称为泛型。这个类型参数将在使用时确定。

**体会：使用泛型的主要优点是能够在编译时而不是在运行时检测错误。**

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-14-59-18-image.png)

## 9.1 自定义泛型类、接口

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-01-30-image.png" alt="" width="477">

1. **泛型类可能有多个参数 <E1,E2,E3>**

2. 泛型类的构造器如下：public Generic Class(){}。
   
   而下面是错误的：publicGenericClass<E>(){}

3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。

4. 泛型不同的引用不能相互赋值。**尽管在编译时ArrayList和ArrayList是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中**

5. 泛型如果**不指定，类型均按照Object处理**，但不等价于Object。
   
   经验：泛型要使用一路都用。要不用，一路都不要用。

6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。

7. 泛型的指定中**不能使用基本数据类型，可以使用包装类替换**。

8. **静态方法中无法使用类的泛型**

9. **异常类不能声明为泛型类**

## 9.2 泛型类子类

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-04-54-image.png" alt="" width="445">

**继承方面的体现：**

* A是B的父类，G\<A\>和G\<B\>不具备父子类关系，是并列关系

* A是B的父类，A\<G\>是B\<G\>的父类

## 9.3 泛型方法

泛型方法可以定义在任意类中，可以是静态的

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-05-28-image.png" alt="" width="475">

## 9.4 通配符<?>

**A是B的父类，G\<A\>和G\<B\>的共同父类G<?>**

- 写：对于list<?>不能添加数据，除非添加null（例外）
- 读：允许，读取数据类型为object

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-09-25-image.png)

**？ 相当于数学中的（-∞，+∞）**

* extends 相当于 <=     **？ entendsA 相当于（-∞，A]**

* super 相当于 >=         **？ super A 相当于[A，+∞）**

---

# 第十章 IO流

## 10.1 流的分类

* 按操作数据单位：字节流(8 bit)字符流(16 bit) 

* 按数据流的流向：输入流，输出流

* 按流的角色：节点流—作用于文件,处理流—作用于已有流（加快流的速度）

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-14-10-image.png" alt="" width="545">

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-14-43-image.png" alt="" width="353">

**流的所属基类看后缀，流创建后必须要手动关闭！**

## 10.2 File

文件或文件目录对象，java.io包下。

* 绝对路径：是一个固定的路径,从盘符开始

* 相对路径：是相对于某个位置开始则默认的相对路径在系统属性**user.dir**中存储

* **存储File.separator**根据操作系统动态提供分隔符

## 10.3 FileReader/Writer

**不能使用字符流处理非文本数据的复制等操作！**

* **FileReader**：将文件内容读入内存。文件读入时一定要存在，否则报异常。
  
  ```java
  //方式一：read方法 一个字符的读麻烦回字符的int类型，如果读到末尾返回-1
  for(inti=0;i<len;i++){
  System.out.print(cbuf[i]);
  }
  //方式二：read重载 ，多个字符的读需要借助一个char[] 储存 返回的int是读取的个数
  Strings=newString(cbuf,0,len);
  System.out.print(s);
  ```

* **FileWriter**：从内存写数据到硬盘文件，不存在的话自动创阿金，存在默认覆盖
  
  ```java
  FileWriter(file,$append$)
  $append$=true,不覆盖添加
  $append$=false,覆盖
  ```

## 10.4 FileInputStream/FileOutputStream

使用字节流对文本文件操作时，读取是遇到中文会乱码，使用字节流对非文本文件进行操作

* 文本文件使用字符流处理—txt、java、cpp……
  
  文本文件可以使用字节流进行复制，但是不能输出读取。

* 非文本文件使用字节流—jpg、mp3、mp4、avi、doc、ppt……
  
  非文本文件不可以使用字符流进行复制等相关操作

## 10.5 处理流

处理流就是套接上原有流的基础上。提供流的读取和写入的速度

### 10.5.1 Buffered 缓冲流（常用—处理流一

开发中通常用缓冲流，效率高。内部缓冲区默认8192 ，达到8192 后会刷新缓冲区flush，可以中途人为调用flush。

![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-27-58-image.png)

```java
// 1造文件
File srcFile = new File(srcPath);
File destFile = new File(destPath);
// 2造流
//节点流
FileInputStream fr = new FileInputStream(srcFile);
FileOutputStream fw = new FileOutputStream(destFile);
//缓冲流
bis = new BufferedInputStream(fr);
bos = new BufferedOutputStream(fw);
// 3读写操作
...
// 4关闭流，先外层再内层——关闭外层的时候，顺便关闭的内层，所以内层流的关闭可以省略
```

### 10.5.2 转换流—处理流二

<img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-28-29-image.png" title="" alt="" width="467">

* InputStreamReader：将InputStream转换为Reader

* OutputStreamWriter：将Writer转换为OutputStream

### 10.5.3 System标准输入输出流—处理流三

* System.in：键盘—InputStream

* System.out：显示器—PrintStream（OutputStream、FilterOutputStream的子类）

* 重定向：通过System类的setIn，setOut方法对默认设备进行改变。
  
  ```java
  public static void setIn(InputStream in)
  public static void setOut(PrintStream out)
  ```

### 10.5.4 PrintStream/PrintWriter打印流（了解）—处理流四

* 提供了一系列重载的print()和println()方法，用于多种数据类型的输出

* PrintStream和PrintWriter的输出不会抛出IOException异常

* PrintStream和PrintWriter有自动flush功能

* PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。

* 在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。

* System.out返回的是PrintStream的实例

### 10.5.5 DataInput/OutputStream数据流—处理流五

**操作基本数据类型和String到文件中或者从文件中取出**，可以使用数据流。

DataInputStream —— InputStream、DataOutputStream —— OutputStream

```java
 DataInputStream dis = new DataInputStream(new FileInputStream("hello.txt"));
 String name = dis.readUTF();
 dis.close();
```

### 10.5.6 ObjectInput/OutputSteam对象流—处理流五（常用）

用于存储和读取基本数据类型数据或对象的处理流。可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。ObjectInputStream、OjbectOutputSteam

#### 1）序列化机制

允许准换成二进制流以进行传输活永久保留在磁盘上，默认基本数据类型都是可序列化，后续对于json等文件都是采用序列化机制

* 序列化：用ObjectOutputStream类保存基本类型数据或对象的机制，对象只有是可序列化的才能写入文件

* 反序列化：用ObjectInputStream类读取基本类型数据或对象的机制，对象只有是反序列化的才能从文件中读出

<img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-15-52-33-image.png" title="" alt="" width="502">

* **类实现可序列化**
  
  * 实现Serializable接口
  
  * 提供序列化id—SerializableId
  
  * 内部的成员变量必须也都是可序列话的，否则无法传输
  
  * 对象流无法序列化static和transient成员变量(传null),static不归对象所有，共享的

#### 2）序列化接口

```java
//什么也没有——标识化接口
public interface Serializable{}
作用： 自动生成的id，如果类有所调整，读取时就无法还原，可以用于加密 
序列化ID起着关键的作用，决定着是否能够成功反序列化！
简单来说，java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地实体类中的serialVersionUID进行比较，如果相同则认为是一致的，便可以进行反序列化，否则就会报序列化版本不一致的异常
```

## 10.6 随机存取流

* **既可以作为输入流，又可以作为输出流**
  
  * 作为输入流：
  
  * 作为输出流： 文件不存在创建文件。文件存在，在数据头部开始覆盖（可以实现插入数据的效果）。可使用ByteArrayOutputStream实现Builder效果避免出现乱码

* 直接继承Object类，实现DataInputDataOutput接口

* **重要方法**
  
  * long getFilePointer( )：返回文件记录指针的当前位置
  
  * void seek(long pos )：将文件指针定位到pos位置

* **继承**
  
  * DataOutput——提供将数据从任何Java基本类型转换为一系列字节
  
  * DataInput——提供从二进制流读取字节并从其中重建任何Java原语类型的数据

* **mode访问模式**
  
  * r: 以只读方式打开
  
  * rw：打开以便读取和写入
  
  * rwd:打开以便读取和写入；同步文件内容的更新
  
  * rws:打开以便读取和写入；同步文件内容和元数据的更新

* **和常规IO流的区别：** 我们以前讲的IO 字节流，包装流等都是按照文件内容的顺序来读取和写入的。而随机访问文件流我们可以在文件的任意地方写入读出数据。

* 可以用RandomAccessFile类来实现一个多线程断点下载的功能：
  
  下载工具下载前都会建立两个临时文件，下载文件大小相同的空文件和记录文件指针的位置文件，暂停时保存上一次的指针，下载时继续断点下载，实现断点下载上传的功能

## 10.7 NIO/NIO2—面向缓冲区/非阻塞式

* NIO：jdk1.4大多数方法在出错时仅返回失败，并不会提供异常信息。

* NIO2：jdk1.7
  
  * Path：File类的升级版本，实际引用资源可以不存在
  
  * Paths 工具类
  
  * Files 工具类 java.nio.files
  
  <img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-16-06-21-image.png" title="" alt="" width="501">

---

# 第十一章 反射机制

Reflection反射是动态语言的关键，动态语言就是在运行时代码可以根据条件改变自身结构

**主要动态语言：Object-C、C#、JavaScript、PHP、Python、Erlang。**

Java不是动态语言但有一定的动态性—**利用反射机制,字节码操作获得类似动态语言的特性。**

## 10.1 Java反射功能和主要API

* **主要功能**
  
  * 在运行时判断任意一个对象所属的类
  
  * 在运行时构造任意一个类的对象
  
  * 在运行时判断任意一个类所具有的成员变量和方法
  
  * 在运行时获取泛型信息
  
  * 在运行时调用任意一个对象的成员变量和方法
  
  * 在运行时处理注解
  
  * 生成动态代理

* **主要API**
  
  * java.lang.Class：代表一个类，**Class的实例对应一个运行时类**
    
    ![](/Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-16-10-24-image.png)
  
  * java.lang.reflect.Method:代表类的方法
  
  * java.lang.reflect.Field:代表类的成员变量
  
  * java.lang.reflect.Constructor:代表类的构造器
  
  * ……

## 10.2 类加载过程与ClassLoader

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-16-11-42-image.png" alt="" width="475">

**ClassLoader**

<img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-16-12-18-image.png" title="" alt="" width="565">

```java
//5.测试JDK提供的Object类由哪个类加载器加载 
classloader = Class.forName("java.lang.Object").getClassLoader(); 
System.out.println(classloader); 
//6.关于类加载器的一个主要方法：getResourceAsStream(String str):获取类路 径下的指定文件的输入流 
InputStream in = this.getClass().getClassLoader().
getResourceAsStream("exer2\\test.properties"); 
System.out.println(in);
```

## 10.3 运行时类的完整结构

可获取的类结构Field、Method、Constructor、Superclass、Interface、Annotation

* 实现的全部接口

* 所继承的父类

* 全部的构造器

* 全部的方法

* 全部的Field

---

# 第十二章 动态代理

spring中的两大特性：ioc容器——依赖注入，aop特性——动态代理

## 12.1 代理设计模式的原理

**使用一个代理将对象包装起来, 然后用该代理对象取代原始对象**

* 任何对原始对象的调用都要通过代理。代理对象决定是否以及何时将方法调用转到原始对象上。

* 最好可以通过一个代理类完成全部的代理功能。

* **在实际开发中，多线程的runnable接口实现的过程也属于代理模式**
  
  <img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-16-16-37-image.png" alt="" width="376">

* **使用场合**：调试、远程方法调用

## 12.2 Proxy类

<img src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-16-17-31-image.png" title="" alt="" width="606">

## 12.3 动态代理步骤

* **Q1：如何根据加载到内存的被代理类，动态创建代理类及其对象？**
  
  通过Proxy.new ProxyInstance()

* **Q2：当通过代理类的对象调用方法时，如何动态调用被代理类的同名方法**
  
  通过InvocationHandler接口的实现类及其方法invoke
1. 创建实现接口InvocationHandler的类，必须实现invoke方法完成代理的具体操作。

2. 创建被代理类和接口

3. 通过Proxy静态方法 创建代理接口
   
   **newProxyInstance(ClassLoader loader, Class[]interfaces,InvocationHandler h)**

4. 通过代理类调用被代理类的类方法

## 12.4 AOP（Aspect Orient Programing）

Proxy和InvocationHandler，很难看出这种动态代理的优势，AOP是更实用的动态代理机制

<img title="" src="file:///Users/sxuet/Library/Application%20Support/marktext/images/2021-08-14-16-23-07-image.png" alt="" width="341">
